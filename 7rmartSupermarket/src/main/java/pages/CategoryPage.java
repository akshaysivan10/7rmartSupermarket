package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {

	public WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Category']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement categoryMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='category']") WebElement enterTheCategory;
	@FindBy(xpath = "//li[@id='134-selectable']") WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']") WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") WebElement confirmationAlert;
	
	public CategoryPage clickOnCategoryMoreInfo() {
		categoryMoreInfo.click();
		return this;
	}
	
	public CategoryPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public CategoryPage enterCategoryOnCategoryField(String categoryName) {
		enterTheCategory.sendKeys(categoryName);
		return this;
	}
	
	public CategoryPage clickOnDiscountInSelectGroups() {
		discount.click();
		return this;
	}
	
	public CategoryPage clickOnChooseFileToUploadImage() {
		String path = GeneralUtility.IMAGE1;
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(chooseFile, path);
		return this;
	}
	
	public CategoryPage clickOnSaveButton() {
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
