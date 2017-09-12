package ro.siit.tau.gr4.tests;

import com.gargoylesoftware.htmlunit.javascript.host.Touch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.*;

import java.util.List;

public class AddToWishListTest extends BaseTest{

    @Test
    public void AddToWishList(){

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        LoginTest loginTest = PageFactory.initElements(driver, LoginTest.class);
        WishListPage wishListPage = PageFactory.initElements(driver, WishListPage.class);

        wishListPage.setDriver(driver);

        //go to category
        categoryPage.clickCategory("Tablets", driver);

                    Assert.assertEquals(categoryPage.getCategoryText("Tablets", driver),
                        "Tablets",
                        "check category page title");

        categoryPage.clickProduct("Samsung Galaxy Tab 10.1", driver);
        String product1 = productPage.getProductTitle("h1", driver);
                    Assert.assertEquals(product1,
                        "Samsung Galaxy Tab 10.1",
                        "check product page title");

        productPage.clickAddToWishListButton();

                    Assert.assertEquals(homePage.getSuccessMessage().getText(),
                        new StringBuilder("You must login or create an account to save ")
                            .append(product1)
                            .append(" to your wish list!\n" +
                                "×").toString(),
                        "check success message");

        categoryPage.clickCategory("Cameras", driver);
        categoryPage.clickProduct("Nikon D300", driver);
        String product2 = productPage.getProductTitle("h1", driver);

        productPage.clickAddToWishListButton();

                Assert.assertEquals(homePage.getSuccessMessage().getText(),
                    new StringBuilder("You must login or create an account to save ")
                        .append(product2)
                        .append(" to your wish list!\n" +
                            "×").toString(),
                    "check success message");

        productPage.goToWishList();
        loginPage.loginFromWishList("abcd@yahoo.com", "Password");

                    Assert.assertEquals(wishListPage.getWishListTitle(),
                        "My Wish List",
                        "check wish list title");

        wishListPage.clickRemoveBtn("Samsung Galaxy Tab 10.1");

                    Assert.assertEquals(wishListPage.getSuccessMessage(),
                        "Success: You have modified your wish list!\n" +
                            "×",
                        "verify success message");

        wishListPage.clickAddToCartBtn("Nikon D300");

        Assert.assertEquals(wishListPage.verifyListedElement("Samsung Galaxy Tab 10.1").isEmpty(),
            true,
            "check if product was removed");

        homePage.clickViewCartBtn();

        Assert.assertEquals(categoryPage.verifyProductIsDisplayed("Nikon D300", driver),
            true,
            "check if product was added in cart");
    }
}
