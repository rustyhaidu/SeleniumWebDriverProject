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

        //"Creating a List of partial Links that contain the Mac String"
        List<WebElement> nameList = driver.findElements(By.partialLinkText("Mac"));
        String linkText;
        int j = 0;
        for (WebElement webElement : nameList) {
            boolean contained = false;
            linkText = webElement.getText();
            contained = linkText.contains("Mac");
            Assert.assertTrue(contained, "Checking that the TITLE of items contain the String Mac, item: " + j);
            j++;
        }

        //"Creating a List of webelements that are h4 from the xpath"
        List<WebElement> h4List = driver.findElements(By.xpath("//div[@class='row']/..//h4/a"));
        Assert.assertEquals(h4List.size(), 4, "Search by Mac return 4 title elements");
        String linkText2;
        int k = 0;
        for (WebElement webElement : h4List) {
            boolean contained = false;
            linkText2 = webElement.getAttribute("href");
            contained = linkText2.contains("Mac");
            Assert.assertTrue(contained, "Checking that the LINKS(href) of the items contain the String Mac, item: " + k);
            k++;
        }
        //"Checking that the String from the bottom of the page shows that correct number of elements found"
        WebElement noOfResultsWebElement = driver.findElement(By.xpath("//div[@class='row']/div[@class='col-sm-6 text-right']"));
        String showingNumberOfResults = noOfResultsWebElement.getText();

        Assert.assertEquals(showingNumberOfResults, "Showing 1 to 4 of 4 (1 Pages)", "Checking the number of results");

        //"Creating a list of buttons[1] = Add to card and click on each one
        List<WebElement> buttonList = driver.findElements(By.xpath("//div[@class='row']/div/div/div[@class='button-group']/button[1]"));
        String itemTitle = "";
        String successMessage;
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).click();
            itemTitle = h4List.get(i).getText();
            Thread.sleep(1000);
            successMessage = driver.
                findElement(By.xpath("//div[@class='container']/div[@class='alert alert-success']"))
                .getText().replace("×", "").trim();

            //"Checking that the Success message contains the item added to cart"
            Assert.assertEquals(successMessage,
                new StringBuilder("Success: You have added")
                    .append(" ")
                    .append(itemTitle)
                    .append(" to your shopping cart!").toString());
            //"Success: You have added "+itemTitle+" to your shopping cart!");
        }
        Thread.sleep(1000);

        String cartTotal;

        // Get the text from the Cart button
        cartTotal = homePage.getTextFromCartTotalButton();
        System.out.println(cartTotal);

        Assert.assertEquals(cartTotal, "4 item(s) - 3,600.00€", "Expected String: item count and total");

        //Creating a list of prices and getting just values
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='row']/div//div/p[@class='price']"));
        String itemValue;
        double expectedTotalValue = 0;
        for (WebElement webElement : priceList) {
            //Getting just the first value from the string by Regex
            itemValue = webElement.getText().replace("\n", "").replaceAll("€Ex.*$", "");

            // Getting the text from the cart button and getting the total value
            expectedTotalValue = expectedTotalValue + Double.parseDouble(itemValue.replace(",", ""));        }
        String cartTotalValue;
        cartTotalValue = cartTotal.substring(cartTotal.indexOf("-")).replace("-", "").trim();
        cartTotalValue = cartTotalValue.replace(",", "").replace("€", "");
        double actualTotalValue = Double.parseDouble(cartTotalValue);

        Assert.assertEquals(expectedTotalValue, actualTotalValue, "comparing the totals");
    }

}
