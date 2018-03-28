package food.diary.pubmed.entities;

import java.util.List;

public class Article {

    String id;
    String title;
    String abstracts;
    List<String> keywords;

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

    public String getAbstracts() {
        return abstracts;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + "\ntitle=" + title + "\nabstracts=" + abstracts + "\nkeywords=" + keywords + "}\n";
    }

}
