

package pages;


import utility.Driver;

public class HomePage extends PageBase {

    public void clickCareerLink (){

        clickElementWithWait(getElementLibrary().getHomepageElements().CompanyButton);
        clickElementWithWait(getElementLibrary().getHomepageElements().CareerLink);


   }
    public String getRedirationUrl() {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        return  currentUrl ;

    }





}
