package ScrollPage;

import pages.PageBase;
import utility.ConfigReader;

public class ScrollCareerPage extends PageBase {


    public void scrollLocaitonsContext() {

        isPageLoaded(5);
        clickElementWithWait(getElementLibrary().getCareersPageElements().declinebottun);
        scrollTo(getElementLibrary().getCareersPageElements().LocationsContext);

    }
    public void scrollLifeatİnsider() {

        isPageLoaded(5);
       clickElementWithWait(getElementLibrary().getCareersPageElements().declinebottun);
        scrollTo(getElementLibrary().getCareersPageElements().swiperwrap);

    }
}
