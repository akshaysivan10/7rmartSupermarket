package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.Base;

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
	public void verifyWhetherSliderCanBeEdited() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String editedLink = ExcelUtility.getString(1, 1, "ManageSliderPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageSliderPage manageSliderPage = new ManageSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageSliderPage.clickOnManageSliderMoreInfo().clickOnEditButton().clickOnDeleteIcon().clickOnChooseFileToUploadImage()
		.enterTheLink(editedLink).clickOnUpdateButton();
		boolean isSliderUpdated = manageSliderPage.isConfirmationMessageDisplayed();
		assertTrue(isSliderUpdated, "Unable to update the slider");
	}
}
