/*
 */
package food.diary.pubmed.query.xml;

import food.diary.utils.FileUtils;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author caikovsk
 */
public class XmlResponseParserTest {

    XmlResponseParser i = new XmlResponseParser();

    public void testGetArticleXmlParts(String resp) throws IOException {

        List<String> l = i.getArticleXmlParts(resp);
        assertEquals(l.size(), 20);
        //   System.out.println(l.get(0));
        String article = l.get(0);
        assertEquals(i.getId(article), "29413008");
        assertEquals(i.getTitle(article), "The Role of Diet in the Treatment of Irritable Bowel Syndrome: A Systematic Review.");
        assertEquals(i.getAbstract(article), "Irritable bowel syndrome (IBS) is a multifaceted illness involving maladaptive shifts in"
                + " the gut microbiota that affect the enteric nervous and immune systems, mucosal barrier function, the balance of "
                + "neurotransmitters and hormones, and emotional well-being. There is abundant evidence indicating that certain foods "
                + "elicit symptoms in IBS. Numerous elimination-type diets have been shown to alleviate symptoms. However, among these,"
                + " the most controversial is a group of foods called fructo, oligo-, di-, and monosaccharides and polyols (FODMAPs). This paper reviews"
                + " the role of diet and systematically analyze the literature for the role of FODMAPs in IBS.");
        assertEquals(i.getKeywords(article).toString(), "[Diet, Elimination diets, FODMAPs, Fiber, Food sensitivities, Gluten, Irritable bowel syndrome, Nutrition]");

        article = l.get(1);
        assertEquals(i.getId(article), "29206754");
        assertEquals(i.getTitle(article), "Abdominal Ultrasound Does Not Reveal Significant Alterations in Patients With Nonceliac Wheat Sensitivity.");

        assertEquals(i.getAbstract(article), "The goal of this study was (A) to evaluate abdominal ultrasound signs in nonceliac wheat sensitivity (NCWS) patients for features useful in diagnosis and (B) to compare these aspects with those of celiac patients to assess whether ultrasound can be useful in the differential diagnosis between NCWS and celiac disease (CD).\n"
                + "NCWS diagnosis is difficult as no biomarkers of this condition have as yet been identified. In CD ultrasound aspects have been identified that have a good diagnostic accuracy.\n"
                + "We prospectively recruited 45 NCWS patients (11 males, 34 females; mean age 35.7 y). Three control groups were included: (A) 99 age-matched CD patients; (B) 18 patients with seronegative CD; (C) 50 patients with irritable bowel syndrome (IBS) who did not improve on a wheat-free diet. NCWS diagnosis was confirmed on the basis of an elimination diet and double-blind placebo-controlled (DBPC) challenge. Ultrasound sign investigation included: dilatation of the small bowel loops, thickening of the small bowel wall, hyperperistalsis, enlarged mesenteric lymph nodes, ascites, hyposplenism, altered diameter of the portal vein.\n"
                + "NCWS patients showed a low frequency of pathologic ultrasound findings. Dilated or thickened loops appeared more often in CD patients than in NCWS patients (88.8% vs. 20%; P&amp;lt;0.0001). These US signs were significantly more frequent in seronegative CD than in NCWS patients (both P&amp;lt;0.0001), whereas no difference was found between NCWS patients and IBS controls.\n"
                + "In NCWS patients' ultrasound does not show a characteristic pattern which could be helpful for diagnosis. However, US can be useful to differentiate between NCWS and CD patients and especially those with seronegative CD. (ClinicalTrials.gov NCT03017274).");

        assertEquals(i.getKeywords(article).toString(), "[]");
        article = l.get(2);
        assertEquals(i.getId(article), "29018540");
        assertEquals(i.getTitle(article), "Efficacy of individualised diets in patients with irritable bowel syndrome: a randomised controlled trial.");

        assertEquals(i.getAbstract(article), "Patients with irritable bowel syndrome (IBS) are often placed on diets guided by food intolerance assays, although these have not been validated. We assessed the effects of individualised diets in patients with IBS guided by a leucocyte activation test.\n"
                + "This is a parallel-group, double-blind, randomised controlled trial of 58 adults with IBS seen at an academic health centre in Northeast USA. Peripheral venous blood was analysed using a leucocyte activation test; individual foods were reported to produce positive or negative results. Participants were randomised to a 4-week diet with either individualised guidance to eliminate foods with positive assay results and allow foods with negative assay results (intervention), or with individualised guidance, matched in rigour and complexity, to eliminate foods with negative assay results and allow foods with positive assay results (comparison). The primary outcome was between-group differences in the IBS Global Improvement Scale (GIS). Secondary outcomes included reductions in IBS Symptom Severity Scale (SSS) scores and increases in IBS Adequate Relief (AR) and Quality of Life (QOL) scores. An aptamer-based proteomic analysis was conducted in strong responders.\n"
                + "The intervention group had significantly greater increases in mean GIS score after 4 weeks (0.86 vs comparison; 95% CI 0.05 to 1.67; p=0.04) and 8 weeks (1.22 vs comparison; 95% CI 0.22 to 2.22; p=0.02). The intervention group also had significantly greater reductions in mean SSS score at 4 weeks (-61.78 vs comparison; 95% CI -4.43 to -119.14; p=0.04) and 8 weeks (-66.42 vs comparison; 95% CI -5.75 to -127.09; p=0.03). There were no significant differences between intervention and comparison groups in mean AR or QOL scores. A reduction in neutrophil elastase concentration was associated with reduced symptoms.\n"
                + "Elimination diets guided by leucocyte activation tests reduced symptoms. These findings could lead to insights into the pathophysiology of IBS.\n"
                + "NCT02186743.");
        assertEquals(i.getKeywords(article).toString(), "[Dietary Factors, Irritable Bowel Syndrome, Quality Of Life]");

        article = l.get(3);
        assertEquals(i.getId(article), "28936910");
        assertEquals(i.getTitle(article), "Modulation of the gut microbiota: a focus on treatments for irritable bowel syndrome.");
        assertEquals(i.getAbstract(article), "Irritable bowel syndrome (IBS), which is characterized by recurrent abdominal pain and disordered bowel habits, is one of the most common functional bowel disorders. IBS is a substantial burden on both patient health-related quality of life and healthcare costs. Several pathophysiologic mechanisms have been postulated for the occurrence of IBS, including altered gastrointestinal motility, visceral hypersensitivity, changes in gut permeability, immune activation, gut-brain dysregulation, central nervous system dysfunction, and changes in the gut microbiota. Of note, both qualitative and quantitative differences have been observed in the gut microbiota of a population with IBS versus a healthy population. Because of the substantial interest in the gut microbiota and its role as a therapeutic target in IBS, this article provides an overview of specific interventions with the potential to modulate the gut microbiota in IBS, including elimination diets, prebiotics, probiotics, synbiotics, and nonsystemic antibiotics. Although probiotics and synbiotics are generally well tolerated, differences in the composition and concentration of different bacterial species and inclusion or exclusion of prebiotic components varies widely across studies and has prevented strong recommendations on their use in IBS. For nonsystemic antibiotics, rifaximin is indicated in the United States for the treatment of IBS with diarrhea in adults and has been shown to be efficacious and well tolerated in well-designed clinical trials. Overall, more consistent evidence is needed regarding the efficacy and safety of elimination diets, prebiotics, probiotics, and synbiotics for the treatment of patients with IBS. Furthermore, additional well-designed studies are needed that examine alterations in the gut microbiota that occur with these interventions and their potential associations with clinical symptoms of IBS.");
        assertEquals(i.getKeywords(article).toString(), "[Antibiotic, constipation, diarrhea, diet, irritable bowel syndrome, microbiota, prebiotic, probiotic, rifaximin]");

        article = l.get(14);
        // System.out.println(i.getId(article));
        //   System.out.println(i.getTitle(article));
        //   System.out.println(i.getAbstract(article));
        //   System.out.println(i.getKeywords(article));
        assertEquals(i.getId(article), "27272325");
        assertEquals(i.getTitle(article), "British Dietetic Association systematic review and evidence-based practice guidelines for the dietary management of irritable bowel syndrome in adults (2016 update).");
        assertEquals(i.getAbstract(article), "The first British Dietetic Association (BDA) guidelines for the dietary management of irritable bowel syndrome (IBS) in adults were published in 2012. Subsequently, there has been a wealth of new research. The aim of this work was to systematically review the evidence for the role of diet in the management of IBS and to update the guidelines.\n"
                + "Twelve questions relating to diet and IBS were defined based on review of the previous guideline questions, current evidence and clinical practice. Chosen topics were on healthy eating and lifestyle (alcohol, caffeine, spicy food, elimination diets, fat and fluid intakes and dietary habits), milk and dairy, dietary fibre, fermentable carbohydrates, gluten, probiotics and elimination diets/food hypersensitivity. Data sources were CINAHL, Cochrane Register of Controlled Trials, Embase, Medline, Scopus and Web of Science up to October 2015. Studies were assessed independently in duplicate using risk of bias tools specific to each included study based on inclusion and exclusion criteria for each question. National Health and Medical Research Council grading evidence levels were used to develop evidence statements and recommendations, in accordance with Practice-based Evidence in Nutrition Global protocol used by the BDA.\n"
                + "Eighty-six studies were critically appraised to generate 46 evidence statements, 15 clinical recommendations and four research recommendations. The IBS dietary algorithm was simplified to first-line (healthy eating, provided by any healthcare professional) and second-line [low FODMAP (fermentable oligosaccharides, disaccharides, monosaccharides and polyols) to be provided by dietitian] dietary advice.\n"
                + "These guidelines provide updated comprehensive evidence-based details to achieve the successful dietary management of IBS in adults.");
        assertEquals(i.getKeywords(article).toString(), "[alcohol, caffeine, diet, dietary fibre, dietary habits, elimination diets and food hypersensitivity, fat, fermentable carbohydrates, fluid, gluten, guidelines, healthy eating, low FODMAP diet, milk and dairy, probiotics, spicy food, systematic review]");
    }

    @Test
    public void testGetArticleXmlParts() throws IOException {

        String resp = new FileUtils().inputStreamToString(getClass().getResourceAsStream("/output.xml"));
        testGetArticleXmlParts(resp);
    }
}
