package ro.siit.tau.gr4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ro.siit.tau.gr4.pages.BasePage;
import ro.siit.tau.gr4.pages.HomePage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    BasePage basePage;

    File[] getListOfFiles(String directoryName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL path = classLoader.getResource(directoryName);
        String configPath = null;

        try {
            configPath = URLDecoder.decode(path.getFile(), "UTF-8");
            System.out.println(configPath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File directory = new File(configPath);

        File[] files = directory.listFiles();
        System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }


    @BeforeMethod
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://shop-tausandbox.rhcloud.com");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
