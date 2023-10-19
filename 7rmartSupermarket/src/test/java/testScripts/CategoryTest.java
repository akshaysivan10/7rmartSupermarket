package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.Base;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base{

	@Test
	public void verifyWhetherNewCategoryInformationsCanBeAdded() {
		
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String category = ExcelUtility.getString(0, 1, "CategoryPage");
		
		LoginPage loginPage = new LoginPage(driver);
		CategoryPage categoryPage = new CategoryPage(driver);
		
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		categoryPage.clickOnCategoryMoreInfo().clickOnNewButton().enterCategoryOnCategoryField(category).clickOnDiscountInSelectGroups()
		.clickOnChooseFileToUploadImage().clickOnSaveButton();
		boolean successfulMessage = categoryPage.isConfirmationMessageAlertDisplayed();
		assertTrue(successfulMessage, "Unable to add new category informations");
	}
}
