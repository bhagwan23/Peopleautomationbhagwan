package deskera.web.automation.go.pages;
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
	
	private WebElement companyName;
	@FindBy(xpath = "//span[text()=' Dashboard ']")
	
	private WebElement dashboardTab;
	@FindBy(xpath = "//a[contains(.,'Sell')]")
	
	private WebElement sellTab;
	@FindBy(xpath = "//span[contains(.,'Buy')]")
	
	private WebElement buyTab;
	@FindBy(xpath = "//span[contains(.,'Pick Pack Ship')]")
	
	private WebElement pickPackShipTab;
	@FindBy(xpath = "(//span[contains(.,'Products')])[1]")
	
	private WebElement ProductsTab;
	@FindBy(xpath = "//span[contains(.,'Warehouse')]")
	
	private WebElement warehouseTab;
	@FindBy(xpath = "(//span[contains(.,'Contacts')])[1]")
	
	private WebElement contactsTab;
	@FindBy(xpath = "//span[contains(.,'Reports')]")
	
	private WebElement reportsTab;
	@FindBy(xpath = "//span[contains(.,'Bank')]")
	
	private WebElement bankTab;
	@FindBy(xpath = "//span[contains(.,'Accounting')]")
	
	private WebElement accountingTab;
	@FindBy(xpath = "(//span[contains(.,'Apps')])[2]")
	
	private WebElement appsTab;
	@FindBy(xpath = "//span[contains(.,'Settings')]")
	
	private WebElement settingsTab;
	@FindBy(xpath = "//span//img[@class='logo']")
	
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[contains(@wtf2tooltip,'Your Connected Apps')]")
	
	private WebElement yourConnectedAppsIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	
	private WebElement switchIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	
	private WebElement userProfileIcon;
	@FindBy(xpath = "//div[contains(@class,'user-name')]")
	
	private WebElement welcomeUser;
	@FindBy(xpath = "//span[contains(.,'Organization check_circle')]")
	
	private WebElement organizationCircle;
	@FindBy(xpath = "(//span[contains(.,'Financial')])[1]")
	
	private WebElement financialCircle;
	@FindBy(xpath = "(//span[contains(.,'Address')])[1]")
	
	private WebElement addressCircle;
	@FindBy(xpath = "//span[contains(.,'Compliance')]")
	
	private WebElement complianceCircle;
	@FindBy(xpath = "//div[@class='mat-headline']")
	
	private WebElement letsGetStartedText;
	@FindBy(xpath = "//button[contains(.,'Try a Demo Company')]")
	
	private WebElement tryDemoCompanyButton;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Organization Name')]")
	
	private WebElement organizationNameText;
	@FindBy(xpath = "//input[@formcontrolname='tenantName']")
	
	private WebElement organizationName;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Tax Residency')]")
	
	private WebElement taxResidencyText;
	@FindBy(xpath = "//input[@formcontrolname='countryLookupCode']")
	
	private WebElement taxResidencyDropdown;
	@FindBy(xpath = "//div[@class='headline'][contains(.,'Financial Settings')]")
	
	private WebElement financialSettingText;
	@FindBy(xpath = "//input[@formcontrolname='financialStartDate']")
	
	private WebElement financialStartDate;
	@FindBy(xpath = "//input[@formcontrolname='bookBeginningStartDate']")
	
	private WebElement bookBeginningStartDate;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Currency')]")
	
	private WebElement currecnyText;
	@FindBy(xpath = "//input[@formcontrolname='currencyLookUpCode']")
	
	private WebElement currecnyDropdown;
	@FindBy(xpath = "//span[contains(.,'Enable Multi-Currency')]")
	
	private WebElement enableMultiCurrency;
	@FindBy(xpath = "//div[@class='headline'][contains(.,'Address Details')]")
	
	private WebElement addressDetailsText;
	@FindBy(xpath = "//input[@formcontrolname='address1']")
	
	private WebElement addressLine1;
	@FindBy(xpath = "//input[@formcontrolname='address2']")
	
	private WebElement addressLine2;
	@FindBy(xpath = "//input[@formcontrolname='city']")
	
	private WebElement city;
	@FindBy(xpath = "//input[contains(@formcontrolname,'state')]")
	
	private WebElement state;
	@FindBy(xpath = "//input[@formcontrolname='postalCode']")
	
	private WebElement zipCode;
	@FindBy(xpath = "//input[contains(@formcontrolname,'timezoneLookUpCode')]")
	
	private WebElement timezone;
	@FindBy(xpath = "//div[@class='headline'][contains(.,'Compliance Details')]")
	
	private WebElement complianceDetailsText;
	@FindBy(xpath = "//div[@class='mat-form-field-infix'][contains(.,'Tax ID No.')]")
	
	private WebElement taxIdNo;
	@FindBy(xpath = "(//span[@class='mat-checkbox-label'])[2]")
	
	private WebElement iDontCollectTaxes;
	@FindBy(xpath = "//input[contains(@formcontrolname,'nexus')]")
	
	private WebElement stateWhereCollectTax;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	
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
