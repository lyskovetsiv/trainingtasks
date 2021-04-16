package frameworktask.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class TenMinuteMailPage extends BasePage {
    private static final String MAIL_URL = "https://10minutemail.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "copy_address")
    private WebElement copyUrlButton;

    @FindBy(id = "inbox_count_number")
    private WebElement inboxCounter;

    @FindBy(xpath = "//*[@class='message_top']")
    private WebElement topEmailMessage;

    @FindBy(xpath = "//*[@id='mobilepadding']/descendant::*[contains(text(), 'Estimated Monthly Cost:')]")
    private WebElement estimatedMonthlyCost;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public TenMinuteMailPage openPage() {
        driver.get(MAIL_URL);
        logger.info("TenMinuteMailPage is opened");
        return this;
    }

    public TenMinuteMailPage openPageInNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(MAIL_URL);
        logger.info("TenMinuteMailPage is opened in a new tab");
        return this;
    }

    public TenMinuteMailPage switchToTheEmailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        logger.info("Switched to TenMinuteEmailTab");
        return this;
    }

    public TenMinuteMailPage getTemporaryUrl() {
        wait.until(ExpectedConditions.visibilityOf(copyUrlButton)).click();
        copyUrlButton.click();
        copyUrlButton.click();
        return this;
    }

    public CalculatorPage switchToFirstTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        logger.info("Switched to CalculatorPage tab");
        return new CalculatorPage(driver);
    }

    public String getTotalPrice() {
        wait.until(ExpectedConditions.textToBePresentInElement(inboxCounter, "1"));
        wait.until(ExpectedConditions.elementToBeClickable(topEmailMessage)).click();
        return estimatedMonthlyCost.getText().replace("Estimated Monthly Cost: USD ", "");
    }
}
