package ro.siit.tau.gr4.pages;


import com.gargoylesoftware.htmlunit.javascript.host.Touch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryPage {

    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "iPhone")
    private WebElement iPhone;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "HTC Touch HD")
    private WebElement htcTouchHd;

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement categoryPageTitle;


    public WebElement getCategoryPageTitle() {
        return categoryPageTitle;
    }

    public void setCategoryPageTitle(WebElement categoryPageTitle) {
        this.categoryPageTitle = categoryPageTitle;
    }

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

    public WebElement getSortBy() {
        return sortBy;
    }

    public void setSortBy(WebElement sortBy) {
        this.sortBy = sortBy;
    }
}
