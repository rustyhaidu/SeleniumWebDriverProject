package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.CartPage;
import ro.siit.tau.gr4.pages.CategoryPage;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.ProductPage;

public class AddToCartAndCheckoutTest extends BaseTest {


    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

    @Test
    public void addToCart() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        homePage.getPhonesAndPdaCategory().click();
        Select sortBy = new Select(categoryPage.getSortBy());
        sortBy.selectByValue("http://shop-tausandbox.rhcloud.com/index.php?route=product/category&path=24&sort=pd.name&order=ASC");
        categoryPage.getiPhone().click();
        productPage.getAddToCartButton().click();

        homePage.getPhonesAndPdaCategory().click();
        categoryPage.getHtcTouchHd().click();
        productPage.getAddToCartButton().click();

        homePage.getCartTotalButton().click();
        clickLinkByHref("route=checkout/cart");

        cartPage.getQuantityField().clear();
        cartPage.getQuantityField().sendKeys("2");

        cartPage.getCheckoutButton().click();

        //categoryPage.getiPhone().click();

        //categoryPage.getCartTotalButton().click();

        //try{ Thread.sleep(5000);}catch(InterruptedException ie){}


    }
}
