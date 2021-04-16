package frameworktask.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {
    private static final String REQUIRED_SEARCH_RESULT = "//b[text()='%s']/ancestor::*[@class='gsc-thumbnail-inside']/descendant::a[@class='gs-title']";
    private final Logger logger = LogManager.getRootLogger();


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BasePage openPage() {
        return this;
    }

    public SearchResultsPage openSearchResult(String searchResult) {
        driver.findElement(By.xpath(String.format(REQUIRED_SEARCH_RESULT, searchResult))).click();
        logger.info("Opened search result for " + searchResult);
        return this;
    }
}
