package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage {

	public WebDriver driver;

	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Mobile Slider']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']") WebElement mobileSliderMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']") WebElement sliderCategory;
	@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") WebElement confirmationAlert;
	
	public MobileSliderPage clickOnMobileSliderMoreInfo() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, mobileSliderMoreInfo);
		return this;
	}
	
	public MobileSliderPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public MobileSliderPage selectCategoryFromDropdown(String text) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownUsingVisibleText(sliderCategory, text);
		return this;
	}
	
	public MobileSliderPage clickOnChooseFileToUploadImage() {
		String path = GeneralUtility.IMAGE2;
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(chooseFile, path);
		return this;
	}
	
	public MobileSliderPage clickOnSaveButton() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	
	public boolean isConfirmationMessageAlertDisplayed() {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, confirmationAlert);
		return confirmationAlert.isDisplayed();
	}
}
