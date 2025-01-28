package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.library.FlowsLibrary;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Utility extends FlowsLibrary {


    //web elementinin tıklanabilir kontrolü
    public static boolean isClickable(WebElement element) {

        try {

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    //sayfanın tamamen yüklenmesini beklemek
    public boolean isPageLoaded(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeoutInSeconds));

        try {

            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    //webelementinin görünür olup olmadığını
    public static boolean isElementVisible(WebElement element, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitTime));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //öğe sayfada görünür olması
    public static void scrollTo(WebElement element1) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView()", element1);

        if (isElementVisible(element1, 20)) {
            System.out.println("sayfada gorundu");
        }
    }

    public void scrollUntilBothElementsVisibleFullScroll(WebElement element1, WebElement element2) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        boolean isElement1Visible = element1.isDisplayed();
        boolean isElement2Visible = element2.isDisplayed();

        while (!isElement1Visible || !isElement2Visible) {

            js.executeScript("arguments[0].scrollIntoView()", element1, element2);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isElement1Visible = element1.isDisplayed();
            isElement2Visible = element2.isDisplayed();
        }


    }

    //weböğesini sayfada merkezde görünür duruma getirme
    public static void scrollToCenter(WebElement element1, WebElement element2) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView({block:\"center\"})", element1, element2);
    }


    //fareyle üzerine gelindiğinde öğelerin görünmesi
    public static void hoverOver(WebElement element, int waitTime) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(Duration.ofMillis(waitTime)).build().perform();
        //actions.moveToElement(element).build().perform();
    }

    //webelementine tıklama
    public void clickElement(WebElement element) {
        element.click();
    }


    //element görünür olduktan sonra tıklama
    public void clickElementWithWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    //input elemanın içeriğini temizleme
    public void clearElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
    }


    //webwlwmwntie input değeri yazmak
    public void sendKeyToElement(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }


    //dropdown menüsü deki value leri seçmek
    public void selectElementByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    //index dergirene gore secim
    public void selectElementByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    //text icerigini alma
    public String getTextElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    //web elementinde text varlığını beklemesi
    public boolean isTextPresentInElement(WebElement element, String text, int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    //Js ile tıklama
    public void clickWithJSExecutor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    //js ile inputa metin gonderme
    public void sendKeyWithJSExecutor(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript(("arguments[0].value=" + text + ";"), element);
    }


    //Yeni pencere geçişi
    public void switchToNewWindow() {
        String currentWindow = Driver.getDriver().getWindowHandle();
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    //elementin var olup olmadığı kontrol
    public boolean doesElementExist(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitTime));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }


    }


    //alert kontrol
    public void switchToAlertAndAccept(int waitTime) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public static void scrollToWait(WebElement element1) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollBy(0, 50);");

            if (isElementVisible(element1, 5)) {
                break;
            }
            /*
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;

             */
        }
    }


    public void pscrol(WebElement element5) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        while (true) {
            js.executeScript("window.scrollBy(0, 50);");
            try {
                Thread.sleep(1000); // 100ms bekle, kaydırmanın daha yavaş olmasını sağla
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (element5.isDisplayed()) {
                break;
            }
        }
    }

    public String getImageUrl(WebElement element8) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        String imageUrl = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0])." +
                        "getPropertyValue('background-image');",
                element8
        );

        if (imageUrl != null && imageUrl.contains("url(")) {
            imageUrl = imageUrl.replace("url(\"", "").
                    replace("\")", "");
        }

        return imageUrl;
    }

    public static void scrollTo22(int scrollToPosition, int sleepTime) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, " + scrollToPosition + ")");
        TimeUnit.MILLISECONDS.sleep(sleepTime);
    }

    public void action(WebElement element){
        Actions actions = new Actions( Driver.getDriver());
        actions.moveToElement(element).click().build().perform();
    }
public void slepp(int i){
    try {
        Thread.sleep(i);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
