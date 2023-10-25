package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{

	@Test
	public void verifyWhetherNewUsersInformationCanBeAdded() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String newUsersUsername = ExcelUtility.getString(0, 1, "AdminUsersPage");
		String newUsersPassword = ExcelUtility.getString(1, 1, "AdminUsersPage");
		String userType = ExcelUtility.getString(2, 1, "AdminUsersPage");

		LoginPage loginPage = new LoginPage(driver);
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);

		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		adminUsersPage.clickOnAdminUsersMoreInfo().clickOnNewButton().enterUsernameOnAdminUsersInfoUsernameField(newUsersUsername)
		.enterPasswordOnAdminUsersInfoUsernameField(newUsersPassword).selectUserTypeFromDropdown(userType).clickOnSaveButton();
		boolean successfulMessage = adminUsersPage.confirmationMessageIsDisplyed();
		assertTrue(successfulMessage, "Unable to create new user ");
	}
}
