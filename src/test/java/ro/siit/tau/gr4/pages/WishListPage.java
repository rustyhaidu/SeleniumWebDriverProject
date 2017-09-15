package ro.siit.tau.gr4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class WishListPage {

    WebDriver driver;
    public void setDriver(WebDriver driver){
        this.driver=driver;}

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement wishListTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='container']/div[@class='alert alert-success']")
    private WebElement sucessMessage;

    /*@FindBy(how = How.XPATH, using = "/*//*[@id='content']/div[1]/table/tbody")
    private WebElement wishListTable;*/

    @FindBy(how = How.XPATH, using = "//table[@class='table table-bordered table-hover']")
    private WebElement wishListTable;

    public String getSuccessMessage(){
        return sucessMessage.getText();
    }

    public WebElement getWishlistRow(String product){
        return driver.findElement(By.xpath("//*[@id='content']/div[1]/table/tbody/tr[descendant::a[text()='"
            + product + "']]"));
    }

    public void clickRemoveBtn(String product){
        WebElement row = this.getWishlistRow(product);
        row.findElement(By.xpath(".//a[@data-original-title='Remove']")).click();
    }
    public void clickAddToCartBtn(String product){
        WebElement row = this.getWishlistRow(product);
        row.findElement(By.xpath(".//button[@type='button' and @data-original-title='Add to Cart']")).click();
    }

    public String getWishListTitle(){
        return wishListTitle.getText();
    }

    public boolean verifyProductIsAbsent(String product) {
        List<WebElement> listOfItems = driver.findElements(By.partialLinkText("" + product + ""));
        System.out.println("List of items: " + listOfItems);
        return listOfItems.isEmpty();
    }

    public boolean verifyProductIsDisplayed(String product, WebDriver driver) throws Exception {
        try {
            WebElement productName = driver.findElement(By.partialLinkText(product));
            return productName.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            return false;

        }
    }

    /*public int verifyProductIsAbsent(String product){
        List<WebElement> listOfItems = driver.findElements(By.partialLinkText("" + product + ""));
        System.out.println(listOfItems);
        return listOfItems.size();
    }*/

    /*public boolean verifyElemenIstAbsent(String product) throws Exception {
        try {
            wishListTable.findElement(By.partialLinkText(product));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }*/


}
