package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {

	@Test
	public void verifyWhetherNewDeliveryBoyInformationsCanBeAdded() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String name = ExcelUtility.getString(0, 1, "ManageDeliveryBoyPage");
		String email = ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
		String mobileNumber = ExcelUtility.getNumeric(2, 1, "ManageDeliveryBoyPage");
		String address = ExcelUtility.getString(3, 1, "ManageDeliveryBoyPage");
		String newUsername = ExcelUtility.getString(4, 1, "ManageDeliveryBoyPage");
		String newPassword = ExcelUtility.getString(5, 1, "ManageDeliveryBoyPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageDeliveryBoyPage manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageDeliveryBoyPage.clickOnManageDeliveryBoyMoreInfo().clickOnNewButton().enterTheName(name)
		.enterTheEmail(email).enterTheMobileNumber(mobileNumber).enterTheAddress(address).enterTheUsername(newUsername)
		.enterThePassword(newPassword).clickOnSaveButton();
		boolean isNewDeliveryBoyAdded = manageDeliveryBoyPage.isConfirmationMessageDisplayed();
		assertTrue(isNewDeliveryBoyAdded, "Unable to add new delivery boy");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToSearchDeliveryBoy() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String name = ExcelUtility.getString(0, 1, "ManageDeliveryBoyPage");
		String email = ExcelUtility.getString(1, 1, "ManageDeliveryBoyPage");
		String newUsername = ExcelUtility.getString(4, 1, "ManageDeliveryBoyPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageDeliveryBoyPage manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageDeliveryBoyPage.clickOnManageDeliveryBoyMoreInfo().clickOnSearchButton().enterTheSearchName(name)
		.enterTheSearchEmail(email).clickOnSearchButtonInsideSearchList();
		boolean isDeliveryBoyAvailable = manageDeliveryBoyPage.isDeliveryBoyListedInTheTable().contains(newUsername);
		assertTrue(isDeliveryBoyAvailable, newUsername + " is not available");
	}
}
