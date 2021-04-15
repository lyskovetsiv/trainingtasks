package webdrivertasks.hurtmeplenty.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import webdrivertasks.hurtmeplenty.models.Instances;

public class PricingCalculatorTest extends BaseTest {
    private static final String SEARCH_INPUT = "Google Cloud Platform Pricing Calculator";
    Instances instances = new Instances("4", null, "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS", "Regular",
            "General purpose", "N1", "n1-standard-8 (vCPUs: 8, RAM: 30GB)", "1", "NVIDIA Tesla V100",
            "2x375 GB", "Iowa (us-central1)", "1 Year");

    @Test
    public void estimatePriceTest() throws InterruptedException {
        mainPage.openPage()
                .clickSearchButton()
                .enterSearchInput(SEARCH_INPUT)
                .openSearchResult(SEARCH_INPUT);
        calculatorPage.isPageOpened()
                .configureInstances(instances)
                .addToEstimate();

        Assert.assertEquals(calculatorPage.getEstimatedMachineClass().toLowerCase(), instances.getMachineClass().toLowerCase());
        Assert.assertTrue(instances.getMachineType().startsWith(calculatorPage.getEstimatedInstanceType()));
        Assert.assertTrue(instances.getDatacenterLocation().startsWith(calculatorPage.getEstimatedRegion()));
        Assert.assertTrue(instances.getLocalSSD().startsWith(calculatorPage.getEstimatedLocalSSDspace()));
        Assert.assertEquals(calculatorPage.getEstimatedCommitmentTerm(), instances.getCommittedUsage());
    }
}
