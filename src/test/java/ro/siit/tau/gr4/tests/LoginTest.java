package ro.siit.tau.gr4.tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.pages.LoginPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTest extends BaseTest {

    @DataProvider(name = "LoginDataProvider")
    public Iterator<Object[]> loginDataProvider() {
        Collection<Object[]> dp = new ArrayList<Object[]>();
        dp.add(new String[]{"abcd@yahoo.com", "Password", " ", "true"});
        //dp.add(new String[]{"", "", "Warning: No match for E-Mail Address and/or Password.", "false"});
//        dp.add(new String[]{"SomeUser", "somePassword", " Warning: No match for E-Mail Address and/or Password."});
        return dp.iterator();
    }

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String emailAddres, String password, String generalError, String resultLogin) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(emailAddres, password );
        loginPage.getGeneralError();


        if(resultLogin.equals("false")) {
            Assert.assertEquals(loginPage.getGeneralError(),
                generalError,
                "Warning: No match for E-Mail Address and/or Password.");
        }
        else if(resultLogin.equals("true")){
            loginPage.myAccountLogout();
            //loginPage.getLogout().sendKeys("");
            new Actions(driver).moveToElement(loginPage.getLogout()).perform();
            Assert.assertTrue(loginPage.getLogout().isDisplayed());
        }
    }

}

