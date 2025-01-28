package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;
import utility.library.FlowsLibrary;


public class HomePageTest extends TestBase {

    @Test(priority = 1)
public void getverifyOpenHomePageTest () {

    String webSiteUrl = ConfigReader.getProperty("URL");
    getFlowsLibrary().navigateToUrl(webSiteUrl);
    Assert.assertTrue(isPageLoaded(85),
            "Career sayfası doğru şekilde yüklenmedi.");
}

@Test(priority = 2)
public void getverifyCareerPageRedirectionTest () {

   getverifyOpenHomePageTest();
    getPageLibrary().getHomePage().clickCareerLink();

    Assert.assertTrue(getPageLibrary().getHomePage().getRedirationUrl().contains("career"),
            "Career sayfasına yönlendirilmedi!");


    }

}
