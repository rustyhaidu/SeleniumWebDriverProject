package ro.siit.tau.gr4.models;

import java.sql.Timestamp;

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
    private String firstNameError;
    private String lastNameError;
    private String emailError;
    private String telephoneError;
    private String address1Error;
    private String cityError;
    private String country1Error;
    private String stateError;
    private String passwordError;
//    private String passwordConfirmError;

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
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    String ts = timestamp.toString();

    public void setEmail(String email) {
        this.email = ts.replaceAll("\\D", "")+email;
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

    public void setAddress1(String address1) {
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

    public String getPasswordConfirm() {return passwordConfirm;}

    public void setPasswordConfirm(String passwordConfirm) {this.passwordConfirm = passwordConfirm;}

    public String getFirstNameError() {
        return firstNameError;
    }

    public void setFirstNameError(String firstNameError) {
        this.firstNameError = firstNameError;
    }

    public String getLastNameError() {
        return lastNameError;
    }

    public void setLastNameError(String lastNameError) {
        this.lastNameError = lastNameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getTelephoneError() {
        return telephoneError;
    }

    public void setTelephoneError(String telephoneError) {
        this.telephoneError = telephoneError;
    }

    public String getAddress1Error() {
        return address1Error;
    }

    public void setAddress1Error(String address1Error) {
        this.address1Error = address1Error;
    }

    public String getCityError() {
        return cityError;
    }

    public void setCityError(String cityError) {
        this.cityError = cityError;
    }

    public void setCountry1Error(String country1Error1) {
        this.country1Error = country1Error1;
    }

    public String getcountry1Error() {
        return country1Error;
    }

    // de pus country error// si in assert
    public String getStateError() {
        return stateError;
    }

    public void setStateError(String stateError) {
        this.stateError = stateError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

//    public String getPasswordConfirmError() {return passwordConfirmError;}
//
//    public void setPasswordConfirmError(String passwordConfirmError) {this.passwordConfirmError = passwordConfirmError;}


    public boolean expectSuccessfulRegistration() {

        if (!this.firstNameError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.lastNameError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.emailError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.telephoneError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.address1Error.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.cityError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.stateError.trim().equalsIgnoreCase("")) {
            return false;
        }
        if (!this.country1Error.trim().equalsIgnoreCase("")) {
                return false;
        }
            if (!this.passwordError.trim().equalsIgnoreCase("")) {
                return false;
            }
//        if (!this.passwordConfirmError.trim().equalsIgnoreCase("")) {
//            return false;
//        }
            return true;
        }
    }



