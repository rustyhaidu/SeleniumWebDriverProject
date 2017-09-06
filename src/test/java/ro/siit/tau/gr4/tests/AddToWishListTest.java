package ro.siit.tau.gr4.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.*;

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

        cartPage.setDriver(driver);

        //go to category
        categoryPage.clickCategory("Cameras", driver);

                    Assert.assertEquals(categoryPage.goToCategory("Cameras", driver).getText(),
                        "Cameras",
                        "check category page title");

        categoryPage.clickProduct("Canon EOS 5D", driver);
                    Assert.assertEquals(productPage.getProductTitle("h1", driver).getText(),
                        "Canon EOS 5D",
                        "check product page title");

        productPage.clickAddToWishListButton();

        productPage.goToWishList();

        loginPage.loginFromWishList("abcd@yahoo.com", "Password");
                    Assert.assertEquals(wishListPage.getWishListTitle(),
                        "My Wish List",
                        "check wish list title");



    }
}
