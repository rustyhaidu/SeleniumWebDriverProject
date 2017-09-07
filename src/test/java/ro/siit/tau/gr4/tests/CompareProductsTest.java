package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

import java.util.List;

public class CompareProductsTest extends BaseTest{

    private HomePage homePage;

    @BeforeMethod
    public void setCompareTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void compareItemsTest(){
        homePage.searchItem(" ");

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        WebElement addToCompareButton = listOfProducts.get(1).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
        addToCompareButton.click();

    }
}
