package ro.siit.tau.gr4.models;

public class RegistrationModel {

    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String fax;
    private String company;
    private String address1;
    private String address2;
    private String city1;
    private String postcode;
    private String country1;
    private String region;
    private String password;
    private String passwordConfirm;
    private String FirstNameError;
    private String LastNameError;
    private String EmailError;
    private String TelephoneError;
    private String Address1Error;
    private String CityError;
    private String StateError;
    private String PasswordError;
    private String PasswordConfirmError;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAdress1(String adress1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getFirstNameError() {
        return FirstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        FirstNameError = firstNameError;
    }

    public String getLastNameError() {
        return LastNameError;
    }

    public void setLastNameError(String lastNameError) {
        LastNameError = lastNameError;
    }

    public String getEmailError() {
        return EmailError;
    }

    public void setEmailError(String emailError) {
        EmailError = emailError;
    }

    public String getTelephoneError() {return TelephoneError;}

    public void setTelephoneError(String telephoneError) {
        TelephoneError = telephoneError;
    }

    public String getAddress1Error() {return Address1Error;}

    public void setAddress1Error(String address1Error) {
        Address1Error = address1Error;
    }

    public String getCityError() {
        return CityError;
    }

    public void setCityError(String cityError) {
        CityError = cityError;
    }

    public String getStateError() {
        return StateError;
    }

    public void setStateError(String stateError) {
        StateError = stateError;
    }

    public String getPasswordError() {
        return PasswordError;
    }

    public void setPasswordError(String passwordError) {
        PasswordError = passwordError;
    }

    public String getPasswordConfirmError() {return PasswordConfirmError;}

    public void setPasswordConfirmError(String passwordConfirmError) {
        PasswordConfirmError = passwordConfirmError;
    }


    public boolean expectSuccessfulRegistration() {

        if (!this.FirstNameError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.LastNameError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.EmailError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.TelephoneError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.Address1Error.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.CityError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.StateError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.PasswordError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.PasswordConfirmError.trim().equalsIgnoreCase("")) {
            return false;
        }
            return true;
        }
}


