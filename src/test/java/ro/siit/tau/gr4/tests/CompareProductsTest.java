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

public class CompareProductsTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setCompareTest() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void compareItemsTest() throws InterruptedException {

        // Make a search by entering the space keyboard character
        homePage.searchItem(" ");
        String successMessage;

        // Get the list of all products
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        // Put into variables the first 4 buttons - add to comparisson
        WebElement addToCompareButton1 = listOfProducts.get(1).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
        WebElement addToCompareButton2 = listOfProducts.get(2).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
        WebElement addToCompareButton3 = listOfProducts.get(3).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
        WebElement addToCompareButton4 = listOfProducts.get(4).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));

        // Get the Titles of the items
        String itemTitle1 = listOfProducts.get(1).findElement(By.tagName("h4")).getText();
        String itemTitle2 = listOfProducts.get(2).findElement(By.tagName("h4")).getText();
        String itemTitle3 = listOfProducts.get(3).findElement(By.tagName("h4")).getText();
        String itemTitle4 = listOfProducts.get(4).findElement(By.tagName("h4")).getText();
        String itemTitle5 = listOfProducts.get(5).findElement(By.tagName("h4")).getText();

        System.out.println("Element to be added: " + itemTitle1);
        addToCompareButton1.click();
        Thread.sleep(1000);

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessage().getText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle1)
                .append(" ")
                .append("to your product comparison!").toString());
        //" Success: You have added Canon EOS 5D to your product comparison!");


        System.out.println("Element to be added: " + itemTitle2);
        addToCompareButton2.click();
        Thread.sleep(1000);

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessage().getText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle2)
                .append(" ")
                .append("to your product comparison!").toString());


        System.out.println("Element to be added: " + itemTitle3);
        addToCompareButton3.click();
        Thread.sleep(1000);

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessage().getText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle3)
                .append(" ")
                .append("to your product comparison!").toString());

        Thread.sleep(1000);
        System.out.println("Element to be added: " + itemTitle4);
        addToCompareButton4.click();
        Thread.sleep(1000);

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessage().getText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle4)
                .append(" ")
                .append("to your product comparison!").toString());

       // Set the wait for getting the comparison link from the success message - HAS NO EFFECT!!
        WebDriverWait wait = new WebDriverWait(driver, 3);
        // Get the Link element from the success message to access the comparison table
        WebElement productComparisonLink =
            wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='alert alert-success']/a[contains(text(),'product comparison')]")));
        System.out.println(productComparisonLink.getText());
        productComparisonLink.click();

        // Get the all Table Data and the cell data for the 4 items, which is the max
        WebElement tableData1 = getTableData(1, 2);
        String productName1 = tableData1.getText();
        WebElement tableData2 = getTableData(1, 3);
        String productName2 = tableData2.getText();
        WebElement tableData3 = getTableData(1, 4);
        String productName3 = tableData3.getText();
        WebElement tableData4 = getTableData(1, 5);
        String productName4 = tableData4.getText();

        System.out.println(productName1);
        System.out.println(productName2);
        System.out.println(productName3);
        System.out.println(productName4);

        // Comparing that the items added to the comparison have the same name as the ones present in the table
        Assert.assertEquals(productName1, itemTitle1, "Checking that the correct item was added");
        Assert.assertEquals(productName2, itemTitle2, "Checking that the correct item was added");
        Assert.assertEquals(productName3, itemTitle3, "Checking that the correct item was added");
        Assert.assertEquals(productName4, itemTitle4, "Checking that the correct item was added");

        // Perform the search again to add another item to the comparison
        homePage.searchItem(" ");

        System.out.println("Replace Element with: " + itemTitle5);
        // Reinitialize the list of products
        listOfProducts = driver.findElements(By.xpath("//div[@class='product-thumb']"));
        // Enter the 5th element to the comparison table
        WebElement addToCompareButton5 = listOfProducts.get(5).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
        addToCompareButton5.click();
        Thread.sleep(1000);

        //Verify the Message for adding an item to the compare list'
        successMessage = homePage.getSuccessMessage().getText().replace("×", "").trim();
        Assert.assertEquals(successMessage,
            new StringBuilder("Success: You have added")
                .append(" ")
                .append(itemTitle5)
                .append(" ")
                .append("to your product comparison!").toString());

        // Reinitialize the link from the success message to go to the comparison table
        productComparisonLink =
            wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='alert alert-success']/a[contains(text(),'product comparison')]")));
        productComparisonLink.click();
        Thread.sleep(1000);

        // Get the table data and their text again to check changes
        tableData1 = getTableData(1, 2);
        productName1 = tableData1.getText();
        tableData2 = getTableData(1, 3);
        productName2 = tableData2.getText();
        tableData3 = getTableData(1, 4);
        productName3 = tableData3.getText();
        tableData4 = getTableData(1, 5);
        productName4 = tableData4.getText();

        //Check the changes
        Assert.assertEquals(itemTitle2, productName1);
        Assert.assertEquals(itemTitle3, productName2);
        Assert.assertEquals(itemTitle4, productName3);
        Assert.assertEquals(itemTitle5, productName4);

    }

    public WebElement getTableData(int row, int column) {
        WebElement tableData = new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='content']/table/tbody[1]/tr[" + row + "]/td[" + column + "]")));
        //*[@id="content"]/table/tbody[1]/tr[1]/td[2]
        return tableData;
    }
}
