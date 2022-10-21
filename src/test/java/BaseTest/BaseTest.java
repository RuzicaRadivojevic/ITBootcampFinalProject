package BaseTest;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public HomePage homePage;
    public CreateAnAccountPage accountPage;
    public SignInPage signInPage;
    public SocialNetworksPage networksPage;
    public ViewCartPage viewCartPage;
    public ContactUsPage contactUsPage;
    public SoftAssert softAssert;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        homePage = new HomePage(driver);
        accountPage = new CreateAnAccountPage(driver);
        signInPage = new SignInPage(driver);
        networksPage = new SocialNetworksPage(driver);
        viewCartPage = new ViewCartPage(driver);
        contactUsPage = new ContactUsPage(driver);
        softAssert = new SoftAssert();

    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void waitForElementVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickability(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void hoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}

