package deskera.web.automation.pages;

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



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	@FindBy(xpath = "//span[contains(text(),'Sign up')]/../span[contains(text(),' for Deskera')]")
	@CacheLookup
	private WebElement signUpForBookkeeper;
	@FindBy(xpath = "//span[contains(text(),'Not a bookkeeper?')]/../span[contains(text(),'Sign up for regular account')]")
	@CacheLookup
	private WebElement regularAccountLink;
	private static String pageTitleText = "Deskera SSO";
	private static String enteredSignUpEmail="";
	
	
	/******************************* Account PAGE ELEMENTS LOCATORS *******************/
	
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
	@FindBy(xpath = "//input[@class='wtf2-checkbox-input cdk-visually-hidden' and @type='checkbox']")
	@CacheLookup
	private WebElement checkbox;
	@FindBy(xpath = "//wtf2-label[contains(text(),'I agree to the')]")
	@CacheLookup
	private WebElement iAgreeTheTerms;
	@FindBy(xpath = "//span[text()=' NEXT ']")
	@CacheLookup
	private WebElement next;
	
	/******************************* Personalize your account PAGE ELEMENTS LOCATORS *******************/
	
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
	
	
	/******************************* Success PAGE ELEMENTS LOCATORS *******************/
	
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

	public void clickSignUpForBookkeeper() {
		bookkeeperLink.click();
	}
	
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
	
	public void clickCreateACcountButton() {
		createAccountButton.click();
	}

	public void enterEmailandPhone(String email, String countryCode, String phoneNumber) {
		WDWait(userSignupEmail);
		//userSignupEmail.sendKeys(email);
		//DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		//Date dateobj = new Date();
		userSignupEmail.sendKeys(email);
		enteredSignUpEmail=userSignupEmail.getAttribute("value");
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
			//userSignupPhone.sendKeys(phoneNumber);
			Random rand = new Random();
			String id = String.format("%04d", rand.nextInt(10000));
			userSignupPhone.sendKeys("998866"+id);
		}
		if (countryCode.equalsIgnoreCase("SG")) {
			WDWait(SGCode);
			SGCode.click();
			userSignupPhone.sendKeys(phoneNumber);
		}
	}
	public void enterEmailId() {
		WDWait(userSignupEmail);
		// Insert  Date and time in email address 
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		userSignupEmail.sendKeys("testauto_"+df.format(dateobj)+"@test.com");
		enteredSignUpEmail=userSignupEmail.getAttribute("value");
		}

	
	/***********************************
	 * 
	 * Account Details Page  manipulation methods
	 * 
	 *********************************/
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
	
	public void enterAccountDetails(String userFirstName,String passWord,String companyname){
		name.sendKeys(userFirstName);
		password.sendKeys(passWord);
		companyName.sendKeys(companyname);
		Actions actions = new Actions(driver);
		actions.moveToElement(checkbox).click().perform();
	}
	
	public void clickNextButton() {
		next.click();
	}
	
	/***********************************
	 * 
	 * Personalize your account Page  manipulation methods
	 * 
	 *********************************/
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
	
	public void enterPersonalizeAccountDetails(){
		industryType.click();
		ITserviceIndustryType.click();
		companySize100.click();
		WDWait(mainThingUsingDeskeraApp);
		Actions actions = new Actions(driver);
		actions.moveToElement(mainThingUsingDeskeraApp).click().perform();
		actions.moveToElement(otherPurpose).click().perform();	
	}
	
	public void clickNext() {
		nextButton.click();
	}
	

	/***********************************
	 * 
	 * Success  Page  manipulation methods
	 * 
	 *********************************/
	public void verifySuccessPageElements(String email){
		WDWait(verifyYourEmailAddress);
		verifyYourEmailAddress.isDisplayed();
		thanksForSigningUp.isDisplayed();
		Assert.assertEquals(weHaveSentEmailTo.getText(), email);
		justClickOnTheLink.isDisplayed();
		cantFindEmail.isDisplayed();
		resendEmailButton.isDisplayed();
	}
	
	public void clickResentEmailButton(){
		resendEmailButton.click();
	}
	
	public void verifyPageElementsAfterResentEmail(){
		WDWait(verifyYourEmailAddress);
		verifyYourEmailAddress.isDisplayed();
		weHaveResentVerification.isDisplayed();
		Assert.assertEquals(weHaveSentEmailTo.getText(), enteredSignUpEmail);
		justClickOnTheLink.isDisplayed();
		cantFindEmail.isDisplayed();
		resendEmailButton.isDisplayed();
	}
	
}

