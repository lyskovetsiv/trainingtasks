package webdrivertasks.hurtmeplenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdrivertasks.hurtmeplenty.models.Instances;
import webdrivertasks.hurtmeplenty.utils.PathCreator;

public class CalculatorPage extends BasePage{
    private static final String CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";
    private static final String DROPDOWN_OPTION = "//*[contains(@class, 'md-select-menu-container md-active md-clickable')]//*[contains(text(), '%s')]";
    PathCreator pathCreator = new PathCreator();

    @FindBy(xpath = "//button[contains(text(), 'Send feedback')]")
    private WebElement sendFeedbackButton;

    @FindBy(xpath = "//*[@title='Compute Engine']/ancestor::md-tab-item")
    private WebElement computeEngineSection;

    @FindBy(id = "input_65")
    private WebElement numberOfInstancesField;

    @FindBy(id = "select_value_label_58")
    private WebElement operatingSystemField;

    @FindBy(id = "select_value_label_59")
    private WebElement machineClassField;

    @FindBy(id = "select_value_label_60")
    private WebElement machineFamilyField;

    @FindBy(id = "select_value_label_61")
    private WebElement seriesField;

    @FindBy(id = "select_value_label_62")
    private WebElement machineTypeField;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']/descendant::div[contains(text(), 'Add GPUs.')]")
    private WebElement addGPUCheckbox;

    @FindBy(id = "select_value_label_397")
    private WebElement gpuNumberField;

    @FindBy(id = "select_value_label_398")
    private WebElement gpuTypeField;

    @FindBy(id = "select_value_label_359")
    private WebElement localSSDField;

    @FindBy(id = "select_value_label_63")
    private WebElement datacenterLocationField;

    @FindBy(id = "select_value_label_64")
    private WebElement committedUsageField;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//*[contains(text(), 'VM class:')]")
    private WebElement estimatedMachineClass;

    @FindBy(xpath = "//*[contains(text(), 'Instance type: ')]")
    private WebElement estimatedInstanceType;

    @FindBy(xpath = "//*[contains(text(), 'Region: ')]")
    private WebElement estimatedRegion;

    @FindBy(xpath = "//*[contains(text(), 'Total available local SSD space ')]")
    private WebElement estimatedSSDspace;

    @FindBy(xpath = "//*[contains(text(), 'Commitment term: ')]")
    private WebElement estimatedTerm;

    @FindBy(xpath = "//*[contains(text(), 'Total Estimated')]")
    private WebElement estimatedPrice;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CalculatorPage openPage() {
        driver.get(CALCULATOR_PAGE_URL);
        return this;
    }

    public CalculatorPage isPageOpened() {
        driver.switchTo().frame(0).switchTo().frame(0);
        wait.until(ExpectedConditions.elementToBeClickable(sendFeedbackButton));
        return this;
    }

    public CalculatorPage chooseComputeEngineSection() {
        computeEngineSection.click();
        return this;
    }

    public CalculatorPage configureInstances(Instances instances) throws InterruptedException {
        numberOfInstancesField.sendKeys(instances.getNumberOfInstances());
        operatingSystemField.click();
        pathCreator.chooseDropdownOption(driver, wait, instances.getOperatingSystem());
        machineFamilyField.click();
        pathCreator.chooseDropdownOption(driver, wait, instances.getMachineFamily());
        seriesField.click();
        pathCreator.chooseDropdownOption(driver, wait, instances.getSeries());
        machineTypeField.click();
        pathCreator.chooseDropdownOption(driver, wait, instances.getMachineType());
        addGPUCheckbox.click();
        gpuNumberField.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(String.format(DROPDOWN_OPTION, instances.getNumberOfGPUs()))))).click();
        gpuTypeField.click();
        pathCreator.chooseDropdownOption(driver, wait, instances.getGpuType());
        localSSDField.click();
        pathCreator.chooseDropdownOption(driver, wait, instances.getLocalSSD());
        datacenterLocationField.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(String.format(DROPDOWN_OPTION, instances.getDatacenterLocation()))))).click();
        committedUsageField.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(String.format(DROPDOWN_OPTION, instances.getCommittedUsage()))))).click();
        return this;
    }

    public CalculatorPage addToEstimate() {
        addToEstimate.click();
        return this;
    }

    public String getEstimatedMachineClass() {
        return estimatedMachineClass.getText().replace("VM class: ", "");
    }

    public String getEstimatedInstanceType() {
        return estimatedInstanceType.getText().replace("Instance type: ", "");
    }

    public String getEstimatedRegion() {
        return estimatedRegion.getText().replace("Region: ", "");
    }

    public String getEstimatedLocalSSDspace() {
        return estimatedSSDspace.getText().replace("Total available local SSD space ", "").replace("GiB", "");
    }

    public String getEstimatedCommitmentTerm() {
        return estimatedTerm.getText().replace("Commitment term: ", "");
    }

    public String getEstimatedPrice() {
        return estimatedPrice.getText().replace("Total Estimated Cost: USD ", "").replace(" per 1 month", "");
    }
}
