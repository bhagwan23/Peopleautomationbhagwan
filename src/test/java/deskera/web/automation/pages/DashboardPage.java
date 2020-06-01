package deskera.web.automation.pages;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class DashboardPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DashboardPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Dashboard/Home  PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[text()='Welcome']/../span[text()=' Onboard ']")
	@CacheLookup
	private WebElement welcomeOnboard;
	@FindBy(xpath = "//div[contains(text(),'You are currently on')]/span")     
	@CacheLookup
	private WebElement youAreCurrentlyOn;
	@FindBy(xpath = "(//span[contains(.,'Upgrade Plan')])[2]")
	@CacheLookup
	private WebElement upgradePlanButton;
	@FindBy(xpath = "//span[contains(.,'If you have any questions about Deskera apps, please write to us at care@deskera.com')]")
	@CacheLookup
	private WebElement anyQuestionsAboutDeskeraApp;
	@FindBy(xpath = "//div[@class='font-size-33 ellipsis'][contains(.,'Hi')]")
	@CacheLookup
	private WebElement hiUser;
	@FindBy(xpath = "//span[contains(.,'Thrilled to see you here! We have some exciting things in store for you.')]")
	@CacheLookup
	private WebElement thrilledToSeeYouHere;
	@FindBy(xpath = ".//span[text()='My Account']")
	@CacheLookup
	private WebElement myAccountButton;
	@FindBy(xpath = "//span[text()=' Deskera Books ']")
	@CacheLookup
	private WebElement deskeraBooksCard;
	@FindBy(xpath = "//span[text()=' Deskera Sales ']")
	@CacheLookup
	private WebElement deskeraSalesCard;
	@FindBy(xpath = "//span[text()=' Desk Shop ']")
	@CacheLookup
	private WebElement deskShopCard;
	@FindBy(xpath = "//span[text()=' Deskera Chat ']")
	@CacheLookup
	private WebElement deskeraChat;
	@FindBy(xpath = "//span[text()=' Download Deskera for Android ']")
	@CacheLookup
	private WebElement downloadDeskeraforAndroid;
	@FindBy(xpath = "//span[text()=' Download Deskera for iOS ']")
	@CacheLookup
	private WebElement downloadDeskeraforiOS;
	@FindBy(xpath = "//span[text()=' Deskera Books ']//following::span[text()='Upgrade Now'][1]")
	@CacheLookup
	private WebElement DeskeraBooksUpgradeNow;
	@FindBy(xpath = "//span[text()=' Deskera Sales ']//following::span[text()='Upgrade Now'][1]")
	@CacheLookup
	private WebElement DeskeraSalesUpgradeNow;
	@FindBy(xpath = "//span//img[@class='logo']")
	@CacheLookup
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	@CacheLookup
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	@CacheLookup
	private WebElement switchToIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	@CacheLookup
	private WebElement userProfileIcon;
	private static String pageTitleText = "Deskera Cloud";
	
	/******************************* Switch To Applications / Launcher Bar  PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//span[contains(text(),'SWITCH TO')]")
	@CacheLookup
	private WebElement switchToText;
	@FindBy(xpath = "//wtf2-icon[contains(text(),'close')]")
	@CacheLookup
	private WebElement CloseSwitchToIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'business')])[1]")
	@CacheLookup
	private WebElement deskeraBooksLink;
	@FindBy(xpath = "//wtf2-icon[contains(.,'perm_identity')]")
	@CacheLookup
	private WebElement deskeraSalesLink;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'shopping_cart')])[1]")
	@CacheLookup
	private WebElement deskShopLink;
	@FindBy(xpath = "//div//p[text()=' Deskera Chat ']")
	@CacheLookup
	private WebElement deskeraChatLink;
	@FindBy(xpath = "//div//p[text()=' Download Deskera on Mobile ']")
	@CacheLookup
	private WebElement downloadDeskeraonMobileLink;
	@FindBy(xpath = "//img[@src='assets/images/applestore.png']")
	@CacheLookup
	private WebElement iOSappStoreImage;
	@FindBy(xpath = "//img[@src='assets/images/playstore.png']")
	@CacheLookup
	private WebElement googlePlayStoreImage;
	@FindBy(xpath = "//div//p[text()=' Administration Settings ']")
	@CacheLookup
	private WebElement administrationSettingLink;
	@FindBy(xpath = "//div//p[text()=' Administration Settings ']")
	@CacheLookup
	private WebElement manageUsersAndAccountsInOnePlaceText;
	
	
	/******************************* User Profile Icon  PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//img[@class='profile-pic-launchpad']")
	@CacheLookup
	private WebElement userProfileImage;
	@FindBy(xpath = "//p[contains(@class,'font-weight-600 m-0 p-0 ellipsis')]")
	@CacheLookup
	private WebElement userProfileName;
	@FindBy(xpath = "//p[contains(@class,'base-md m-0 p-0 ellipsis')]")
	@CacheLookup
	private WebElement userProfileEmail;
	@FindBy(xpath = "//button[contains(text(),'Manage Account')]")
	@CacheLookup
	private WebElement ManageAccountButton;
	@FindBy(xpath = "//button[contains(text(),'Billing')]")
	@CacheLookup
	private WebElement billingButton;
	@FindBy(xpath = "//button[contains(.,'Sign Out')]")
	@CacheLookup
	private WebElement signOutButton;
	
	
	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	public void verifyPageTitle() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void verifyDashboardPageElements() {
		WDWait(welcomeOnboard);
		welcomeOnboard.isDisplayed();
		youAreCurrentlyOn.isDisplayed();
		WDWait(upgradePlanButton);
		upgradePlanButton.isDisplayed();
		anyQuestionsAboutDeskeraApp.isDisplayed();
		hiUser.isDisplayed();
		thrilledToSeeYouHere.isDisplayed();
		myAccountButton.isDisplayed();
		deskeraBooksCard.isDisplayed();
		deskeraSalesCard.isDisplayed();
		deskShopCard.isDisplayed();
		deskeraChat.isDisplayed();
		downloadDeskeraforAndroid.isDisplayed();
		downloadDeskeraforiOS.isDisplayed();
		DeskeraBooksUpgradeNow.isDisplayed();
		DeskeraSalesUpgradeNow.isDisplayed();
		chatIcon.isDisplayed();
		homeIcon.isDisplayed();
		switchToIcon.isDisplayed();
		userProfileIcon.isDisplayed();
	}
	
	public void verifyLauncherBarPanelElements() {
		WDWait(switchToIcon);
		switchToIcon.click();
		WDWait(switchToText);
		switchToText.isDisplayed();
		CloseSwitchToIcon.isDisplayed();
		deskeraBooksLink.isDisplayed();
		deskeraSalesLink.isDisplayed();
		deskShopLink.isDisplayed();
		deskeraChatLink.isDisplayed();
		downloadDeskeraonMobileLink.isDisplayed();
		iOSappStoreImage.isDisplayed();
		googlePlayStoreImage.isDisplayed();
		administrationSettingLink.isDisplayed();
		manageUsersAndAccountsInOnePlaceText.isDisplayed();
		CloseSwitchToIcon.click();	
	}
	
	public void verifyUserProfilePanelElements() {
		WDWait(userProfileIcon);
		userProfileIcon.click();
		WDWait(userProfileImage);
		userProfileImage.isDisplayed();
		userProfileName.isDisplayed();
		userProfileEmail.isDisplayed();
		ManageAccountButton.isDisplayed();
		billingButton.isDisplayed();
		signOutButton.isDisplayed();
		userProfileImage.click();	
	}
	public void openDeskeraBooksApp() {
		deskeraBooksCard.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void openDeskeraSalesApp() {
		deskeraSalesCard.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void openDeskShopApp() {
		deskShopCard.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void openDownloadDeskeraforAndroidPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(downloadDeskeraforAndroid).click().perform();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void openDownloadDeskeraforiOSPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(downloadDeskeraforiOS).click().perform();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void openDeskeraChatPage() {
		deskeraChat.click();
	}
	
	public void launchDeskeraBooksApp() {
		switchToIcon.click();
		WDWait(deskeraBooksLink);
		deskeraBooksLink.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void launchDeskeraSalesApp() {
		switchToIcon.click();
		WDWait(deskeraSalesLink);
		deskeraSalesLink.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void launchDeskShopApp() {
		switchToIcon.click();
		WDWait(deskShopLink);
		deskShopLink.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void openAdministrationSettingPage() {
		WDWait(switchToIcon);
		switchToIcon.click();
		WDWait(administrationSettingLink);
		administrationSettingLink.click();
	}
	
	public void openBillingPage() {
		WDWait(userProfileIcon);
		userProfileIcon.click();
		WDWait(billingButton);
		billingButton.click();
	}
	
	public void openCompanyDetailsPage() {
		WDWait(userProfileIcon);
		userProfileIcon.click();
		WDWait(ManageAccountButton);
		ManageAccountButton.click();
	}
	
	public void clickChatIcon() {
		WDWait(chatIcon);
		chatIcon.click();		
	}
	
	public void userLogout() {
		WDWait(userProfileIcon);
		userProfileIcon.click();
		WDWait(signOutButton);
		signOutButton.click();
	}
	
	
	}
	
	

