package ro.siit.tau.gr4.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryPage {

    @FindBy(how = How.ID, using = "input-sort")
    private WebElement sortBy;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[1]/span")
    private WebElement productChart;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "iPhone")
    private WebElement iPhone;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cart-total\"]")
    private WebElement CartTotalButton;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "View Cart")
    public WebElement viewCart;






    public WebElement getCartTotalButton() {
        return CartTotalButton;
    }

    public WebElement getViewCart() {
        return viewCart;
    }

    public void setViewCart(WebElement viewCart) {
        this.viewCart = viewCart;
    }

    public void setCartTotalButton(WebElement cartTotalButton) {
        CartTotalButton = cartTotalButton;
    }

    public WebElement getiPhone() {
        return iPhone;
    }

    public void setiPhone(WebElement iPhone) {
        this.iPhone = iPhone;
    }

    public WebElement getProductChart() {
        return productChart;
    }

    public void setProductChart(WebElement productChart) {
        this.productChart = productChart;
    }

    public WebElement getSortBy() {
        return sortBy;
    }

    public void setSortBy(WebElement sortBy) {
        this.sortBy = sortBy;
    }
}
