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

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement checkoutTitle;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement updateButton;

    public void clickUpdateButton() {
        updateButton.click();
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

    public void setCartBreadcrumb(WebElement cartBreadcrumb) {
        this.cartBreadcrumb = cartBreadcrumb;
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public static WebElement getQuantityField(String product, WebDriver driver) {
        WebElement productInCart = driver.findElement(By.xpath("//tr[descendant::a[text()='" + product + "']]//td[4]//input[@type='text']"));
        return productInCart;
    }
    public String readQuantity(String product, WebDriver driver){
        WebElement productRow = getQuantityField(product, driver);
        WebElement quantityField = productRow.findElement(By.xpath("//tr[descendant::a[text()='" + product + "']]//td[4]//input[@type='text']"));
        return quantityField.getAttribute("value");
    }

}
