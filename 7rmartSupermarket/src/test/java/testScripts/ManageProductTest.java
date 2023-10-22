package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.Base;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	
	@Test
	public void verifyWhetherNewProductCanBeAdded() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(0, 1, "ManageProductPage");
		String tag = ExcelUtility.getString(1, 1, "ManageProductPage");
		String group = ExcelUtility.getString(2, 1, "ManageProductPage");
		String weightValue = ExcelUtility.getNumeric(3, 1, "ManageProductPage");
		String weightUnit = ExcelUtility.getString(4, 1, "ManageProductPage");
		String maximumQuantity = ExcelUtility.getNumeric(5, 1, "ManageProductPage");
		String price = ExcelUtility.getNumeric(6, 1, "ManageProductPage");
		String mrp = ExcelUtility.getNumeric(7, 1, "ManageProductPage");
		String availableStock = ExcelUtility.getNumeric(8, 1, "ManageProductPage");
		String purchasePrice = ExcelUtility.getNumeric(9, 1, "ManageProductPage");
		String description = ExcelUtility.getString(10, 1, "ManageProductPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageProductPage manageProductPage = new ManageProductPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageProductPage.clickOnManageProductMoreInfo().clickOnNewButton().enterTheTitleInTitleField(title)
		.clickOnTheProductType().enterTheTagInTagField(tag).selectGroupFromDropdown(group).enterTheWeightValueInWeightValueField(weightValue)
		.selectWeightUnit(weightUnit).enterTheMaximumQuantityInMaximumQuantityCanOrderField(maximumQuantity)
		.enterThePriceInPriceField(price).enterTheMRPInMRPField(mrp).enterTheStockAvailabilityInStockAvailabilityField(availableStock)
		.enterThePurchasePriceInPurchasePriceField(purchasePrice).clickOnUnlimitedStockCheckBox().enterTheDescriptionInDescriptionTextBox(description)
		.clickOnImageChooseFileToUploadImage().clickOnSubImagesChooseFileToUploadImage().clickOnYesRadioButtonInFeatured();
		boolean successfulMessage = manageProductPage.isConfirmationAlertDisplayed();
		assertTrue(successfulMessage, "Unable to add new product informations");
	}

}
