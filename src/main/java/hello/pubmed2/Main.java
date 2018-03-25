package hello.pubmed2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static String pubmedUrl = "https://www.ncbi.nlm.nih.gov/pubmed/?term=(((exclusion)+OR+elimination)+AND+diet)+AND+ibs";
    static String SET_COOKIE_HEADER = "Set-Cookie";

    String get(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("HEAD");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String l;

            while ((l = in.readLine()) != null) {
                System.out.println(l);
            }
        }

        List<String> cookieStrs = con.getHeaderFields().get(SET_COOKIE_HEADER);
        List<HttpCookie> cookies = new LinkedList<>();
        for (String c : cookieStrs) {
            System.out.println(c);
            cookies.addAll(HttpCookie.parse(c));
        }
        System.out.println(cookies);
        return null;
    }
    private CookieManager cm;

    void setCookieManager() {
        cm = new CookieManager();
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cm);
    }

    public static void main(String... args) throws IOException {
        Main i = new Main();
        i.setCookieManager();
        System.out.println(CookieHandler.getDefault());
        i.get(pubmedUrl);
        System.out.println(">>> " + i.cm.getCookieStore().getCookies());
    }
}
