package frameworktask.page;

import frameworktask.models.Instance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalculatorPage extends BasePage {
    private static final String CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";
    private static final String OPTION_FROM_DROPDOWN = "//*[contains(@class, 'md-select-menu-container md-active md-clickable')]//*[contains(text(), '%s')]";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[contains(text(), 'Send feedback')]")
    private WebElement sendFeedbackButton;

    @FindBy(xpath = "//*[@title='Compute Engine']/ancestor::md-tab-item")
    private WebElement computeEngineSection;

    @FindBy(id = "input_66")
    private WebElement numberOfInstancesField;

    @FindBy(id = "select_value_label_59")
    private WebElement operatingSystemField;

    @FindBy(id = "select_value_label_60")
    private WebElement machineClassField;

    @FindBy(id = "select_value_label_61")
    private WebElement machineFamilyField;

    @FindBy(id = "select_value_label_62")
    private WebElement seriesField;

    @FindBy(id = "select_value_label_63")
    private WebElement machineTypeField;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']/descendant::div[contains(text(), 'Add GPUs.')]")
    private WebElement addGPUCheckbox;

    @FindBy(id = "select_value_label_398")
    private WebElement gpuNumberField;

    @FindBy(id = "select_value_label_399")
    private WebElement gpuTypeField;

    @FindBy(id = "select_value_label_360")
    private WebElement localSSDField;

    @FindBy(id = "select_value_label_64")
    private WebElement datacenterLocationField;

    @FindBy(id = "select_value_label_65")
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

    @FindBy(xpath = "//*[contains(text(), 'Email Estimate')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//md-content//*[@name='description'][@type='email']")
    private WebElement emailInputBox;

    @FindBy(xpath = "//*[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CalculatorPage openPage() {
        driver.get(CALCULATOR_PAGE_URL);
        logger.info("CalculatorPage opened");
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

    public CalculatorPage configureInstances(Instance instance){
        numberOfInstancesField.sendKeys(instance.getNumberOfInstances());
        chooseOperatingSystemOption(instance.getOperatingSystem());
        chooseMachineFamilyOption(instance.getMachineFamily());
        chooseSeriesOption(instance.getSeries());
        chooseMachineTypeOption(instance.getMachineType());
        addGPUCheckbox.click();
        chooseGPUNumberOption(instance.getNumberOfGPUs());
        chooseGPUType(instance.getGpuType());
        chooseLocalSSDOption(instance.getLocalSSD());
        chooseDatacenterLocationOption(instance.getDatacenterLocation());
        chooseCommittedUsageOption(instance.getCommittedUsage());
        logger.info("Instance configured");
        return this;
    }

    public CalculatorPage addToEstimate() {
        addToEstimate.click();
        return this;
    }

    public CalculatorPage emailEstimateButtonClick() {
        emailEstimateButton.click();
        return this;
    }

    public CalculatorPage setEmail() {
        driver.switchTo().frame(0).switchTo().frame(0);
        emailInputBox.click();
        emailInputBox.sendKeys(Keys.SHIFT, Keys.INSERT);
        logger.info("Email is set");
        return this;
    }

    public void sendEmailButtonClick() {
        sendEmailButton.click();
        new TenMinuteMailPage(driver);
    }

    public void chooseOperatingSystemOption (String option) {
        operatingSystemField.click();
        chooseDropdownOption(option);
    }

    public void chooseMachineFamilyOption (String option) {
        machineFamilyField.click();
        chooseDropdownOption(option);
    }

    public void chooseSeriesOption (String option) {
        seriesField.click();
        chooseDropdownOption(option);
    }

    public void chooseMachineTypeOption (String option) {
        machineTypeField.click();
        chooseDropdownOption(option);
    }

    public void chooseGPUNumberOption (String option) {
        gpuNumberField.click();
        chooseDropdownOption(option);
    }

    public void chooseGPUType (String option) {
        gpuTypeField.click();
        chooseDropdownOption(option);
    }

    public void chooseLocalSSDOption (String option) {
        localSSDField.click();
        chooseDropdownOption(option);
    }

    public void chooseDatacenterLocationOption (String option) {
        datacenterLocationField.click();
        chooseDropdownOption(option);
    }

    public void chooseCommittedUsageOption (String option) {
        committedUsageField.click();
        chooseDropdownOption(option);
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

    private void chooseDropdownOption(String optionName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(OPTION_FROM_DROPDOWN, optionName)))).click();
    }
}
