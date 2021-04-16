package frameworktask.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PathCreator {
    private static final String OPTION_FROM_DROPDOWN = "//*[contains(@class, 'md-select-menu-container')]//*[contains(text(), '%s')]";

    public void chooseDropdownOption(WebDriver driver, WebDriverWait wait, String optionName) {
        WebElement currentElement = driver.findElement(By.xpath(String.format(OPTION_FROM_DROPDOWN, optionName)));
        wait.until(ExpectedConditions.elementToBeClickable(currentElement));
        currentElement.click();
    }
}
