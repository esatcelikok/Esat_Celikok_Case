package utility.library;


import elements.*;


public class ElementLibrary {

    HomePageElements homepageElements;
    CareersPageElements careerspageElements ;
    JobDetailPageElements JobdetailPageElements;


    OpenPositionsPageElements openpositionsPageElements;


    public ElementLibrary() {
        homepageElements = new  HomePageElements();
        careerspageElements = new  CareersPageElements();
        JobdetailPageElements = new JobDetailPageElements();
        openpositionsPageElements = new OpenPositionsPageElements();


    }

    public HomePageElements getHomepageElements() {
        return homepageElements ;
    }

    public CareersPageElements getCareersPageElements() {
        return  careerspageElements;
    }

    public JobDetailPageElements getJobDetailPageElements() {
        return JobdetailPageElements;
    }

    public OpenPositionsPageElements getOpenPositionsPageElements() {
        return openpositionsPageElements;
    }

}
