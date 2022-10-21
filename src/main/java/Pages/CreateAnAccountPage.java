package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAnAccountPage {

    WebDriver driver;

    @FindBy(id= "uniform-id_gender2")
    WebElement genderRadioBtn;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id ="customer_lastname")
    WebElement lastName;

    @FindBy(id ="passwd")
    WebElement password;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id= "id_state")
    WebElement state;

    @FindBy(xpath = "//*[@id=\"id_state\"]/option[2]")
    WebElement alabama;

    @FindBy(id= "postcode")
    WebElement zipCode;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    WebElement registerBtn;

    @FindBy(id = "alias")
    WebElement addressAlias;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement createdAccount;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement logOutBtn;



    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGender() {
        genderRadioBtn.click();
    }

    public void clickAndInputFirstName(String yourName) {
        firstName.click();
        firstName.sendKeys(yourName);
    }


    public void clickAndInputLastName(String yourLastName) {

        lastName.click();
        lastName.sendKeys(yourLastName);
    }


    public void clickAndInputPassword(String yourPassword) {
        password.click();
        password.sendKeys(yourPassword);
    }


    public void clickAndInputAddress(String yourAddress) {
        address.click();
        address.sendKeys(yourAddress);
    }

    public void clickAndInputCity(String yourCity) {
        city.click();
        city.sendKeys(yourCity);
    }


    public void clickAndSelectState() {
        state.click();
        alabama.click();
    }

    public void clickAndInputZipCode(String zipCodes) {
        zipCode.click();
        zipCode.sendKeys(zipCodes);
    }


    public void clickAndInputMobile(String mobPhone) {
        mobilePhone.click();
        mobilePhone.sendKeys(mobPhone);
    }

    public void clickAndInputAlias(String alias) {
        addressAlias.click();
        addressAlias.sendKeys(alias);
    }


    public void clickRegister() {
        registerBtn.click();
    }

    public void clickOnCreatedAccount() {
        createdAccount.click();
    }

    public WebElement getLogOutBtn() {
        return logOutBtn;
    }

}

