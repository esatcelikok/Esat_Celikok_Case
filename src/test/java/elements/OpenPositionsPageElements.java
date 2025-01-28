package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class OpenPositionsPageElements {

    public OpenPositionsPageElements()

    {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[1]/span[1]/span[1]/span[2]")
    public WebElement DropdowmLocation;
    @FindBy(xpath = "//ul[@id='select2-filter-by-location-results']/li[2]")
    public WebElement Locationİstanbul;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    public WebElement DropdownDepertment;
    @FindBy(xpath = "//ul[@id='select2-filter-by-department-results']/li[12]")
    public WebElement DepartmentQuality;


    @FindBy(xpath = "//h3[contains(text(),'Browse')]")
    public WebElement ScrollBrowse;

    @FindBy(xpath = "//section[@id='career-position-list']//div[@class='row']//div[1]//div[1]//a[1]")
    public WebElement ViewRoleBtn;

    @FindBy(xpath = "//p[normalize-space()='Senior Software Quality Assurance Engineer']")
    public WebElement JobsCardTitle;

    @FindBy(xpath = "//section[@id='career-position-list']//div[@class='row']//div[1]//div[1]//span[1]")
    public WebElement JobsCardDepartment;

    @FindBy(xpath = "//section[@id='career-position-list']//div[@class='row']//div[1]//div[1]//div[1]")
    public WebElement JobsCardLocation;






//section[@id='career-position-list']//div[@class='row']//div[1]//div[1]//span[1]
}



