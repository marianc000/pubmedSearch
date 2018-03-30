package food.diary.pubmed.entities;

import java.util.List;
import java.util.Objects;

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
