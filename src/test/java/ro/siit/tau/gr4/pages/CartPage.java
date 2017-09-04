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

    @FindBy(how = How.CSS, using = "input[name^='quantity']")
    private WebElement quantityField;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement checkoutTitle;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement updateButton;

    public void setQuantity(String quantity){
        quantityField.clear();
        quantityField.sendKeys(quantity);
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

    public WebElement getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(WebElement quantityField1) {
        this.quantityField = quantityField1;
    }

    public void setCartBreadcrumb(WebElement cartBreadcrumb) {
        this.cartBreadcrumb = cartBreadcrumb;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void setCheckoutButton(WebElement checkoutButton) {
        this.checkoutButton = checkoutButton;
    }

    public static WebElement findProduct(String product, WebDriver driver) {
        WebElement productInCart = (new WebDriverWait( driver, 3))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[descendant::a[text()='" + product + "']]")));
        return productInCart;
    }

    public WebElement getQuantityField(String product, WebDriver driver){
        WebElement productRow = findProduct(product, driver);
        WebElement quantityField = productRow.findElement(By.cssSelector("input[name^='quantity']"));
        return quantityField;
    }




}
