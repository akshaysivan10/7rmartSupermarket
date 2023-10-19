package com.obsqura.rmartSupermarket;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import utilities.ScreenShotUtility;

public class Base {
	
	public WebDriver driver;
	public ScreenShotUtility scrshot;

	@BeforeMethod
	public void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Eclipse\\7rmartSupermarket\\src\\main\\java\\com\\obsqura\\rmartSupermarket\\Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverClose(TestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE)
		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
