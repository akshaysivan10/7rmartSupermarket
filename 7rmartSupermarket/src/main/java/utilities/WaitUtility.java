package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 20;
	public static final long FLUENT_WAIT = 20;
	public static final long POLLING_TIME = 5;

	public void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}

	public void waitForAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementSelectionState (WebDriver driver, WebElement target, boolean value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementSelectionStateToBe(target, value));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}

	public void waitForElementToBeSelected(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(target));
	}

	public void waitForFrameToBeAvailable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(target));
	}

	public void waitForInvisibilityOfElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(target));
	}

	public void waitForInvisibilityOfElementWithText(WebDriver driver, By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}

	public void waitForPresenceOfAllElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void waitForPresenceOfElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForTextToBePresentInElement(WebDriver driver, WebElement target, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, text));
	}

	public void waitForTextToBePresentInElementLocated(WebDriver driver, By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public void waitForTextToBePresentInElementValue(WebDriver driver, WebElement target, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementValue(target, text));
	}

	public void waitForTitle(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleIs(text));
	}

	public void waitForTitleContains(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleContains(text));
	}

	public void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForVisibilityOfAllElementsLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void waitForVisibilityOfElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementFluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAlertFluentWait(WebDriver driver) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForElementSelectionStateFluentWait(WebDriver driver, WebElement element, boolean value) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementSelectionStateToBe(element, value));
	}
	
	public void waitForElementToBeClickableFluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeSelectedFluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitForFrameToBeAvailableFluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public void waitForInvisibilityOfElementFluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForInvisibilityOfElementWithTextFluentWait(WebDriver driver, By locator, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}
	
	public void waitForPresenceOfAllElementFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitForPresenceOfElementFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForTextToBePresentInElementFluentWait(WebDriver driver, WebElement element, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitForTextToBePresentInElementLocatedFluentWait(WebDriver driver, By locator, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	
	public void waitForTextToBePresentInElementValueFluentWait(WebDriver driver, WebElement element, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
	
	public void waitForTitleFluentWait(WebDriver driver, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleIs(text));
	}
	
	public void waitForTitleContainsFluentWait(WebDriver driver, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleContains(text));
	}
	
	public void waitForVisibilityOfAllElementsFluentWait(WebDriver driver, List<WebElement> element, String text) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public void waitForVisibilityOfAllElementsLocatedFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void waitForVisibilityOfElementLocatedFluentWait(WebDriver driver, By locator) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
				  .pollingEvery(Duration.ofSeconds(POLLING_TIME))
				  .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
