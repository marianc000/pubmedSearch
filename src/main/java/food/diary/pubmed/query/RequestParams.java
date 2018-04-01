package food.diary.pubmed.query;

public class RequestParams {

    static String[] SECOND_REQUEST_PARAMETERS = {"term=%28%28%28exclusion%29+OR+elimination%29+AND+diet%29+AND+ibs+",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_PageController.PreviousPageName=results",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_Facets.FacetsUrlFrag=filters%3D",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_Facets.FacetSubmitted=false",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.sPresentation=xml",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.sSort=none",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.sPageSize=20",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.FFormat=docsum",
        "citman_count=20",
        "citman_start=1",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.FileFormat=docsum",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.LastPresentation=docsum",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.Presentation=xml",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.PageSize=20",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.LastPageSize=20",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.Format=text",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.PrevPageSize=20",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.PrevPresentation=docsum",
        "CollectionStartIndex=1",
        "CitationManagerStartIndex=1",
        "CitationManagerCustomRange=false",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_ResultsController.ResultCount=72",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_Pager.cPage=1",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_Pager.CurrPage=1",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_Pager.cPage=1",
        "EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.EmailTab.EmailHID=16WYBH8NuO0xS_SMBJ0eM2WE2Tutpew-qr72krvj5l8Vvs8rqYTVACDCETULZUyNpAUqnodTxvm7ZMXLEUJGUA4sVZMBUjxMea",
        "EntrezSystem2.PEntrez.DbConnector.Db=pubmed",
        "EntrezSystem2.PEntrez.DbConnector.LastDb=pubmed",
        "EntrezSystem2.PEntrez.DbConnector.Term=%28%28%28exclusion%29+OR+elimination%29+AND+diet%29+AND+ibs",
        "EntrezSystem2.PEntrez.DbConnector.LastQueryKey=1",
        "EntrezSystem2.PEntrez.DbConnector.Cmd=displaychanged",
        "p%24a=EntrezSystem2.PEntrez.PubMed.Pubmed_ResultsPanel.Pubmed_DisplayBar.sPresentation",
        "p%24l=EntrezSystem2",
        "p%24st=pubmed"};

    static String PUBMED_BASE_URL = "https://www.ncbi.nlm.nih.gov/pubmed?";
    static String PUBMED_QUERY_PARAMETER = "term=";
    //TODO:put to properties
    //   static String[] PUBMED_QUERIES = {"(((exclusion)+OR+elimination)+AND+diet)+AND+ibs", "food+diary+diet+ibs", "%22food+diary%22+OR+%22food+journal%22"};
    static String[] PUBMED_QUERIES = {"diet AND ibs"};

    static String SECOND_REQUEST_PARAMETERS_QUERY_PLACEHOLDER = "%28%28%28exclusion%29+OR+elimination%29+AND+diet%29+AND+ibs";

    //  "food+diary+diet+ibs", "food diary" OR "food journal" 
    public String getPubmedSecondUrl(int index) {
        return PUBMED_BASE_URL + String.join("&", SECOND_REQUEST_PARAMETERS).replace(SECOND_REQUEST_PARAMETERS_QUERY_PLACEHOLDER, getPubmedQuery(index));
    }

    public String getPubmedQuery(int index) {
        return PUBMED_QUERIES[index].replace(" ", "+");// get them from properties file
    }

    public static int getPubmedQueriesCount() {
        return PUBMED_QUERIES.length;
    }

    public String getPubmedFirstUrl(int index) {
        return PUBMED_BASE_URL + PUBMED_QUERY_PARAMETER + getPubmedQuery(index);
    }

}
