package ro.siit.tau.gr4.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import ro.siit.tau.gr4.models.RegistrationModel;

public class RegistrationPage {
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement firstNameField;

    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement lastNameField;

    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "input-telephone")
    private WebElement telephoneField;

    @FindBy(how = How.ID, using = "input-fax")
    private WebElement faxField;

    @FindBy(how = How.ID, using = "input-company")
    private WebElement companyField;

    @FindBy(how = How.ID, using = "input-address-1")
    private WebElement address1Field;

    @FindBy(how = How.ID, using = "input-address-2")
    private WebElement address2Field;

    @FindBy(how = How.ID, using = "input-city")
    private WebElement city1Field;

    @FindBy(how = How.ID, using = "input-postcode")
    private WebElement postcodeField;

    @FindBy(how = How.ID, using = "input-country")
    private WebElement country1Field;

    @FindBy(how = How.ID, using = "input-zone")
    private WebElement regionField;

    @FindBy(how = How.ID, using = "input-password")
    private WebElement password1Field;

    @FindBy(how = How.ID, using = "input-confirm")
    private WebElement passwordConfirmField;

    @FindBy(how = How.XPATH, using = "//input[@name='agree' and @type='checkbox']")
    private WebElement agreeButton;

    @FindBy(how = How.XPATH, using = "//input[@value='Continue']")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//input[@name='firstname']/following-sibling::div")
    private WebElement actualFirstNameError;

    @FindBy(how = How.XPATH, using = "//input[@name='lastname']/following-sibling::div")
    private WebElement actualLastNameError;

    @FindBy(how = How.XPATH, using = "//input[@name='email']/following-sibling::div")
    private WebElement actualEmailError;

    @FindBy(how = How.XPATH, using = "//input[@name='telephone']/following-sibling::div")
    private WebElement actualTelephoneError;

    @FindBy(how = How.XPATH, using = "//input[@name='address_1']/following-sibling::div")
    private WebElement actualAddress1Error;

    @FindBy(how = How.XPATH, using = "//input[@name='city']/following-sibling::div")
    private WebElement actualCityError;

    @FindBy(how = How.XPATH, using = "//input[@name='country_id']/following-sibling::div")
    private WebElement actualcountry1Error;

    @FindBy(how = How.XPATH, using = "//select[@name='zone_id']/following-sibling::div")
    private WebElement actualStateError;

    @FindBy(how = How.XPATH, using = "//input[@name='password']/following-sibling::div")
    private WebElement actualPasswordError;

    @FindBy(how = How.XPATH, using = "//input[@name='confirm']/following-sibling::div")
    private WebElement actualPasswordConfirmError;
    @FindBy(how = How.XPATH, using = "//a[@title='My Account']")
    private WebElement myAccount;
    @FindBy(how = How.LINK_TEXT, using = "Register")
    private WebElement registerButton;

    public void click_on_register(){
        myAccount.click();
        registerButton.click();

    }
    public void register(RegistrationModel registrationModel) {
        firstNameField.clear();
        firstNameField.sendKeys(registrationModel.getFirstName());
        lastNameField.clear();
        lastNameField.sendKeys(registrationModel.getLastName());
        emailField.clear();
        emailField.sendKeys(registrationModel.getEmail());
        telephoneField.clear();
        telephoneField.sendKeys(registrationModel.getTelephone());
        faxField.clear();
        faxField.sendKeys(registrationModel.getFax());
        companyField.clear();
        companyField.sendKeys(registrationModel.getCompany());
        address1Field.clear();
        address1Field.sendKeys(registrationModel.getAddress1());
        address2Field.clear();
        address2Field.sendKeys(registrationModel.getAddress2());
        city1Field.clear();
        city1Field.sendKeys(registrationModel.getCity1());
        postcodeField.clear();
        postcodeField.sendKeys(registrationModel.getPostcode());
//        country1Field.clear();
//        country1Field.sendKeys(registrationModel.getCountry1());
////        regionField.clear();
//        regionField.sendKeys(registrationModel.getRegion());
        password1Field.clear();
        password1Field.sendKeys(registrationModel.getPassword());
        passwordConfirmField.clear();
        passwordConfirmField.sendKeys(registrationModel.getPasswordConfirm());

        agreeButton.click();
        submitButton.click();

    }

    public String getFirstNameError() {
        try {
            return actualFirstNameError.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getLastNameError() {
        try {
            return actualLastNameError.getText();
        } catch (NoSuchElementException e) {
                return  "";
        }

    }

    public String getEmailError() {
        try {
            return actualEmailError.getText();
        }catch (NoSuchElementException e){
            return "";

        }
    }
    public String getTelephoneError() {
        try {
            return actualTelephoneError.getText();
        }catch (NoSuchElementException e){
            return "";

        }
    }
    public String getAddress1Error() {
        try {
            return actualAddress1Error.getText();
        }catch (NoSuchElementException e){
            return "";

        }
    }
    public String getCityError() {
        try {
            return actualCityError.getText();
        }catch (NoSuchElementException e){
            return "";

        }
    }
    public String getcountry1Error() {
        try {
            return actualcountry1Error.getText();
        }catch (NoSuchElementException e){
            return "";
        }
    }
    public String getStateError() {
        try {
            return actualStateError.getText();
        }catch (NoSuchElementException e){
            return "";
        }
    }
    public String getPasswordError() {
        try {
            return actualPasswordError.getText();
        }catch (NoSuchElementException e){
            return "";
        }
    }
    public String getPasswordConfirmError() {
        try {
            return actualPasswordConfirmError.getText();
        }catch (NoSuchElementException e){
            return "";
        }
    }

    public void setCountryRegion(String country, String region) throws InterruptedException {

        Select dd = new Select(country1Field);
        dd.selectByVisibleText(country);
        //dd.selectByValue(country);
        Thread.sleep(1000);

        Select mm = new Select(regionField);
        mm.selectByVisibleText(region);
        //mm.selectByValue(region);
    }

}


