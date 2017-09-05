package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

import java.util.List;

public class HomePageTests extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void setUpSearch() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void searchItemsAndAddToCartTest() throws InterruptedException {
        homePage.searchItem("Mac");
        List<WebElement> checks = driver.findElements(By.className("image"));

        Assert.assertEquals(checks.size(), 4, "Search by Mac return 4 Image elements");

        //List<String> nameList = getNameListOfItems("http://shop-tausandbox.rhcloud.com/index.php?route=product/product&product_id");
        List<WebElement> nameList = driver.findElements(By.partialLinkText("Mac"));
        String linkText;
        int i = 0;
        for (WebElement webElement : nameList) {
            boolean contained = false;
            linkText = webElement.getText();
            contained = linkText.contains("Mac");
            Assert.assertTrue(contained, "Checking that the items contain the String Mac, item: " + i);
            i++;
        }

        List<WebElement> h4List = driver.findElements(By.xpath("//div[@class='row']/..//h4/a"));
        Assert.assertEquals(h4List.size(), 4, "Search by Mac return 4 title elements");
        String linkText2;
        int i2 = 0;
        for (WebElement webElement : h4List) {
            boolean contained = false;
            linkText2 = webElement.getText();
            contained = linkText2.contains("Mac");
            Assert.assertTrue(contained, "Checking that the items contain the String Mac, item: " + i2);
            i2++;
        }

        WebElement noOfResultsWebElement = driver.findElement(By.xpath("//div[@class='row']/div[@class='col-sm-6 text-right']"));
        String showingNumberOfResults = noOfResultsWebElement.getText();

        Assert.assertEquals(showingNumberOfResults, "Showing 1 to 4 of 4 (1 Pages)", "Checking the number of results");

        List<WebElement> buttonList = driver.findElements(By.xpath("//div[@class='row']/div/div/div[@class='button-group']/button[1]"));

        for (WebElement webElement : buttonList) {
            webElement.click();
        }
        Thread.sleep(1000);

        String cartTotal;
        cartTotal = homePage.getCartTotalButton().getText();

        System.out.println(cartTotal);

        Assert.assertEquals(cartTotal, "4 item(s) - 3,600.00€", "Expected String: item count and total");

        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='row']/div//div/p[@class='price']"));
        String itemValue;
        double expectedTotalValue = 0;
        for (WebElement webElement : priceList) {
            itemValue = webElement.getText().replace("\n", "").replaceAll("€Ex.*$", "");
            //System.out.println(Double.parseDouble(itemValue.replace(",", "")));
            expectedTotalValue = expectedTotalValue + Double.parseDouble(itemValue.replace(",", ""));
        }
        String cartTotalValue;
        cartTotalValue = cartTotal.substring(cartTotal.indexOf("-")).replace("-","").trim();
        cartTotalValue = cartTotalValue.replace(",", "").replace("€", "");
        double actualTotalValue = Double.parseDouble(cartTotalValue);

        Assert.assertEquals(expectedTotalValue,actualTotalValue,"comparing the totals");
    }

}
