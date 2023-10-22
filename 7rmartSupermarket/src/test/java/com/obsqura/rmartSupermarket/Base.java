package com.obsqura.rmartSupermarket;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotUtility;

public class Base {

	public WebDriver driver;
	public ScreenShotUtility scrshot;

	@BeforeMethod
	public void initializeBrowser() {
		
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverClose(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE)
		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
