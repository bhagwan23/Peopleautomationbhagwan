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

import io.qameta.allure.Step;

public class ContactsPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public ContactsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* CONTACTS PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[text()=' Contacts ']")
	@CacheLookup
	private WebElement contactsButton;
	@FindBy(xpath ="//span[contains(text(),'Add Contact')]")
	@CacheLookup
	private WebElement  addContactButton;
	@FindBy(xpath= "//button[@class='mat-long-button mat-flat-button mat-button-base mat-primary']")
	@CacheLookup
	private WebElement newContactButton;
	@FindBy(xpath= "//span[contains(.,'Start by Adding or Importing Your Contacts')]")
	@CacheLookup
	private List<WebElement> startByAddingOrImportingYourContacts;

	private static String pageTitleText = "Deskera Books";


	/******************************* ADD CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//div[contains(text(),'General Info')]")
	@CacheLookup
	private WebElement generalInfotab;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	@CacheLookup
	private WebElement name;
	@FindBy(xpath= "//input[@formcontrolname='email']")
	@CacheLookup
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@formcontrolname='uen']")
	@CacheLookup
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@formcontrolname='tax']")
	@CacheLookup
	private WebElement taxNumber;
	@FindBy(xpath= "//div[@class='currency-dropdown-code']")
	@CacheLookup
	private WebElement currency;
	@FindBy(xpath= "//input[@name='sequenceValue']")
	@CacheLookup
	private WebElement autoNumberingFormat;

	@FindBy(xpath="//div[contains(text(),'Accounting')]")
	@CacheLookup
	private WebElement accountingtab;
	@FindBy(xpath= "//p[contains(text(),'Payment Terms')]")
	@CacheLookup
	private WebElement paymentTerms;
	@FindBy(xpath= "//div[@class='mat-form-field-infix']/mat-select[@formcontrolname='paymentTermCode']")
	@CacheLookup
	private WebElement paymentTermsList;

	@FindBy(xpath="//span[contains(text(),'NET 0')]")
	@CacheLookup
	private WebElement selectNET0;
	@FindBy(xpath="//span[contains(text(),'NET 10')]")
	@CacheLookup
	private WebElement selectNET10;
	@FindBy(xpath="//span[contains(text(),'NET 15')]")
	@CacheLookup
	private WebElement selectNET15;
	@FindBy(xpath= "//span[@class='mat-option-text'][contains(text(),'NET 30')]")
	@CacheLookup
	private WebElement selectNET30;
	@FindBy(xpath= "//span[contains(text(),'NET 45')]")
	@CacheLookup
	private WebElement selectNET45;

	@FindBy(xpath= "//div[contains(text(),'Address')]")
	@CacheLookup
	private WebElement address;
	@FindBy(xpath= "//textarea[@formcontrolname='address1']")
	@CacheLookup
	private WebElement enterAddress;
	@FindBy(xpath= "//input[@formcontrolname='state']")
	@CacheLookup
	private WebElement state;
	@FindBy(xpath= "//input[@formcontrolname='postalCode']")
	@CacheLookup
	private WebElement postalCode;
	@FindBy(xpath= "//input[@formcontrolname='city']")
	@CacheLookup
	private WebElement city;
	@FindBy(xpath= "//input[@formcontrolname='country']")
	@CacheLookup
	private WebElement country;
	@FindBy(xpath= "//button[@class='mat-flat-button mat-button-base mat-primary']")
	@CacheLookup
	private WebElement saveButton;
	@FindBy(xpath= "//div//i[contains(@class,'fa-times close-button m')]//self::i[1]")
	@CacheLookup
	private WebElement cancel;
	@FindBy(xpath= "(//input[@aria-autocomplete='list'])[1]")
	@CacheLookup
	private WebElement accountPayable;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[2]")
	@CacheLookup
	private WebElement accountReceivable;
	
	@FindBy(xpath= "//span[text()='Contact Successfuly Added']")
	@CacheLookup
	private WebElement createContactSuccessMessage;
	
	/******************************* Verify Added contacts elements *******************/

	@FindBy(xpath= "//mat-cell[contains(text(),'Edward')]")
	@CacheLookup
	private WebElement addedContactName;
	@FindBy(xpath= "//div[contains(text(),'Contact Name')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement contactName;
	@FindBy(xpath= "//div[contains(text(),'Contact UEN')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement uENnumber;
	@FindBy(xpath="//div[contains(text(),'Tax Number')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement tax;
	@FindBy(xpath= "//div[contains(text(),'Purchase Account')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement accPayable;
	@FindBy(xpath= "//div[contains(text(),'Sales Account')]/following-sibling::div[@class='field-value']")
	@CacheLookup
	private WebElement accReceivable;


	@FindBy(xpath= "//div[contains(text(),'Edward')]")
	@CacheLookup
	private WebElement enteredContactName;
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/mat-table/mat-row[1]/mat-cell[3]")
	@CacheLookup
	private WebElement enteredName;
	
	@FindBy(xpath= "//span[@class='menu-label ng-star-inserted'][contains(text(),'Custom Fields')]")
	@CacheLookup
	private WebElement customField;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	@CacheLookup
	private WebElement customCancelButton;
	@FindBy(xpath= "//span[contains(text(),'Custom Number Format')]")
	@CacheLookup
	private WebElement customNumberFormat;
	@FindBy(xpath= "//span[contains(text(),'Cancel')]")
	@CacheLookup
	private WebElement cusomNumberFormatCancelButton;
	
	@FindBy(xpath= "//div[@class='field-value'][contains(text(),'desk')]")
	@CacheLookup
	private WebElement contactOrg;
	@FindBy(xpath="//div[contains(text(),'UEN989888898')]")
	@CacheLookup
	private WebElement enteredUEN;
	@FindBy(xpath= "//div[contains(text(),'SGD')]")
	@CacheLookup
	private WebElement enteredCurrency;
	@FindBy(xpath= "//div[contains(text(),'XYZ1234')]")
	@CacheLookup
	private WebElement enteredTaxNumber;
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
	
	@FindBy(xpath= "//button[@class='cancel-btn mat-icon-button mat-button-base mat-primary']//mat-icon[@class='mat-icon notranslate mat-icon-no-color']//*[local-name()='svg']")
	@CacheLookup
	private WebElement contactBackButton;
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/div[2]/div[2]/div[1]/span[2]")
	@CacheLookup
	private WebElement allSummaryCount;
	
	/******************************* Contacts Object Manipulation Methods *******************/
	@Step("Open URl")
	public void openURL(String URL) {
		driver.get(URL);
	}
	@Step("Verify page title")
	public void verifyPageTitle() {
		//Assert.assertEquals(driver.getTitle(), pageTitleText);
	}
	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("verify contact elements")
	public void verifyContactElements(){
		WDWait(contactsButton);
		contactsButton.isDisplayed();

	}
	@Step("Click on contact button")
	public void clickContactsButton() throws InterruptedException{
		WDWait(contactsButton);
		contactsButton.click(); 
		clickPopup();
		//Thread.sleep(3000);
	}
	@Step("close popup on contacts page")
	public void clickPopup() throws InterruptedException{	
		//driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Contacts ']"))); // Contact // link                                                                                                            // or                                                                                                            // Produ                                                                                                            // link
		driver.findElement(By.xpath("//span[text()=' Contacts ']")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found clickin on new Contact Button");
				break;
			}
			try {
				if (driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).isDisplayed()) {
					System.out.println("closig popup now 1");
					driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click(); //popup close button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		// driver.findElement(By.xpath("//button[3]/span")).click(); // Create new contact button

	}
	@Step("click on new contact button")
	public void clickAddContactButton(){
		WDWait(newContactButton);
		newContactButton.isDisplayed();
		newContactButton.click();
		
		WDWait(customNumberFormat);
		customNumberFormat.isDisplayed();
		customNumberFormat.click();
		WDWait(cusomNumberFormatCancelButton);
		cusomNumberFormatCancelButton.isDisplayed();
		cusomNumberFormatCancelButton.click();
		WDWait(customField);
		customField.isDisplayed();
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
		customCancelButton.click();
		
		/*WDWait(addContactButton);   //Add contacts through Add Contact button
		addContactButton.isDisplayed();
		addContactButton.click();*/
		
		WDWait(generalInfotab);
		generalInfotab.isDisplayed();
		generalInfotab.click();

	}
	@Step("Enter general info")
	public void enterGeneralInfo(String Cname, String email, String UEN, String tax){
		WDWait(name);
		//wait.until(ExpectedConditions.elementToBeClickable(name));
		name.isDisplayed();
		name.sendKeys(Cname);
		WDWait(emailAddress);
		emailAddress.sendKeys(email);
		WDWait(contactUEN);
		contactUEN.sendKeys(UEN);		
		WDWait(taxNumber);
		taxNumber.sendKeys(tax);
		currency.isDisplayed();
		Assert.assertEquals(currency.getText(), "Singapore Dollar (SGD)");
		autoNumberingFormat.isDisplayed();

		WDWait(saveButton);
		saveButton.isDisplayed();
	}
	@Step("Enter account details")
	public void enterAccountingDetails(){
		WDWait(accountingtab);
		accountingtab.isDisplayed();
		accountingtab.click();
		paymentTerms.isDisplayed();
		Assert.assertEquals(paymentTermsList.getText(), "NET 30");

		WDWait(paymentTermsList);
		paymentTermsList.isDisplayed();
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
	}
	@Step("Click on save button")
	public void clickSaveButton(){
		saveButton.click();
	}
	@Step("Verify added contacts")
	public void verifyAddedContacts(String cName, String UENNumber, String TAXNumber) throws InterruptedException{
		/*WDWait(addedContactName);
		addedContactName.isDisplayed();
		addedContactName.click();
		enteredContactName.isDisplayed();
		contactName.isDisplayed();*/

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
		
		scrollToElement(accPayable);
		wait.until(ExpectedConditions.visibilityOf(accPayable));
		Thread.sleep(4000);
		Assert.assertEquals(accPayable.getText(), buyAccount);
		scrollToElement(accReceivable);
		wait.until(ExpectedConditions.visibilityOf(accReceivable));
		Thread.sleep(4000);
		Assert.assertEquals(accReceivable.getText(), sellAccount);
		
		contactOrg.isDisplayed();
		WDWait(customField);
		customField.isDisplayed();
		customField.click();
		WDWait(customCancelButton);
		customCancelButton.isDisplayed();
		customCancelButton.click();
		//enteredNumber.isDisplayed();
		//enteredUEN.isDisplayed();
		enteredCurrency.isDisplayed();
		enteredTaxNumber.isDisplayed();
		//enteredpurchaseAccount.isDisplayed();
		//enteredPaymentTerms.isDisplayed();
		contactBackButton.isDisplayed();
		contactBackButton.click();
	}
	@Step("Verify success message")
	public void verifyContactCreatedSucessMessage(){
		WDWait(createContactSuccessMessage);
		createContactSuccessMessage.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(createContactSuccessMessage));

	}
	@Step("Verify summary count")
	public void allSummaryCount(){
		WDWait(allSummaryCount);
		allSummaryCount.isDisplayed();
	    Assert.assertEquals(allSummaryCount.getText(), "2");

	}
	@Step("Scroll page")
	public void scrollToElement(WebElement element)
	{

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
}
