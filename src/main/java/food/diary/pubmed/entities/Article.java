package food.diary.pubmed.entities;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Article {

    String id;
    String title;
    String abstracts;
    List<String> keywords;

    static Pattern TAGS_PATTERN = Pattern.compile("&lt;([bi])&gt;(\\w+?)&lt;/\\1&gt;");
    static Pattern BRACKETS_WITH_NUMBERS_PATTERN = Pattern.compile(" ?\\([^\\(]*?[0-9][^\\(]*?\\)");
    static Pattern SQUARE_BRACKETS_PATTERN = Pattern.compile(" ?\\[[^\\[]+?\\]");

    static String removeTags(String str) {
        Matcher m = TAGS_PATTERN.matcher(str);
        return m.replaceAll(" $2 ");
    }

    static String removeSquareBrackets(String str) {
        Matcher m = SQUARE_BRACKETS_PATTERN.matcher(str);
        return m.replaceAll("");
    }

    static String removeBrackets(String str) {
        //  System.out.println("1 : " + str);
        Matcher m = BRACKETS_WITH_NUMBERS_PATTERN.matcher(str);
//        if (m.find()) {
//            System.out.println("11: " + m.group());
//        }
        String r = m.replaceAll("");
        //     System.out.println("12: " + r);
        Matcher m2 = BRACKETS_WITH_NUMBERS_PATTERN.matcher(r);// sometimes brackets can be nested
        if (m2.find()) {
            //        System.out.println("2 : " + r);
            return removeBrackets(r);
        } else {
            return r;
        }
    }

    public Article(String id, String title, String abstracts, List<String> keywords) {
        this.id = id;
        this.title = title;
        this.abstracts = abstracts;
        this.keywords = keywords;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return "https://www.ncbi.nlm.nih.gov/pubmed/" + id;
    }

    public String getAbstracts() {
        return removeTags(removeBrackets(removeSquareBrackets(abstracts)));
    }

    public List<String> getKeywordsAsList() {
        return keywords;
    }

    public String getKeywords() {
        return String.join(", ", keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);

    }

    @Override
    public boolean equals(Object obj) {
        final Article other = (Article) obj;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + "\ntitle=" + title + "\nabstracts=" + abstracts + "\nkeywords=" + keywords + "}\n";
    }

}
