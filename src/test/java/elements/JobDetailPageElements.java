package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;


public class JobDetailPageElements {

    public JobDetailPageElements()

    {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[normalize-space()='Senior Software Quality Assurance Engineer']")
    public WebElement PositionTitle;
    @FindBy(xpath = "//div[@class='postings-btn-wrapper']")
    public WebElement ApplyjobBtn;

//h2[normalize-space()='Senior Software Quality Assurance Engineer'] PositionTitle
    //div[@class='postings-btn-wrapper'] ApplyjobBtn
}
