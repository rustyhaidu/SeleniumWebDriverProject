package ro.siit.tau.gr4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Iterator;
import java.util.List;

public class HomePage {


    @FindBy(how = How.XPATH, using = "//*[@id=\"cart\"]")
    private WebElement cartTotalButton;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "View Cart")
    private WebElement viewCartButton;

    @FindBy(how = How.XPATH, using = "//div[@class='container']/div[@class='alert alert-success']")
    private WebElement successMessage;

    @FindBy(how = How.XPATH, using = "//div[@id='search']/input")
    private WebElement searchEdit;

    @FindBy(how = How.XPATH, using = "//div[@id='search']/span/button")
    private WebElement searchButton;

    @FindBy(how = How.CLASS_NAME, using = "image")
    private List<WebElement> listOfImageElements;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Mac")
    private List<WebElement> macProductList;

    @FindBy(how = How.XPATH, using = "//div[@class='row']/..//h4/a")
    private List<WebElement> h4List;

    @FindBy(how = How.XPATH, using = "//div[@class='row']/div[@class='col-sm-6 text-right']")
    private WebElement noOfResultsWebElement;

    @FindBy(how = How.XPATH, using = "//div[@class='row']/div/div/div[@class='button-group']/button[1]")
    private List<WebElement> buttonList;

    @FindBy(how = How.XPATH, using = "//div[@class='row']/div//div/p[@class='price']")
    private List<WebElement> priceList;

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public void clickViewCartBtn(){
        viewCartButton.click();
    }

    public List<WebElement> getPriceList() {
        return priceList;
    }

    public List<WebElement> getButtonList() {
        return buttonList;
    }

    public String getTextFromNoOfResults() {
        return noOfResultsWebElement.getText();
    }

    public List<WebElement> getFoundH4List() {
        return h4List;
    }

    public List<WebElement> getListOfImageElements() {
        return listOfImageElements;
    }

    public List<WebElement> getFoundMacNameList() {
        return macProductList;
    }

    public void clickCartTotalButton() {
        cartTotalButton.click();
    }

    public String getTextFromCartTotalButton() {
        return cartTotalButton.getText();
    }

    public void setCartTotalButton(WebElement cartTotalButton) {
        this.cartTotalButton = cartTotalButton;
    }

    public void searchItem(String itemName){
        searchEdit.clear();
        searchEdit.sendKeys(itemName);
        searchButton.click();
    }

    public void clickLinkByHref(String href, WebDriver driver) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
        String anchorAttribute;
        while (i.hasNext()) {
            WebElement anchor = i.next();
            anchorAttribute = anchor.getAttribute("href");
            if (anchorAttribute.contains(href)) {
                anchor.click();
                break;
            }
        }
    }

    public void clickViewCart(String href, WebDriver driver){
        clickLinkByHref(href, driver);
    }

}
