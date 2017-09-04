package ro.siit.tau.gr4.tests;

import org.openqa.selenium.support.PageFactory;
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
        dp.add(new String[]{"abcd@yahoo.com", "Password", " "});
//        dp.add(new String[]{"", "", " Warning: No match for E-Mail Address and/or Password."});
//        dp.add(new String[]{"SomeUser", "somePassword", " Warning: No match for E-Mail Address and/or Password."});
        return dp.iterator();
    }

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String emailAddres, String password, String generalError) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(emailAddres, password );
        loginPage.getGeneralError();

    }
}
