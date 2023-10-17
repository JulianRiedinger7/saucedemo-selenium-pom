package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseTest {

    WebDriver driver;

    @BeforeClass
    @Parameters({"url"})
    public void beforeClass(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public LoginPage loadFirstPage() {
        return new LoginPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
