package food.diary.utils;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    FileUtils fileUtils = new FileUtils();

    public String get(String urlStr, String method) throws IOException {
        long start = System.currentTimeMillis();

        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        if (method != null) {
            con.setRequestMethod(method);
        }//    con.setRequestMethod("HEAD");
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
        try {
            return fileUtils.inputStreamToString(con.getInputStream());
        } finally {
            System.out.println("execution time=" + (System.currentTimeMillis() - start)); // replace by interceptor

        }
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

    public   static CookieStore getCookieStore() {
        return cm.getCookieStore();
    }

    public   static void resetCookieStore() {
        getCookieStore().removeAll();
    }

}
