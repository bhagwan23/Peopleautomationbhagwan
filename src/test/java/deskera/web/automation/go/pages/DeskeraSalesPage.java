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

public class DeskeraSalesPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DeskeraSalesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Deskera Sales  PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//div[@class='ellipsis company-name']")
	@CacheLookup
	private WebElement companyName;
	@FindBy(xpath = "(//span[contains(.,'Dashboard')])[1]")
	@CacheLookup
	private WebElement dashboardTab;
	@FindBy(xpath = "//span[contains(@ng-reflect-translate,'Deals')]")
	@CacheLookup
	private WebElement dealsTab;
	@FindBy(xpath = "//span[@ng-reflect-translate='Contacts']")
	@CacheLookup
	private WebElement contactsTab;
	@FindBy(xpath = "//span[contains(@ng-reflect-translate,'Campaigns')]")
	@CacheLookup
	private WebElement campaignsTab;
	@FindBy(xpath = "//span[contains(.,'Assets')]")
	@CacheLookup
	private WebElement assetsTab;
	@FindBy(xpath = "//span[@ng-reflect-translate='Activities']")
	@CacheLookup
	private WebElement activitiesTab;
	@FindBy(xpath = "(//span[contains(.,'Settings')])[1]")
	@CacheLookup
	private WebElement settingTab;
	@FindBy(xpath = "//h6[contains(.,'Sales Dashboard')]")
	@CacheLookup
	private WebElement salesDashboardText;
	@FindBy(xpath = "//h5[contains(.,'Welcome ')]")
	@CacheLookup
	private WebElement welcomeUserText;
	@FindBy(xpath = "//p[contains(.,'Initiate your sales with building new contacts. Please visit contacts to proceed')]")
	@CacheLookup
	private WebElement initiateyoursalesText;
	@FindBy(xpath = "//button[contains(.,'Go to contacts')]")
	@CacheLookup
	private WebElement goToContactsButton;
	@FindBy(xpath = "(//h6[contains(.,'organization')])[1]")
	@CacheLookup
	private WebElement organization;
	@FindBy(xpath = "(//h6[contains(.,'person')])[1]")
	@CacheLookup
	private WebElement person;
	@FindBy(xpath = "//h6[contains(.,'deals lost')]")
	@CacheLookup
	private WebElement dealsLost;
	@FindBy(xpath = "//h6[contains(.,'deals won')]")
	@CacheLookup
	private WebElement dealsWon;
	@FindBy(xpath = "//h6[contains(.,'Won and Lost Deals')]")
	@CacheLookup
	private WebElement wonandLostDealsText;
	@FindBy(xpath = "(//span[contains(.,'Monthly')])[2]")
	@CacheLookup
	private WebElement monthlyDropdown;
	@FindBy(xpath = "//span//img[@class='logo']")
	@CacheLookup
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	@CacheLookup
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	@CacheLookup
	private WebElement switchIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	@CacheLookup
	private WebElement userProfileIcon;
	private static String pageTitleText = "Deskera Sales";
	
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
	
	public void verifyDeskeraSalesPageElements() {
		WDWait(companyName);
		companyName.isDisplayed();
		dashboardTab.isDisplayed();
		dealsTab.isDisplayed();
		contactsTab.isDisplayed();
		campaignsTab.isDisplayed();
		assetsTab.isDisplayed();
		activitiesTab.isDisplayed();
		settingTab.isDisplayed();
		salesDashboardText.isDisplayed();
		welcomeUserText.isDisplayed();
		initiateyoursalesText.isDisplayed();
		goToContactsButton.isDisplayed();
		organization.isDisplayed();
		person.isDisplayed();
		dealsLost.isDisplayed();
		dealsWon.isDisplayed();
		wonandLostDealsText.isDisplayed();
		monthlyDropdown.isDisplayed();	
		chatIcon.isDisplayed();
		homeIcon.isDisplayed();
		switchIcon.isDisplayed();
		userProfileIcon.isDisplayed();
	}
	
	public void closeDeskeraSalesTab() {
		driver.close();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	}
	
}
