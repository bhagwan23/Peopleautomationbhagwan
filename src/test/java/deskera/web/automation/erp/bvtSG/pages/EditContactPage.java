package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class EditContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public EditContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);

		
	}

	/******************************* EDIT CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	@CacheLookup

	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Edit')]")
	
	private WebElement editButton;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	
	private WebElement name;
	@FindBy(xpath= "//input[@formcontrolname='email']")
	
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@formcontrolname='uen']")
	
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@formcontrolname='tax']")
	
	private WebElement taxNumber;
	
	@FindBy(xpath= "//div[contains(text(),'Address')]")
	
	private WebElement address;
	@FindBy(xpath= "//textarea[@formcontrolname='address1']")
	
	private WebElement enterAddress;
	@FindBy(xpath= "//input[@formcontrolname='state']")
	
	private WebElement state;
	@FindBy(xpath= "//input[@formcontrolname='postalCode']")
	
	private WebElement postalCode;
	@FindBy(xpath= "//input[@formcontrolname='city']")
	
	private WebElement city;
	@FindBy(xpath= "//input[@formcontrolname='country']")
	
	private WebElement country;
	
	@FindBy(xpath= "//span[@class='field-value add-address']")
	@CacheLookup
	private WebElement addAnotherAddress;

	@FindBy(xpath= "//div[contains(text(),'Current Billing Address')]")
	@CacheLookup
	private WebElement currentBillingAddress;

	@FindBy(xpath= "//div[contains(text(),'Current Shipping Address')]")
	@CacheLookup
	private WebElement currentShippingAddress;
	
	@FindBy(xpath= "//span[contains(text(),'Save Changes')]")
	
	private WebElement saveChangeButton;
	
	@FindBy(xpath= "//span[text()='Contact is successfully Updated']")
	
	private WebElement updateContactSuccessMessage;
	
	/******************************* Verify edited contact objects *******************/
	
	@FindBy(xpath= "//input[@placeholder='Search Records']")
	
	private WebElement searchRecord;
	@FindBy(xpath= "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]")
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
	@FindBy(xpath="//div[contains(text(),'Currency')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement contactCurrency;
	@FindBy(xpath= "//div[contains(text(),'Purchase Account')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement accPayable;
	@FindBy(xpath= "//div[contains(text(),'Sales Account')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement accReceivable;
	@FindBy(xpath="//div[@class='section-container py-4']//div[4]//div[1]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement buyPaymentTerm;
	@FindBy(xpath="//div[@class='section-container py-4']//div[7]//div[1]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement sellPaymentTerm;
	@FindBy(xpath="//*[@id='container-1']/dt-navbar/div/div[1]/button/div/span")
	@CacheLookup
	private WebElement companyOrg;
	@FindBy(xpath="//div[contains(text(),'Contact Organisation')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement contactOrg;
	String organization;

	/*******************************Edit Contacts Object Manipulation Methods *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("Search contact to edit")
	public void searchRecord(String cName) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		Thread.sleep(3000);
		/*Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();*/
		
	}
	@Step("Click on Context Menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		WDWait(contextMenuIcon);
		contextMenuIcon.isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
		Thread.sleep(3000);
		contextMenuIcon.click();
		Thread.sleep(4000);
	}
	@Step("Click on Edit button")
	public void clickEditButton() throws InterruptedException{
		
		WDWait(editButton);
		editButton.isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		Thread.sleep(3000);
		editButton.click();	
		
	}
	@Step("Enter new general info")
	public void editGeneralInfo(String cname,String email, String uenno, String taxno){
		WDWait(name);
		name.clear();
		name.sendKeys(cname);
		
		WDWait(emailAddress);
		emailAddress.clear();
		emailAddress.sendKeys(email);
		
		WDWait(contactUEN);
		contactUEN.clear();
		contactUEN.sendKeys(uenno);
		
		WDWait(taxNumber);
		taxNumber.clear();
		taxNumber.sendKeys(taxno);
	}
	@Step("Enter new address info")
	public void editAddressInfo(String addr, String state1,String postal, String city1, String country1){ 
		WDWait(address);
		address.isDisplayed();
		address.click();
		
		WDWait(enterAddress);
		enterAddress.clear();
		enterAddress.sendKeys(addr);
		
		WDWait(state);
		state.clear();
		state.sendKeys(state1);
		
		WDWait(postalCode);
		postalCode.clear();
		postalCode.sendKeys(postal);
		
		WDWait(city);
		city.clear();
		city.sendKeys(city1);
		
		WDWait(country);
		country.clear();
		country.sendKeys(country1);
		
		WDWait(addAnotherAddress);
		addAnotherAddress.isDisplayed();
		
		WDWait(currentBillingAddress);
		currentBillingAddress.isDisplayed();
		
		WDWait(currentShippingAddress);
		currentShippingAddress.isDisplayed();

	}
	@Step("Click on save and change button")
	public void clickSaveChangeButton(){
		WDWait(saveChangeButton);
		saveChangeButton.isDisplayed();
		saveChangeButton.click();
	}
	@Step("Verify success message")
	public void verifysuccessmessage(){
		WDWait(updateContactSuccessMessage);
		updateContactSuccessMessage.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(updateContactSuccessMessage));

	}
	@Step("Verify copied contact")
	public void verifyEditedContact(String cName, String UENNumber, String TAXNumber, String currency, String paymentTerms) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		
		WDWait(enteredName);
		wait.until(ExpectedConditions.elementToBeClickable(enteredName));
		Assert.assertEquals(enteredName.getText(), cName);
		enteredName.click();
		
		Assert.assertEquals(contactName.getText(), cName);
		Assert.assertEquals(uENnumber.getText(), UENNumber);
		Assert.assertEquals(tax.getText(), TAXNumber);
		Assert.assertEquals(contactCurrency.getText(), currency);
		organization= companyOrg.getText();
		Assert.assertEquals(contactOrg.getText(),organization);


		scrollToElement(accPayable);
		wait.until(ExpectedConditions.visibilityOf(accPayable));
		Thread.sleep(5000);
		Assert.assertEquals(accPayable.getText(), "Accounts Payable");
		
		scrollToElement(accReceivable);
		wait.until(ExpectedConditions.visibilityOf(accReceivable));
		Thread.sleep(5000);
		Assert.assertEquals(accReceivable.getText(), "Accounts Receivable");

		Assert.assertEquals(buyPaymentTerm.getText(), paymentTerms);
		Assert.assertEquals(sellPaymentTerm.getText(), paymentTerms);

	}
	@Step("Scroll page")
	public void scrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
}
