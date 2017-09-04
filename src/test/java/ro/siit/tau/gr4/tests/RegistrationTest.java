package ro.siit.tau.gr4.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.models.RegistrationModel;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.RegistrationPage;
import ro.siit.tau.gr4.pages.WelcomePage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by andrei on 9/4/2017.
 */
public class RegistrationTest extends BaseTest {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @DataProvider(name = "JSONDataProviderRegistration")
    public Iterator<Object[]> jsonDataProviderCollection() {
        Collection<Object[]> dp = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File[] files = getListOfFiles("json/Registration");
            for (File f : files) {
                RegistrationModel m = mapper.readValue(f, RegistrationModel.class);
                dp.add(new Object[]{m});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dp.iterator();
    }

    @Test(dataProvider = "JSONDataProviderRegistration")
    public void RegistrationTest1(RegistrationModel registrationModel) {

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        registrationPage.register(registrationModel);
        if (registrationModel.expectSuccessfulRegistration() == false) {
            Assert.assertEquals(registrationPage.getFirstNameError(),
                registrationModel.getFirstNameError(),
                "Verifying first name error");

            Assert.assertEquals(registrationPage.getLastNameError(),
                registrationModel.getLastNameError(),
                "Verifying last name error");

            Assert.assertEquals(registrationPage.getEmailError(),
                registrationModel.getEmailError(),
                "Verifying Email error");

            Assert.assertEquals(registrationPage.getTelephoneError(),
                registrationModel.getTelephoneError(),
                "Verifying telephone error");

            Assert.assertEquals(registrationPage.getAddress1Error(),
                registrationModel.getAddress1Error(),
                "Verifying address1 error");

            Assert.assertEquals(registrationPage.getCityError(),
                registrationModel.getCityError(),
                "Verifying City error error");

            Assert.assertEquals(registrationPage.getStateError(),
                registrationModel.getStateError(),
                "Verifying City error error");
            Assert.assertEquals(registrationPage.getPasswordConfirmError(),
                registrationModel.getPasswordConfirmError(),
                "Verifying City error error");


        } else if(registrationModel.expectSuccessfulRegistration() == true){
            Assert.assertEquals(welcomePage.getWelcome().isDisplayed(),
                true,
                "Check if Welcome is displayed");
        }

    }
}
