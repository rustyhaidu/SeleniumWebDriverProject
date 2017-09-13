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

    @FindBy(how = How.XPATH, using = "//button[@data-original-title='Add to Wish List']")
    private WebElement addToWishListButton;

    @FindBy(how = How.ID, using = "wishlist-total")
    private WebElement WishList;

    public void clickAddToWishListButton(){
        addToWishListButton.click();
    }

    public void goToWishList(){
        WishList.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void setAddToCartButton(WebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    /*public WebElement getProductName() {
        return productName;
    }*/

    public String getProductTitle(String product, WebDriver driver){
        WebElement productTitle = driver.findElement(By.tagName(product));
        return productTitle.getText();
    }




}
