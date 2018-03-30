/*
 */
package food.diary.pubmed.query;

import food.diary.pubmed.entities.Article;
import static food.diary.pubmed.query.RequestParams.getPubmedQueriesCount;
import food.diary.pubmed.query.xml.XmlResponseParser;
import food.diary.pubmed.query.xml.XmlResponseParserTest;
import food.diary.utils.HttpUtils;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caikovsk
 */
public class PubmedRequestsTest {

    PubmedRequests i = new PubmedRequests();

    List<URI> getCookieUrls() {
        return HttpUtils.getCookieStore().getURIs();
    }

    @Test
    public void testMakeRequests() throws IOException {
        HttpUtils.resetCookieStore();
        assertTrue(getCookieUrls().isEmpty());
        String xml0 = i.makeFirstRequest(0);
        Files.write(Paths.get("src\\test\\resources\\xml0.xml"), xml0.getBytes(StandardCharsets.UTF_8));
        System.out.println(">>>" + xml0.length());
        System.out.println(getCookieUrls());
        assertEquals(getCookieUrls().size(), 1);
        assertTrue(getCookieUrls().get(0).toString().equals("http://www.ncbi.nlm.nih.gov"));
        //
        String xml = i.makeSecondRequest(0);
        System.out.println(">>>" + xml.length());
        //    System.out.println(">>>" + xml);
        Files.write(Paths.get("src\\test\\resources\\xml1.xml"), xml.getBytes(StandardCharsets.UTF_8));
        assertTrue(xml.length() > 0);

        XmlResponseParserTest test = new XmlResponseParserTest();
        test.testGetArticleXmlParts(xml);
        String xml2 = i.getXmlResult(0);
//
        System.out.println(">>>" + xml2.length());
        //   System.out.println(">>>" + xml2);
        Files.write(Paths.get("src\\test\\resources\\xml2.xml"), xml2.getBytes(StandardCharsets.UTF_8));
        assertTrue(xml2.length() > 0);
        test.testGetArticleXmlParts(xml2);
    }


}
