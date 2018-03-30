package food.diary.pubmed.query;

import food.diary.utils.HttpUtils;
import java.io.IOException;

public class PubmedRequests {

    RequestParams urls = new RequestParams();
    HttpUtils httpUtils = new HttpUtils();

    String makeFirstRequest(int index) throws IOException {
        System.out.println(">makeFirstRequest");
        return httpUtils.get(urls.getPubmedFirstUrl(index), "HEAD");
    }

    String makeSecondRequest(int index) throws IOException {
        System.out.println(">makeSecondRequest");
        return httpUtils.get(urls.getPubmedSecondUrl(index));
    }

    public String getXmlResult(int index) throws IOException {
        System.out.println(">getXmlResult");
        HttpUtils.resetCookieStore();
        makeFirstRequest(index);
        return makeSecondRequest(index);
    }

//    public static void main(String... args) throws IOException {
//        PubmedRequests i = new PubmedRequests();
//        i.getXmlResult();
//    }
}
