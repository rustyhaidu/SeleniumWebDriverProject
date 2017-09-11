package ro.siit.tau.gr4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WishListPage {

    WebDriver driver;

    public void setDriver(WebDriver driver){
        this.driver=driver;}

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement wishListTitle;

    public WebElement getWishlistRow(String product){
        return (new WebDriverWait( driver, 3))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[descendant::a[text()='"
                + product + "']]")));
    }

    /*public WebElement getRemoveBtn(String product){
        WebElement row = this.getWishlistRow(product);
        return row.findElement(By.cssSelector("a[data-original-title^='Remove']"));
    }*/
    public WebElement getAddToCartBtn(String product){
        WebElement row = this.getWishlistRow(product);
        return row.findElement(By.xpath("//button[@type='button' and contains(@data-original-title,'Add to Cart')]"));
    }

    public String getWishListTitle(){
        return wishListTitle.getText();
    }

    public List<WebElement> verifyElementIsNotListed(String product){
        List<WebElement> listOfItems = driver.findElements(By.cssSelector("a[href*='" + product + "']"));
        return listOfItems;
    }






}
