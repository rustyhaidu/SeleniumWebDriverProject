package ro.siit.tau.gr4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CategoryPage {


    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement categoryTitle;

    public String getCategoryTitle(){
        return categoryTitle.getText();
    }

    public WebElement getSortBy() {
        return sortBy;
    }

    public void setSortBy(WebElement sortBy) {
        this.sortBy = sortBy;
    }

    public String getProductTitle(String product, WebDriver driver) {
        WebElement productName = driver.findElement(By.partialLinkText(product));
        return productName.getText();
    }



    public void clickProduct(String product, WebDriver driver) {
        WebElement productName = driver.findElement(By.partialLinkText(product));
        productName.click();
    }

    public String getCategoryText(String category, WebDriver driver){
        WebElement categoryName = driver.findElement(By.linkText(category));
        return categoryName.getText();
    }

    public void clickCategory(String category, WebDriver driver){
        WebElement categoryName = driver.findElement(By.linkText(category));
        categoryName.click();
    }
}
