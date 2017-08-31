package ro.siit.tau.gr4.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement cartTitle;

    @FindBy(how = How.NAME, using = "Use Coupon Code ")
    private WebElement couponCode;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Checkout")
    private WebElement checkoutButton;

    @FindBy(how = How.CSS, using = "tr:nth-child(2) td .input-group input.form-control")
    private WebElement quantityField;

    public WebElement getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(WebElement quantityField) {
        this.quantityField = quantityField;
    }

    public WebElement getCartTitle() {
        return cartTitle;
    }

    public void setCartTitle(WebElement cartTitle) {
        this.cartTitle = cartTitle;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void setCheckoutButton(WebElement checkoutButton) {
        this.checkoutButton = checkoutButton;
    }


}
