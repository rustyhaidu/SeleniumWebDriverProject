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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrei on 9/4/2017.
 */
public class RegistrationTest extends BaseTest {

    File[] getListOfFiles(String directoryName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File directory = new File(classLoader.getResource(directoryName).getFile());
        File[] files = directory.listFiles();
        System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }

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
    public void RegistrationTest1(RegistrationModel registrationModel) throws InterruptedException {

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        registrationPage.click_on_register();
        registrationPage.setCountryRegion(registrationModel.getCountry1(), registrationModel.getRegion());
        registrationPage.register(registrationModel);

//        RegistrationPage.selectOption(registrationModel.getOptionName);


        if (registrationModel.expectSuccessfulRegistration() == false) {
            Assert.assertEquals(registrationPage.getFirstNameError().getText(),
                registrationModel.getFirstNameError(),
                "Verifying first name error");

            Assert.assertEquals(registrationPage.getLastNameError().getText(),
                registrationModel.getLastNameError(),
                "Verifying last name error");

            Assert.assertEquals(registrationPage.getEmailError().getText(),
                registrationModel.getEmailError(),
                "Verifying Email error");

            Assert.assertEquals(registrationPage.getTelephoneError().getText(),
                registrationModel.getTelephoneError(),
                "Verifying telephone error");

            Assert.assertEquals(registrationPage.getAddress1Error().getText(),
                registrationModel.getAddress1Error(),
                "Verifying address1 error");

            Assert.assertEquals(registrationPage.getCityError().getText(),
                registrationModel.getCityError(),
                "Verifying City error error");

            Assert.assertEquals(registrationPage.getStateError().getText(),
                registrationModel.getStateError(),
                "Verifying City error error");
            Assert.assertEquals(registrationPage.getPasswordError().getText(),
                registrationModel.getPasswordError(),
                "Verifying Password error error");


        } else if(registrationModel.expectSuccessfulRegistration() == true){
            Assert.assertEquals(welcomePage.getWelcome().isDisplayed(),
                true,
                "Check if Welcome is displayed");
        }

    }
}
