package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithValidCredentials() {

		String validUsername = ExcelUtility.getString(1, 0, "LoginPage");
		String validPassword = ExcelUtility.getString(1, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(validUsername).enterPasswordOnPasswordField(validPassword).clickOnTheSigninButton();
		boolean isHomePageAvailable = loginPage.isHomePageDisplayed();
		assertTrue(isHomePageAvailable, "User is unable to login with valid credentials");
	}

	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithInvalidCredentials() {

		String invalidUsername = ExcelUtility.getString(1, 2, "LoginPage");
		String invalidPassword = ExcelUtility.getString(1, 3, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(invalidUsername).enterPasswordOnPasswordField(invalidPassword).clickOnTheSigninButton();
		boolean isAlertMessageAvailable = loginPage.isAlertMessageDisplayed();
		assertTrue(isAlertMessageAvailable, "User is able to login with invalid credentials");
	}

	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithValidUserNameAndInvalidPassword() {

		String validUsername = ExcelUtility.getString(1, 4, "LoginPage");
		String invalidPassword = ExcelUtility.getString(1, 5, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(validUsername).enterPasswordOnPasswordField(invalidPassword).clickOnTheSigninButton();
		boolean isAlertMessageAvailable = loginPage.isAlertMessageDisplayed();
		assertTrue(isAlertMessageAvailable, "User is able to login with invalid password");
	}

	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithInvalidUserNameAndValidPassword() {

		String invalidUsername = ExcelUtility.getString(1, 6, "LoginPage");
		String validPassword = ExcelUtility.getString(1, 7, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(invalidUsername).enterPasswordOnPasswordField(validPassword).clickOnTheSigninButton();
		boolean isAlertMessageAvailable = loginPage.isAlertMessageDisplayed();
		assertTrue(isAlertMessageAvailable, "User is able to login with invalid username");
	}
}
