package food.diary.pubmed.query;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NewClass {
 public static void main(String... args) throws IOException {
     String s="term=(((exclusion)+OR+elimination)+AND+diet)+AND+ibs";
       System.out.println(URLEncoder.encode(s, StandardCharsets.UTF_8.name()));
    }
}
