package deskera.web.automation.erp.bvtSG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UsersPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public UsersPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
		
		
		/******************************* Users  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'addADD USER')]")
	@CacheLookup
	private WebElement addUsersButton;
	
		
	private static String pageTitleText = "Deskera Books";
	
	
	/******************************* Add User Section  ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
	@CacheLookup
	private WebElement firstName;
		

	/***********************************
	 * 
	 * Page objects manipulation methods
	* 
	 *********************************/
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
}
