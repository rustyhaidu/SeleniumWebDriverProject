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

    //go to category
        categoryPage.goToCategory("Phones & PDAs", driver).click();

                Assert.assertEquals(categoryPage.goToCategory("Phones & PDAs", driver).getText(),
                    "Phones & PDAs",
                    "check category page title");

    //add iPhone to Cart
        categoryPage.getProduct("iPhone", driver).click();

                Assert.assertEquals(productPage.getProductName().getText(),
                    "iPhone",
                    "check product page title");

        productPage.getAddToCartButton().click();

                Assert.assertEquals(productPage.getProductTitle("h1", driver).getText(),
                    "iPhone",
                    "check product page title");

    //go to Cart
        homePage.getCartTotalButton().click();
        clickLinkByHref("route=checkout/cart");

                    Assert.assertEquals(cartPage.getCartBreadcrumb().getText(),
                        "Shopping Cart",
                        "check if cart page is displayed");
                    Assert.assertEquals(categoryPage.getProduct("iPhone", driver).getText(),
                        "iPhone",
                        "check if product is in cart");

    //set quantity
        cartPage.setQuantity("4");
        cartPage.getQuantityField("iPhone", driver).sendKeys("7");

        cartPage.getUpdateButton().click();

                    Assert.assertEquals(cartPage.getQuantityField().getAttribute("value"),
                        "4",
                        "check if qty is set");

    //checkout
        cartPage.getCheckoutButton().click();

        Assert.assertEquals(cartPage.getCheckoutTitle().getText(),
            "Checkout",
            "check title for checkout page");
    }

}
