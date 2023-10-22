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

	@FindBy(xpath = "//p[text()='Category']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement categoryMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='category']") private WebElement enterTheCategory;
	@FindBy(xpath = "//li[@id='134-selectable']") private WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationAlert;

	public CategoryPage clickOnCategoryMoreInfo() {
		categoryMoreInfo.click();
		return this;
	}

	public CategoryPage clickOnNewButton() {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, newButton);
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
		String path = GeneralUtility.ADDCATEGORY_DIARYMILK_IMAGEUPLOAD;
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
		return confirmationAlert.isDisplayed();
	}
}
