package deskera.web.automation.pages;

import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	/******************************* PAGE ELEMENTS LOCATORS *******************/
	@FindBy(name = "email")
	@CacheLookup
	private WebElement userSignupEmail;
	@FindBy(id = "phone")
	@CacheLookup
	private WebElement userSignupPhone;
	@FindBy(xpath = "//span[contains(text(),'CREATE ACCOUNT')]")
	@CacheLookup
	private WebElement createAccountButton;
	@FindBy(xpath = "//div[@class='col-4 country-flag-col']")
	@CacheLookup
	private WebElement countryCodeSelector;
	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button//div[contains(text(),'United States +1')]")
	@CacheLookup
	private WebElement USCode;
	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button//div[contains(text(),'Singapore +65')]")
	@CacheLookup
	private WebElement SGCode;
	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button//div[contains(text(),'India') and contains(text(),'+91')]")
	@CacheLookup
	private WebElement INCode;
	@FindBy(xpath = "//span[contains(text(),'Are you a bookkeeper?')]/../span[contains(text(),'Sign up for Deskera Bookkeeper')]")
	@CacheLookup
	private WebElement bookkeeperLink;
	@FindBy(xpath = "//span[contains(text(),'Already have an account ?')]/../span[contains(text(),'Sign in')]")
	@CacheLookup
	private WebElement alreadyHaveAccount;
	private static String pageTitleText = "Deskera SSO";

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	public void openURL(String URL) {
		driver.get(URL);
	}

	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	public void verifySignUpPageElements() {
		WDWait(userSignupEmail);
		userSignupEmail.isDisplayed();
		userSignupPhone.isDisplayed();
		alreadyHaveAccount.isDisplayed();
		createAccountButton.isDisplayed();
		countryCodeSelector.isDisplayed();
		bookkeeperLink.isDisplayed();
	}

	public void clickCreateACcountButton() {
		createAccountButton.click();
	}

	public void enterEmailandPhone(String email, String countryCode, String phoneNumber) {
		WDWait(userSignupEmail);
		userSignupEmail.sendKeys(email);
		WDWait(userSignupPhone);
		countryCodeSelector.click();
		// Country specific selector
		if (countryCode.equalsIgnoreCase("US")) {
			WDWait(USCode);
			USCode.click();
			userSignupPhone.sendKeys(phoneNumber);
		}
		if (countryCode.equalsIgnoreCase("IN")) {
			WDWait(INCode);
			INCode.click();
			userSignupPhone.sendKeys(phoneNumber);
		}
		if (countryCode.equalsIgnoreCase("SG")) {
			WDWait(SGCode);
			SGCode.click();
			userSignupPhone.sendKeys(phoneNumber);
		}
	}
}
