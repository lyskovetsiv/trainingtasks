package frameworktask.test;

import frameworktask.service.InstancesCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import frameworktask.models.Instances;

public class PricingCalculatorTest extends BaseTest {
    private static final String SEARCH_INPUT = "Google Cloud Platform Pricing Calculator";
    private static final String FINAL_PRICE = "5,413.06";

    @Test
    public void estimatePriceTest() throws InterruptedException {
        Instances instancesOptions = InstancesCreator.withFieldsFromProperty();

        mainPage.openPage()
                .clickSearchButton()
                .enterSearchInput(SEARCH_INPUT)
                .openSearchResult(SEARCH_INPUT);
        calculatorPage.isPageOpened()
                .configureInstances(instancesOptions)
                .addToEstimate();

        Assert.assertEquals(calculatorPage.getEstimatedMachineClass().toLowerCase(), instancesOptions.getMachineClass().toLowerCase(), "Machine class is incorrect");
        Assert.assertTrue(instancesOptions.getMachineType().startsWith(calculatorPage.getEstimatedInstanceType()), "Machine type is incorrect");
        Assert.assertTrue(instancesOptions.getDatacenterLocation().startsWith(calculatorPage.getEstimatedRegion()), "Datacenter location is incorrect");
        Assert.assertTrue(instancesOptions.getLocalSSD().startsWith(calculatorPage.getEstimatedLocalSSDspace()), "Estimated SSD is wrong");
        Assert.assertEquals(calculatorPage.getEstimatedCommitmentTerm(), instancesOptions.getCommittedUsage(), "Commitment term is incorrect");
        Assert.assertEquals(calculatorPage.getEstimatedPrice(), FINAL_PRICE, "Final price is incorrect");
    }
}