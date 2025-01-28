package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utility.Driver;

import java.util.stream.IntStream;

public class OpenPositionsPage extends PageBase{

    public void Jobfilterlist(){

slepp(19000);

        clickElementWithWait(getElementLibrary().getOpenPositionsPageElements().DropdownDepertment);

        clickElementWithWait(getElementLibrary().getOpenPositionsPageElements().DepartmentQuality);

        clickElementWithWait(getElementLibrary().getOpenPositionsPageElements().DropdowmLocation);

        clickElementWithWait(getElementLibrary().getOpenPositionsPageElements().Locationİstanbul);

        slepp(2000);

        isElementVisible(getElementLibrary().getOpenPositionsPageElements().JobsCardDepartment,10);
        slepp(2000);

clickElementWithWait(getElementLibrary().getOpenPositionsPageElements().ViewRoleBtn);
slepp(5000);

    }

    public String getRedirectsUrl() {
        slepp(5000);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(currentUrl);
        return  currentUrl ;

    }
}
