package webdrivertasks.hurtmeplenty.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class TenMinuteMailPage extends BasePage{
    private static final String MAIL_URL = "https://10minutemail.com/";

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
        return this;
    }

    public TenMinuteMailPage openPageInNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(MAIL_URL);
        return this;
    }

    public TenMinuteMailPage switchToTheEmailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public TenMinuteMailPage getTemporaryUrl() {
        wait.until(ExpectedConditions.elementToBeClickable(copyUrlButton)).click();
        copyUrlButton.click();
        copyUrlButton.click();
        return this;
    }

    public CalculatorPage switchToFirstTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new CalculatorPage(driver);
    }

    public String getTotalPrice() {
        wait.until(ExpectedConditions.textToBePresentInElement(inboxCounter, "1"));
        wait.until(ExpectedConditions.elementToBeClickable(topEmailMessage)).click();
        return estimatedMonthlyCost.getText().replace("Estimated Monthly Cost: USD ", "");
    }
}
