package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base {

	@Test
	public void verifyWhetherNewSliderCanBeAdded() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String link = ExcelUtility.getString(0, 1, "ManageSliderPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageSliderPage manageSliderPage = new ManageSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageSliderPage.clickOnManageSliderMoreInfo().clickOnNewButton().clickOnChooseFileToUploadImage()
		.enterTheLink(link).clickOnSaveButton();
		boolean isSliderAdded = manageSliderPage.isConfirmationMessageDisplayed();
		assertTrue(isSliderAdded, "Unable to add new slider");
	}
	
	@Test
	public void verifyWhetherTheAddedSliderCanBeEdited() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String link = ExcelUtility.getString(0, 1, "ManageSliderPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageSliderPage manageSliderPage = new ManageSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageSliderPage.clickOnManageSliderMoreInfo().clickOnEditButton().clickOnDeleteIcon().clickOnChooseFileToUploadImageToEditImage()
		.enterTheLink(link).clickOnUpdateButton();
		boolean isSliderUpdated = manageSliderPage.isConfirmationMessageDisplayed();
		assertTrue(isSliderUpdated, "Unable to update the slider");
	}
	
	@Test
	public void verifyWhetherTheAddedSliderCanBeDeleted() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageSliderPage manageSliderPage = new ManageSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageSliderPage.clickOnManageSliderMoreInfo().clickOnDeleteButton();
		boolean isSliderDeleted = manageSliderPage.isConfirmationMessageDisplayed();
		assertTrue(isSliderDeleted, "Unable to delete the slider");
	}
	
	@Test
	public void verifyWhetherTheAdminCanResetThePageAndNavigateToHomePage() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageSliderPage manageSliderPage = new ManageSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageSliderPage.clickOnManageSliderMoreInfo().clickOnResetButton().clickOnHomeLink();
		boolean isHomePageDisplayed = manageSliderPage.isHomePageDisplayed();
		assertTrue(isHomePageDisplayed, "Unable to navigate to home page");
	}
}
