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

public class DownloadDeskeraforiOSPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public DownloadDeskeraforiOSPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	

	/******************************* Download Deskera for iOS Page PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[contains(.,'App Store')]")
	@CacheLookup
	private WebElement appStoreLink;
	@FindBy(xpath = "//span[contains(.,'App Store')]//following::span[contains(text(),'Preview')]")
	@CacheLookup
	private WebElement previewText;
	@FindBy(xpath = "//*[contains(@class,'artwork we-artwork--fullwidth we-artwork--ios-app-icon')]")
	@CacheLookup
	private WebElement coverArtImage;
	@FindBy(xpath = "//h1[@class='product-header__title app-header__title'][contains(.,'Deskera: Business & Accounting')]")
	@CacheLookup
	private WebElement productHeader;
	@FindBy(xpath = "//h2[contains(.,'Invoices, Taxes, & Accounting')]")
	@CacheLookup
	private WebElement invoiceTaxesAccountingText;
	@FindBy(xpath = "//a[contains(.,'Deskera Holdings Ltd.')]")
	@CacheLookup
	private WebElement deskeraHoldingLtdLink;
	private static String pageTitleText = "Deskera: Business & Accounting on the App Store";
	
	
	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle().contains(pageTitleText), true);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void verifyDownloadDeskeraforiOSPageElements() {
		WDWait(appStoreLink);
		appStoreLink.isDisplayed();
		previewText.isDisplayed();
		coverArtImage.isDisplayed();
		productHeader.isDisplayed();
		WDWait(coverArtImage);
		coverArtImage.isDisplayed();
		invoiceTaxesAccountingText.isDisplayed();
		deskeraHoldingLtdLink.isDisplayed();
	}
	
	public void closeDeskeraforiOSTab() {
		driver.close();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	}

}
