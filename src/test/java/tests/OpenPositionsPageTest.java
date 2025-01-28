package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class OpenPositionsPageTest extends TestBase {

    public void gotoqualityassurancepage () {

        String webSiteUrl = ConfigReader.getProperty("OpenPositionUrl");
        getFlowsLibrary().navigateToUrl(webSiteUrl);
    }
    @Test(priority = 1)
    public void JobsCardFilterCheck() throws InterruptedException {
        gotoqualityassurancepage();
        getScrollPageLibrary().getScrollOpenPositionsPage().scrolljobslist();
       getPageLibrary().getOpenPositionsPage().Jobfilterlist();

        Assert.assertEquals(getElementLibrary().getOpenPositionsPageElements().
                JobsCardDepartment.getText(),"Quality Assurance");
        Assert.assertEquals(getElementLibrary().getOpenPositionsPageElements().
                JobsCardLocation.getText(),"Istanbul, Turkey");
    }
    @Test(priority = 2)
    public void RedirectsViewRoleBtn(){
        isPageLoaded(20);
Assert.assertEquals(getPageLibrary().getOpenPositionsPage().getRedirectsUrl(),
        "https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc");

    }
}
