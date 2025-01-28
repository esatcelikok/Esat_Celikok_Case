package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import utility.ConfigReader;
import utility.library.PageLibrary;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CareersPageTest extends TestBase {

    public void gotocareerpage () {

        String webSiteUrl = ConfigReader.getProperty("career");
        getFlowsLibrary().navigateToUrl(webSiteUrl);
    }

    @Test()
    public void LocationsCardsCheck() {

      gotocareerpage();
  getScrollPageLibrary().getScrollCareerPage().scrollLocaitonsContext();

        List<Map<String, String>> expectedData = ActualData.CountryCapitalData();
       List<Map<String, String>> resultData = getPageLibrary().getCareersPage().CountryCapitalMatch();

       Assert.assertEquals(getElementLibrary().getCareersPageElements().
                cards.size(), 25);
        Assert.assertEquals(resultData,expectedData,
                "ülke şehir eşleşemedi");

        Assert.assertEquals(getElementLibrary().getCareersPageElements().Locationtitle.getText(),
                "Our Locations");

        Assert.assertEquals(getElementLibrary().getCareersPageElements().LocationsContext.getText(),
               "28 offices across 6 continents, home to 1100+ Insiders" );

    }


    @Test()
    public void SwiperAutoSlideCheckTest() {

      gotocareerpage();
      getScrollPageLibrary().getScrollCareerPage().scrollLifeatİnsider();
        List<Boolean> results = getPageLibrary().getCareersPage().SwiperAutoSlideCheck();

        getPageLibrary().getCareersPage().SwiperAutoSlideCheck().forEach(

                result -> Assert.assertTrue(result, "AutoSlide yapılamıyor" +
                        results.indexOf(result)));

    }









}
