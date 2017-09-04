package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.CartPage;
import ro.siit.tau.gr4.pages.CategoryPage;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.ProductPage;
import ro.siit.tau.gr4.utils.Utility;

public class AddToCartAndCheckoutTest extends BaseTest {

    @Test
    public void addToCart() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);

        //select category page and sort products
        categoryPage.goToCategory("Phones & PDAs", driver).click();

        Select sortBy = new Select(categoryPage.getSortBy());
        sortBy.selectByVisibleText("Name (A - Z)");

                Assert.assertEquals(categoryPage.goToCategory("Phones & PDAs", driver).getText(),
                    "Phones & PDAs",
                    "check category page title");

        //add iPhone to Cart
        categoryPage.getProduct("iPhone", driver).click();
        productPage.getAddToCartButton().click();

                Assert.assertEquals(productPage.getProductTitle("h1", driver).getText(),
                    "iPhone",
                    "check product page title");

        //add Htc to Cart
        categoryPage.goToCategory("Phones & PDAs", driver).click();
        categoryPage.getProduct("HTC Touch HD", driver).click();
        productPage.getAddToCartButton().click();

                    Assert.assertEquals(productPage.getProductTitle("h1", driver).getText(),
                        "HTC Touch HD",
                        "check product page title");

        //go to Cart
        homePage.getCartTotalButton().click();
        clickLinkByHref("route=checkout/cart");

                    Assert.assertEquals(cartPage.getCartBreadcrumb().getText(),
                        "Shopping Cart",
                        "check cart page breadcrumb");


        //set quantities
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
    }

    //try{ Thread.sleep(5000);}catch(InterruptedException ie){}

}
