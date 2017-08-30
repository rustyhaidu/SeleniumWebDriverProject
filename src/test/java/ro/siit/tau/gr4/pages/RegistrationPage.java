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
    private WebElement adress1Field;

    @FindBy(how = How.ID, using = "input-address-2")
    private WebElement adress2Field;


}
