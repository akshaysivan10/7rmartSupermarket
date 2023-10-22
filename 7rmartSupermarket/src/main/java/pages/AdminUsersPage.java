package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Admin Users']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']") private WebElement adminUsersInfoUsername;
	@FindBy(xpath = "//input[@id='password']") private WebElement adminUsersInfoPassword;
	@FindBy(xpath = "//select[@id='user_type']") private WebElement userType;
	@FindBy(xpath = "//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]") private WebElement confirmationAlert;

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return this;
	}

	public AdminUsersPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnAdminUsersInfoUsernameField(String username) {
		adminUsersInfoUsername.sendKeys(username);
		return this;
	}

	public AdminUsersPage enterPasswordOnAdminUsersInfoUsernameField(String password) {
		adminUsersInfoPassword.sendKeys(password);
		return this;
	}

	public AdminUsersPage selectUserTypeFromDropdown(String text) {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownUsingVisibleText(userType, text);
		return this;
	}

	public AdminUsersPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public boolean confirmationMessageIsDisplyed() {
		return confirmationAlert.isDisplayed();
	}
}
