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
	
	private WebElement companyName;
	@FindBy(xpath = "(//span[contains(.,'Dashboard')])[1]")
	
	private WebElement dashboardTab;
	@FindBy(xpath = "//span[contains(@ng-reflect-translate,'Deals')]")
	
	private WebElement dealsTab;
	@FindBy(xpath = "//span[@ng-reflect-translate='Contacts']")
	
	private WebElement contactsTab;
	@FindBy(xpath = "//span[contains(@ng-reflect-translate,'Campaigns')]")
	
	private WebElement campaignsTab;
	@FindBy(xpath = "//span[contains(.,'Assets')]")
	
	private WebElement assetsTab;
	@FindBy(xpath = "//span[@ng-reflect-translate='Activities']")
	
	private WebElement activitiesTab;
	@FindBy(xpath = "(//span[contains(.,'Settings')])[1]")
	
	private WebElement settingTab;
	@FindBy(xpath = "//h6[contains(.,'Sales Dashboard')]")
	
	private WebElement salesDashboardText;
	@FindBy(xpath = "//h5[contains(.,'Welcome ')]")
	
	private WebElement welcomeUserText;
	@FindBy(xpath = "//p[contains(.,'Initiate your sales with building new contacts. Please visit contacts to proceed')]")
	
	private WebElement initiateyoursalesText;
	@FindBy(xpath = "//button[contains(.,'Go to contacts')]")
	
	private WebElement goToContactsButton;
	@FindBy(xpath = "(//h6[contains(.,'organization')])[1]")
	
	private WebElement organization;
	@FindBy(xpath = "(//h6[contains(.,'person')])[1]")
	
	private WebElement person;
	@FindBy(xpath = "//h6[contains(.,'deals lost')]")
	
	private WebElement dealsLost;
	@FindBy(xpath = "//h6[contains(.,'deals won')]")
	
	private WebElement dealsWon;
	@FindBy(xpath = "//h6[contains(.,'Won and Lost Deals')]")
	
	private WebElement wonandLostDealsText;
	@FindBy(xpath = "(//span[contains(.,'Monthly')])[2]")
	
	private WebElement monthlyDropdown;
	@FindBy(xpath = "//span//img[@class='logo']")
	
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	
	private WebElement switchIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	
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
