package ro.siit.tau.gr4.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement cartTitle;

    @FindBy(how = How.NAME, using = "Use Coupon Code ")
    private WebElement couponCode;



}
