package hello.pubmed2;

import static hello.pubmed2.RequestParams.PUBMED_BASE_URL;
import static hello.pubmed2.RequestParams.getPubmedSecondUrl;
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

    static String PUBMED_FIRST_URL = PUBMED_BASE_URL + "term=(((exclusion)+OR+elimination)+AND+diet)+AND+ibs";

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

    String get2(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String l;

            while ((l = in.readLine()) != null) {
                sb.append(l);
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
        return sb.toString();
    }

    private CookieManager cm;

    private void setCookieManager() {
        cm = new CookieManager();
        cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cm);
    }

    public Main() {
        setCookieManager();
    }

    String getXmlResult() throws IOException {
        get(PUBMED_FIRST_URL);
        return get2(getPubmedSecondUrl());
    }

    public static void main(String... args) throws IOException {
        Main i = new Main();
        i.getXmlResult();
    }
}
