package ro.siit.tau.gr4.tests;

import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.HomePage;

public class CompareProductsTest extends BaseTest{

    private HomePage homePage;

    @Test
    public void compareItemsTest(){
        homePage.searchItem(" ");
    }
}
