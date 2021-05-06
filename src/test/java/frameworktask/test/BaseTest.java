package frameworktask.test;

import frameworktask.driver.DriverSingleton;
import frameworktask.page.CalculatorPage;
import frameworktask.page.MainPage;
import frameworktask.page.SearchResultsPage;
import frameworktask.page.TenMinuteMailPage;
import frameworktask.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
