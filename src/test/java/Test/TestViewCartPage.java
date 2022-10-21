package Test;

import BaseTest.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestViewCartPage extends BaseTest {
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
    public void testIfSelectedItemMatchesTheOneInTheCartAndIfItsSuccessfullyDeleted() throws InterruptedException {
        hoverToElement(homePage.getWomen());
        hoverToElement(homePage.getSummerDresses());
        homePage.clickSummerDresses();
        hoverToElement(homePage.getFirstDress());
        hoverToElement(homePage.getAddToCart());
        homePage.clickOnAddToCardButton();
        Thread.sleep(1000);
        homePage.clickProceedToCheckOutButton();

        softAssert.assertEquals(viewCartPage.getCartContainsText(), "Your shopping cart contains: 1 Product");
        softAssert.assertEquals(viewCartPage.getNameOfTheBoughtProductText(), homePage.getNameOfTheProductText());

        viewCartPage.clickDeleteItem();

        waitForElementVisibility(viewCartPage.getMessage());

        softAssert.assertEquals(viewCartPage.getMessageText(), "Your shopping cart is empty.");
        softAssert.assertAll();
    }
}
