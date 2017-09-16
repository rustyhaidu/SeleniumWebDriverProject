package ro.siit.tau.gr4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage{

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

    public WebElement getProductInfo(){
        WebElement productInfo = driver.findElement(By.xpath("//div[@class='col-sm-4' and descendant::h2]"));
        return productInfo;
    }

    public String getPrice(){
        String price = getProductInfo().findElement(By.tagName("h2")).getText();
        return price;
    }

    public String getExTaxPrice(){
        String price = getProductInfo().findElement(By.xpath(".//ul[2]/li/following-sibling::li")).getText();
        return price;
    }

    public String getCurrencySymbolFromPrice(){
        String price = getProductInfo().findElement(By.tagName("h2")).getText();
        return price.replaceAll("[^£]","");
    }

    public String getCurrencySymbolFromExTaxPrice(){
        String price = getProductInfo().findElement(By.xpath(".//ul[2]/li/following-sibling::li")).getText();
        return price.replaceAll("[^£]","");
    }
}
