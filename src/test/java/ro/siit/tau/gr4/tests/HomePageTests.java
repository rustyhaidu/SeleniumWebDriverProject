package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

import java.util.List;

public class HomePageTests extends BaseTest{

    HomePage homePage;

    @BeforeMethod
    public void setUpSearch(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void searchItemTest(){
        homePage.searchItem("Mac");
        List<WebElement> checks =  driver.findElements(By.className("image"));

        Assert.assertEquals(checks.size(),4, "Search by Mac return 4 elements");

        //List<String> nameList = getNameListOfItems("http://shop-tausandbox.rhcloud.com/index.php?route=product/product&product_id");
        List<WebElement> nameList = driver.findElements(By.partialLinkText("Mac"));
        String linkText;
        for (WebElement webElement : nameList){
            boolean contained = false;
            linkText = webElement.getText();
            contained = linkText.contains("Mac");
            Assert.assertTrue(contained, "Checking that the items contain the String Mac");

        }
    }

}
