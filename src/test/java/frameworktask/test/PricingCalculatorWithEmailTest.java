package frameworktask.test;

import frameworktask.models.Instances;
import frameworktask.service.InstancesCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PricingCalculatorWithEmailTest extends BaseTest {
    private static final String SEARCH_INPUT = "Google Cloud Platform Pricing Calculator";
    private static final String FINAL_PRICE = "5,413.06";

    @Test
    public void estimatePriceTestWithEmail() throws InterruptedException {
        Instances instancesOptions = InstancesCreator.withFieldsFromProperty();
        mainPage.openPage()
                .clickSearchButton()
                .enterSearchInput(SEARCH_INPUT)
                .openSearchResult(SEARCH_INPUT);
        calculatorPage.isPageOpened()
                .configureInstances(instancesOptions)
                .addToEstimate()
                .emailEstimateButtonClick();
        tenMinuteMailPage.openPageInNewTab()
                .getTemporaryUrl()
                .switchToFirstTab()
                .setEmail()
                .sendEmailButtonClick()
                .switchToTheEmailTab();

        Assert.assertEquals(tenMinuteMailPage.getTotalPrice(), FINAL_PRICE, "Price in Email is incorrect");

    }
}
