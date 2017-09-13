package ro.siit.tau.gr4.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

public class ChangeCurrencyTest extends BaseTest {

    @Test
    public void CurrencyTest(){

            HomePage homePage = PageFactory.initElements(driver, HomePage.class);

            homePage.clickCurrencyButton();
            homePage.setCurrency("GBP", driver);

        Assert.assertEquals(homePage.readCurrencySymbol(),
            "£",
            "check currency symbol is correct");

        Assert.assertEquals(homePage.getTextFromCartTotalButton().contains("£"),
            true,
            "check ");

        }

}
