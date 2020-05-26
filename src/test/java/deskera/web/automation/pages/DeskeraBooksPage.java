package deskera.web.automation.pages;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeskeraBooksPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DeskeraBooksPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Deskera Books  PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	@CacheLookup
	private WebElement companyName;
	@FindBy(xpath = "//span[text()=' Dashboard ']")
	@CacheLookup
	private WebElement dashboardTab;
	@FindBy(xpath = "//a[contains(.,'Sell')]")
	@CacheLookup
	private WebElement sellTab;
	@FindBy(xpath = "//span[contains(.,'Buy')]")
	@CacheLookup
	private WebElement buyTab;
	@FindBy(xpath = "//span[contains(.,'Pick Pack Ship')]")
	@CacheLookup
	private WebElement pickPackShipTab;
	@FindBy(xpath = "(//span[contains(.,'Products')])[1]")
	@CacheLookup
	private WebElement ProductsTab;
	@FindBy(xpath = "//span[contains(.,'Warehouse')]")
	@CacheLookup
	private WebElement warehouseTab;
	@FindBy(xpath = "(//span[contains(.,'Contacts')])[1]")
	@CacheLookup
	private WebElement contactsTab;
	@FindBy(xpath = "//span[contains(.,'Reports')]")
	@CacheLookup
	private WebElement reportsTab;
	@FindBy(xpath = "//span[contains(.,'Bank')]")
	@CacheLookup
	private WebElement bankTab;
	@FindBy(xpath = "//span[contains(.,'Accounting')]")
	@CacheLookup
	private WebElement accountingTab;
	@FindBy(xpath = "(//span[contains(.,'Apps')])[2]")
	@CacheLookup
	private WebElement appsTab;
	@FindBy(xpath = "//span[contains(.,'Settings')]")
	@CacheLookup
	private WebElement settingsTab;
	@FindBy(xpath = "//span//img[@class='logo']")
	@CacheLookup
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	@CacheLookup
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[contains(@wtf2tooltip,'Your Connected Apps')]")
	@CacheLookup
	private WebElement yourConnectedAppsIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	@CacheLookup
	private WebElement switchIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	@CacheLookup
	private WebElement userProfileIcon;
	@FindBy(xpath = "//div[contains(@class,'user-name')]")
	@CacheLookup
	private WebElement welcomeUser;
	@FindBy(xpath = "//span[contains(.,'Organization check_circle')]")
	@CacheLookup
	private WebElement organizationCircle;
	@FindBy(xpath = "(//span[contains(.,'Financial')])[1]")
	@CacheLookup
	private WebElement financialCircle;
	@FindBy(xpath = "(//span[contains(.,'Address')])[1]")
	@CacheLookup
	private WebElement addressCircle;
	@FindBy(xpath = "//span[contains(.,'Compliance')]")
	@CacheLookup
	private WebElement complianceCircle;
	@FindBy(xpath = "//div[@class='mat-headline']")
	@CacheLookup
	private WebElement letsGetStartedText;
	@FindBy(xpath = "//button[contains(.,'Try a Demo Company')]")
	@CacheLookup
	private WebElement tryDemoCompanyButton;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Organization Name')]")
	@CacheLookup
	private WebElement organizationNameText;
	@FindBy(xpath = "//input[@formcontrolname='tenantName']")
	@CacheLookup
	private WebElement organizationName;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Tax Residency')]")
	@CacheLookup
	private WebElement taxResidencyText;
	@FindBy(xpath = "//input[@formcontrolname='countryLookupCode']")
	@CacheLookup
	private WebElement taxResidencyDropdown;
	@FindBy(xpath = "//div[@class='headline'][contains(.,'Financial Settings')]")
	@CacheLookup
	private WebElement financialSettingText;
	@FindBy(xpath = "//input[@formcontrolname='financialStartDate']")
	@CacheLookup
	private WebElement financialStartDate;
	@FindBy(xpath = "//input[@formcontrolname='bookBeginningStartDate']")
	@CacheLookup
	private WebElement bookBeginningStartDate;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Currency')]")
	@CacheLookup
	private WebElement currecnyText;
	@FindBy(xpath = "//input[@formcontrolname='currencyLookUpCode']")
	@CacheLookup
	private WebElement currecnyDropdown;
	@FindBy(xpath = "//span[contains(.,'Enable Multi-Currency')]")
	@CacheLookup
	private WebElement enableMultiCurrency;
	@FindBy(xpath = "//div[@class='headline'][contains(.,'Address Details')]")
	@CacheLookup
	private WebElement addressDetailsText;
	@FindBy(xpath = "//input[@formcontrolname='address1']")
	@CacheLookup
	private WebElement addressLine1;
	@FindBy(xpath = "//input[@formcontrolname='address2']")
	@CacheLookup
	private WebElement addressLine2;
	@FindBy(xpath = "//input[@formcontrolname='city']")
	@CacheLookup
	private WebElement city;
	@FindBy(xpath = "//input[contains(@formcontrolname,'state')]")
	@CacheLookup
	private WebElement state;
	@FindBy(xpath = "//input[@formcontrolname='postalCode']")
	@CacheLookup
	private WebElement zipCode;
	@FindBy(xpath = "//input[contains(@formcontrolname,'timezoneLookUpCode')]")
	@CacheLookup
	private WebElement timezone;
	@FindBy(xpath = "//div[@class='headline'][contains(.,'Compliance Details')]")
	@CacheLookup
	private WebElement complianceDetailsText;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Tax ID No.')]")
	@CacheLookup
	private WebElement taxIdNo;
	@FindBy(xpath = "(//span[@class='mat-checkbox-label'])[2]")
	@CacheLookup
	private WebElement iDontCollectTaxes;
	@FindBy(xpath = "//input[contains(@formcontrolname,'nexus')]")
	@CacheLookup
	private WebElement stateWhereCollectTax;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	@CacheLookup
	private WebElement saveButton;
	private static String pageTitleText = "Deskera Books";
	
	
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
	
	public void verifyDeskeraBooksPageElements() {
		WDWait(companyName);
		companyName.isDisplayed();
		dashboardTab.isDisplayed();
		sellTab.isDisplayed();
		buyTab.isDisplayed();
		pickPackShipTab.isDisplayed();
		ProductsTab.isDisplayed();
		warehouseTab.isDisplayed();
		contactsTab.isDisplayed();
		reportsTab.isDisplayed();
		bankTab.isDisplayed();
		accountingTab.isDisplayed();
		appsTab.isDisplayed();
		settingsTab.isDisplayed();
		chatIcon.isDisplayed();
		homeIcon.isDisplayed();
		yourConnectedAppsIcon.isDisplayed();
		switchIcon.isDisplayed();
		userProfileIcon.isDisplayed();
	}
	
	public void verifyCompanyCreationPageElements() {
		WDWait(welcomeUser);
		welcomeUser.isDisplayed();
		organizationCircle.isDisplayed();
		financialCircle.isDisplayed();
		addressCircle.isDisplayed();
		complianceCircle.isDisplayed();
		letsGetStartedText.isDisplayed();
		tryDemoCompanyButton.isDisplayed();
		organizationNameText.isDisplayed();
		organizationName.isDisplayed();
		taxResidencyText.isDisplayed();
		taxResidencyDropdown.isDisplayed();
		financialSettingText.isDisplayed();
		financialStartDate.isDisplayed();
		bookBeginningStartDate.isDisplayed();
		currecnyText.isDisplayed();
		currecnyDropdown.isDisplayed();
		enableMultiCurrency.isDisplayed();
		addressDetailsText.isDisplayed();	
		addressLine1.isDisplayed();
		addressLine2.isDisplayed();
		city.isDisplayed();
		state.isDisplayed();
		timezone.isDisplayed();	
		complianceDetailsText.isDisplayed();
		taxIdNo.isDisplayed();
		iDontCollectTaxes.isDisplayed();
		stateWhereCollectTax.isDisplayed();
		saveButton.isDisplayed();
	}
	
	public void closeDeskeraBooksTab() {
		driver.close();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	}
}
