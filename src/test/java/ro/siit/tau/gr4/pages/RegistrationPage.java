package ro.siit.tau.gr4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

    @FindBy(how = How.ID, using = "Password Confirm")
    private WebElement passwordConfirmField;

    @FindBy(how = How.NAME, using = "//input[@name='agree']")
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

    @FindBy(how = How.XPATH, using = "//select[@name='zone_id']/following-sibling::div")
    private WebElement actualStateError;

    @FindBy(how = How.XPATH, using = "//input[@name='password']/following-sibling::div")
    private WebElement actualPasswordError;

    @FindBy(how = How.XPATH, using = "//input[@name='confirm']/following-sibling::div")
    private WebElement actualPasswordConfirmError;

    public WebElement getFirstNameError() {
        return actualFirstNameError;
    }

    public WebElement getLastNameError() {
        return actualLastNameError;
    }

    public WebElement getEmailError() {
        return actualEmailError;
    }

    public WebElement getTelephoneError() {
        return actualTelephoneError;
    }

    public WebElement getAddress1Error() {
        return actualAddress1Error;
    }

    public WebElement getCityError() {
        return actualCityError;
    }

    public WebElement getStateError() {
        return actualStateError;
    }

    public WebElement getPasswordError() {
        return actualPasswordError;
    }

    public WebElement getPasswordConfirmError() {
        return actualPasswordConfirmError;
    }
}

