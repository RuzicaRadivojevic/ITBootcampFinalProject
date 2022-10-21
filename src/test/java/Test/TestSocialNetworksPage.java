package Test;

import BaseTest.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class TestSocialNetworksPage extends BaseTest {

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
    public void testSocialNetworks() throws InterruptedException {

        scrollIntoView(networksPage.getFacebook());
        networksPage.clickFacebook();
        Thread.sleep(1000);
        networksPage.clickTwitter();
        Thread.sleep(1000);
        networksPage.clickYoutube();
        Thread.sleep(1000);
        networksPage.clickGooglePlus();
        Thread.sleep(1000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(4));
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/groups/525066904174158/"));
        driver.close();

        driver.switchTo().window(tabs.get(3));
        softAssert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/seleniumfrmwrk");
        driver.close();

        driver.switchTo().window(tabs.get(2));
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA");
        driver.close();

        driver.switchTo().window(tabs.get(1));
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://accounts.google.com/v3/signin/identifier"));
        driver.close();

        driver.switchTo().window(tabs.get(0));
        softAssert.assertAll();
    }
}
