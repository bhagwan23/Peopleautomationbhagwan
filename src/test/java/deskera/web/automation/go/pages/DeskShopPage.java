package deskera.web.automation.go.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
	
	/******************************* Deskera Shop Set Up  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//h1[contains(.,'Welcome to Shop Setup')]")
	
	private List<WebElement> welcomeToShopSetupText;
   @FindBy(xpath = "(//div[contains(.,'Complete your setup to start selling products')])[5]")
	
	private WebElement completeYourSetupText;
    @FindBy(xpath = "//button[contains(.,'Setup Shop')]")
	
	private WebElement setupShopButton;
    @FindBy(xpath = "//a[contains(.,'Continue')]")
	
	private WebElement continueButton;
    
  //h1[contains(.,'Your Store Has Been Setup!')]
    
    /******************************* Deskera PAGE ELEMENTS LOCATORS *******************/
    
	@FindBy(xpath = "//img[contains(@class,'desk-logo-icon')]//following::div[@class='seller-center']")
	
	private WebElement deskShopLogo;
	@FindBy(xpath = "//input[@type='text']")
	
	private WebElement searchBox;
	@FindBy(xpath = "//div[@id='changeCompanyName']")
	
	private WebElement companyName;
	@FindBy(xpath = "//img[@id='changeProfileImage']")
	
	private WebElement profileImage;
	@FindBy(xpath = "//wtf2-icon[contains(.,'home')]")
	
	private WebElement homeIcon;
	@FindBy(xpath = "(//span[contains(.,'shop Dashboard')])[2]")
	
	private WebElement shopDashboardText;
	@FindBy(xpath = "//span[contains(text(),'Shop Profile')]")
	
	private WebElement shopProfileButton;
	@FindBy(xpath = "//span[contains(.,'open_in_new Storefront')]")
	
	private WebElement storefrontButton;
	@FindBy(xpath = "//wtf2-icon[contains(.,'local_offer')]")
	
	private WebElement localOfferIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'shopping_basket')])[1]")
	
	private WebElement shoppingBasketIcon;
	@FindBy(xpath = "//wtf2-icon[contains(.,'shopping_cart')]")
	
	private WebElement shoppingCartIcon;
	@FindBy(xpath = "//wtf2-icon[contains(.,'attach_money')]")
	
	private WebElement attachMoneyIcon;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'PRODUCTS')]")
	
	private WebElement products;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'QUOTES')]")
	
	private WebElement quotes;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'ORDERS')]")
	
	private WebElement orders;
	@FindBy(xpath = "//div[@class='wid-label'][contains(.,'SALES')]")
	
	private WebElement sales;
	@FindBy(xpath = "(//span[contains(.,'Dashboard')])[1]")
	
	private WebElement dashboardTab;
	@FindBy(xpath = "//span[contains(.,'Catalog')]")
	
	private WebElement catalogTab;
	@FindBy(xpath = "(//span[contains(.,'Transactions')])[1]")
	
	private WebElement transactionTab;
	@FindBy(xpath = "//span[contains(.,'My Communication')]")
	
	private WebElement myCommunicationTab;
	@FindBy(xpath = "//span[contains(.,'My Account')]")
	
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
	
	// Click on Setup shop Button if user is newly signed in 
	public void clickSetupShop() {
		if(welcomeToShopSetupText.size() != 0){
			completeYourSetupText.isDisplayed();
			setupShopButton.click();
			WDWait(continueButton);		
			continueButton.click();
		}
	}
	
	public void verifyDeskShopPageElements() {
		WDWait(deskShopLogo);
		deskShopLogo.isDisplayed();
		searchBox.isDisplayed();
		companyName.isDisplayed();
		profileImage.isDisplayed();
		homeIcon.isDisplayed();
		WDWait(shopDashboardText);
		shopDashboardText.isDisplayed();
		WDWait(shopProfileButton);
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
