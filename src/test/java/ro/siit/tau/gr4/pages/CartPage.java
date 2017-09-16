package ro.siit.tau.gr4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

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

    public String getCheckoutTitle() {
        return checkoutTitle.getText();
    }

    public String getCartBreadcrumbText() {
        return cartBreadcrumb.getText();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

   public WebElement getCartRow(String product){
        return (new WebDriverWait( driver, 3))
          .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-bordered']/tbody/tr[descendant::a[text()='"
              +product+"']]")));
    }

    public WebElement getQuantityField(String product){
        WebElement cartRow = this.getCartRow(product);
        return cartRow.findElement(By.cssSelector("input[name^='quantity']"));
    }

    public String readQuantity(String product){
        WebElement quantityField = this.getQuantityField(product);
        return quantityField.getAttribute("value");
    }

}
