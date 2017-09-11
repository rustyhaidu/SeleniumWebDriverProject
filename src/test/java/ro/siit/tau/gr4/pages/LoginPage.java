package ro.siit.tau.gr4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID,using = "input-email")
    private WebElement emailAddressField;

    @FindBy(how = How.ID,using = "input-password")
    private WebElement passwordField;

    @FindBy(how = How.LINK_TEXT, using = "Login")
    private WebElement myAccountLogin;

    @FindBy(how = How.XPATH,using = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private WebElement loginButtonBeforeDropDown;

    @FindBy(how = How.XPATH,using = "//input[@value='Login']")
    private WebElement loginButtonAfterDropDown;

    @FindBy(how = How.XPATH,using = "/html/body/div[2]/div[1]")
    private WebElement generalErrorField;

    @FindBy(how = How.XPATH, using = "//a[@title='My Account']")
    private WebElement myAccount;

    @FindBy(how = How.XPATH, using = "//*[@id=\'top-links\']/ul/li[2]/ul/li[5]/a")
    private WebElement logout;


    public void login(String emailAddress, String password){
        myAccount.click();
        //loginButtonBeforeDropDown.click();
        myAccountLogin.click();
        emailAddressField.clear();
        emailAddressField.sendKeys(emailAddress);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButtonAfterDropDown.click();
    }

    public void loginFromWishList(String emailAddress, String password){

        emailAddressField.clear();
        emailAddressField.sendKeys(emailAddress);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButtonAfterDropDown.click();
    }


    public String getGeneralError(){

        return generalErrorField.getText();
    }

    public void myAccountLogout(){
        myAccount.click();
    }

    public WebElement getLogout(){
        return  logout;
    }

}
