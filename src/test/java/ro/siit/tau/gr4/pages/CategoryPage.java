package ro.siit.tau.gr4.pages;


import com.gargoylesoftware.htmlunit.javascript.host.Touch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryPage {

    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

 /*   @FindBy(how = How.XPATH, using = "/*//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]/span")
    private WebElement productChart;*/

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "iPhone")
    private WebElement iPhone;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "HTC Touch HD")
    private WebElement htcTouchHd;

    public WebElement getHtcTouchHd() {
        return htcTouchHd;
    }

    public void setHtcTouchHd(WebElement htcTouchHd) {
        this.htcTouchHd = htcTouchHd;
    }

    public WebElement getiPhone() {
        return iPhone;
    }

    public void setiPhone(WebElement iPhone) {
        this.iPhone = iPhone;
    }

/*    public WebElement getProductChart() {
        return productChart;
    }

    public void setProductChart(WebElement productChart) {
        this.productChart = productChart;
    }*/

    public WebElement getSortBy() {
        return sortBy;
    }

    public void setSortBy(WebElement sortBy) {
        this.sortBy = sortBy;
    }
}
