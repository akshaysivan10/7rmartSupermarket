package com.obsqura.rmartSupermarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Eclipse\\7rmartSupermarket\\src\\main\\java\\com\\obsqura\\rmartSupermarket\\Resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void driverClose() {
		
		driver.quit();
	}

}
