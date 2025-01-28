package utility.library;

import pages.*;

public class PageLibrary {

    HomePage homepage;
    CareersPage careerspage;
    JobDetailPage jobdetailPage;
    OpenPositionsPage openpositionsPage;



    public PageLibrary() {
         homepage = new HomePage();
         careerspage = new CareersPage();
        jobdetailPage = new JobDetailPage();
        openpositionsPage = new OpenPositionsPage();

    }

    public HomePage getHomePage() {
        return homepage;
    }

    public CareersPage getCareersPage() {
        return careerspage;
    }

    public JobDetailPage getJobDetailPage() {
        return jobdetailPage;
    }

    public OpenPositionsPage getOpenPositionsPage() {
        return openpositionsPage;
    }


}
