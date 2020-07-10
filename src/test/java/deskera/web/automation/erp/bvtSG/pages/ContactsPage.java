package deskera.web.automation.erp.bvtSG.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class ContactsPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public ContactsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}

	/******************************* CONTACTS PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[text()=' Contacts ']")
	
	private WebElement contactsButton;

	@FindBy(xpath ="//span[contains(text(),'Add Contact')]")
	
	private WebElement  addContactButton;
	@FindBy(xpath= "//button[@class='mat-long-button mat-flat-button mat-button-base mat-primary']")
	
	private WebElement newContactButton;
	@FindBy(xpath= "//span[contains(.,'Start by Adding or Importing Your Contacts')]")
	
	private List<WebElement> startByAddingOrImportingYourContacts;

	private static String pageTitleText = "Deskera Books";
	
	@FindBy(css = "	i.fas.fa-times.close-button.mt-2")
	
	private WebElement closeOverlayPopup;
	


	/******************************* ADD CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//div[contains(text(),'General Info')]")
	
	private WebElement generalInfotab;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	
	private WebElement name;
	@FindBy(xpath= "//input[@formcontrolname='email']")
	
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@formcontrolname='uen']")
	
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@formcontrolname='tax']")
	
	private WebElement taxNumber;
	@FindBy(xpath= "//div[@class='currency-dropdown-code']")
	
	private WebElement currency;
	@FindBy(xpath= "//input[@name='sequenceValue']")
	
	private WebElement autoNumberingFormat;

	@FindBy(xpath="//div[contains(text(),'Accounting')]")
	
	private WebElement accountingtab;
	@FindBy(xpath= "//p[contains(text(),'Payment Terms')]")
	
	private WebElement paymentTerms;
	@FindBy(xpath= "//div[@class='mat-form-field-infix']/mat-select[@formcontrolname='paymentTermCode']")
	
	private WebElement paymentTermsList;

	@FindBy(xpath="//span[contains(text(),'NET 0')]")
	
	private WebElement selectNET0;
	@FindBy(xpath="//span[contains(text(),'NET 10')]")
	
	private WebElement selectNET10;
	@FindBy(xpath="//span[contains(text(),'NET 15')]")
	
	private WebElement selectNET15;
	@FindBy(xpath= "//span[@class='mat-option-text'][contains(text(),'NET 30')]")
	
	private WebElement selectNET30;
	@FindBy(xpath= "//span[contains(text(),'NET 45')]")
	
	private WebElement selectNET45;

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
	@FindBy(xpath="//div[contains(text(),'Set as Current Billing Address')]")
	@CacheLookup	
	private WebElement setAsCurrentBillingAddress;
	@FindBy(xpath="//div[contains(text(),'Set as Current Shipping Address')]")
	@CacheLookup
	private WebElement setAsCurrentShippingAddress;
	@FindBy(xpath="//span[@class='field-value add-address']")
	@CacheLookup
	private WebElement addAnotherAddress;
	@FindBy(xpath= "//button[@class='mat-flat-button mat-button-base mat-primary']")
	
	private WebElement saveButton;
	@FindBy(xpath= "//div//i[contains(@class,'fa-times close-button m')]//self::i[1]")
	
	private WebElement cancel;
	@FindBy(xpath= "(//input[@aria-autocomplete='list'])[1]")
	
	private WebElement accountPayable;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[2]")
	
	private WebElement accountReceivable;

	@FindBy(xpath= "//span[text()='Contact Successfuly Added']")
	
	private WebElement createContactSuccessMessage;

	/******************************* Verify Added contacts elements *******************/


	@FindBy(xpath= "//mat-cell[contains(text(),'Edward')]")
	
	private WebElement addedContactName;
	@FindBy(xpath= "//div[contains(text(),'Contact Name')]/following-sibling::div[@class='field-value']")
	
	private WebElement contactName;
	@FindBy(xpath= "//div[contains(text(),'Contact UEN')]/following-sibling::div[@class='field-value']")
	
	private WebElement uENnumber;
	@FindBy(xpath="//div[contains(text(),'Tax Number')]/following-sibling::div[@class='field-value']")
	
	private WebElement tax;
	@FindBy(xpath="//div[contains(text(),'Currency')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement contactCurrency;
	@FindBy(xpath= "//div[contains(text(),'Purchase Account')]/following-sibling::div[@class='field-value']")
	
	private WebElement accPayable;
	@FindBy(xpath= "//div[contains(text(),'Sales Account')]/following-sibling::div[@class='field-value']")
	
	private WebElement accReceivable;
	@FindBy(xpath="//div[@class='section-container py-4']//div[4]//div[1]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement buyPaymentTerm;
	@FindBy(xpath="//div[@class='section-container py-4']//div[7]//div[1]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement sellPaymentTerm;

	@FindBy(xpath= "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]")
	@CacheLookup
	private WebElement enteredName;
	
	@FindBy(xpath="//*[@id='container-1']/dt-navbar/div/div[1]/button/div/span")
	@CacheLookup
	private WebElement companyOrg;
	@FindBy(xpath="//div[contains(text(),'Contact Organisation')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement contactOrg;
	
	@FindBy(xpath="//div[contains(text(),'Accounts Receivable')]")
	@CacheLookup
	private WebElement enteredpurchaseAccount;
	@FindBy(xpath= "//div[@class='section-container py-4']//div[4]//div[2]")
	@CacheLookup
	private WebElement enteredPaymentTerms;
	String buyAccount,sellAccount;

	@FindBy(xpath= "//input[@placeholder='Search Records']")
	@CacheLookup
	private WebElement searchRecord;
	
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/div[2]/div[2]/div[1]/span[2]")
	@CacheLookup
	private WebElement allSummaryCount;
	
	String organization;
	
	/******************************* Custom Number Format Objects 	*******************************/

	@FindBy(xpath= "//span[@class='menu-label ng-star-inserted'][contains(text(),'Custom Fields')]")
	
	private WebElement customField;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	
	private WebElement customCancelButton;
	@FindBy(xpath= "//span[contains(text(),'Custom Number Format')]")
	
	private WebElement customNumberFormat;

	@FindBy(xpath = "//mat-label[contains(.,'Preview')]")
	@CacheLookup
	private WebElement previewLabel;
	@FindBy(xpath = "//div//div[contains(@class,'result mt')]")
	@CacheLookup
	private WebElement previewBox;
	@FindBy(xpath = "//input[@placeholder='Enter prefix']")
	@CacheLookup
	private WebElement prefixTextBox;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[2]")
	@CacheLookup
	private WebElement separatorDropdown;
	@FindBy(xpath = "//input[@placeholder='Enter display digits']")
	@CacheLookup
	private WebElement displayDigits;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[3]")
	@CacheLookup
	private WebElement separatorDropdownAfterDigits;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter suffix')]")
	@CacheLookup
	private WebElement suffixTextBox;
	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']//following::span[contains(.,'Set as Default ')]")
	@CacheLookup
	private WebElement setAsDefault;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	@CacheLookup
	private WebElement cusomNumberFormatCancelButton;
	@FindBy(xpath = "(//button[contains(.,'Save')])[2]")
	@CacheLookup
	private WebElement customNumberFormatSaveButton;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	@CacheLookup
	private WebElement hyphen;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	@CacheLookup
	private WebElement hypenAfterDigits;
	@FindBy(xpath = "//input[contains(@placeholder,'Auto-Numbering Format')]")
	@CacheLookup
	private WebElement autoNumberingformat;
	@FindBy(xpath = "//div[@class='section-container pb-4']//div[3]//div[1]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement displayedNumber;
	String customFormatNumber="U-0001-R";



	/******************************* Contacts Object Manipulation Methods *******************/
	@Step("Open URl")
	public void openURL(String URL) {
		driver.get(URL);
	}
	@Step("Verify page title")
	public void verifyPageTitle() {
	Assert.assertEquals(driver.getTitle(), pageTitleText);
	}
	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("verify contact elements")
	public void verifyContactElements(){
		WDWait(contactsButton);
		sAssert.assertTrue(contactsButton.isDisplayed(),"Verify Contact Section link");

	}
	@Step("Click on contact button")
	public void clickContactsButton() throws InterruptedException{
		WDWait(contactsButton);
		contactsButton.click(); 
		clickPopup();
	}
	@Step("close popup on contacts page")
	public void clickPopup() throws InterruptedException{	
		//driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		WDWait(contactsButton);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Contacts ']"))); // Contact // link                                                                                                            // or                                                                                                            // Produ                                                                                                            // link
		//driver.findElement(By.xpath("//span[text()=' Contacts ']")).click();
		contactsButton.click();
		Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found!");
				break;
			}
			try {
				if (closeOverlayPopup.isDisplayed()) {
					System.out.println("closig popup now 1");
					closeOverlayPopup.click(); //popup close button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	@Step("click on new contact button")
	public void clickAddContactButton(){
		WDWait(newContactButton);
		sAssert.assertTrue(newContactButton.isDisplayed(),"Verify New Contact Button");
		newContactButton.click();

		
		/*
=======

		WDWait(customNumberFormat);
		sAssert.assertTrue(customNumberFormat.isDisplayed(),"Verify Custom Number format option");
		customNumberFormat.click();
>>>>>>> master
		WDWait(cusomNumberFormatCancelButton);
		sAssert.assertTrue(cusomNumberFormatCancelButton.isDisplayed(),"");
		cusomNumberFormatCancelButton.click();
		WDWait(customField);
		sAssert.assertTrue(customField.isDisplayed(),"Verify Custom filed option");
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
<<<<<<< HEAD
		customCancelButton.click();*/
		

		WDWait(generalInfotab);
		sAssert.assertTrue(generalInfotab.isDisplayed(),"Veify generalInfotab");
		generalInfotab.click();
		
		sAssert.assertAll();

	}
	@Step("Enter general info")
	public void enterGeneralInfo(String Cname, String email, String UEN, String tax){
		WDWait(name);

		//wait.until(ExpectedConditions.elementToBeClickable(name));
		sAssert.assertTrue(name.isDisplayed(),"");
		name.sendKeys(Cname);
		WDWait(emailAddress);
		emailAddress.sendKeys(email);
		WDWait(contactUEN);
		contactUEN.sendKeys(UEN);		
		WDWait(taxNumber);
		taxNumber.sendKeys(tax);
		sAssert.assertTrue(currency.isDisplayed(),"Verify currency");
		Assert.assertEquals(currency.getText(), "Singapore Dollar (SGD)");
		sAssert.assertTrue(autoNumberingFormat.isDisplayed(),"Verify autoNumberingFormat");

		WDWait(saveButton);
		sAssert.assertTrue(saveButton.isDisplayed(),"Verify saveButton");
		sAssert.assertAll();

	}
	@Step("Enter account details")
	public void enterAccountingDetails(){
		WDWait(accountingtab);
		sAssert.assertTrue(accountingtab.isDisplayed(),"Verify accountingtab");
		accountingtab.click();
		sAssert.assertTrue(paymentTerms.isDisplayed(),"Verify paymentTerms");
		sAssert.assertEquals(paymentTermsList.getText(), "NET 30");

		WDWait(paymentTermsList);
		sAssert.assertTrue(paymentTermsList.isDisplayed(),"Verify paymentTermsList");
		paymentTermsList.click();
		selectNET0.isDisplayed();
		selectNET10.isDisplayed();
		selectNET15.isDisplayed();
		selectNET45.isDisplayed();
		selectNET30.isDisplayed();
		selectNET30.click();

		WDWait(accountPayable);
		accountPayable.isDisplayed();
		buyAccount=accountPayable.getAttribute("value");
		Assert.assertEquals(accountPayable.getAttribute("value"), "Accounts Payable");

		WDWait(accountReceivable);
		accountReceivable.isDisplayed();
		sellAccount=accountReceivable.getAttribute("value");
		Assert.assertEquals(accountReceivable.getAttribute("value"), "Accounts Receivable");
		
		sAssert.assertAll();


	}
	@Step("Verify address details")
	public void addressDetails(){
		WDWait(address);
		address.isDisplayed();
		address.click();
		enterAddress.isDisplayed();
		state.isDisplayed();
		postalCode.isDisplayed();
		city.isDisplayed();
		country.isDisplayed();
		setAsCurrentBillingAddress.isDisplayed();
		setAsCurrentShippingAddress.isDisplayed();
		addAnotherAddress.isDisplayed();
		
		
		sAssert.assertAll();

	}
	@Step("Enter address details")
	public void addAddressDetail(String addr, String state1,String postal, String city1, String country1){ 
		WDWait(enterAddress);
		enterAddress.sendKeys(addr);
		WDWait(state);
		state.sendKeys(state1);
		WDWait(postalCode);
		postalCode.sendKeys(postal);
		WDWait(city);
		city.sendKeys(city1);
		WDWait(country);
		country.sendKeys(country1);
		
		sAssert.assertAll();

	}
	@Step("Click on save button")
	public void clickSaveButton(){
		saveButton.click();
	}
	@Step("Verify added contacts")
	public void verifyAddedContacts(String cName, String UENNumber, String TAXNumber,String currency, String paymentTerms) throws InterruptedException{

		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);

		/*Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();*/

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
		Assert.assertEquals(accPayable.getText(), buyAccount);
		scrollToElement(accReceivable);
		wait.until(ExpectedConditions.visibilityOf(accReceivable));
		Thread.sleep(5000);
		Assert.assertEquals(accReceivable.getText(), sellAccount);
		
		Assert.assertEquals(buyPaymentTerm.getText(), paymentTerms);
		Assert.assertEquals(sellPaymentTerm.getText(), paymentTerms);
		
		
		/*WDWait(customField);
		customField.isDisplayed();
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
		customCancelButton.click();*/
		sAssert.assertAll();


	}
	@Step("Verify success message")
	public void verifyContactCreatedSucessMessage(){
		WDWait(createContactSuccessMessage);
		createContactSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(createContactSuccessMessage));
		sAssert.assertAll();


	}
	@Step("Verify summary count")
	public void allSummaryCountForFirstContact(){
		WDWait(allSummaryCount);
		allSummaryCount.isDisplayed();
	    Assert.assertEquals(allSummaryCount.getText(), "1");

	}
	@Step("Verify summary count")
	public void allSummaryCountForSecondContact(){
		WDWait(allSummaryCount);
		sAssert.assertTrue(allSummaryCount.isDisplayed());
		sAssert.assertEquals(allSummaryCount.getText(), "2","Verify count of 2 contacts displayed for All Summary");
		sAssert.assertAll();
		

	}
	@Step("Clilck on custom number format link")
	public void clickCustomNumberFormat(){
		WDWait(customNumberFormat);
		customNumberFormat.isDisplayed();
		customNumberFormat.click();
	}
	@Step("Verify Custom Number Format Page Elements ")
	public void verifyCustomNumberFormatPageElements() {
		WDWait(previewLabel);
		previewLabel.isDisplayed();
		previewBox.isDisplayed();
		prefixTextBox.isDisplayed();
		separatorDropdown.isDisplayed();
		displayDigits.isDisplayed();
		separatorDropdownAfterDigits.isDisplayed();
		suffixTextBox.isDisplayed();
		setAsDefault.isDisplayed();
		cusomNumberFormatCancelButton.isDisplayed();
		customNumberFormatSaveButton.isDisplayed();
	}
	@Step("Enter Custom Number format details ")
	public void enterCustomNumberFormatDetails() {
		WDWait(prefixTextBox);
		prefixTextBox.sendKeys("U");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdown));
		separatorDropdown.click();
		WDWait(hyphen);
		hyphen.click();
		displayDigits.clear();
		displayDigits.sendKeys("4");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdownAfterDigits));
		separatorDropdownAfterDigits.click();
		WDWait(hypenAfterDigits);
		hypenAfterDigits.click();
		WDWait(suffixTextBox);
		suffixTextBox.sendKeys("C");	
	}
	@Step("Preview Custom Number format")
	public void previewCustomNumberFormat() {
		WDWait(previewBox);
		Assert.assertEquals(previewBox.getText(), customFormatNumber);	
	}
	@Step("Click on Save Button on Custom Number Format Page")
	public void clickSaveCustomNumberFormatButton() throws InterruptedException {
		WDWait(customNumberFormatSaveButton);
		customNumberFormatSaveButton.click();
		//Thread.sleep(4000);
	}
	@Step("Verify Custom Number Format In Contact Number")
	public void verifyCustomNumberFormatInContactNumber() throws InterruptedException {
		WDWait(autoNumberingformat);
		Thread.sleep(5000);
		Assert.assertEquals(autoNumberingformat.getAttribute("value"), customFormatNumber);		
	}
	@Step("Verify Contact Number and Format")
	public void verifyCustomFormatNumber() {
		WDWait(displayedNumber);
		Actions action = new Actions(driver);
		action.moveToElement(displayedNumber).perform();
        Assert.assertEquals(displayedNumber.getText(), customFormatNumber);
	}
	@Step("Scroll page")
	public void scrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
}
