package ro.siit.tau.gr4.pages;


import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    @FindBy(how = How.ID, using = "button-cart")
    private WebElement addToCartButton;

    @FindBy(how = How.ID, using = "quantity")
    private WebElement quantity;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement productName;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void setAddToCartButton(WebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public void setQuantity(WebElement quantity) {
        this.quantity = quantity;
    }

    public WebElement getProductName() {
        return productName;
    }

    public static WebElement getProductTitle(String product, WebDriver driver){
        WebElement productTitle = (new WebDriverWait(driver, 3))
            .until(ExpectedConditions.presenceOfElementLocated(By.tagName(product)));
        return productTitle;
    }


}
