package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {
    public WebDriver driver;


    @FindBy(css = "#cart_title > span")
    WebElement cartContains;

    @FindBy(css = "#product_5_19_0_0 > td.cart_description > p")
    WebElement nameOfTheBoughtProduct;

    @FindBy(id= "5_19_0_0")
    WebElement deleteItem;

    @FindBy(css = ".alert.alert-warning")
    WebElement message;

    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartContainsText() {
        return cartContains.getText();
    }

    public String getNameOfTheBoughtProductText() {
        return nameOfTheBoughtProduct.getText();
    }

    public void clickDeleteItem() {
        deleteItem.click();
    }


    public String getMessageText() {
        return message.getText();
    }

    public WebElement getMessage() {
        return message;
    }
}
