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
        cartPage.setDriver(driver);

        //go to category
        categoryPage.clickCategory("Phones & PDAs", driver);

                    Assert.assertEquals(categoryPage.getCategoryTitle(),
                        "Phones & PDAs",
                        "check category page title");

        //add prod.1 to Cart
        categoryPage.clickProduct("iPhone", driver);
                    Assert.assertEquals(productPage.getProductTitle("h1", driver).getText(),
                        "iPhone",
                        "check product page title");
        productPage.getAddToCartButton().click();

        //add prod.2 to Cart
        categoryPage.clickCategory("Phones & PDAs", driver);
        categoryPage.clickProduct("HTC Touch HD", driver);
                    Assert.assertEquals(productPage.getProductTitle("h1", driver).getText(),
                        "HTC Touch HD",
                        "check product page title");
        productPage.getAddToCartButton().click();

        //go to Cart
        homePage.clickCartTotalButton();
        homePage.clickViewCart("route=checkout/cart", driver);
                    Assert.assertEquals(cartPage.getCartBreadcrumb().getText(),
                        "Shopping Cart",
                        "check if cart page is displayed");
                    Assert.assertEquals(categoryPage.getProduct("iPhone", driver).getText(),
                        "iPhone",
                        "check if product is in cart");
        //change quantity for prod. 1
        cartPage.getQuantityField("iPhone").clear();
        cartPage.getQuantityField("iPhone").sendKeys("4");

        cartPage.clickUpdateButton();
                    Assert.assertEquals(cartPage.readQuantity("iPhone"),
                        "4",
                        "check if qty is set");
                    Assert.assertEquals(cartPage.readQuantity("HTC Touch HD"),
                        "1",
                        "check if qty is set");
        //checkout
        cartPage.clickCheckoutButton();
                    Assert.assertEquals(cartPage.getCheckoutTitle().getText(),
                        "Checkout",
                        "check title for checkout page");
    }
}
