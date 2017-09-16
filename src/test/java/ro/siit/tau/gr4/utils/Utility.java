package ro.siit.tau.gr4.utils;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Utility {

    /*Select sortBy = new Select(categoryPage.getSortBy());
        sortBy.selectByVisibleText("Name (A - Z)");*/

    //try{ Thread.sleep(5000);}catch(InterruptedException ie){}


    /*@FindBy(how = How.CSS, using = "input[name^='quantity']") - all input types having the name
    starting with 'quantity'*/


/*
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement productName;*/


  /*  public WebElement getQuantityField(String product){
        WebElement cartRow = this.getCartRow(product);
        return cartRow.findElement(By.xpath("//div[@class='input-group btn-block']/input[@type='text']"));
    }*/

  /*  public WebElement getQuantityField(String product) {
        WebElement productInCart = driver.findElement(By.xpath("//tr[descendant::a[text()='" +
            product + "']]//td[4]//input[@type='text']"));
        return productInCart;
    }

    public String readQuantity(String product){
        WebElement quantityField = getQuantityField(product);
        return quantityField.getAttribute("value");}*/

   /* public WebElement getCartRow(String product){
        String descendent = "//form/div[@class='table-responsive']/table[@class='table table-bordered']/tbody/tr[descendant::a[text()='" + product + "']]";
        return (new WebDriverWait( driver, 3))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(descendant)));
    }*/

   //("a[href*='long']")


   /* public void clickLinkByHref(String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while (i.hasNext()) {
            WebElement anchor = i.next();
            if (anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }*/

  /*  public WebElement getQuantityField(String product) {
        WebElement productInCart = driver.findElement(By.xpath("//tr[descendant::a[text()='" +
            product + "']]//td[4]//input[@type='text']"));
        return productInCart;
    }

   /* public WebElement getCartRow(String product){
        String descendent = "//form/div[@class='table-responsive']/table[@class='table table-bordered']/tbody/tr[descendant::a[text()='" + product + "']]";
        return (new WebDriverWait( driver, 3))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(descendent)));
    }*/


    /*public WebElement getQuantityField(String product){
        WebElement cartRow = this.getCartRow(product);
        return cartRow.findElement(By.cssSelector("input[name^='quantity']"));
    }*/

    //homePage.clickViewCart("route=checkout/cart", driver);

    //.replaceAll("[^£]","")


/*  @FindBy(how = How.XPATH, using = "//div[descendant::a[text()='MacBook']]")
    WebElement productCaption;*/



}
