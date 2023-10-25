package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {

	@Test
	public void verifyWhetherTheUserIsAbleToAddNewOfferCode() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String offerCode = ExcelUtility.getString(0, 1, "ManageOfferCodePage");
		String percentage = ExcelUtility.getNumeric(1, 1, "ManageOfferCodePage");
		String amount = ExcelUtility.getNumeric(2, 1, "ManageOfferCodePage");
		String description = ExcelUtility.getString(3, 1, "ManageOfferCodePage");
		LoginPage loginPage = new LoginPage(driver);
		ManageOfferCodePage manageOfferCodePage = new ManageOfferCodePage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageOfferCodePage.clickOnManageOfferCodeMoreInfo().clickOnNewButton().enterTheOfferCode(offerCode).clickOnYesRadioButton()
		.enterThePercentage(percentage).enterTheAmount(amount).enterTheDescription(description).clickOnImageChooseFileToUploadImage()
		.clickOnSaveButton();
		boolean successfulMessage = manageOfferCodePage.isConfirmationMessageDisplayed();
		assertTrue(successfulMessage, "Unable to add new offer code");
	}
}
