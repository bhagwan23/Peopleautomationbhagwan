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

public class DownloadDeskeraforAndroidPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DownloadDeskeraforAndroidPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Download Deskera for Android Page PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//img[@src='https://www.gstatic.com/android/market_images/web/play_prism_hlock_2x.png']")
	@CacheLookup
	private WebElement googlePlayLogo;
	@FindBy(xpath = "//input[@aria-label='Search']")
	@CacheLookup
	private WebElement searchBox;
	@FindBy(xpath = "//span[contains(.,'Free Business Accounting (Invoice, Tax, Inventory)')]")
	@CacheLookup
	private WebElement freeBusinessAccountingText;
	@FindBy(xpath = "//a[contains(.,'Free Invoice, Billing, Tax, Accounting & Business')]")
	@CacheLookup
	private WebElement freeInvoiceBillingTaxLink;
	@FindBy(xpath = "//img[contains(@alt,'Cover art')]")
	@CacheLookup
	private WebElement coverArtImage;
	@FindBy(xpath = "//span[contains(.,'Add to wishlist')]")
	@CacheLookup
	private WebElement addToWishlistLink;
	@FindBy(xpath = "//button[contains(.,'Install')]")
	@CacheLookup
	private WebElement installButton;
	private static String pageTitleText = "Free Business Accounting (Invoice, Tax, Inventory) - Apps on Google Play";
	
	
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
	
	public void verifyDownloadDeskeraforAndroidPageElements() {
		WDWait(googlePlayLogo);
		googlePlayLogo.isDisplayed();
		searchBox.isDisplayed();
		freeBusinessAccountingText.isDisplayed();
		freeInvoiceBillingTaxLink.isDisplayed();
		coverArtImage.isDisplayed();
		addToWishlistLink.isDisplayed();
		installButton.isDisplayed();
	}
	
	public void closeDeskeraforAndroidTab() {
		driver.close();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	}
	
}
