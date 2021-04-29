package frameworktask.test;

import frameworktask.service.InstancesCreator;
import org.testng.annotations.Test;
import frameworktask.models.Instance;
import org.testng.asserts.SoftAssert;

public class PricingCalculatorTest extends BaseTest {
    private static final String SEARCH_INPUT = "Google Cloud Platform Pricing Calculator";
    private static final String FINAL_PRICE = "5,413.06";

    @Test
    public void estimatePriceTest() {
        Instance instanceOptions = InstancesCreator.withFieldsFromProperty();

        mainPage.openPage()
                .clickSearchButton()
                .enterSearchInput(SEARCH_INPUT)
                .openSearchResult(SEARCH_INPUT);
        calculatorPage.isPageOpened()
                .configureInstances(instanceOptions)
                .addToEstimate();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculatorPage.getEstimatedMachineClass().toLowerCase(), instanceOptions.getMachineClass().toLowerCase(), "Machine class is incorrect");
        softAssert.assertTrue(instanceOptions.getMachineType().startsWith(calculatorPage.getEstimatedInstanceType()), "Machine type is incorrect");
        softAssert.assertTrue(instanceOptions.getDatacenterLocation().startsWith(calculatorPage.getEstimatedRegion()), "Datacenter location is incorrect");
        softAssert.assertTrue(instanceOptions.getLocalSSD().startsWith(calculatorPage.getEstimatedLocalSSDspace()), "Estimated SSD is wrong");
        softAssert.assertEquals(calculatorPage.getEstimatedCommitmentTerm(), instanceOptions.getCommittedUsage(), "Commitment term is incorrect");
        softAssert.assertEquals(calculatorPage.getEstimatedPrice(), FINAL_PRICE, "Final price is incorrect");

        softAssert.assertAll();
    }
}
