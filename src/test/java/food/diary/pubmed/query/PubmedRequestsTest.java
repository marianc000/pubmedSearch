/*
 */
package food.diary.pubmed.query;

import food.diary.utils.HttpUtils;
import java.io.IOException;
import java.net.URI;
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
    public void testMakeFirstRequest() throws IOException {

        assertTrue(getCookieUrls().isEmpty());
        System.out.println(">>>" + i.makeFirstRequest());
        System.out.println(getCookieUrls());
        assertEquals(getCookieUrls().size(), 1);
        assertTrue(getCookieUrls().get(0).toString().equals("http://www.ncbi.nlm.nih.gov"));
    }
}
