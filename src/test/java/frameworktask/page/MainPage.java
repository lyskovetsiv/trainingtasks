package frameworktask.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@class='devsite-searchbox']/*[@name='q']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='devsite-searchbox']/*[@name='q']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@class='gcsc-more-maybe-branding-root']")
    private WebElement searchResultWindow;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage openPage() {
        driver.get(MAIN_PAGE_URL);
        logger.info("MainPage is opened");
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        logger.info("Search button clicked");
        return this;
    }

    public SearchResultsPage enterSearchInput(String input) {
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(searchResultWindow));
        return new SearchResultsPage(driver);
    }
}
