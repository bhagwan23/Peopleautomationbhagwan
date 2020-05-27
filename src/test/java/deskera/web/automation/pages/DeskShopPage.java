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

public class DeskShopPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DeskShopPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Deskera Shop  PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//img[contains(@class,'desk-logo-icon')]//following::div[@class='seller-center']")
	@CacheLookup
	private WebElement deskShopLogo;
	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	private WebElement searchBox;
	@FindBy(xpath = "//div[@id='changeCompanyName']")
	@CacheLookup
	private WebElement companyName;
	@FindBy(xpath = "//img[@id='changeProfileImage']")
	@CacheLookup
	private WebElement profileImage;
	@FindBy(xpath = "//wtf2-icon[contains(.,'home')]")
	@CacheLookup
	private WebElement homeIcon;
	@FindBy(xpath = "(//span[contains(.,'shop Dashboard')])[2]")
	@CacheLookup
	private WebElement shopDashboardText;
	@FindBy(xpath = "//span[contains(text(),' Shop Profile ')]")
	@CacheLookup
	private WebElement shopProfileButton;
	@FindBy(xpath = "//span[contains(.,'open_in_new Storefront')]")
	@CacheLookup
	private WebElement storefrontButton;
	@FindBy(xpath = "//wtf2-icon[contains(.,'local_offer')]")
	@CacheLookup
	private WebElement localOfferIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'shopping_basket')])[1]")
	@CacheLookup
	private WebElement shoppingBasketIcon;
	@FindBy(xpath = "//wtf2-icon[contains(.,'shopping_cart')]")
	@CacheLookup
	private WebElement shoppingCartIcon;
	@FindBy(xpath = "//wtf2-icon[contains(.,'attach_money')]")
	@CacheLookup
	private WebElement attachMoneyIcon;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'PRODUCTS')]")
	@CacheLookup
	private WebElement products;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'QUOTES')]")
	@CacheLookup
	private WebElement quotes;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'ORDERS')]")
	@CacheLookup
	private WebElement orders;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'SALES')]")
	@CacheLookup
	private WebElement sales;
	@FindBy(xpath = "(//span[contains(.,'Dashboard')])[1]")
	@CacheLookup
	private WebElement dashboardTab;
	@FindBy(xpath = "//span[contains(.,'Catalog')]")
	@CacheLookup
	private WebElement catalogTab;
	@FindBy(xpath = "(//span[contains(.,'Transactions')])[1]")
	@CacheLookup
	private WebElement transactionTab;
	@FindBy(xpath = "//span[contains(.,'My Communication')]")
	@CacheLookup
	private WebElement myCommunicationTab;
	@FindBy(xpath = "//span[contains(.,'My Account')]")
	@CacheLookup
	private WebElement myAccountTab;
	
	
	private static String pageTitleText = "Desk Seller Center";
	
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
	
	public void verifyDeskShopPageElements() {
		WDWait(deskShopLogo);
		deskShopLogo.isDisplayed();
		searchBox.isDisplayed();
		companyName.isDisplayed();
		profileImage.isDisplayed();
		homeIcon.isDisplayed();
		shopDashboardText.isDisplayed();
		shopProfileButton.isDisplayed();
		storefrontButton.isDisplayed();
		localOfferIcon.isDisplayed();
		shoppingBasketIcon.isDisplayed();
		shoppingCartIcon.isDisplayed();
		attachMoneyIcon.isDisplayed();
		products.isDisplayed();
		quotes.isDisplayed();
		orders.isDisplayed();
		sales.isDisplayed();
		dashboardTab.isDisplayed();
		catalogTab.isDisplayed();
		transactionTab.isDisplayed();
		myCommunicationTab.isDisplayed();
		myAccountTab.isDisplayed();
	}
	
	public void closeDeskShopTab() {
		driver.close();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	}
}
