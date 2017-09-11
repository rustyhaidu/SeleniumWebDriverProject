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
        categoryPage.clickCategory("Cameras", driver);

                    Assert.assertEquals(categoryPage.goToCategory("Cameras", driver).getText(),
                        "Cameras",
                        "check category page title");

        categoryPage.clickProduct("Canon EOS 5D", driver);
        String product1 = productPage.getProductTitle("h1", driver).getText();
                    Assert.assertEquals(product1,
                        "Canon EOS 5D",
                        "check product page title");

        productPage.clickAddToWishListButton();

                    Assert.assertEquals(homePage.getSuccessMessage().getText(),
                        new StringBuilder("You must login or create an account to save ")
                            .append(product1)
                            .append(" to your wish list!\n" +
                                "×").toString(),
                        "check message");

        categoryPage.clickCategory("Cameras", driver);
        categoryPage.clickProduct("Nikon D300", driver);
        String product2 = productPage.getProductTitle("h1", driver).getText();
        productPage.clickAddToWishListButton();

                Assert.assertEquals(homePage.getSuccessMessage().getText(),
                    new StringBuilder("You must login or create an account to save ")
                        .append(product2)
                        .append(" to your wish list!\n" +
                            "×").toString(),
                    "check message");
        productPage.goToWishList();

        loginPage.loginFromWishList("abcd@yahoo.com", "Password");
                    Assert.assertEquals(wishListPage.getWishListTitle(),
                        "My Wish List",
                        "check wish list title");

        wishListPage.getRemoveBtn("Canon EOS 5D").click();
        wishListPage.getAddToCartBtn("Nikon D300").click();


                    Assert.assertEquals(wishListPage.getListOfProducts("Canon EOS 5D").isEmpty(),
                        true,
                        "check if product was removed");



    }
}
