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

        homePage.clickCurrencyButton();
        homePage.setCurrency("GBP", driver);


                Assert.assertEquals(homePage.readCurrencySymbol(),
                    "£",
                    "check currency symbol is correctly set in the Currency dropdown button");

                Assert.assertEquals(homePage.getTextFromCartTotalButton().contains("£"),
                    true,
                    "currency Symbol is displayed on the Cart Button");

                Assert.assertEquals(homePage.getProductCurrencySymbol("MacBook"),
                    "££",
                    "check currency Symbol is displayed twice in the price");

        categoryPage.clickProduct("iPhone", driver);

                Assert.assertEquals(productPage.getProductPrice(),
                    "??",
                    "chekkk");

    }


}
