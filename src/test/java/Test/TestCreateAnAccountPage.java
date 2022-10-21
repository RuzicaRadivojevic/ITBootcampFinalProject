package Test;

import BaseTest.BaseTest;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCreateAnAccountPage extends BaseTest {

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
    public void testIfAccountIsCreatedAndVisibilityFuctionalityOfLogOutButton() throws InterruptedException {
        homePage.clickSignInBtn();
        signInPage.inputEmailToCreateAnAccount(Faker.instance().bothify("????@gmail.com"));
        signInPage.clickOnCreateAccountBtn();
        accountPage.clickGender();
        accountPage.clickAndInputFirstName(Faker.instance().bothify("?????"));
        accountPage.clickAndInputLastName(Faker.instance().bothify("?????"));
        accountPage.clickAndInputPassword(Faker.instance().bothify("?????"));
        accountPage.clickAndInputAddress(Faker.instance().bothify("?????"));
        accountPage.clickAndInputCity(Faker.instance().bothify("?????"));
        accountPage.clickAndSelectState();
        accountPage.clickAndInputZipCode("12000");
        accountPage.clickAndInputMobile(Faker.instance().bothify("064184154"));
        accountPage.clickAndInputAlias(Faker.instance().bothify("?????"));
        accountPage.clickRegister();
        accountPage.clickOnCreatedAccount();
        Thread.sleep(2000);

        String message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        softAssert.assertEquals(signInPage.getWelcomeToAccountMessage(), message);

        softAssert.assertTrue(accountPage.getLogOutBtn().isDisplayed());
        accountPage.getLogOutBtn().click();


        String page = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        softAssert.assertEquals(page, driver.getCurrentUrl());

        softAssert.assertAll();
    }
}
