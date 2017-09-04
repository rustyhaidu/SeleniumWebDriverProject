package ro.siit.tau.gr4.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how = How.LINK_TEXT, using = "Phones & PDAs")
    private WebElement phonesAndPdaCategory;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Cameras")
    private WebElement camerasCategory;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cart\"]")
    private WebElement cartTotalButton;


    public WebElement getCartTotalButton() {
        return cartTotalButton;
    }

    public void setCartTotalButton(WebElement cartTotalButton) {
        this.cartTotalButton = cartTotalButton;
    }

    public WebElement getPhonesAndPdaCategory() {
        return phonesAndPdaCategory;
    }

    public void setPhonesAndPdaCategory(WebElement phonesAndPdaCategory) {
        this.phonesAndPdaCategory = phonesAndPdaCategory;
    }

    public WebElement getCamerasCategory() {
        return camerasCategory;
    }

    public void setCamerasCategory(WebElement camerasCategory) {
        this.camerasCategory = camerasCategory;
    }
}
