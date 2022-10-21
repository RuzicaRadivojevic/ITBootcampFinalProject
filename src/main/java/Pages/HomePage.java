package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
    WebElement women;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(2) > ul > li:nth-child(3) > a")
    WebElement summerDresses;

    @FindBy(id = "contact-link")
    WebElement contactUs;


    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")
    WebElement signIn;

    @FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.left-block > div > a.product_img_link")
    WebElement firstDress;

    @FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    WebElement addToCart;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2")
    WebElement addedToCart;

    @FindBy(css = "#product_5_19_0_0 > td.cart_description > p > a")
    WebElement nameOfTheProduct;

    @FindBy(css = ".btn.btn-default.button.button-medium")
    WebElement proceedToCheckOut;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnAddToCardButton(){
        addToCart.click();
    }

    public WebElement getWomen() {
        return women;
    }

    public WebElement getSummerDresses() {
        return summerDresses;
    }

    public void clickSummerDresses() {
        summerDresses.click();
    }

    public void clickSignInBtn() {
        signIn.click();
    }

    public String SummerDressesGetText() {
        return summerDresses.getText();
    }


    public String getAddedToCartMessage() {
        return addedToCart.getText();
    }


    public WebElement getFirstDress() {
        return firstDress;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getContactUs() {
        return contactUs;
    }

    public void clickProceedToCheckOutButton() {
        proceedToCheckOut.click();
    }

    public String getNameOfTheProductText() {
        return nameOfTheProduct.getText();
    }
}

