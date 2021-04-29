package frameworktask.test;

import frameworktask.models.Instance;
import frameworktask.service.InstancesCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PricingCalculatorWithEmailTest extends BaseTest {
    private static final String SEARCH_INPUT = "Google Cloud Platform Pricing Calculator";
    private static final String FINAL_PRICE = "5,413.06";

    @Test
    public void estimatePriceTestWithEmail() {
        Instance instanceOptions = InstancesCreator.withFieldsFromProperty();
        mainPage.openPage()
                .clickSearchButton()
                .enterSearchInput(SEARCH_INPUT)
                .openSearchResult(SEARCH_INPUT);
        calculatorPage.isPageOpened()
                .configureInstances(instanceOptions)
                .addToEstimate()
                .emailEstimateButtonClick();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        tenMinuteMailPage.openPage()
                .getTemporaryUrl();

        driver.switchTo().window(tabs.get(0));

                calculatorPage.setEmail()
                .sendEmailButtonClick();

        driver.switchTo().window(tabs.get(1));

        Assert.assertEquals(tenMinuteMailPage.getTotalPrice(), FINAL_PRICE, "Price in Email is incorrect");
    }
}
