package com.obsqura.rmartSupermarket;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login extends Base {

	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithValidCredentials() {
		
		String validUsername = "admin";
		String validPassword = "admin";
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		usernameField.sendKeys(validUsername);
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys(validPassword);
		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signinButton.click();
		WebElement managePages = driver.findElement(By.xpath("//div[contains(@class,'small-box')]//child::p[text()='Manage Pages']"));
		boolean managePagesDisplayed = managePages.isDisplayed();
		assertTrue(managePagesDisplayed, "User is unable to login with valid credentials");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithInvalidCredentials() {
		
		String invalidUsername = "Akshay";
		String invalidPassword = "Akshay";
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		usernameField.sendKeys(invalidUsername);
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys(invalidPassword);
		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signinButton.click();
		WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]//child::h5[text()=' Alert!']"));
		boolean alertMessageDisplayed = alertMessage.isDisplayed();
		assertTrue(alertMessageDisplayed,"User is able to login with invalid credentials");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithValidUserNameAndInvalidPassword() {
		
		String validUsername = "admin";
		String invalidPassword = "akshay";
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		usernameField.sendKeys(validUsername);
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys(invalidPassword);
		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signinButton.click();
		WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]//child::h5[text()=' Alert!']"));
		boolean alertMessageDisplayed = alertMessage.isDisplayed();
		assertTrue(alertMessageDisplayed,"User is able to login with valid username and invalid password");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithInvalidUserNameAndValidPassword() {
		
		String invalidUsername = "akshay";
		String validPassword = "admin";
		
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		usernameField.sendKeys(invalidUsername);
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordField.sendKeys(validPassword);
		WebElement signinButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signinButton.click();
		WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]//child::h5[text()=' Alert!']"));
		boolean alertMessageDisplayed = alertMessage.isDisplayed();
		assertTrue(alertMessageDisplayed,"User is able to login with invalid username and valid password");
	}
}
