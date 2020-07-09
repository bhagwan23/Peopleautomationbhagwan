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
	
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(text(),'Accounting')]")	
	private WebElement accountingButton;
	
	@FindBy(xpath = "//div[contains(@class,'row ng-star-inserted')]//div[1]//wtf2-card[1]")
	private WebElement coaCard;

	private static String pageTitleText = "Chart of Accounts";
	@FindBy(xpath = "//h1[contains(text(),'Chart of Accounts')]")
	
	private WebElement welcomeCOA;
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Add')]")

	private WebElement addCOAbutton;
	@FindBy(xpath = "//span[text()='Accounts:']")

	private WebElement accountsLabel;
	@FindBy(xpath = "//span[text()='Filters']")

	private WebElement filters;
	@FindBy(xpath = "//span[text()='Summary']")

	private WebElement summary;
	
//	@FindBy(xpath = "//mat-checkbox[@id='mat-checkbox-321']")
//	private WebElement selectAllCheckbox;
	
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
	
	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement accountType;
	
	@FindBy(xpath = "//input[@formcontrolname='accountCode']")
	private WebElement accountCode;
	
	@FindBy(xpath = "//input[@formcontrolname='name']")
	private WebElement accountName;
	
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private WebElement description;
	
	@FindBy(xpath = "//button[@class='mat-flat-button mat-button-base mat-primary']//span[@class='mat-button-wrapper']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Bank')]")
	private WebElement bank;
	
//	@FindBy(xpath = "//span[contains(text(),'Cash')]")
//	private WebElement cash;
//	
//	@FindBy(xpath = "//span[contains(text(),'Cost of Goods Sold')]")
//	private WebElement costOfGoodsSold;
//	
//	@FindBy(xpath = "//span[contains(text(),'Current Assets')]")
//	private WebElement currentAssets;
//	
//	@FindBy(xpath = "//span[contains(text(),'Current Liabilities')]")
//	private WebElement currentLiabilities;
//	
//	@FindBy(xpath = "//span[contains(text(),'Equity')]")
//	private WebElement equity;
//	
//	@FindBy(xpath = "//mat-option[@id='mat-option-198']//span[@class='mat-option-text'][contains(text(),'Expenses')]")
//	private WebElement expenses;
//	
//	@FindBy(xpath = "//mat-option[@id='mat-option-199']//span[@class='mat-option-text'][contains(text(),'Income')]")
//	private WebElement income;
//	
//	@FindBy(xpath = "//span[contains(text(),'Non-current Assets')]")
//	private WebElement nonCurrentAssets;
//	
//	@FindBy(xpath = "//span[contains(text(),'Non-current Liabilities')]")
//	private WebElement nonCurrentLiabilities;
//	
//	@FindBy(xpath = "//span[contains(text(),'Other Expenses')]")
	private WebElement otherExpenses;
	
	@FindBy(xpath= "//span[text()='Account is successfully created.']")
	@CacheLookup
	private WebElement createCOASuccessMessage;
	
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
	
	@Step("Click on accounting button")
	public void clickAccountingButton() throws InterruptedException{
		WDWait(accountingButton);
		accountingButton.click(); 
		//Thread.sleep(3000);
	}
	
	@Step("Click on Chart Of Accounts card")
	public void clickChartOfAccountsCard() throws InterruptedException{
		WDWait(coaCard);
		coaCard.click(); 
		Thread.sleep(2000);
	}
	
	@Step("Verify page elements")
	public void verifyCOAPageElements() throws InterruptedException {
		WDWait(welcomeCOA);
		welcomeCOA.isDisplayed();
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(welcomeCOA));
		addCOAbutton.isDisplayed();
		accountsLabel.isDisplayed();
		filters.isDisplayed();
		summary.isDisplayed();
//		selectAllCheckbox.isDisplayed();
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
	public void enterAccountDetails(String name, String code, String type, String desc) throws InterruptedException {
		WDWait(accountType);
		accountType.sendKeys(type);
		sAssert.assertTrue(accountType.isDisplayed(),"Verify account type list");
		Thread.sleep(2000);
//		accountType.click();
		bank.isDisplayed();
//		cash.isDisplayed();
//		costOfGoodsSold.isDisplayed();
//		nonCurrentAssets.isDisplayed();
//		nonCurrentLiabilities.isDisplayed();
//		income.isDisplayed();
//		currentAssets.isDisplayed();
//		currentLiabilities.isDisplayed();
//		equity.isDisplayed();
//		expenses.isDisplayed();
//		otherExpenses.isDisplayed();
		bank.click();
		accountCode.sendKeys(code);
		accountName.sendKeys(name);
		description.sendKeys(desc);
	}

	@Step("Click On Save Button")
	public void clickSaveButton() throws InterruptedException {
		WDWait(saveButton);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		
	}
	
	@Step("Verify success message")
	public void verifyCOACreatedSucessMessage() throws InterruptedException {
		WDWait(createCOASuccessMessage);
//		createCOASuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(createCOASuccessMessage));
		createCOASuccessMessage.isDisplayed();

	}
	
}

