package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}

	public void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void doubleClickOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void contextClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void dragAndDropElement(WebElement source, WebElement target, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertAndGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public void switchToAlertAndSendKeys(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void selectDropdownUsingIndex(WebElement element, int indexNo) {
		Select select = new Select(element);
		select.selectByIndex(indexNo);
	}

	public void selectDropdownUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);	}

	public void selectDropdownUsingVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void javaScriptExecutorForClick(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

//	public void javaScriptExecutorForScroll(WebDriver driver) {
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("window.scrollBy(0, 100)", "");
//	}
//
//	public void javaScriptExecutorForSendKeys(WebDriver driver, WebElement element, String text) {
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].value='"+ text +"';", element);
//	}

	public void getAttribute(WebElement element, String text) {
		element.getAttribute(text);
	}

	public void getCssValue(WebElement element, String text) {
		element.getCssValue(text);
	}
}
