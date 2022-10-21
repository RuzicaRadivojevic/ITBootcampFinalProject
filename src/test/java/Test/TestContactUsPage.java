package Test;

import BaseTest.BaseTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestContactUsPage extends BaseTest {

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
    public void testDoesButtonContactUsOpenTheCorrectForm() {
        homePage.getContactUs().click();
        waitForElementVisibility(contactUsPage.getCustomerServiceForm());
        scrollIntoView(contactUsPage.getCustomerServiceForm());

        Assert.assertTrue(contactUsPage.getCustomerServiceForm().isDisplayed());
    }

    @Test
    public void successfullSendingAMessage() throws InterruptedException {
        homePage.getContactUs().click();
        waitForElementVisibility(contactUsPage.getCustomerServiceForm());
        hoverToElement(contactUsPage.getSubjectHeading());
        contactUsPage.getSubjectHeading().click();
        scrollIntoView(contactUsPage.getOrderReference());
        contactUsPage.clickOnCustomerService();
        contactUsPage.clickAndInputEmail(Faker.instance().bothify("??????@gmail.com"));
        Thread.sleep(1000);
        contactUsPage.inputImagePath("C:\\Users\\Dell\\Desktop\\twitter-meme-maker-1.png");
        contactUsPage.getOrderReference().sendKeys(Faker.instance().bothify("??????"));
        contactUsPage.clickAndInputMessage(Faker.instance().bothify("?????"));
        contactUsPage.clickSend();

        Thread.sleep(1000);

        Assert.assertEquals(contactUsPage.getNotificationMessage().getText(), "Your message has been successfully sent to our team.");

        Thread.sleep(2000);

    }
}
