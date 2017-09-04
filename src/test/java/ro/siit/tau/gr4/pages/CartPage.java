package ro.siit.tau.gr4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Shopping Cart")
    private WebElement cartBreadcrumb;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Checkout")
    private WebElement checkoutButton;

    @FindBy(how = How.CSS, using = "tr:nth-child(2) td .input-group input.form-control")
    private WebElement quantityField2;

    @FindBy(how = How.CSS, using = "tr:nth-child(1) td .input-group input.form-control")
    private WebElement quantityField1;

    /*@FindBy(how = How.PARTIAL_LINK_TEXT, using = "HTC Touch HD")
    private WebElement listedHtc;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "iPhone")
    private WebElement listediPhone;*/

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement checkoutTitle;

    @FindBy(how = How.CSS, using = "tr:nth-child(1) td .input-group span button:nth-child(1)")
    private WebElement updateButton;

    public void setQuantity(String quantityP1, String quantityP2){
        quantityField1.clear();
        quantityField1.sendKeys(quantityP1);
        quantityField2.clear();
        quantityField2.sendKeys(quantityP2);
    }

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(WebElement updateButton) {
        this.updateButton = updateButton;
    }

    public WebElement getCheckoutTitle() {
        return checkoutTitle;
    }

    public void setCheckoutTitle(WebElement checkoutTitle) {
        this.checkoutTitle = checkoutTitle;
    }


    public WebElement getCartBreadcrumb() {
        return cartBreadcrumb;
    }

    public WebElement getQuantityField1() {
        return quantityField1;
    }

    public void setQuantityField1(WebElement quantityField1) {
        this.quantityField1 = quantityField1;
    }

    public void setCartBreadcrumb(WebElement cartBreadcrumb) {
        this.cartBreadcrumb = cartBreadcrumb;
    }

    public WebElement getQuantityField2() {
        return quantityField2;
    }

    public void setQuantityField2(WebElement quantityField2) {
        this.quantityField2 = quantityField2;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void setCheckoutButton(WebElement checkoutButton) {
        this.checkoutButton = checkoutButton;
    }

    public static WebElement findProduct(String product, WebDriver driver) {
        WebElement productInCart = (new WebDriverWait( driver, 3))
            .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(product)));
        return productInCart;
    }


}
