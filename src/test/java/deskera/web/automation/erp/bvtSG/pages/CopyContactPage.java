package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class CopyContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public CopyContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* COPY CONTACT PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	@CacheLookup
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Copy')]")
	@CacheLookup
	private WebElement copyButton;
	@FindBy(xpath= "//button[@class='mat-flat-button mat-button-base mat-primary']")
	@CacheLookup
	private WebElement saveButton;
	@FindBy(xpath= "//span[text()='Contact Successfuly Added']")
	@CacheLookup
	private WebElement copyContactSuccessMessage;
	
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/mat-table/mat-row[1]/mat-cell[3]")
	@CacheLookup
	private WebElement enteredName;
	@FindBy(xpath= "//div[contains(text(),'Contact Name')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement contactName;
	@FindBy(xpath= "//div[contains(text(),'Contact UEN')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement uENnumber;
	@FindBy(xpath="//div[contains(text(),'Tax Number')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement tax;
	@FindBy(xpath= "//div[@class='field-value'][contains(text(),'desk')]")
	@CacheLookup
	private WebElement contactOrg;
	@FindBy(xpath= "//div[contains(text(),'Account Payable')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement accPayable;
	@FindBy(xpath= "//div[contains(text(),'Sales Account')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement accReceivable;
	@FindBy(xpath="//input[@id='mat-input-4']")
	@CacheLookup
	private WebElement accountReceivable;
	String buyAccount,sellAccount;
	@FindBy(xpath= "//span[@class='menu-label ng-star-inserted'][contains(text(),'Custom Fields')]")
	@CacheLookup
	private WebElement customField;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	@CacheLookup
	private WebElement customCancelButton;
	@FindBy(xpath= "//div[contains(text(),'Currency')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement currency;
	
	/******************************Copy Contacts Object Manipulation Methods *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("Click on Context menu icon")
	public void clickContextMenuIcon(){
		WDWait(contextMenuIcon);
		contextMenuIcon.isDisplayed();
		contextMenuIcon.click();
	}
	@Step("Click on copy button")
	public void clickCopyButton(){
		WDWait(copyButton);
		copyButton.isDisplayed();
		copyButton.click();
	}
	@Step("Click on Save button")
	public void clickSaveButton(){
		WDWait(saveButton);
		saveButton.isDisplayed();
		saveButton.click();
	}
	@Step("Verify success message")
	public void verifysuccessmessage(){
		WDWait(copyContactSuccessMessage);
		copyContactSuccessMessage.isDisplayed();
	}
	@Step("Verify copied contact")
	public void verifyCopiedContact(String cName, String UENNumber, String TAXNumber){
		WDWait(enteredName);
		Assert.assertEquals(enteredName.getText(), cName);
		//wait.until(ExpectedConditions.visibilityOf(enteredName));
		enteredName.isDisplayed();
		enteredName.click();
		
		Assert.assertEquals(contactName.getText(), cName);
		Assert.assertEquals(uENnumber.getText(), UENNumber);
		Assert.assertEquals(tax.getText(), TAXNumber);
		
		contactOrg.isDisplayed();
		Assert.assertEquals(currency.getText(), "SGD");
		
		scrollToElement(accPayable);
		wait.until(ExpectedConditions.visibilityOf(accPayable));
		Assert.assertEquals(accPayable.getText(), buyAccount);
		scrollToElement(accountReceivable);
		Assert.assertEquals(accountReceivable.getText(), sellAccount);
		
		WDWait(customField);
		customField.isDisplayed();
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
		customCancelButton.click();
		}
	@Step("Scroll page")
	public void scrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
}
