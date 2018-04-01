package food.diary.pubmed;

import food.diary.pubmed.entities.Article;
import food.diary.pubmed.query.PubmedRequests;
import static food.diary.pubmed.query.RequestParams.getPubmedQueriesCount;
import food.diary.pubmed.query.xml.XmlResponseParser;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Loader {

    private static Set<Article> articles;

    public  Set<Article> getArticles() {
        System.out.println(">>>getArticles");
        if (articles == null) {
            try {
                articles = refreshAllArticles();
            } catch (IOException ex) {
                System.out.println("failed to load articles from pubmed");
                ex.printStackTrace();
                if (articles == null) {
                    System.out.println("previous articles were null");
                    articles = new HashSet<>();
                }
            }
        }
        return articles;
    }

    private static Set<Article> refreshAllArticles() throws IOException {
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

    @PostConstruct
    void postConstruct() {
        getArticles();
    }
}
