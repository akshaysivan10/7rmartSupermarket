package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;

public class Base {

	public WebDriver driver;
	public ScreenShotUtility scrshot;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} 
		else {
			throw new Exception("Browser is not correct");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverClose(ITestResult iTestResult) throws IOException {
		
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
