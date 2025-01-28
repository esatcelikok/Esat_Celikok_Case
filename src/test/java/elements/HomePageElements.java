package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class HomePageElements {

    public HomePageElements()

    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "body > nav:nth-child(5) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
    public WebElement WhynsederButton;

    @FindBy(xpath = "//body/nav[@id='navigation']/div[@class='container-fluid']/div[@id='navbarNavDropdown']/ul[@class='navbar-nav']/li[2]/a[1]")
    public WebElement PlatformButton;

    @FindBy(css = "body > nav:nth-child(5) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")
    public WebElement SolutionsButton;

    @FindBy(xpath = ".nav-link.nav-no-dropdown[href='https://useinsider.com/our-customers/?_gl=1*cj6uc5*_up*MQ..*_ga*ODY1MzA5MDg4LjE3Mzc1MDEyNzU.*_ga_5LPMJ6EFP5*MTczNzUwMTI3Mi4xLjAuMTczNzUwMTI3Mi4wLjAuMA..']")
    public WebElement CostumersButton;

    @FindBy(css = "body > nav:nth-child(5) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(5) > a:nth-child(1)")
    public WebElement ResourcesButton;

    @FindBy(css= "body > nav:nth-child(5) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)")
    public WebElement CompanyButton;

    @FindBy(xpath = "//a[@id='highlight-en']")
    public WebElement PlatformTourButton;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='Careers']")
    public WebElement CareerLink;



}
