/*
 */
package food.diary.pubmed;

import food.diary.pubmed.entities.Article;
import static food.diary.pubmed.query.RequestParams.getPubmedQueriesCount;
import food.diary.pubmed.query.xml.XmlResponseParser;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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

        Set<Article> set = new Loader().getArticles();
        //  System.out.println(size);
        assertEquals(set.size(), 20);
        Set<String> keywords = new TreeSet<>();
        for (Article a : set) {
            for (String s : a.getKeywordsAsList()) {
                keywords.add(s.toLowerCase());
            }
        }
        for (String s : keywords) {
            System.out.println(s);
        }

    }
}
