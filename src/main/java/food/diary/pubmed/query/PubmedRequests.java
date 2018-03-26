package food.diary.pubmed.query;

import food.diary.utils.HttpUtils;
import java.io.IOException;

public class PubmedRequests {
 
     RequestParams urls = new RequestParams();
    HttpUtils httpUtils = new HttpUtils();


     String makeFirstRequest() throws IOException {
        return httpUtils.get(urls.getPubmedFirstUrl(),"HEAD");
    }

    String makeSecondRequest() throws IOException {
        return httpUtils.get(urls.getPubmedSecondUrl());
    }

    String getXmlResult() throws IOException {
        httpUtils.resetCookieStore();
        makeFirstRequest();
        return makeSecondRequest();
    }

    public static void main(String... args) throws IOException {
        PubmedRequests i = new PubmedRequests();
        i.getXmlResult();
    }
}
