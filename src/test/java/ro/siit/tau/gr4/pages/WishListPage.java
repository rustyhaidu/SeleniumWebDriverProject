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

    @FindBy(how = How.XPATH, using = "//div[@class='container']/div[@class='alert alert-success']")
    private WebElement sucessMessage;

    public String getSuccessMessage(){
        return sucessMessage.getText();
    }

    public WebElement getWishlistRow(String product){
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[descendant::a[text()='"
            + product + "']]"));
    }

    public void clickRemoveBtn(String product){
        WebElement row = this.getWishlistRow(product);
        row.findElement(By.xpath(".//a[@data-original-title='Remove']")).click();
    }
    public WebElement getAddToCartBtn(String product){
        WebElement row = this.getWishlistRow(product);
        return row.findElement(By.xpath(".//button[@type='button' and @data-original-title='Add to Cart']"));
    }

    public String getWishListTitle(){
        return wishListTitle.getText();
    }

    public List<WebElement> verifyElementIsNotListed(String product){
        List<WebElement> listOfItems = driver.findElements(By.cssSelector("a[href*='" + product + "']"));
        return listOfItems;
    }






}
