package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.Base;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {

	@Test
	public void verifyWhetherNewLocationCanBeAdded() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String country = ExcelUtility.getString(0, 1, "ManageLocationPage");
		String state = ExcelUtility.getNumeric(1, 1, "ManageLocationPage");
		String location = ExcelUtility.getString(2, 1, "ManageLocationPage");
		String deliveryCharge = ExcelUtility.getNumeric(3, 1, "ManageLocationPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageLocationPage manageLocationPage = new ManageLocationPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageLocationPage.clickOnManageLocationMoreInfo().clickOnNewButton().selectCountryFromDropdown(country)
		.selectStateFromDropdown(state).enterTheLocation(location).enterTheDeliveryCharge(deliveryCharge)
		.clickOnSaveButton();
		boolean successfulMessage = manageLocationPage.isConfirmationMessageDisplayed();
		assertTrue(successfulMessage, "Unable to add new location");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToSearchTheNewlyAddedLocation() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String country = ExcelUtility.getString(0, 1, "ManageLocationPage");
		String state = ExcelUtility.getNumeric(1, 1, "ManageLocationPage");
		String location = ExcelUtility.getString(2, 1, "ManageLocationPage");
		LoginPage loginPage = new LoginPage(driver);
		ManageLocationPage manageLocationPage = new ManageLocationPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		manageLocationPage.clickOnManageLocationMoreInfo().clickOnSearchButton().selectCountryFromDropdown(country)
		.selectStateFromDropdown(state).enterTheLocation(location).clickOnSearchLocationButton();
		boolean isLocationListed = manageLocationPage.isLocationListedInTheTable().contains(location);
		assertTrue(isLocationListed, location + " is not available in the table");
	}
}