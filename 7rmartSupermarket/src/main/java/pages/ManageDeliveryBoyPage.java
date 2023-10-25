package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageDeliveryBoyPage {

public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Manage Delivery Boy']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") private WebElement manageDeliveryBoyMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']") private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']") private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']") private WebElement mobileNumberField;
	@FindBy(xpath = "//textarea[@id='address']") private WebElement addressField;
	@FindBy(xpath = "//input[@id='username']") private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Save']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']") private WebElement searchNameField;
	@FindBy(xpath = "//input[@id='ut']") private WebElement searchEmailField;
	@FindBy(xpath = "//button[@name='Search']") private WebElement searchListSearchButton;
	@FindBy(xpath = "//table[contains(@class,'table-hover')]//tr//td[5]") private  List<WebElement> listOfDeliveryBoys;
	
	PageUtility pageUtility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	
	public ManageDeliveryBoyPage clickOnManageDeliveryBoyMoreInfo() {
		manageDeliveryBoyMoreInfo.click();
		return this;
	}
	
	public ManageDeliveryBoyPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheName(String name) {
		nameField.sendKeys(name);;
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheEmail(String email) {
		emailField.sendKeys(email);;
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheMobileNumber(String mobileNumber) {
		mobileNumberField.sendKeys(mobileNumber);;
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheAddress(String address) {
		addressField.sendKeys(address);;
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheUsername(String username) {
		usernameField.sendKeys(username);;
		return this;
	}
	
	public ManageDeliveryBoyPage enterThePassword(String password) {
		passwordField.sendKeys(password);;
		return this;
	}
	
	public ManageDeliveryBoyPage clickOnSaveButton() {
		pageUtility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	
	public boolean isConfirmationMessageDisplayed() {
		waitUtility.waitForElement(driver, confirmationMessage);
		return confirmationMessage.isDisplayed();
	}
	
	public ManageDeliveryBoyPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheSearchName(String name) {
		searchNameField.sendKeys(name);;
		return this;
	}
	
	public ManageDeliveryBoyPage enterTheSearchEmail(String email) {
		searchEmailField.sendKeys(email);;
		return this;
	}
	
	public ManageDeliveryBoyPage clickOnSearchButtonInsideSearchList() {
		searchListSearchButton.click();
		return this;
	}
	
	public List<String> isDeliveryBoyListedInTheTable() {
		List<String> deliveryBoysList = new ArrayList<>();
		for(WebElement deliveryBoysAvailable: listOfDeliveryBoys) {
			String deliveryBoysText = deliveryBoysAvailable.getText();
			deliveryBoysList.add(deliveryBoysText);
		}
		return deliveryBoysList;
	}
}
