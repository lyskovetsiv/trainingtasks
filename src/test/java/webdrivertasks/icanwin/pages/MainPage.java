package webdrivertasks.icanwin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://pastebin.com/";
    @FindBy(id = "postform-text")
    private WebElement formForText;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationTime;
    @FindBy(id = "postform-name")
    private WebElement pasteName;
    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;
    @FindBy(xpath = "//*[@class='btn -big']")
    private WebElement createNewPasteButton;
    @FindBy(xpath = "//*[@class='notice -success -post-view']")
    private WebElement successfulPasteCreation;
    @FindBy(xpath = "//*[@class='info-top']")
    private WebElement nameOfCreatedPaste;
    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement textOfCreatedPaste;
    @FindBy(xpath = "//*[@class='left']/a")
    private WebElement syntaxHighlightingOfPaste;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public MainPage enterTextInMainForm(String text) {
        formForText.click();
        formForText.sendKeys(text);
        return this;
    }

    public MainPage setExpirationTime(String expirationTime) {
        String expirationTimeXpath = String.format("//*[@class='select2-results__option'][text()='%s']", expirationTime);

        pasteExpirationTime.click();
        driver.findElement(By.xpath(expirationTimeXpath)).click();
        return this;
    }

    public MainPage enterPasteName(String pasteTitle) {
        pasteName.sendKeys(pasteTitle);
        return this;
    }

    public MainPage setSyntaxHighlighting(String languageName) {
        String syntaxHighlightingXpath = String.format("//*[@class='select2-results__option'][text()='%s']", languageName);

        syntaxHighlighting.click();
        driver.findElement(By.xpath(syntaxHighlightingXpath)).click();
        return this;
    }

    public MainPage createNewPasteButtonClick() {
        createNewPasteButton.click();
        return this;
    }

    public String getTitleOfCreatedPaste() {
        wait.until(ExpectedConditions.visibilityOf(successfulPasteCreation));
        return nameOfCreatedPaste.getText();
    }

    public String getTextOfCreatedPaste() {
        wait.until(ExpectedConditions.visibilityOf(successfulPasteCreation));
        return textOfCreatedPaste.getText();
    }

    public String getSyntaxHighlighting() {
        wait.until(ExpectedConditions.visibilityOf(successfulPasteCreation));
        return syntaxHighlightingOfPaste.getText();
    }
}
