package food.diary.utils;

import static food.diary.utils.FileUtils.BUFFER_SIZE;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import static javax.ws.rs.core.HttpHeaders.ACCEPT_ENCODING;
import static javax.ws.rs.core.HttpHeaders.CONTENT_ENCODING;

public class HttpUtils {

    FileUtils fileUtils = new FileUtils();

    public String get(String urlStr, String method) throws IOException {
        long start = System.currentTimeMillis();

        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        if (method != null) {
            con.setRequestMethod(method);
        }
        con.setRequestProperty(ACCEPT_ENCODING, "gzip");
//    con.setRequestMethod("HEAD");
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
//            String l;
//            while ((l = in.readLine()) != null) {
//                sb.append(l);
//                System.out.println(l);
//            }
//        }

//        List<String> cookieStrs = con.getHeaderFields().get(HttpHeaders.SET_COOKIE);
//        List<HttpCookie> cookies = new LinkedList<>();
//        for (String c : cookieStrs) {
//            System.out.println(c);
//            cookies.addAll(HttpCookie.parse(c));
//        }
//        System.out.println(cookies);
//        return sb.toString(); 
        InputStream is = con.getInputStream();
        String contentEncoding = con.getHeaderField(CONTENT_ENCODING);
        if (contentEncoding.equals("gzip")) { // not for HEAD, there
            System.out.println("trying to use gzip");
            try {
                is = new GZIPInputStream(is, BUFFER_SIZE);
            } catch (EOFException ex) {
                System.out.println("will not use gzip because of no content");
            }
        }
        String content = fileUtils.inputStreamToString(is);
        System.out.println("execution time=" + (System.currentTimeMillis() - start) + "; length=" + content.length()); // replace by interceptor
        return content;
    }

    public String get(String urlStr) throws IOException {
        return get(urlStr, null);
    }

    private static CookieManager cm;

    private static void setCookieManager() {
        cm = new CookieManager();//
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cm);
    }

    static {
        setCookieManager();
    }

    public static CookieStore getCookieStore() {
        return cm.getCookieStore();
    }

    public static void resetCookieStore() {
        getCookieStore().removeAll();
    }

}
