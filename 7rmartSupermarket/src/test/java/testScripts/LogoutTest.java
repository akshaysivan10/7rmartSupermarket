package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test
	public void verifyWhetherTheUserIsAbleToLogout() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		logoutPage.clickOnTheAdminDropdown().clickOnLogout();
		boolean isLoginDisplayed = logoutPage.isLoginPageDisplayed();
		assertTrue(isLoginDisplayed, "Unable to logout from the website");
	}
}
