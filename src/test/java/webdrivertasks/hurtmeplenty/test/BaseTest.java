package webdrivertasks.hurtmeplenty.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdrivertasks.hurtmeplenty.page.CalculatorPage;
import webdrivertasks.hurtmeplenty.page.MainPage;
import webdrivertasks.hurtmeplenty.page.SearchResultsPage;

public class BaseTest {
    private WebDriver driver;
    MainPage mainPage;
    SearchResultsPage searchResultsPage;
    CalculatorPage calculatorPage;

    @BeforeMethod
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        calculatorPage = new CalculatorPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
