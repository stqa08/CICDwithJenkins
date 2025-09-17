package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebDriverWait waitForElement;
    protected PageFactory pageFactory;
    public static Actions action;

    @BeforeClass
    public void setupBrowserAndNavigateToWebApp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080");
        options.addArguments("no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions"); // to disable extension
        options.addArguments("--disable-notifications"); // to disable notification
        options.addArguments("--disable-application-cache");
        options.addArguments("--enable-javascript");  // Enable JavaScript
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitForElement = new WebDriverWait(driver, Duration.ofSeconds(4));
        pageFactory = new PageFactory();
        action = new Actions(driver);

        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterClass
    public void closeBrowserContext() {
        driver.quit();
    }
}