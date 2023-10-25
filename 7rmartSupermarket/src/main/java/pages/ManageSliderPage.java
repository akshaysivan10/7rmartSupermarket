package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageSliderPage {

public WebDriver driver;
	
	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Manage Slider']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") private WebElement manageSliderMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement imageChooseFile;
	@FindBy(xpath = "//input[@id='link']") private WebElement linkField;
	@FindBy(xpath = "//button[text()='Save']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationMessage;
	@FindBy(xpath = "//td[text()='https://7rmartsupermarket/icecream/chocolate']//following::i[contains(@class,'fa-edit')][1]") private WebElement editButton;
	@FindBy(xpath = "//span[contains(@class,'fa-trash-alt')]") private WebElement deleteIcon;
	@FindBy(xpath = "//button[text()='Update']") private WebElement updateButton;
	@FindBy(xpath = "//td[text()='https://7rmartsupermarket/icecream/chocolate']//following::i[contains(@class,'fa-trash-alt')][1]") private WebElement deleteButton;
	@FindBy(xpath = "//a[text()=' Reset']") private WebElement resetButton;
	@FindBy(xpath = "//a[text()='Home']") private WebElement home;
	@FindBy(xpath = "//li[text()='Dashboard']") private WebElement dashboard;
	
	PageUtility pageUtility = new PageUtility();
	FileUploadUtility fileUploadUtility = new FileUploadUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public ManageSliderPage clickOnManageSliderMoreInfo() {
		manageSliderMoreInfo.click();
		return this;
	}
	
	public ManageSliderPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public ManageSliderPage clickOnChooseFileToUploadImage() {
		String path = GeneralUtility.MANAGESLIDER_ICECREAM_IMAGEUPLOAD;
		fileUploadUtility.fileUploadUsingSendKeys(imageChooseFile, path);
		return this;
	}
	
	public ManageSliderPage enterTheLink(String link) {
		linkField.clear();
		linkField.sendKeys(link);
		return this;
	}
	
	public ManageSliderPage clickOnSaveButton() {
		pageUtility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	
	public boolean isConfirmationMessageDisplayed() {
		waitUtility.waitForElement(driver, confirmationMessage);
		return confirmationMessage.isDisplayed();
	}
	
	public ManageSliderPage clickOnEditButton() {
		editButton.click();
		return this;
	}
	
	public ManageSliderPage clickOnDeleteIcon() {
		deleteIcon.click();
		pageUtility.switchToAlertAndAccept(driver);
		return this;
	}
	
	public ManageSliderPage clickOnUpdateButton() {
		
		pageUtility.javaScriptExecutorForClick(driver, updateButton);
		return this;
	}
	
	public ManageSliderPage clickOnChooseFileToUploadImageToEditImage() {
		String path = GeneralUtility.MANAGESLIDER_CHOCOLATEICECREAM_IMAGEUPLOAD;
		fileUploadUtility.fileUploadUsingSendKeys(imageChooseFile, path);
		return this;
	}
	
	public ManageSliderPage clickOnDeleteButton() {
		pageUtility.javaScriptExecutorForClick(driver, deleteButton);
		pageUtility.switchToAlertAndAccept(driver);
		return this;
	} 
	
	public ManageSliderPage clickOnResetButton() {
		resetButton.click();
		return this;
	}
	
	public ManageSliderPage clickOnHomeLink() {
		home.click();
		return this;
	}
	
	public boolean isHomePageDisplayed() {
		return dashboard.isDisplayed();
	}
}
