package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSupermarket.Base;

import pages.ManagePagesPage;
import utilities.ExcelUtility;
import pages.LoginPage;

public class ManagePagesTest extends Base {

	@Test
	public void verifyWhetherTheUserIsAbleToSearchValidProducts() {
		
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String validProductName = ExcelUtility.getString(1, 0, "ManagePagesPage");
		
		LoginPage loginPage = new LoginPage(driver);
		ManagePagesPage managePagesPage = new ManagePagesPage(driver);
		
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		managePagesPage.clickOnTheManagePagesTile().clickOnTheSearchButton().enterProductName(validProductName).clickOnTheProductSearchButton();
		
		boolean product = managePagesPage.isProductListedInTheTable().contains(validProductName);
		assertTrue(product, validProductName + " is not available");	
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToSearchInvalidProducts() {
		
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String invalidProductName = ExcelUtility.getString(1, 1, "ManagePagesPage");
		
		LoginPage loginPage = new LoginPage(driver);
		ManagePagesPage managePagesPage = new ManagePagesPage(driver);
		
		loginPage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnTheSigninButton();
		managePagesPage.clickOnTheManagePagesTile().clickOnTheSearchButton().enterProductName(invalidProductName).clickOnTheProductSearchButton();
		boolean isResultNotFoundDisplayedInTheTable = managePagesPage.isResultNotfoundDisplayed();
		assertTrue(isResultNotFoundDisplayedInTheTable, invalidProductName + " is available");
	}
}
