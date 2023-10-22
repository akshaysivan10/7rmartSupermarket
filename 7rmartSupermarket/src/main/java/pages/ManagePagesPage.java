package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePagesPage {

	public WebDriver driver;

	public ManagePagesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Pages']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") private WebElement managePagesMoreInfo;
	@FindBy(xpath = "//a[@href='javascript:void(0)']") private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']") private WebElement titleField;
	@FindBy(xpath = "//button[@name='Search']") private WebElement productSearchButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-hover')]//tr//td[1]")) private List<WebElement> listOfProducts;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']") private WebElement resultNotFound;

	public ManagePagesPage clickOnTheManagePagesTile() {
		managePagesMoreInfo.click();
		return this;
	}

	public ManagePagesPage clickOnTheSearchButton() {
		searchButton.click();
		return this;
	}

	public ManagePagesPage enterProductName(String productName) {
		titleField.sendKeys(productName);
		return this;
	}

	public ManagePagesPage clickOnTheProductSearchButton() {
		productSearchButton.click();
		return this;
	}

	public List<String> isProductListedInTheTable() {
		List<String> productList = new ArrayList<>();
		for(WebElement productsAvailable: listOfProducts) {
			String productText = productsAvailable.getText();
			productList.add(productText);
		}
		return productList;
	}

	public boolean isResultNotfoundDisplayed() {
		return resultNotFound.isDisplayed();
	}
}
