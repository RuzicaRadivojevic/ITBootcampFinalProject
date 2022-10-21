package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public WebDriver driver;

    @FindBy(id = "email_create")
    WebElement emailToCreateAccount;

    @FindBy(id = "SubmitCreate")
    WebElement createAccount;

    @FindBy(id = "email")
    WebElement existingEmail;

    @FindBy(id = "passwd")
    WebElement existingPassword;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(css = "#login_form > div > p.lost_password.form-group > a")
    WebElement forgotYourPassword;

    @FindBy(className = "info-account")
    WebElement welcomeMessage;

    @FindBy(css = ".alert.alert-danger")
    WebElement alertMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputEmailToCreateAnAccount(String email) {
        emailToCreateAccount.click();
        emailToCreateAccount.sendKeys(email);
    }

    public void clickOnCreateAccountBtn() {
        createAccount.click();
    }

    public void inputExisitingEmail(String yourEmail) {
        existingEmail.sendKeys(yourEmail);

    }

    public void inputExisitingPassword(String yourPassword) {
        existingPassword.sendKeys(yourPassword);

    }

    public void clickSignInButton() {
        signInButton.click();

    }

    public void clickForgetYourPassword() {
        forgotYourPassword.click();

    }

    public String getWelcomeToAccountMessage() {
        return welcomeMessage.getText();
    }

    public WebElement getAlertMessage() {
        return alertMessage;
    }
}
