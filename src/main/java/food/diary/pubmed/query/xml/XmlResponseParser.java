package food.diary.pubmed.query.xml;

import food.diary.pubmed.entities.Article;
import food.diary.utils.FileUtils; 
 
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlResponseParser {

    Pattern ARTICLE_PATTERN = Pattern.compile("&lt;PubmedArticle&gt;(.*?)&lt;/PubmedArticle&gt;", Pattern.DOTALL);
    Pattern ARTICLE_TITLE_PATTERN = Pattern.compile("&lt;ArticleTitle&gt;(.*?)&lt;/ArticleTitle&gt;", Pattern.DOTALL);
    Pattern ARTICLE_ABSTRACT_PATTERN = Pattern.compile("&lt;AbstractText.*?&gt;(.*?)&lt;/AbstractText&gt;", Pattern.DOTALL);
    Pattern ARTICLE_ID_PATTERN = Pattern.compile("&lt;ArticleId IdType=\"pubmed\"&gt;(.*?)&lt;/ArticleId&gt;", Pattern.DOTALL);
    Pattern ARTICLE_KEYWORD_PATTERN = Pattern.compile("&lt;Keyword .*?&gt;(.*?)&lt;/Keyword&gt;", Pattern.DOTALL);

    List<String> getArticleXmlParts(String responseBody) {
        List<String> l = new LinkedList<>();
        Matcher m = ARTICLE_PATTERN.matcher(responseBody);
        int c = 0;
        while (m.find()) {
            c++;
            l.add(m.group(1));
        }
        return l;
    }

    String getTitle(String article) {
        Matcher m = ARTICLE_TITLE_PATTERN.matcher(article);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

  String  /* List<String>*/ getAbstract(String article) {
        Matcher m = ARTICLE_ABSTRACT_PATTERN.matcher(article);
        List<String> l = new LinkedList<>();
        while (m.find()) {
            l.add(m.group(1));
        }
        return String.join("\n", l);
    }

    String getId(String article) {
        Matcher m = ARTICLE_ID_PATTERN.matcher(article);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    List<String> getKeywords(String article) {
    //    System.out.println(article);
     //   System.out.println();
        Matcher m = ARTICLE_KEYWORD_PATTERN.matcher(article);
        List<String> l = new LinkedList<>();
        while (m.find()) {
            l.add(m.group(1));
    //        System.out.println(m.group(1));
        }
        return l;
    }

    List<Article> getArticles(String resp) {
        List<String> articleXmls = getArticleXmlParts(resp);
        List<Article> articles = new LinkedList<>();
        for (String a : articleXmls) {
            Article article = new Article(getId(a), getTitle(a), getAbstract(a), getKeywords(a));
            articles.add(article);
               System.out.println(">>>>>" + article);
        }
        return articles;
    }

    public static void main(String[] ar) throws IOException {
        XmlResponseParser i = new XmlResponseParser();
        String resp = new FileUtils().inputStreamToString(i.getClass().getResourceAsStream("/output.xml"));
        i.getArticles(resp);
    }
}
