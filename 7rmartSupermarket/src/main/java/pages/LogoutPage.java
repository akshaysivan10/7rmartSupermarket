package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	public WebDriver driver;

	public LogoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[contains(@class,'dropdown')]//child::a[@class='nav-link']") private WebElement admin;
	@FindBy(xpath = "//div[contains(@class,'dropdown-menu')]//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") private WebElement logout;
	@FindBy(xpath = "//p[text()='Sign in to start your session']") private WebElement signInText;
	
	public LogoutPage clickOnTheAdminDropdown() {
		admin.click();
		return this;
	}
	
	public LogoutPage clickOnLogout() {
		logout.click();
		return this;
	}
	
	public boolean isLoginPageDisplayed() {
		return signInText.isDisplayed();
	}
}
