package ro.siit.tau.gr4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by andrei on 9/4/2017.
 */
public class WelcomePage {
    @FindBy(how = How.LINK_TEXT, using = "Your Account Has Been Created!")
    private WebElement welcome;

    public WebElement getWelcome() {return welcome;}

    @FindBy(how = How.LINK_TEXT, using = "Continue")
    private WebElement ContinueBtn;

}
