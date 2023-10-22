package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOfferCodePage {

public WebDriver driver;
	
	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Manage Offer Code']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") private WebElement manageOfferCodeMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='offer_code']") private WebElement offerCodeField;
	@FindBy(xpath = "//input[@value='yes']") private WebElement firstOrderYesRadioButton;
	@FindBy(xpath = "//input[@id='offer_per']") private WebElement percentageField;
	@FindBy(xpath = "//input[@id='offer_price']") private WebElement amountField;
	@FindBy(xpath = "//div[@role='textbox']") private WebElement descriptionField;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement imageChooseFile;
	@FindBy(xpath = "//button[@type='submit']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationMessage;
	
	public ManageOfferCodePage clickOnManageOfferCodeMoreInfo() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, manageOfferCodeMoreInfo);
		return this;
	}
	
	public ManageOfferCodePage clickOnNewButton() {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementToBeClickable(driver, newButton);
		newButton.click();
		return this;
	}
	
	public ManageOfferCodePage enterTheOfferCode(String offerCode) {
		offerCodeField.sendKeys(offerCode);;
		return this;
	}
	
	public ManageOfferCodePage clickOnYesRadioButton() {
		firstOrderYesRadioButton.click();
		return this;
	}
	
	public ManageOfferCodePage enterThePercentage(String percentage) {
		percentageField.sendKeys(percentage);;
		return this;
	}
	
	public ManageOfferCodePage enterTheAmount(String amount) {
		amountField.sendKeys(amount);;
		return this;
	}
	
	public ManageOfferCodePage enterTheDescription(String description) {
		descriptionField.sendKeys(description);;
		return this;
	}
	
	public ManageOfferCodePage clickOnImageChooseFileToUploadImage() {
		String path = GeneralUtility.MANAGEOFFERCODE_TOYCAR_IMAGEUPLOAD;
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(imageChooseFile, path);
		return this;
	}
	
	public ManageOfferCodePage clickOnSaveButton() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	
	public boolean isConfirmationMessageDisplayed() {
		return confirmationMessage.isDisplayed();
	}
}
