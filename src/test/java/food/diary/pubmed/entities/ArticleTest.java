/*
 */
package food.diary.pubmed.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caikovsk
 */
public class ArticleTest {

    public ArticleTest() {
    }

    @Test
    public void testRemoveTags() {
        //Compared to healthy controls, they had significantly lower consumption of milk (74.6iversus&lt;/i&gt;88.4 g/day;
        //  String str = "Compared to healthy controls, they had significantly lower consumption of milk (74.6&lt;i&gt;versus&lt;/i&gt;88.4 g/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.0001), yogurt (108.4&lt;i&gt;versus&lt;/i&gt;115.5 g/day;&lt;i&gt;p&lt;/i&gt;= 0.001), fruits (192.3&lt;i&gt;versus&lt;/i&gt;203.8 g/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.001), and higher soft non-sugared beverages (1167.2&lt;i&gt;versus&lt;/i&gt;1122.9 ml/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.001). They had higher total energy intake (2028.9&lt;i&gt;versus&lt;/i&gt;1995.7 kcal/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.001), with higher intakes of lipids (38.5&lt;i&gt;versus&lt;/i&gt;38.1% of total energy intake;&lt;i&gt;p&lt;/i&gt;= 0.001) and lower intakes of proteins (16.4&lt;i&gt;versus&lt;/i&gt;16.8% of total energy intake;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.0001), as well as micronutrients (calcium, potassium, zinc and vitamins B2, B5 and B9, all&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.0001).";
        //               Compared to healthy controls, they had significantly lower consumption of milk (74.6s88.4 g/day
        String str = "Compared to healthy controls, they had significantly lower consumption of milk (74.6&lt;i&gt;versus&lt;/i&gt;88.4 g/day";

        String r = Article.removeTags(str);
        //    System.out.println(r);
        assertEquals(r, "Compared to healthy controls, they had significantly lower consumption of milk (74.6 versus 88.4 g/day");

        str = "dietary intake and the&lt;i&gt;TAS1R2&lt;/i&gt;genotype in lean";
        r = Article.removeTags(str);
        //   System.out.println(r);

        assertEquals(r, "dietary intake and the TAS1R2 genotype in lean");
    }

    @Test
    public void testRemoveBrackets() {
        String str = "Subjects included were mainly women (76.9%) and the mean age was 50.2 ± 14.2 years. Among these individuals, 1870 (5.1%) presented with IBS. Compared to healthy controls, they had significantly lower consumption of milk (74.6&lt;i&gt;versus&lt;/i&gt;88.4 g/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.0001), yogurt (108.4&lt;i&gt;versus&lt;/i&gt;115.5 g/day;&lt;i&gt;p&lt;/i&gt;= 0.001), fruits (192.3&lt;i&gt;versus&lt;/i&gt;203.8 g/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.001), and higher soft non-sugared beverages (1167.2&lt;i&gt;versus&lt;/i&gt;1122.9 ml/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.001). They had higher total energy intake (2028.9&lt;i&gt;versus&lt;/i&gt;1995.7 kcal/day;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.001), with higher intakes of lipids (38.5&lt;i&gt;versus&lt;/i&gt;38.1% of total energy intake;&lt;i&gt;p&lt;/i&gt;= 0.001) and lower intakes of proteins (16.4&lt;i&gt;versus&lt;/i&gt;16.8% of total energy intake;&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.0001), as well as micronutrients (calcium, potassium, zinc and vitamins B2, B5 and B9, all&lt;i&gt;p&lt;/i&gt;&amp;lt; 0.0001).";
        String r = Article.removeBrackets(str);
        //    System.out.println(r);
        assertEquals(r, "Subjects included were mainly women and the mean age was 50.2 ± 14.2 years. Among these individuals, 1870 presented with IBS. Compared to healthy controls, they had significantly lower consumption of milk, yogurt, fruits, and higher soft non-sugared beverages. They had higher total energy intake, with higher intakes of lipids and lower intakes of proteins, as well as micronutrients.");
        str = "healthy children (median=2 [25% to 75% quartile=0 to 4]; χ(2)=28.6; P&amp;lt;0.001). Children";
        r = Article.removeBrackets(str);
        //System.out.println(r);
        assertEquals(r, "healthy children. Children");
        //
        str = "A greater proportion of children with IBS (143 of 154 [92.9%]) vs healthy children (20 of 32 [62.5%]) identified at least one self-perceived food intolerance (χ(2)=22.5; P&amp;lt;0.001). Children with IBS identified a greater number (median=4 [25% to 75% quartile=2 to 6]) of perceived symptom-inducing foods than healthy children (median=2 [25% to 75% quartile=0 to 4]; χ(2)=28.6; P&amp;lt;0.001). Children with IBS avoided more foods (median=2 [25% to 75% quartile=1 to 4]) than healthy children (median=0 [25% to 75% quartile=0 to 2.75]; χ(2)=20.8; P&amp;lt;0.001). The number of self-perceived food intolerances was weakly associated (r value range= -0.17 to 0.21) with pain frequency, pain severity, somatization, anxiety, functional disability, and decreased quality of life.";

        r = Article.removeBrackets(str);
        //   System.out.println(r);
        assertEquals(r, "A greater proportion of children with IBS vs healthy children identified at least one self-perceived food intolerance. Children with IBS identified a greater number of perceived symptom-inducing foods than healthy children. Children with IBS avoided more foods than healthy children. The number of self-perceived food intolerances was weakly associated with pain frequency, pain severity, somatization, anxiety, functional disability, and decreased quality of life.");

    }

    @Test
    public void testRemoveSquareBrackets() {
        String str = "the major (T) allele carriers consumed more carbohydrates [TT = 45.2 percentage of energy intake (E%); TG = 45.2E%; GG = 43.7E%;&lt;i&gt;p&lt;/i&gt; = 0.01] and less fat";
        String r = Article.removeSquareBrackets(str);
        //     System.out.println(r);
        assertEquals(r, "the major (T) allele carriers consumed more carbohydrates and less fat");
    }
}
