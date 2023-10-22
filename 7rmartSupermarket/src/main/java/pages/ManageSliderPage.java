package pages;

import java.util.ArrayList;
import java.util.List;

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
	@FindBy(xpath = "//td[text()='https://7rmartsupermarket/icecream/choco']//following::i[contains(@class,'fa-edit')][1]") private WebElement editButton;
	@FindBy(xpath = "//span[contains(@class,'fa-trash-alt')]") private WebElement deleteIcon;
	@FindBy(xpath = "//button[text()='Update']") private WebElement updateButton;
	
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
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(imageChooseFile, path);
		return this;
	}
	
	public ManageSliderPage enterTheLink(String link) {
		linkField.clear();
		linkField.sendKeys(link);
		return this;
	}
	
	public ManageSliderPage clickOnSaveButton() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	
	public boolean isConfirmationMessageDisplayed() {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, confirmationMessage);
		return confirmationMessage.isDisplayed();
	}
	
	public ManageSliderPage clickOnEditButton() {
		editButton.click();
		return this;
	}
	
	public ManageSliderPage clickOnDeleteIcon() {
		deleteIcon.click();
		PageUtility pageUtility = new PageUtility();
		pageUtility.switchToAlertAndAccept(driver);
		return this;
	}
	
	public ManageSliderPage clickOnUpdateButton() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, updateButton);
		return this;
	}
}
