package ro.siit.tau.gr4.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

import java.util.*;

public class CompareProductsTest extends BaseTest {

    private HomePage homePage;

    @DataProvider(name = "itemToAddToCompareList")
    public Object[][] jsonDataProviderCollection() {

        return new Object[][]{
            {"Canon EOS 5D", "HP LP3065", "HTC Touch HD", "iMac", "iPhone"}
        };
    }

    @BeforeMethod
    public void setCompareTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(dataProvider = "itemToAddToCompareList")
    public void compareItemsTest(String[] arrayOfItems) throws InterruptedException {

        // Make a search by entering the space keyboard character
        homePage.searchItem(" ");

        // Get the list of all products
        List<String> itemTitles = new ArrayList<>();

        for (int i = 0; i < arrayOfItems.length - 1; i++) {
            String itemTitle = addProductToCompareTable(arrayOfItems[i], itemTitles);
            //Verify the Message for adding an item to the compare list'
            checkProductAddedSuccessMessage(itemTitle);
        }

        System.out.println(homePage.getProductComparisonLink().getText());
        homePage.getProductComparisonLink().click();
        int columnCount = basePage.getPrecedingH1TableColumnCount("Product Comparison", 1);

        System.out.println("\nGet the table data from the first position, column 2, array index = 0 ");
        checkTableContent(itemTitles, columnCount, 2);

        // Perform the search again to add another item to the comparison
        homePage.searchItem(" ");

        //Verify the Message for adding an item to the compare list
        String itemTitle = addProductToCompareTable(arrayOfItems[4], itemTitles);
        checkProductAddedSuccessMessage(itemTitle);
        homePage.getProductComparisonLink().click();

        System.out.println("\nGet the table data and their text again to check changes, without the first item, it was replaced");
        checkTableContent(itemTitles, columnCount, 1);
    }

    private String addProductToCompareTable(String arrayOfItem, List<String> itemTitles) throws InterruptedException {
        WebElement addToCompareButton = homePage.getCompareButton(arrayOfItem);
        String itemTitle = homePage.getItemTitle(arrayOfItem);
        itemTitles.add(itemTitle);
        System.out.println("Element to be added: " + itemTitle);
        addToCompareButton.click();
        Thread.sleep(1000);
        return itemTitle;
    }

    private void checkProductAddedSuccessMessage(String itemTitle) {
        String successMessage;
        successMessage = homePage.getSuccessMessageText().replaceAll("\n.*", "").trim();
        //successMessage = successMessage.replace("╫", "").trim();
        System.out.println(successMessage);
        Assert.assertEquals(
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle)
                .append(" ")
                .append("to your product comparison!").toString(),
            successMessage);
    }

    private void checkTableContent(List<String> itemTitles, int columnCount, int minusArrayIndex) {
        String productName;
        String expectedItemTitle;
        for (int i = 2; i <= columnCount; i++) {
            WebElement tableData = basePage.getPrecedingH1TableData("Product Comparison",1, i);
            productName = tableData.getText();
            expectedItemTitle = itemTitles.get(i - minusArrayIndex);
            System.out.println("Expected item Title: " + expectedItemTitle);
            System.out.println("Actual Product added: " + productName);
            Assert.assertEquals(expectedItemTitle, productName, "Checking that the correct item was added");
        }
    }
}
