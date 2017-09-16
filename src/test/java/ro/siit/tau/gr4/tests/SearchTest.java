package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

import java.util.List;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUpSearch() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void searchItemsAndAddToCartTest() throws InterruptedException {
        homePage.searchItem("Mac");
        List<WebElement> checks = homePage.getListOfImageElements();

        Assert.assertEquals(checks.size(), 4, "Search by Mac return 4 Image elements");

        //"Creating a List of partial Links that contain the Mac String"
        List<WebElement> nameList = homePage.getFoundMacNameList();
        String linkText;
        int j = 0;
        for (WebElement webElement : nameList) {
            boolean contained;
            linkText = webElement.getText();
            contained = linkText.contains("Mac");
            Assert.assertTrue(contained, "Checking that the TITLE of items contain the String Mac, item: " + j);
            j++;
        }

        //"Creating a List of webelements that are h4 from the xpath"
        List<WebElement> h4List = homePage.getFoundH4List();
        Assert.assertEquals(h4List.size(), 4, "Search by Mac return 4 title elements");
        String linkText2;
        int k = 0;
        for (WebElement webElement : h4List) {
            boolean contained;
            linkText2 = webElement.getAttribute("href");
            contained = linkText2.contains("Mac");
            Assert.assertTrue(contained, "Checking that the LINKS(href) of the items contain the String Mac, item: " + k);
            k++;
        }
        //"Checking that the String from the bottom of the page shows that correct number of elements found"
        String showingNumberOfResults = homePage.getTextFromNoOfResults();

        Assert.assertEquals(showingNumberOfResults, "Showing 1 to 4 of 4 (1 Pages)", "Checking the number of results");

        //"Creating a list of buttons[1] = Add to card and click on each one
        List<WebElement> buttonList = homePage.getButtonList();
        String itemTitle;
        String successMessage;
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).click();
            itemTitle = h4List.get(i).getText();
            Thread.sleep(1000);
            successMessage = homePage.getSuccessMessageText().replaceAll("\n.*", "").trim();

            //"Checking that the Success message contains the item added to cart"
            Assert.assertEquals(
                new StringBuilder("Success: You have added")
                    .append(" ")
                    .append(itemTitle)
                    .append(" to your shopping cart!").toString(),
                successMessage);
            //"Success: You have added "+itemTitle+" to your shopping cart!");
        }
        Thread.sleep(1000);

        String cartTotal;

        // Get the text from the Cart button
        cartTotal = homePage.getTextFromCartTotalButton();
        System.out.println(cartTotal);

        Assert.assertEquals(cartTotal, "4 item(s) - 3,600.00\u20AC", "Expected String: item count and total");

        //Creating a list of prices and getting just values
        List<WebElement> priceList = homePage.getPriceList();
        String itemValue;
        double expectedTotalValue = 0;
        for (WebElement webElement : priceList) {
            //Getting just the first value from the string by Regex
            itemValue = webElement.getText().replace("\n", "").replaceAll("\\u20ACEx.*$", "");

            // Getting the text from the cart button and getting the total value
            expectedTotalValue = expectedTotalValue + Double.parseDouble(itemValue.replace(",", ""));        }
        String cartTotalValue;
        cartTotalValue = cartTotal.substring(cartTotal.indexOf("-")).replace("-", "").trim();
        cartTotalValue = cartTotalValue.replace(",", "").replace("\u20AC", "");
        double actualTotalValue = Double.parseDouble(cartTotalValue);

        Assert.assertEquals(expectedTotalValue, actualTotalValue, "comparing the totals");
    }

}
