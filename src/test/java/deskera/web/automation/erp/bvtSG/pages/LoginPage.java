package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.asynchttpclient.netty.request.body.NettyCompositeByteArrayBody;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	@FindBy(xpath = "(/html/body/app-root/microframework-signin/div[1]/div/div/div[1]/div/form/button[1]/span)")
	@CacheLookup
	private WebElement signInButton;
	@FindBy(xpath = "(//span[contains(.,'Sign in using Google')])[1]")
	@CacheLookup
	private WebElement signInUsingGoogle;
	@FindBy(xpath = "(//span[contains(.,'Sign in using Facebook')])[1]")
	@CacheLookup
	private WebElement signInUsingFacebook;
	@FindBy(xpath = "(//span[contains(.,'have an account ? ')]/../span[contains(text(),'Sign Up Now')])[2]")
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
	
	public void verifyLoginPageElements() {
		WDWait(userLoginEmail);
		userLoginEmail.isDisplayed();
		userLoginPassword.isDisplayed();
		eyeIcon.isDisplayed();
		rememberMe.isDisplayed();
		forgotPasswordLink.isDisplayed();
		signInButton.isDisplayed();
		signInUsingGoogle.isDisplayed();
		signInUsingFacebook.isDisplayed();
		signUpNowLink.isDisplayed();
	}
	
	public void enterEmailandPassword(String email, String password) {
		WDWait(userLoginEmail);
		userLoginEmail.sendKeys(email);
		userLoginPassword.click();
		userLoginPassword.sendKeys(password);
	}
	
	public void clickSignIn() {
		WDWait(signInButton);
		signInButton.click();
		WDWait(dashboardHeading);
		dashboardHeading.isDisplayed();
	}
	
	public void clickSignInUsingGoogle() {
		signInUsingGoogle.click();
	}
	
	public void enterGoogleEmailPassword(String email ,String password) {
		googleEmailOrPhone.sendKeys(email);
		nextButton.click();
		googlePassword.sendKeys(password);
		PasswordNextButton.click();	
	}
	
	}
	

