package deskera.web.automation.erp.coa.pages;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;



public class ChartOfAccountsPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public ChartOfAccountsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}
	
	private static String pageTitleText = "Chart of Accounts";
	@FindBy(xpath = "//span[text()='Chart of Accounts']")
	
	private WebElement welcomeCOA;
	@FindBy(xpath = "//span[text()='Add']")

	private WebElement addCOAbutton;
	@FindBy(xpath = "//span[text()='Accounts:']")

	private WebElement accountsLabel;
	@FindBy(xpath = "//span[text()='Filters']")

	private WebElement filters;
	@FindBy(xpath = "//span[text()='Summary']")

	private WebElement summary;
	
	@FindBy(xpath = "//mat-checkbox[@id='mat-checkbox-321']")
	private WebElement selectAllCheckbox;
	
	@FindBy(xpath = "//mat-header-cell[contains(.,'Number')]")
	private WebElement numberHeaderCell;
	
	@FindBy(xpath = "//mat-header-cell[contains(.,'Name')]")
	private WebElement nameHeaderCell;
	
	@FindBy(xpath = "//mat-header-cell[contains(.,'Type')]")
	private WebElement typeBalHeaderCell;
	
	@FindBy(xpath = "//mat-header-cell[contains(.,'Reporting Balance')]")
	private WebElement reportingBalHeaderCell;
	
	@FindBy(xpath = "//mat-header-cell[contains(.,'Status')]")
	private WebElement statusHeaderCell;
	
	@FindBy(xpath = "//label[contains(text(),'Add New Account')]")
	private WebElement addNewAccountLabel;
	
	@FindBy(xpath = "//h3[contains(text(),'Account Details')]")
	private WebElement accountDetailsLabel;
	
	@FindBy(xpath = "//input[@id='mat-input-19']")
	private WebElement accountType;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Code')]")
	private WebElement accountCode;
	
	@FindBy(xpath = "//input[@id='mat-input-17']")
	private WebElement accountName;
	
	@FindBy(xpath = "//textarea[@id='mat-input-18']")
	private WebElement description;
	
	@FindBy(xpath = "//button[@class='mat-flat-button mat-button-base mat-primary']//span[@class='mat-button-wrapper']")
	private WebElement saveButton;
	
	@Step("Open URl")
	public void openURL(String URL) {
		driver.get(URL);
	}
	
	@Step("Verify Page Title")
	public void verifyPageTitle() {
		sAssert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Verify page wlwmwnts")
	public void verifyCOAPageElements() {
		WDWait(welcomeCOA);
		welcomeCOA.isDisplayed();
		addCOAbutton.isDisplayed();
		accountsLabel.isDisplayed();
		filters.isDisplayed();
		summary.isDisplayed();
		selectAllCheckbox.isDisplayed();
		numberHeaderCell.isDisplayed();
		nameHeaderCell.isDisplayed();
		typeBalHeaderCell.isDisplayed();
		reportingBalHeaderCell.isDisplayed();
		statusHeaderCell.isDisplayed();
	}
	
	@Step("Click on Add button")
	public void clickAddCOAbutton() {
		WDWait(addCOAbutton);
		sAssert.assertTrue(addCOAbutton.isDisplayed(),"Verify Add Accounts Button");
		addCOAbutton.click();
		addNewAccountLabel.isDisplayed();
		accountDetailsLabel.isDisplayed();
		sAssert.assertTrue(accountType.isDisplayed(), "Account type dropdown");
		sAssert.assertTrue(accountCode.isDisplayed(), "Account code input box");
		sAssert.assertTrue(accountName.isDisplayed(), "Account name input box");
		sAssert.assertTrue(description.isDisplayed(), "Account description");
		
	}
	
	@Step("Enter account details")
	public void enterAccountDetails(String name, String code, String type, String desc) {
		WDWait(accountType);
		accountType.sendKeys(type);
		accountCode.sendKeys(code);
		accountName.sendKeys(name);
		description.sendKeys(desc);
	}

	@Step("Click On Save Button")
	public void clickSaveButton() {
		WDWait(saveButton);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
}

