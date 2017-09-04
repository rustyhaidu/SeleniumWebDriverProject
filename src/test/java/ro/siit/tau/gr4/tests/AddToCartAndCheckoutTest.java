package ro.siit.tau.gr4.tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.CartPage;
import ro.siit.tau.gr4.pages.CategoryPage;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.ProductPage;
import sun.misc.ASCIICaseInsensitiveComparator;

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

        Assert.assertEquals(categoryPage.getCategoryPageTitle().getText(),
            "Phones & PDAs",
            "check category page title");

        //add iPhone to Cart
        categoryPage.getiPhone().click();
        productPage.getAddToCartButton().click();

        Assert.assertEquals(productPage.getProductName().getText(),
            "iPhone",
            "check product page title");

        //add Htc to Cart
        homePage.getPhonesAndPdaCategory().click();
        categoryPage.getHtcTouchHd().click();
        productPage.getAddToCartButton().click();

        Assert.assertEquals(productPage.getProductName().getText(),
            "HTC Touch HD",
            "check product page title");

        //go to Cart
        homePage.getCartTotalButton().click();
        clickLinkByHref("route=checkout/cart");

        Assert.assertEquals(cartPage.getCartBreadcrumb().getText(),
            "Shopping Cart",
            "check cart page breadcrumb");

        Assert.assertEquals(cartPage.getListediPhone().getText(),
            "iPhone",
            "check if iPhone is in Cart");

        Assert.assertEquals(cartPage.getListedHtc().getText(),
            "HTC Touch HD",
            "check if Htc is in Cart");

        //set quantity
        cartPage.setQuantity("2", "3");

        cartPage.getUpdateButton().click();

        Assert.assertEquals(cartPage.getQuantityField1().getAttribute("value"),
            "2",
            "check qty first listed product");

        Assert.assertEquals(cartPage.getQuantityField2().getAttribute("value"),
            "3",
            "check qty second listed product");

        //checkout
        cartPage.getCheckoutButton().click();

        Assert.assertEquals(cartPage.getCheckoutTitle().getText(),
            "Checkout",
            "check title for checkout page");

        //try{ Thread.sleep(5000);}catch(InterruptedException ie){}

    }
}
