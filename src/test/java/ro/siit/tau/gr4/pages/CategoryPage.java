package ro.siit.tau.gr4.pages;


import com.gargoylesoftware.htmlunit.javascript.host.Touch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {


    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    public WebElement getSortBy() {
        return sortBy;
    }

    public void setSortBy(WebElement sortBy) {
        this.sortBy = sortBy;
    }


    public WebElement getProduct(String product, WebDriver driver) {
        WebElement productName = (new WebDriverWait( driver, 3))
            .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(product)));
        return productName;
    }


    public WebElement goToCategory(String category, WebDriver driver){
        WebElement categoryName = (new WebDriverWait(driver, 3))
            .until(ExpectedConditions.presenceOfElementLocated(By.linkText(category)));
        return categoryName;
    }


}
