package deskera.web.automation.go.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BillingPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BillingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Billing  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//img[@class='logo img-circle ng-star-inserted']")
	
	private WebElement companyLogo;
	@FindBy(xpath = "//div[@class='ellipsis company-name']")
	
	private WebElement companyName;
	@FindBy(xpath = "//wtf2-icon[contains(.,'keyboard_arrow_down')]")
	
	private WebElement companyNameArrow;
	@FindBy(xpath = "//span[contains(.,'My Account')]")
	
	private WebElement myAccountTab;
	@FindBy(xpath = "//span[contains(.,'Company Details')]")
	
	private WebElement companyDetailsTab;
	@FindBy(xpath = "//span[contains(.,'Billing')]")
	
	private WebElement billingTab;
	@FindBy(xpath = "//span[contains(.,'User Management')]")
	
	private WebElement userManagementTab;
	@FindBy(xpath = "//wtf2-icon[contains(@wtf2tooltip,'Collapse')]")
	
	private WebElement collapseIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'home')])[2]")
	
	private WebElement homeIcon_BillingPage;
	@FindBy(xpath = "//h6[contains(.,'Billing')]")
	
	private WebElement billingText;
	@FindBy(xpath = "//div[@class='product-avatar-wrap']//following::div[contains(text(),'Deskera Books')]")
	
	private WebElement deskeraBooksText;
	@FindBy(xpath = "//div[@class='product-avatar-wrap']//following::div[contains(text(),'Deskera Sales')]")
	
	private WebElement deskeraSalesText;
	@FindBy(xpath = "//div[@class='text-muted d-flex align-items-center']")
	
	private WebElement currentPlanName;
	@FindBy(xpath = "//div[contains(.,'01')]/following::div[contains(.,'Free User')]")
	
	private WebElement oneFreeUserText;
	@FindBy(xpath = "(//div[contains(.,'$10 / user / month for additional user')])[16]")
	
	private WebElement $10forAdditionalUser;
	@FindBy(xpath = "//span[contains(.,'UPGRADE PLAN')]")
	
	private WebElement upgradePlanButton;
	@FindBy(xpath = "//span[contains(@class,'price-current')]/./sup[@class='currency-symbol']/following::span[@class='currency-main']/following::sup")
	
	private WebElement currentAmount;
	@FindBy(xpath = "//div[contains(text(),'Estimated amount for your billing cycle')]")
	
	private WebElement estimatedAmountforYourBillingText;
	@FindBy(xpath = "//div[text()=' This amount will be charged on ']")
	
	private WebElement thisAmountWillbeChargedonText;
	@FindBy(xpath = "//span[@class='font-weight-700 ng-star-inserted']")
	
	private WebElement nextBillingDate;
	@FindBy(xpath = "//span[@class='font-weight-700 ng-star-inserted']")
	
	private WebElement viewDetailsButton;
	
	// Few of the below elements will be visible to new User/ Without Card details 
	
	@FindBy(xpath = "//div[contains(text(),'Billing Details')]")
	
	private WebElement billingDetailsText;
	@FindBy(xpath = "//wtf2-icon[contains(text(),'credit_card')]")
	
	private WebElement creditCardIcon;
	@FindBy(xpath = "//div[contains(text(),'Saved card')]")
	
	private WebElement savedCardText;
	@FindBy(xpath = "//span[contains(text(),'Add Credit card to initiate the payment')]")
	
	private WebElement addCreditCardToInitiatePaymentText;
	@FindBy(xpath = "//span[contains(text(),'ADD CARD')]")
	
	private WebElement addCardButton;
	@FindBy(xpath = "//div[contains(text(),'Billing Contact')]")
	
	private WebElement billingContactText;
	@FindBy(xpath = "//div[contains(text(),'We will be sending invoices to this contact')]")
	
	private WebElement weWillSendInvoicesToThisContactText;
	@FindBy(xpath = "//img[contains(@class,'mr-2 user-avatar')]")
	
	private WebElement billingContact_UserLogo;
	@FindBy(xpath = "//div[@class='ellipsis ng-star-inserted']/div[@class='ellipsis font-weight-500']")
	
	private WebElement billingContact_UserName;
	@FindBy(xpath = "//div[@class='ellipsis ng-star-inserted']/div[@class='text-muted base-md ellipsis']")
	
	private WebElement billingContact_UserEmail;
	
	/******************************* Home PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span//img[@class='logo']")
	
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	
	private WebElement switchToIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	
	private WebElement userProfileIcon;
	private static String pageTitleText = "Deskera Cloud";
	

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void verifyBillingPageElements() {
		WDWait(companyLogo);
		companyLogo.isDisplayed();
		companyName.isDisplayed();
		companyNameArrow.isDisplayed();
		myAccountTab.isDisplayed();
		companyDetailsTab.isDisplayed();
		billingTab.isDisplayed();
		userManagementTab.isDisplayed();
		homeIcon_BillingPage.isDisplayed();
		billingText.isDisplayed();
		deskeraBooksText.isDisplayed();
		deskeraSalesText.isDisplayed();
		currentPlanName.isDisplayed();
		oneFreeUserText.isDisplayed();
		$10forAdditionalUser.isDisplayed();
		upgradePlanButton.isDisplayed();
		currentAmount.isDisplayed();
		estimatedAmountforYourBillingText.isDisplayed();
		thisAmountWillbeChargedonText.isDisplayed();
		nextBillingDate.isDisplayed();
		viewDetailsButton.isDisplayed();
		billingDetailsText.isDisplayed();
		creditCardIcon.isDisplayed();
		savedCardText.isDisplayed();
		addCreditCardToInitiatePaymentText.isDisplayed();
		addCardButton.isDisplayed();
		billingContactText.isDisplayed();
		weWillSendInvoicesToThisContactText.isDisplayed();
		WDWait(billingContact_UserLogo);
		billingContact_UserLogo.isDisplayed();
		WDWait(billingContact_UserName);
		billingContact_UserName.isDisplayed();
		billingContact_UserEmail.isDisplayed();
		collapseIcon.isDisplayed();
		chatIcon.isDisplayed();
		homeIcon.isDisplayed();
		switchToIcon.isDisplayed();
		userProfileIcon.isDisplayed();	
	}
}
