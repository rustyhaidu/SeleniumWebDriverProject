package ro.siit.tau.gr4.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class HomePage {

    WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"cart\"]")
    private WebElement cartTotalButton;

    @FindBy(how = How.CSS, using = "a[href*='route=checkout/cart']")
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

    @FindBy(how = How.XPATH, using = "//div[@class='product-thumb']")
    private List<WebElement> listOfProducts;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-success']/a[contains(text(),'product comparison')]")
    WebElement productComparisonLink;

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public WebElement getProductComparisonLink() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        // Get the Link element from the success message to access the comparison table
        return wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.xpath("//div[@class='alert alert-success']/a[contains(text(),'product comparison')]")));
    }

    public WebElement getTableData(int row, int column) {
        return new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='content']/table/tbody[1]/tr[" + row + "]/td[" + column + "]")));
    }

    public List<WebElement> getListOfProducts() {
        return listOfProducts;
    }

    public WebElement getCompareButton(List<WebElement> productList, int index){
        return productList.get(index).findElement(By.cssSelector("button[data-original-title='Compare this Product']"));
    }

    public String getItemTitle(List<WebElement> productList, int index){
        return productList.get(index).findElement(By.tagName("h4")).getText();
    }


    public void clickViewCartBtn() {
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

    public void searchItem(String itemName) {
        searchEdit.clear();
        searchEdit.sendKeys(itemName);
        searchButton.click();
    }


}
