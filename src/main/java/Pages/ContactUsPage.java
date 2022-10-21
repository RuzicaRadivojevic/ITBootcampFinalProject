package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    @FindBy(css = "#center_column > form")
    WebElement customerServiceForm;

    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @FindBy(css = "#id_contact > option:nth-child(2)")
    WebElement customerService;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "id_order")
    WebElement orderReference;

    @FindBy(xpath = "//input[@id='fileUpload']")
    WebElement uploadImage;

    @FindBy(id = "message")
    WebElement message;

    @FindBy(id = "submitMessage")
    WebElement send;

    @FindBy(css = ".alert.alert-success")
    WebElement notificationMessage;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCustomerServiceForm() {
        return customerServiceForm;
    }

    public WebElement getSubjectHeading() {
        return subjectHeading;
    }

    public void clickOnCustomerService() {
        customerService.click();
    }
    public void inputImagePath(String path){
        uploadImage.sendKeys(path);
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public void clickAndInputEmail(String yourEmail) {
        email.click();
        email.sendKeys(yourEmail);
    }

    public void clickAndInputMessage(String messages) {
        message.click();
        message.sendKeys(messages);
    }

    public void clickSend() {
        send.click();
    }

    public WebElement getNotificationMessage() {
        return notificationMessage;
    }
}
