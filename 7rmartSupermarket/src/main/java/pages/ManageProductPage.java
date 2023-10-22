package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProductPage {

	public WebDriver driver;
	
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Manage Product']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']") private WebElement manageProductMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='title']") private WebElement enterTheTitle;
	@FindBy(xpath = "//input[@value='Nonveg']") private WebElement productType;
	@FindBy(xpath = "//input[@id='tag']") private WebElement enterTheTag;
	@FindBy(xpath = "//select[@id='grp_id']") private WebElement group;
	@FindBy(xpath = "//input[@id='m_weight']") private WebElement enterTheWeightValue;
	@FindBy(xpath = "//select[@id='w_unit']") private WebElement weightUnit;
	@FindBy(xpath = "//input[@id='max_weight']") private WebElement enterTheMaximumQuantity;
	@FindBy(xpath = "//input[@id='w_price']") private WebElement enterThePrice;
	@FindBy(xpath = "//input[@name='w_mrp']") private WebElement enterTheMRP;
	@FindBy(xpath = "//input[@id='w_stock']") private WebElement enterTheStockAvailability;
	@FindBy(xpath = "//input[@id='w_pp']") private WebElement enterThePurchasePrice;
	@FindBy(xpath = "//input[@name='unlimitw[]']") private WebElement unlimitedStockCheckBox;
	@FindBy(xpath = "//div[@role='textbox']") private WebElement textBox;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement imageChooseFile;
	@FindBy(xpath = "//input[@name='subfile[]']") private WebElement subImagesChooseFile;
	@FindBy(xpath = "//label[text()='Featured']//following::input[@value='yes']") private WebElement featuredRadioButtonYes;
	@FindBy(xpath = "//button[text()='Save']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationMessage;
	
	public ManageProductPage clickOnManageProductMoreInfo() {
		manageProductMoreInfo.click();
		return this;
	}
	
	public ManageProductPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public ManageProductPage enterTheTitleInTitleField(String title) {
		enterTheTitle.sendKeys(title);
		return this;
	}
	
	public ManageProductPage clickOnTheProductType() {
		productType.click();
		return this;
	}
	
	public ManageProductPage enterTheTagInTagField(String tag) {
		enterTheTag.sendKeys(tag);
		return this;
	}
	
	public ManageProductPage selectGroupFromDropdown(String text) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownUsingVisibleText(group, text);
		return this;
	}
	
	public ManageProductPage enterTheWeightValueInWeightValueField(String weightValue) {
		enterTheWeightValue.sendKeys(weightValue);
		return this;
	}
	
	public ManageProductPage selectWeightUnit(String value) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownUsingValue(weightUnit, value);
		return this;
	}
	
	public ManageProductPage enterTheMaximumQuantityInMaximumQuantityCanOrderField(String maximumQuantity) {
		enterTheMaximumQuantity.sendKeys(maximumQuantity);
		return this;
	}
	
	public ManageProductPage enterThePriceInPriceField(String price) {
		enterThePrice.sendKeys(price);
		return this;
	}
	
	public ManageProductPage enterTheMRPInMRPField(String mrp) {
		enterTheMRP.sendKeys(mrp);
		return this;
	}
	
	public ManageProductPage enterTheStockAvailabilityInStockAvailabilityField(String availableStock) {
		enterTheStockAvailability.sendKeys(availableStock);
		return this;
	}
	
	public ManageProductPage enterThePurchasePriceInPurchasePriceField(String purchasePrice) {
		enterThePurchasePrice.sendKeys(purchasePrice);
		return this;
	}
	
	public ManageProductPage clickOnUnlimitedStockCheckBox() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, unlimitedStockCheckBox);
		return this;
	}
	
	public ManageProductPage enterTheDescriptionInDescriptionTextBox(String description) {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, textBox);
		textBox.sendKeys(description);
		return this;
	}
	
	public ManageProductPage clickOnImageChooseFileToUploadImage() {
		String path = GeneralUtility.MANAGEPRODUCT_CHICKENBIRIYANI_IMAGEUPLOAD;
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(imageChooseFile, path);
		return this;
	}
	
	public ManageProductPage clickOnSubImagesChooseFileToUploadImage() {
		String path = GeneralUtility.MANAGEPRODUCT_BIRIYANI_SUBIMAGEUPLOAD;
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(subImagesChooseFile, path);
		return this;
	}
	
	public ManageProductPage clickOnYesRadioButtonInFeatured() {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementToBeClickable(driver, featuredRadioButtonYes);
		featuredRadioButtonYes.click();
		return this;
	}
	
	public ManageProductPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}
	
	public boolean isConfirmationAlertDisplayed() {
		return confirmationMessage.isDisplayed();
	}
}
