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

    @FindBy(how = How.XPATH, using = "//div[@id='search']/input")
    private WebElement searchEdit;

    @FindBy(how = How.XPATH, using = "//div[@id='search']/span/button")
    private WebElement searchButton;

    public void clickCartTotalButton() {
        cartTotalButton.click();
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

        while (i.hasNext()) {
            WebElement anchor = i.next();
            if (anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }

    public void clickViewCart(String href, WebDriver driver){
        clickLinkByHref(href, driver);
    }

}
