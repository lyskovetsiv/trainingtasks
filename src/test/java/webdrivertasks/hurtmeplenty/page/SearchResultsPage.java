package webdrivertasks.hurtmeplenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage{
    private static final String REQUIRED_SEARCH_RESULT = "//b[text()='%s']/ancestor::*[@class='gsc-thumbnail-inside']/descendant::a[@class='gs-title']";


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
        return this;
    }
}
