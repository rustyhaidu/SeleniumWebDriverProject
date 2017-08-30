package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.CategoryPage;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.ProductPage;

public class AddToCartAndCheckoutTest extends BaseTest {




    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);

    @Test
    public void addToCart() {

       /* try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }*/

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.getPhonesAndPdaCategory().click();

        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        Select sortBy = new Select(categoryPage.getSortBy());
        sortBy.selectByValue("http://shop-tausandbox.rhcloud.com/index.php?route=product/category&path=24&sort=pd.name&order=ASC");

        categoryPage.getiPhone().click();

        ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
        productPage.getAddToCartButton().click();



        /*categoryPage.getCartTotalButton().click();*/








    }
}
