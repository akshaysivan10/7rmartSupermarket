package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.Base;

import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base {

	@Test
	public void verifyWhetherNewSliderInformationsCanBeAdded() {
		
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String category = ExcelUtility.getString(0, 1, "MobileSliderPage");
		LoginPage loginPage = new LoginPage(driver);
		MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		mobileSliderPage.clickOnMobileSliderMoreInfo().clickOnNewButton().selectCategoryFromDropdown(category)
		.clickOnChooseFileToUploadImage().clickOnSaveButton();
		boolean successfulMessage = mobileSliderPage.isConfirmationMessageAlertDisplayed();
		assertTrue(successfulMessage, "Unable to add slider informations");
	}
}
