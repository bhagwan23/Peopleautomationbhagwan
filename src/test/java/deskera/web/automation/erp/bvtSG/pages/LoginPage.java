package deskera.web.automation.erp.bvtSG.pages;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LoginPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* LOGIN PAGE ELEMENTS LOCATORS *******************/


	@FindBy(xpath = "//span[contains(text(),'Deskera Books')]")
	@CacheLookup
	private WebElement goToDeskeraBooksCard;


	@FindBy(xpath = "//*[@id='wtf2-input-2']") 
	@CacheLookup
	private WebElement userLoginEmail;
	@FindBy(xpath = "//*[@id='wtf2-input-3']")
	@CacheLookup
	private WebElement userLoginPassword;
	@FindBy(xpath = "//wtf2-icon[contains(.,'visibility_off')]")
	@CacheLookup
	private WebElement eyeIcon;
	@FindBy(xpath = "(//span[contains(.,'Remember me')])[1]")
	@CacheLookup
	private WebElement rememberMe;
	@FindBy(xpath = "//span[contains(.,'Forgot Password')]")
	@CacheLookup
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "(//span[contains(.,'SIGN IN')])[2]")
	@CacheLookup
	private WebElement signInButton;
	@FindBy(xpath = "(//span[contains(.,'Sign in using Google')])[1]")
	@CacheLookup
	private WebElement signInUsingGoogle;

	@FindBy(xpath = "(//span[contains(.,'SIGN UP Now')])[2]")
	@CacheLookup
	private WebElement signUpNowLink;
	@FindBy(xpath = "//h6[@class='m-0 p-0 font-weight-500']")
	@CacheLookup
	private WebElement dashboardHeading;
	private static String pageTitleText = "Deskera SSO";

	/******************************* Sign Using Google PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//input[@aria-label='Email or phone']")
	@CacheLookup
	private WebElement googleEmailOrPhone;
	@FindBy(xpath = "//span[@class='CwaK9']/span[contains(text(),'Next')]")
	@CacheLookup
	private WebElement nextButton;
	@FindBy(xpath = "//input[contains(@autocomplete,'current-password')]")
	@CacheLookup
	private WebElement googlePassword;
	@FindBy(xpath = "//span[@class='CwaK9']/span[contains(text(),'Next')]")
	@CacheLookup
	private WebElement PasswordNextButton;



	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}

	@Step("Verify Page Title")
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("Verify Login Page Elements")
	public void verifyLoginPageElements() {
		WDWait(userLoginEmail);
		userLoginEmail.isDisplayed();
		userLoginPassword.isDisplayed();
		eyeIcon.isDisplayed();
		rememberMe.isDisplayed();
		forgotPasswordLink.isDisplayed();
		signInButton.isDisplayed();
		signInUsingGoogle.isDisplayed();
		WDWait(signUpNowLink);
		signUpNowLink.isDisplayed();
	}

	@Step("Enter Email and Password")
	public void enterEmailandPassword(String email, String password) {
		WDWait(userLoginEmail);
		userLoginEmail.sendKeys(email);
		userLoginPassword.click();
		userLoginPassword.sendKeys(password);
	}

	@Step("Click Sign In")
	public void clickSignIn() {
		WDWait(signInButton);
		signInButton.click();
		goToDeskeraBooks();
		//WDWait(dashboardHeading);
		//dashboardHeading.isDisplayed();
	}



	@Step("Go to Deskera books from GO")
	public void goToDeskeraBooks()

	{
		WDWait(goToDeskeraBooksCard);
		goToDeskeraBooksCard.click();

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
	}

	@Step("ClickS On ignIn Using Google")
	public void clickSignInUsingGoogle() {
		signInUsingGoogle.click();
	}

	@Step("Enter Google Email Password")
	public void enterGoogleEmailPassword(String email ,String password) {
		googleEmailOrPhone.sendKeys(email);
		nextButton.click();
		googlePassword.sendKeys(password);
		PasswordNextButton.click();	
	}

}


