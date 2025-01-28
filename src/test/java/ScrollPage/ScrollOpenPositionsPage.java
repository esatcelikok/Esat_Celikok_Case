package ScrollPage;

import pages.PageBase;

public class ScrollOpenPositionsPage extends PageBase {

public void scrolljobslist () throws InterruptedException {

    isPageLoaded(10);
    clickElementWithWait(getElementLibrary().getCareersPageElements().declinebottun);
   scrollTo(getElementLibrary().getOpenPositionsPageElements().ScrollBrowse);


    }
}
