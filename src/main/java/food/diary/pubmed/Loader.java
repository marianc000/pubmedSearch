package food.diary.pubmed;

import food.diary.pubmed.entities.Article;
import food.diary.pubmed.query.PubmedRequests;
import static food.diary.pubmed.query.RequestParams.getPubmedQueriesCount;
import food.diary.pubmed.query.xml.XmlResponseParser;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Loader {

    private static Set<Article> articles;

    public static Set<Article> getArticles() throws IOException {
        if (articles == null) {
            articles = refreshAllArticles();
        }
        return articles;
    }

    private static Set<Article> refreshAllArticles() throws IOException   {
        XmlResponseParser parser = new XmlResponseParser();
        PubmedRequests http = new PubmedRequests();
        Set<Article> set = new LinkedHashSet<>();
        for (int c = 0; c < getPubmedQueriesCount(); c++) {
            String xml = http.getXmlResult(c);
            List<Article> articles = parser.getArticles(xml);
            set.addAll(articles);
        }
        return set;
    }
}
