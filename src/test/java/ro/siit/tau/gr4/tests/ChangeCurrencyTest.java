package ro.siit.tau.gr4.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.CategoryPage;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.ProductPage;

public class ChangeCurrencyTest extends BaseTest {

    @Test
    public void CurrencyTest() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

        homePage.setDriver(driver);
        productPage.setDriver(driver);

        //change currency
        homePage.clickCurrencyButton();
        homePage.setCurrency("GBP", driver);
        Assert.assertEquals(homePage.readCurrencySymbol(),
            //"£",
            "\u00A3",
            "check currency symbol is correctly set in the currency dropdown button");
        Assert.assertEquals(homePage.getTextFromCartTotalButton().contains("\u00A3"),
            true,
            "check currency symbol is displayed on the Cart Button");
        Assert.assertEquals(homePage.getProductCurrencySymbol("MacBook"),
            //"££",
            "\u00A3\u00A3",
            "check currency symbol is displayed twice: in price and in Ex.Tax Price");

        //go to the product page
        categoryPage.clickProduct("iPhone", driver);
        Assert.assertEquals(productPage.getCurrencySymbolFromPrice(),
            //"£",
            "\u00A3",
            "check currency symbol is displayed in price");
        Assert.assertEquals(productPage.getCurrencySymbolFromExTaxPrice(),
            //"£",
            "\u00A3",
            "check currency symbol is displayed in Ex.Tax Price");

    }


}
