package ro.siit.tau.gr4.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.siit.tau.gr4.models.RegistrationModel;
import ro.siit.tau.gr4.pages.HomePage;
import ro.siit.tau.gr4.pages.LoginPage;
import ro.siit.tau.gr4.pages.RegistrationPage;
import ro.siit.tau.gr4.pages.WelcomePage;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrei on 9/4/2017.
 */
public class RegistrationTest extends BaseTest {

    @DataProvider(name = "JSONDataProviderRegistration")
    public Iterator<Object[]> jsonDataProviderCollection() throws URISyntaxException {
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
    public void RegistrationTest1(RegistrationModel registrationModel) throws InterruptedException {

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        registrationPage.click_on_register();
        registrationPage.setCountryRegion(registrationModel.getCountry1(), registrationModel.getRegion());
        registrationPage.register(registrationModel);

//        RegistrationPage.selectOption(registrationModel.getOptionName);


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

            Assert.assertEquals(registrationPage.getPasswordError(),
                registrationModel.getPasswordError(),
                "Verifying Password error error");

            Assert.assertEquals(registrationPage.getcountry1Error(),
                registrationModel.getcountry1Error(),
                "Verifying country error");

        } else if(registrationModel.expectSuccessfulRegistration() == true){
            Assert.assertEquals(welcomePage.getContinueBtn().isDisplayed(),
                true,
                "Check if Continue button is displayed");
        }

    }
}
