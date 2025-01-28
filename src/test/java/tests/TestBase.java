package tests;



import org.testng.annotations.BeforeMethod;
import utility.Driver;
import utility.Utility;
import utility.library.ElementLibrary;
import utility.library.FlowsLibrary;
import utility.library.PageLibrary;
import utility.library.ScrollPageLibrary;

import java.time.Duration;


public class TestBase extends Utility {

    FlowsLibrary flowsLibrary;
    PageLibrary pageLibrary;
    ScrollPageLibrary scrollPageLibrary;

    private final ElementLibrary elementsLibrary;

    public TestBase() {
        elementsLibrary = new ElementLibrary();
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100000));
         flowsLibrary = new FlowsLibrary();
         pageLibrary = new PageLibrary();
        scrollPageLibrary = new ScrollPageLibrary();


    }

   /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.close();
    }

    */


    public  FlowsLibrary getFlowsLibrary() {
        return flowsLibrary;
    }
    public   PageLibrary getPageLibrary() {
        return pageLibrary;
    }
    public ElementLibrary getElementLibrary() {
        return  elementsLibrary;
    }
    public  ScrollPageLibrary getScrollPageLibrary() {
        return scrollPageLibrary;
    }


}
