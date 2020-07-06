package deskera.web.automation.erp.bvtSG.pages;

import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignUpPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}

	/******************************* PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//div[1]/button[1]/span[1]/span[contains(text(),'SIGN UP Now')]")
	@CacheLookup
	private WebElement SignUpNow;
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
	@FindBy(xpath = "//span[contains(text(),'Are you a book-keeper?')]/../span[contains(text(),'Sign up for Deskera Book-keeper')]")
	@CacheLookup
	private WebElement bookkeeperLink;
	@FindBy(xpath = "//span[contains(text(),'Already have an account ?')]/../span[contains(text(),'SIGN IN')]")
	@CacheLookup
	private WebElement alreadyHaveAccount;
	@FindBy(xpath = "//span[contains(text(),'Already have an account ?')]/../span[contains(text(),'SIGN IN')]")
	@CacheLookup
	private WebElement signUpForBookkeeper;
	@FindBy(xpath = "//span[contains(text(),'Not a bookkeeper?')]/../span[contains(text(),'Sign up for regular account')]")
	@CacheLookup
	private WebElement regularAccountLink;
	private static String pageTitleText = "Deskera SSO";
	/*******************************
	 * Account PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//img[contains(@src,'/assets/images/logos/deskera-logo.svg')]")
	@CacheLookup
	private WebElement deskeraLogo;
	@FindBy(xpath = "//span[contains(text(),'account details')]")
	@CacheLookup
	private WebElement accountDetails;
	@FindBy(name = "name")
	@CacheLookup
	private WebElement name;
	@FindBy(name = "password")
	@CacheLookup
	private WebElement password;
	@FindBy(xpath = "//wtf2-icon[contains(.,'visibility_off')]")
	@CacheLookup
	private WebElement eyeIcon;
	@FindBy(xpath = "//input[@formcontrolname='companyname']")
	@CacheLookup
	private WebElement companyName;
	@FindBy(xpath = "//wtf2-checkbox[@id='wtf2-checkbox-3']/label/div")
	@CacheLookup
	private WebElement checkbox;
	@FindBy(xpath = "//wtf2-label[contains(text(),'I agree to the')]")
	@CacheLookup
	private WebElement iAgreeTheTerms;
	@FindBy(xpath = "//span[text()=' NEXT ']")
	@CacheLookup
	private WebElement next;
	/*******************************
	 * Personalize your account PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//span[text()='Personalize your']//following::span[text()=' account ']")
	@CacheLookup
	private WebElement personalizeAccount;
	@FindBy(xpath = "//wtf2-select[@formcontrolname='industryType']")
	@CacheLookup
	private WebElement industryType;
	@FindBy(xpath = "//span[text()='IT Service']")
	@CacheLookup
	private WebElement ITserviceIndustryType;
	@FindBy(xpath = "//wtf2-label[contains(text(),'What is your Company Size')]")
	@CacheLookup
	private WebElement whatIsCompanySize;
	@FindBy(xpath = "//wtf2-button-toggle-group[@formcontrolname='companySize']//wtf2-button-toggle[5]")
	@CacheLookup
	private WebElement companySize100;
	@FindBy(xpath = "//wtf2-label[contains(text(),'What is the main thing you want to manage using Deskera')]")
	@CacheLookup
	private WebElement mainThingUsingDeskeraApp;
	@FindBy(xpath = "//span[text()='Others']")
	@CacheLookup
	private WebElement otherPurpose;
	@FindBy(xpath = "//span[text()=' NEXT ']")
	@CacheLookup
	private WebElement nextButton;
	@FindBy(xpath = "//span[text()=' SKIP ']")
	@CacheLookup
	private WebElement skipButton;
	/*******************************
	 * Success PAGE ELEMENTS LOCATORS
	 *******************/
	@FindBy(xpath = "//h5[contains(text(),'Please verify your email address')]")
	@CacheLookup
	private WebElement verifyYourEmailAddress;
	@FindBy(xpath = "//p[contains(.,', thanks for signing up. We have sent an email to ')]")
	@CacheLookup
	private WebElement thanksForSigningUp;
	@FindBy(xpath = "//p[@class='p1']/a")
	@CacheLookup
	private WebElement weHaveSentEmailTo;
	@FindBy(xpath = "(//p[contains(@class,'p1')])[3]")
	@CacheLookup
	private WebElement justClickOnTheLink;
	@FindBy(xpath = "//div/p[contains(text(),'Still can')]")
	@CacheLookup
	private WebElement cantFindEmail;
	@FindBy(xpath = "//span[text()=' Resend Email ']")
	@CacheLookup
	private WebElement resendEmailButton;
	@FindBy(xpath = "(//p[contains(@class,'p1')])[1]")
	@CacheLookup
	private WebElement weHaveResentVerification;

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
	public void verifyPageTitle() {
		sAssert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("Verify Sign Up Page Elements")
	public void verifySignUpPageElements() {
		WDWait(SignUpNow);
		wait.until(ExpectedConditions.elementToBeClickable(SignUpNow));
		SignUpNow.click();
		WDWait(userSignupEmail);
		userSignupEmail.isDisplayed();
		userSignupPhone.isDisplayed();
		WDWait(alreadyHaveAccount);
		alreadyHaveAccount.isDisplayed();
		WDWait(createAccountButton);
		createAccountButton.isDisplayed();
		WDWait(countryCodeSelector);
		countryCodeSelector.isDisplayed();
		WDWait(bookkeeperLink);
		bookkeeperLink.isDisplayed();
	}

	@Step("Click on SignUp for Bookkeper ")
	public void clickSignUpForBookkeeper() {
		WDWait(bookkeeperLink);
		bookkeeperLink.click();
	}

	@Step("Verify Bookkeeper SignUp Page Elements ")
	public void verifyBookkeeperSignUpPageElements() {
		WDWait(signUpForBookkeeper);
		signUpForBookkeeper.isDisplayed();
		userSignupEmail.isDisplayed();
		userSignupPhone.isDisplayed();
		alreadyHaveAccount.isDisplayed();
		createAccountButton.isDisplayed();
		countryCodeSelector.isDisplayed();
		regularAccountLink.isDisplayed();
	}

	@Step("Click on Create Account Button")
	public void clickCreateACcountButton() {
		WDWait(createAccountButton);
		createAccountButton.click();
	}

	@Step("Enter Email and Phone Number")
	public void enterEmailandPhone(String email, String countryCode, String phoneNumber) {
		WDWait(userSignupEmail);
		// userSignupEmail.sendKeys(email);
		// DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		// Date dateobj = new Date();
		userSignupEmail.sendKeys(email);
		WDWait(userSignupPhone);
		countryCodeSelector.click();
		// Country specific selector
		if (countryCode.equalsIgnoreCase("SG")) {
			WDWait(SGCode);
			SGCode.click();
			Random rand = new Random();
			String id = String.format("%04d", rand.nextInt(10000));
			userSignupPhone.sendKeys("9988" + id);
		}
		if (countryCode.equalsIgnoreCase("US")) {
			WDWait(USCode);
			USCode.click();
			userSignupPhone.sendKeys(phoneNumber);
		}
		if (countryCode.equalsIgnoreCase("IN")) {
			WDWait(INCode);
			INCode.click();
			// userSignupPhone.sendKeys(phoneNumber);
			Random rand = new Random();
			String id = String.format("%04d", rand.nextInt(10000));
			userSignupPhone.sendKeys("998866" + id);
		}
	}

	@Step("Enter Email")
	public void enterEmailId(String email) {
		WDWait(userSignupEmail);
		userSignupEmail.sendKeys(email);
	}

	/***********************************
	 * 
	 * Account Details Page manipulation methods
	 * 
	 *********************************/
	@Step("Verify Account Details Page Elements")
	public void verifyAccountDetailsPageElements() {
		WDWait(deskeraLogo);
		deskeraLogo.isDisplayed();
		WDWait(accountDetails);
		accountDetails.isDisplayed();
		name.isDisplayed();
		password.isDisplayed();
		eyeIcon.isDisplayed();
		companyName.isDisplayed();
		checkbox.isDisplayed();
		iAgreeTheTerms.isDisplayed();
		next.isDisplayed();
	}

	@Step("Enter Account Details")
	public void enterAccountDetails(String userFirstName, String passWord, String companyname) {
		name.sendKeys(userFirstName);
		password.sendKeys(passWord);
		companyName.sendKeys(companyname);
		if (!checkbox.isSelected()) {
			WDWait(checkbox);
			checkbox.click();
		}
	}

	@Step("Click on Next Button")
	public void clickNextButton() {
		next.click();
	}

	/***********************************
	 * 
	 * Personalize your account Page manipulation methods
	 * 
	 *********************************/
	@Step("Verify Personalize Account Page Elements")
	public void verifyPersonalizeAccountPageElements() {
		WDWait(personalizeAccount);
		personalizeAccount.isDisplayed();
		WDWait(industryType);
		industryType.isDisplayed();
		whatIsCompanySize.isDisplayed();
		companySize100.isDisplayed();
		mainThingUsingDeskeraApp.isDisplayed();
		nextButton.isDisplayed();
		skipButton.isDisplayed();
	}

	@Step("Enter Personalize Account Details")
	public void enterPersonalizeAccountDetails() {
		WDWait(industryType);
		industryType.click();
		ITserviceIndustryType.click();
		companySize100.click();
		WDWait(mainThingUsingDeskeraApp);
		Actions actions = new Actions(driver);
		actions.moveToElement(mainThingUsingDeskeraApp).click().perform();
		actions.moveToElement(otherPurpose).click().perform();
	}

	@Step("Click on Next Button")
	public void clickNext() throws InterruptedException {
		// wait.until(ExpectedConditions.visibilityOf(nextButton));
		/*
		 * Actions action = new Actions(driver); action.moveToElement(nextButton);
		 */
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		nextButton.click();
	}

	/***********************************
	 * 
	 * Success Page manipulation methods
	 * 
	 *********************************/
	@Step("Verify Success Page Elements")
	public void verifySuccessPageElements(String email) {
		WDWait(verifyYourEmailAddress);
		verifyYourEmailAddress.isDisplayed();
		thanksForSigningUp.isDisplayed();
		sAssert.assertEquals(weHaveSentEmailTo.getText(), email);
		justClickOnTheLink.isDisplayed();
		cantFindEmail.isDisplayed();
		resendEmailButton.isDisplayed();
	}

	@Step("Click Resent Email Button")
	public void clickResentEmailButton() {
		resendEmailButton.click();
	}

	@Step("Verify Page Elements After Resent Email")
	public void verifyPageElementsAfterResentEmail(String email) {
		WDWait(verifyYourEmailAddress);
		verifyYourEmailAddress.isDisplayed();
		weHaveResentVerification.isDisplayed();
		sAssert.assertEquals(weHaveSentEmailTo.getText(), email);
		WDWait(justClickOnTheLink);
		justClickOnTheLink.isDisplayed();
		cantFindEmail.isDisplayed();
		resendEmailButton.isDisplayed();
	}

	@Step("Zoom Out")
	public void zoomOut() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '0.90'");
		Thread.sleep(3000);
	}
}
