package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

        String successMessage;
        homePage.searchItem(" ");

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        WebElement addToCompareButton = listOfProducts.get(1).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
       // WebElement itemTitle = listOfProducts.get(1).findElement(By.linkText("Canon EOS 5D"));
        WebElement itemTitle = listOfProducts.get(1).findElement(By.tagName("h4"));

        System.out.println(itemTitle.getText());
        addToCompareButton.click();

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessage().getText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle.getText())
                .append(" ")
                .append("to your product comparison!").toString());
        //" Success: You have added Canon EOS 5D to your product comparison!");

        WebElement productComparissonLink =
            new WebDriverWait( driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//div[@class='alert alert-success']/a[contains(text(),'product comparison')]")));
        System.out.println(productComparissonLink.getText());
        productComparissonLink.click();

    }
}
