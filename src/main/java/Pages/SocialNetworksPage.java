package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialNetworksPage {
    public WebDriver driver;

    @FindBy(css= "#social_block > ul > li.facebook > a")
    WebElement facebook;

    @FindBy(css = "#social_block > ul > li.twitter > a")
    WebElement twitter;

    @FindBy(css = "#social_block > ul > li.youtube > a")
    WebElement youTube;

    @FindBy(css = "#social_block > ul > li.google-plus > a")
    WebElement googlePlus;

    public SocialNetworksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFacebook() {

        facebook.click();
    }
    public void clickTwitter() {
        twitter.click();
    }
    public void clickYoutube() {
        youTube.click();
    }
    public void clickGooglePlus() {
        googlePlus.click();
    }

    public WebElement getFacebook() {
        return facebook;
    }
}
