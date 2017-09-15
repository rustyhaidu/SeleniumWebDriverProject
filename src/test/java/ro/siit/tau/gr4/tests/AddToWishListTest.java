package ro.siit.tau.gr4.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.*;

public class AddToWishListTest extends BaseTest{

    @Test
    public void AddToWishListTest(){

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

        //click product1
        categoryPage.clickProduct("Samsung Galaxy Tab 10.1", driver);
        String product1 = productPage.getProductTitle("h1", driver);
                    Assert.assertEquals(product1,
                        "Samsung Galaxy Tab 10.1",
                        "check product page title");

        //add product1 to wishList
        productPage.clickAddToWishListButton();

                    Assert.assertEquals(homePage.getSuccessMessageText(),
                        new StringBuilder("You must login or create an account to save ")
                            .append(product1)
                            .append(" to your wish list!\n" +
                                "×").toString(),
                        "check success message");

        //go to category and select product 2
        categoryPage.clickCategory("Cameras", driver);
        categoryPage.clickProduct("Nikon D300", driver);
        String product2 = productPage.getProductTitle("h1", driver);

        //add product2 to wishList
        productPage.clickAddToWishListButton();
                Assert.assertEquals(homePage.getSuccessMessageText(),
                    new StringBuilder("You must login or create an account to save ")
                        .append(product2)
                        .append(" to your wish list!\n" +
                            "×").toString(),
                    "check success message");

        //go to WishList/login
        productPage.goToWishList();
        loginPage.loginFromWishList("abcd@yahoo.com", "Password");
                    Assert.assertEquals(wishListPage.getWishListTitle(),
                        "My Wish List",
                        "check wish list title");

        //remove product from wishList & verify was removed
        wishListPage.clickRemoveBtn("Samsung Galaxy Tab 10.1");
                    Assert.assertEquals(wishListPage.getSuccessMessage(),
                        "Success: You have modified your wish list!\n" +
                            "×",
                        "verify success message");

        //add product to cart
        wishListPage.clickAddToCartBtn("Nikon D300");
        int rowCount = basePage.getWishListTableRowCount();
        boolean found = false;
        String value = "";
        for (int i = 1; i <= rowCount; i++) {
            value = basePage.getWishListTableData("My Wish List", i, 2)
                .getText();
            if (value.equals("Samsung Galaxy Tab 10.1")){
                found = true;
            }
        }
        Assert.assertEquals(found,
            false,
            "check if product was removed");

        //go to cart & verify product was added
        homePage.clickViewCartBtn();

        rowCount = basePage.getShoppingCartTableRowCount();
        found = false;

        for (int i = 1; i <= rowCount; i++) {
            value = basePage.getShoppingCartTableData(i, 2)
                .getText();
            if (value.equals("Nikon D300")){
                found = true;
            }
        }
        Assert.assertEquals(found,
            true,
            "check if product was added in cart");
    }
}
