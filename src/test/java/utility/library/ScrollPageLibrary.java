package utility.library;


import ScrollPage.ScrollCareerPage;
import ScrollPage.ScrollOpenPositionsPage;

public class ScrollPageLibrary {


    ScrollCareerPage scrollCareerPage;
    ScrollOpenPositionsPage scrollOpenPositionsPage;

    public ScrollPageLibrary() {
        scrollCareerPage =new ScrollCareerPage ();
        scrollOpenPositionsPage=new ScrollOpenPositionsPage();
    }

    public ScrollCareerPage getScrollCareerPage() {
        return scrollCareerPage;
    }

    public ScrollOpenPositionsPage getScrollOpenPositionsPage() {
        return scrollOpenPositionsPage;
    }
}
