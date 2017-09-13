package ro.siit.tau.gr4.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

import java.util.LinkedList;
import java.util.List;

public class CompareProductsTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setCompareTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
    }

    @Test
    public void compareItemsTest() throws InterruptedException {

        // Make a search by entering the space keyboard character
        homePage.searchItem(" ");
        String successMessage;
        String productName;
        String expectedItemTitle;

        // Get the list of all products
        List<WebElement> listOfProducts = homePage.getListOfProducts();
        List<String> itemTitles = new LinkedList<>();

        for (int i = 1; i < 5; i++) {

            WebElement addToCompareButton = homePage.getCompareButton(listOfProducts, i);
            String itemTitle = homePage.getItemTitle(listOfProducts, i);
            itemTitles.add(itemTitle);
            System.out.println("Element to be added: " + itemTitle);
            addToCompareButton.click();
            Thread.sleep(1000);

            //Verify the Message for adding an item to the compare list'
            successMessage = homePage.getSuccessMessageText().replace("×", "").trim();
            Assert.assertEquals(successMessage,
                new StringBuilder("Success: You have added")
                    .append(" ")
                    .append(itemTitle)
                    .append(" ")
                    .append("to your product comparison!").toString());
        }

        System.out.println(homePage.getProductComparisonLink().getText());
        homePage.getProductComparisonLink().click();

        for (int i = 2; i < 6; i++) {
            WebElement tableData = homePage.getTableData(1, i);
            productName = tableData.getText();
            expectedItemTitle = itemTitles.get(i - 2);
            System.out.println("Actual Product added: " + productName);
            System.out.println("Expected item Title: " + expectedItemTitle);
            Assert.assertEquals(expectedItemTitle, productName, "Checking that the correct item was added");
        }

        // Perform the search again to add another item to the comparison
        homePage.searchItem(" ");

        WebElement addToCompareButton = homePage.getCompareButton(listOfProducts, 5);
        String itemTitle = homePage.getItemTitle(listOfProducts, 5);
        itemTitles.add(itemTitle);
        addToCompareButton.click();
        Thread.sleep(1000);

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessageText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle)
                .append(" ")
                .append("to your product comparison!").toString());


        homePage.getProductComparisonLink().click();

        // Get the table data and their text again to check changes
        for (int i = 2; i < 6; i++) {
            WebElement tableData = homePage.getTableData(1, i);
            productName = tableData.getText();
            expectedItemTitle = itemTitles.get(i - 1);
            System.out.println("Actual Product added: " + productName);
            System.out.println("Expected item Title: " + expectedItemTitle);
            Assert.assertEquals(expectedItemTitle, productName, "Checking that the correct item was added");
        }

    }
}
