package ro.siit.tau.gr4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTableData(int row, int column) {
        return new WebDriverWait(driver, 3)
            .until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='content']/table/tbody[1]/tr[" + row + "]/td[" + column + "]")));
    }

    public int getProductComparisonTableRowCount() {
        int rowCount = driver.findElements(By.xpath("//*[@id='content']/table/tbody[1]/tr")).size();
        return rowCount;
    }

    public int getProductComparisonTableColumnCount() {
        int columnCount = driver.findElements(By.xpath("//*[@id='content']/table/tbody[1]/tr[1]/td")).size();
        return columnCount;
    }

    public WebElement getPrecedingH1Table(String header) {
        return driver.findElement(By.xpath("//table[@class='table table-bordered' and preceding-sibling::h1[text()='" + header + "']]"));
    }

    public WebElement getPrecedingH1TableData(String header, int row, int column) {
        return getPrecedingH1Table(header).findElement(By.xpath(".//tbody[1]/tr[" + row + "]/td[" + column + "]"));

    }

    public int getPrecedingH1TableRowCount(String header) {
        return getPrecedingH1Table(header).findElements(By.xpath(".//tbody[1]/tr")).size();
    }

    public int getPrecedingH1TableColumnCount(String header, int row) {
        return getPrecedingH1Table(header).findElements(By.xpath(".//tbody[1]/tr[" + row + "]/td")).size();
    }

    //***********************************************************WishList**********H2//

    public WebElement getWishListTable() {
        return driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']"));
    }

    public WebElement getWishListTableCell(String header, int row, int column) {
        return getWishListTable().findElement(By.xpath(".//tbody[1]/tr[" + row + "]/td[" + column + "]"));
    }

    public int getWishListTableRowCount() {
        return getWishListTable().findElements(By.xpath(".//tbody/tr")).size();
    }

    public int getWishListTableColumnCount(String header, int row) {
        return getWishListTable().findElements(By.xpath(".//tbody[1]/tr[" + row + "]/td")).size();
    }

    /***************************************************another table******/
    public WebElement getShoppingCartTableData(int row, int column) {
        String xpath = ".//tbody/tr[" + row + "]/td[" + column + "]";
        return getShoppingCartTable().findElement(By.xpath(xpath));

    }

    public WebElement getShoppingCartTable() {
        return driver.findElement(By.xpath("//div[@class='table-responsive']/table[@class='table table-bordered']"));
        //*[@id="content"]/div[1]/table
    }

    public int getShoppingCartTableRowCount() {
        return getShoppingCartTable().findElements(By.xpath(".//tbody[1]/tr")).size();
    }

    public int getShoppingCartTableColumnCount(int row) {
        return getShoppingCartTable().findElements(By.xpath(".//tbody[1]/tr[" + row + "]/td")).size();
    }
}
