package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage {

	public WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Manage Location']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']") private WebElement manageLocationMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") private WebElement countryDropdown;
	@FindBy(xpath = "//select[@id='st_id']") private WebElement stateDropdown;
	@FindBy(xpath = "//input[@id='location']") private WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']") private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[text()='Save']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement searchButton;
	@FindBy(xpath = "//button[@name='Search']") private WebElement searchLocationButton;
	@FindBy(xpath = "//table[contains(@class,'table-hover')]//tr//td[1]") private List<WebElement> listOfLocations;
	
	public ManageLocationPage clickOnManageLocationMoreInfo() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, manageLocationMoreInfo);
		return this;
	}
	
	public ManageLocationPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public ManageLocationPage selectCountryFromDropdown(String countryName) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownUsingVisibleText(countryDropdown, countryName);
		return this;
	}
	
	public ManageLocationPage selectStateFromDropdown(String stateValue) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownUsingValue(stateDropdown, stateValue);
		return this;
	}
	
	public ManageLocationPage enterTheLocation(String locationName) {
		locationField.sendKeys(locationName);
		return this;
	}
	
	public ManageLocationPage enterTheDeliveryCharge(String amount) {
		deliveryChargeField.sendKeys(amount);
		return this;
	}
	
	public ManageLocationPage clickOnSaveButton() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.javaScriptExecutorForClick(driver, saveButton);
		return this;
	}
	
	public boolean isConfirmationMessageDisplayed() {
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, confirmationMessage);
		return confirmationMessage.isDisplayed();
	}
	
	public ManageLocationPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}
	
	public ManageLocationPage clickOnSearchLocationButton() {
		searchLocationButton.click();
		return this;
	}
	
	public List<String> isLocationListedInTheTable() {
		List<String> locationList = new ArrayList<>();
		for(WebElement locationsAvailable: listOfLocations) {
			String locationText = locationsAvailable.getText();
			locationList.add(locationText);
		}
		return locationList;
	}
}

