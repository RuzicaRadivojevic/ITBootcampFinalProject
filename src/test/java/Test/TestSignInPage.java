package Test;

import BaseTest.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSignInPage extends BaseTest {
    String validEmail = "rukiruzic123@gmail.com";
    String validPassword = "lalala";

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
    public void testSuccessfulSignIn() throws InterruptedException {
        homePage.clickSignInBtn();
        signInPage.inputExisitingEmail(validEmail);
        signInPage.inputExisitingPassword(validPassword);
        signInPage.clickSignInButton();

        Thread.sleep(2000);

        String message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        softAssert.assertEquals(signInPage.getWelcomeToAccountMessage(), message);
        softAssert.assertAll();


    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][]
                {
                        {"rukiruzic123@gmail.com", ""},
                        {"", "lalala"},
                        {"", ""},
                };
    }

    @Test(dataProvider = "invalidCredentials")
    public void testMessageAfterInvalidCredentialsInput(String email, String password) throws InterruptedException {
        homePage.clickSignInBtn();
        signInPage.inputExisitingEmail(email);
        signInPage.inputExisitingPassword(password);
        signInPage.clickSignInButton();
        Thread.sleep(2000);

        softAssert.assertTrue(signInPage.getAlertMessage().isDisplayed());
        softAssert.assertAll();

    }
}