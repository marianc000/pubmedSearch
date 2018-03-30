/*
 */
package food.diary.pubmed;

import food.diary.pubmed.entities.Article;
import static food.diary.pubmed.query.RequestParams.getPubmedQueriesCount;
import food.diary.pubmed.query.xml.XmlResponseParser;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caikovsk
 */
public class LoaderTest {

    public LoaderTest() {
    }

    @Test
    public void testGetArticles() throws IOException {

        int size = Loader.getArticles().size();
        System.out.println(size);
        assertTrue(size == 60);
    }
}
