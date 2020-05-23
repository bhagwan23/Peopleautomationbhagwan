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
	private static String pageTitleText = "Deskera SSO";
	
	
	/******************************* Account PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//img[contains(@src,'/assets/images/logos/deskera-logo.svg')]")
	@CacheLookup
	private WebElement deskeralogo;
	@FindBy(xpath = "//span[contains(text(),'account details')]")
	@CacheLookup
	private WebElement accountdetails;
	@FindBy(name = "name")
	@CacheLookup
	private WebElement name;
	@FindBy(name = "password")
	@CacheLookup
	private WebElement password;
	@FindBy(xpath = "//input[@formcontrolname='companyname']")
	@CacheLookup
	private WebElement companyname;
	@FindBy(xpath = "//input[@class='wtf2-checkbox-input cdk-visually-hidden' and @type='checkbox']")
	@CacheLookup
	private WebElement checkbox;
	@FindBy(xpath = "//wtf2-label[contains(text(),'I agree to the')]")
	@CacheLookup
	private WebElement iagree;
	@FindBy(xpath = "//span[text()=' NEXT ']")
	@CacheLookup
	private WebElement next;
	
	/******************************* Personalize your account PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//span[text()='Personalize your']/following::span[text()=' account ']")
	@CacheLookup
	private WebElement personalizeaccount;
	@FindBy(xpath = "//wtf2-select[@formcontrolname='industryType']")
	@CacheLookup
	private WebElement industrytype;
	@FindBy(xpath = "//span[text()='IT Service']")
	@CacheLookup
	private WebElement ITserviceindustrytype;
	@FindBy(xpath = "//wtf2-label[contains(text(),'What is your Company Size')]")
	@CacheLookup
	private WebElement whatiscompanysize;
	@FindBy(xpath = "//wtf2-button-toggle-group[@formcontrolname='companySize']//wtf2-button-toggle[5]")
	@CacheLookup
	private WebElement companysize100;
	@FindBy(xpath = "//wtf2-label[contains(text(),'What is the main thing you want to manage using Deskera')]")
	@CacheLookup
	private WebElement mainthingusingdeskeraapp;
	@FindBy(xpath = "//span[text()='Others']")
	@CacheLookup
	private WebElement otherpurpose;
	@FindBy(xpath = "//span[text()=' NEXT ']")
	@CacheLookup
	private WebElement nextbutton;
	@FindBy(xpath = "//span[text()=' SKIP ']")
	@CacheLookup
	private WebElement skipbutton;
	
	
	/******************************* Success PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//h5[contains(text(),'Please verify your email address')]")
	@CacheLookup
	private WebElement verifyyouremail;
	@FindBy(xpath = "//div/p[contains(text(),'Still can')]")
	@CacheLookup
	private WebElement cantfindemail;
	
	@FindBy(xpath = "//span[text()=' Resend Email ']")
	@CacheLookup
	private WebElement resendemailbutton;
	
	
	
	

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

	
	/***********************************
	 * 
	 * Account Details Page  manipulation methods
	 * 
	 *********************************/
	public void verifyAccountDetailsPageElements() {
		WDWait(deskeralogo);
		deskeralogo.isDisplayed();
		WDWait(accountdetails);
		accountdetails.isDisplayed();
		name.isDisplayed();
		password.isDisplayed();
		companyname.isDisplayed();
		checkbox.isDisplayed();
		iagree.isDisplayed();	
	}
	public void enterAccountDetails(String userFirstName,String passWord,String companyName){
		name.sendKeys(userFirstName);
		password.sendKeys(passWord);
		companyname.sendKeys(companyName);
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
	public void verifyPersonalizeaccountPageElements() {
		WDWait(industrytype);
		industrytype.isDisplayed();
		whatiscompanysize.isDisplayed();
		companysize100.isDisplayed();
		mainthingusingdeskeraapp.isDisplayed();
		nextbutton.isDisplayed();
		skipbutton.isDisplayed();	
	}
	public void enterPersonalizeAccountDetails(){
		industrytype.click();
		ITserviceindustrytype.click();
		companysize100.click();
		WDWait(mainthingusingdeskeraapp);
		Actions actions = new Actions(driver);
		actions.moveToElement(mainthingusingdeskeraapp).click().perform();
		actions.moveToElement(otherpurpose).click().perform();	
	}
	public void clickNext() {
		nextbutton.click();
	}
	

	/***********************************
	 * 
	 * Success  Page  manipulation methods
	 * 
	 *********************************/
	public void verifySuccesspage(){
		WDWait(verifyyouremail);
		verifyyouremail.isDisplayed();
		cantfindemail.isDisplayed();
		resendemailbutton.isDisplayed();
	}
}

