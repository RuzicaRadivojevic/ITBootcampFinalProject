package Test;

import BaseTest.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestHomePage extends BaseTest {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void closePage() {
        driver.manage().getCookies();
        driver.close();
        driver.quit();
    }

    @Test
    public void testDoesBrowserOpenCorrectPageAndIfTheProductIsAddedInTheCart() throws InterruptedException {
        hoverToElement(homePage.getWomen());
        hoverToElement(homePage.getSummerDresses());
        softAssert.assertEquals(homePage.SummerDressesGetText(), "Summer Dresses");
        homePage.clickSummerDresses();
        softAssert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?id_category=11&controller=category");
        hoverToElement(homePage.getFirstDress());
        hoverToElement(homePage.getAddToCart());
        homePage.clickOnAddToCardButton();
        Thread.sleep(4000);

        softAssert.assertEquals(homePage.getAddedToCartMessage(), "Product successfully added to your shopping cart");
        softAssert.assertAll();
    }

}
