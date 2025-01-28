package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {}

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            initializeDriver();
        }
        return driverPool.get();
    }

    private static void initializeDriver() {
        String browser = System.getProperty("browser", ConfigReader.getProperty("browser"));
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driverPool.set(initChromeDriver());
                    break;
                case "edge":
                    driverPool.set(initEdgeDriver());
                    break;
                default:
                    throw new UnsupportedOperationException("Browser " + browser + " is not supported.");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Handle exceptions without using Logger
        }
    }

    private static WebDriver initChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        configureChromeOptions(options);
        return new ChromeDriver(options);
    }

    private static WebDriver initEdgeDriver() {
        return new EdgeDriver();
    }

    private static void configureChromeOptions(ChromeOptions options) {
        // Set Chrome options here
        options.addArguments("--disable-infobars");
        options.addArguments("--force-device-scale-factor=0.9"); // %90 zoom
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        // Example: Configure default download directory
        String downloadFilepath = ConfigReader.getProperty("download.default_directory");
        options.addArguments("download.default_directory=" + downloadFilepath);
    }

    public static void close() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
