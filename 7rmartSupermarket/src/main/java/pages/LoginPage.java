package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']") WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement signinButton;
	@FindBy(xpath = "//div[contains(@class,'small-box')]//child::p[text()='Manage Pages']") WebElement managePagesOnHomePage;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]//child::h5[text()=' Alert!']") WebElement alertMessageBox;

	public LoginPage enterUserNameOnUserNameField(String userName) {
		usernameField.sendKeys(userName);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public LoginPage clickOnTheSigninButton() {
		signinButton.click();
		return this;
	}

	public boolean isHomePageDisplayed() {
		return managePagesOnHomePage.isDisplayed();
	}

	public boolean isAlertMessageDisplayed() {
		return alertMessageBox.isDisplayed();
	}
}
