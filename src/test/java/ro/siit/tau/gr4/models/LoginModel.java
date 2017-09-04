package ro.siit.tau.gr4.models;

public class LoginModel {
    private String emailAddress;
    private String password;
    private String generalError;

    public LoginModel(String emailAddress,String password, String generalError) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.generalError = generalError;
    }

    public String getEmailAddress() { return emailAddress; }

    public void setEmailAddress(String password) { this.emailAddress = password; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getgeneralError() {  return generalError; }

    public void setgeneralError(String passwordError) { this.generalError = generalError; }
}
