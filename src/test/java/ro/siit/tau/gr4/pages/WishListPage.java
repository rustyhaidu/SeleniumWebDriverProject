package ro.siit.tau.gr4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WishListPage {

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement wishListTitle;

    public String getWishListTitle(){
        return wishListTitle.getText();
    }
}
