package pages;


import utility.ConfigReader;

public class JobDetailPage extends PageBase{

    public void gotoDetailPage() {

        String webSiteUrl = ConfigReader.getProperty("JobDetailUrl");
        getFlowsLibrary().navigateToUrl(webSiteUrl);
        isPageLoaded(5);

    }
}
