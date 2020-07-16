package deskera.web.automation.erp.bvtSG.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class AccountingPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	
	public AccountingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);
	}
	
	/*******************************
	 Credit Note  PAGE ELEMENTS LOCATORS
	 ***********************************/
	@FindBy(xpath = "//span[contains(.,'Credit Notes')]")
	private WebElement creditNoteButton;
	@FindBy(xpath = "//span[contains(text(),'CREATE CREDIT NOTE')]")
	private WebElement createCreditNoteButton;
	@FindBy(xpath = "//span//span[contains(text(),'CANCEL ')]")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[contains(.,'SAVE')]")
	private WebElement saveButton;
	@FindBy(xpath = "//input[@name='contactComboData']")
	private WebElement contactDropdown;
	@FindBy(xpath = "//div[@role='listbox']//following::div[2]//span")
	private WebElement firstContact;
	@FindBy(xpath = "//wtf2-select[@name='currencyid']//div//span//span[contains(.,'Dollar (SGD)')]")
	private WebElement currencyDropdown;
	@FindBy(xpath = "//span[@class='contact-name ng-star-inserted']")
	private WebElement contactName;
	@FindBy(xpath = "//input[@name='accountComboData']")
	private WebElement accountDropdown;
	@FindBy(xpath = "//div[@role='listbox']//following::div[2]//span[2]")
	private WebElement firstAccount;
	@FindBy(xpath = "(//span[contains(@class,'currency-main')])[1]")
	private WebElement amountTextArea;
	@FindBy(xpath = "(//input[contains(@ng-reflect-name,'amountControl')])[1]")
	private WebElement amountTextBox;
	@FindBy(xpath = "//span[text()='Credit Note Saved Successfully']")
	private WebElement createCreditNoteSuccessMessage;
	@FindBy(xpath = "//span[@class='price-current ng-star-inserted']//span[1]")
	private WebElement displayedAmount;
	@FindBy(xpath = "//div[@class='org-avatar ng-star-inserted']")
	private WebElement userProfileIcon;
	@FindBy(xpath = "//mat-icon[@role='img' and @svgicon='collapse']")
	private WebElement collapseIcon;
	private static String pageTitleText = "Deskera Books";
	
	
	/*********************************************************
	 Deposit PAGE ELEMENTS LOCATORS
	 *********************************************************/
	@FindBy(xpath = "//span[contains(.,'Deposit')]")
	private WebElement depositButton;
	@FindBy(xpath = "//span[contains(text(),'CREATE')]")
	private WebElement createButton;
	@FindBy(xpath = "//span[contains(.,'ADVANCE PAYMENT')]")
	private WebElement advancePaymentButton;
	@FindBy(xpath = "//wtf2-select[@name='contact']")
	private WebElement contactListBox;
	@FindBy(xpath = "//span[@class='wtf2-option-text']")
	private WebElement contact1FromListBox;
	@FindBy(xpath = "//div[@class='wtf2-select-value']//span[contains(.,'Deposit To')]")
	private WebElement depositToDropdown;
	@FindBy(xpath = "//span[contains(.,'Cash (SGD)')]")
	private WebElement cashDropdownOption;
	@FindBy(xpath = "//input[@placeholder='Payment Date']")
	private WebElement paymentDate;
	@FindBy(xpath = "//button[contains(.,' Save ')]")
	private WebElement saveButtonOnAdvancePayment;
	@FindBy(xpath = "(//span[contains(@class,'price-current ng-star-inserted')]//span[1])[3]")
	private WebElement amountPaid;
	

	/*********************************************************
	 * Credit Note Page objects manipulation methods
	 *********************************************************/
	@Step("Verify Accounting Page Title")
	public void verifyPageTitle() throws InterruptedException {
		sAssert.assertEquals(driver.getTitle(), pageTitleText);
		sAssert.assertAll();
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Click on Credit Note Option")
	public void clickCreditNote(){
		WDWait(creditNoteButton);
		creditNoteButton.click();
	}
	
	@Step("Click on Create Credit Note Button")
	public void clickCreateCreditNote(){
		wait.until(ExpectedConditions.elementToBeClickable(createCreditNoteButton));
		createCreditNoteButton.click();
	}
	
	@Step("Select Contact")
	public void selectContact(String contactName) {
		wait.until(ExpectedConditions.elementToBeClickable(contactDropdown));
		contactDropdown.click();
		contactDropdown.sendKeys(contactName);
		wait.until(ExpectedConditions.elementToBeClickable(firstContact));
		firstContact.click();
	}
	
	@Step("Verify Currency")
	public void verifyCurrency() throws InterruptedException{
		Thread.sleep(2000);
		WDWait(currencyDropdown);
		currencyDropdown.isDisplayed();
	}
	
	@Step("Verify Create Credit Note Page Elements")
	public void verifyCreateCreditNotePageElements(){
		
	}
	
	@Step("Select Account")
	public void selectAccount(){
		Actions action = new Actions(driver);
		action.moveToElement(accountDropdown).build().perform();
		WDWait(accountDropdown);
		accountDropdown.click();
		accountDropdown.sendKeys("ACC");
		wait.until(ExpectedConditions.elementToBeClickable(firstAccount));
		firstAccount.click();		
	}
	
	@Step("Enter Amount")
	public void enterAmount(String creditNoteAmount) throws InterruptedException{
		//WDWait(amountTextBox);
		wait.until(ExpectedConditions.elementToBeClickable(amountTextArea));
		amountTextArea.click();
	    WDWait(amountTextBox);
		amountTextBox.sendKeys(creditNoteAmount);
	}
	
	@Step("Click On Save Button")
	public void clickSaveButton(){
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
		WDWait(saveButton);
		saveButton.click();		
	}
	
	@Step("Verify Create Credit Note Success Message")
	public void verifyCreateCreditNoteSuccessMessage() throws InterruptedException{
		WDWait(createCreditNoteSuccessMessage);	
		createCreditNoteSuccessMessage.isDisplayed();
		Thread.sleep(3000);
	}
	
	@Step("Verify DIsplayed Amount")
	public void verifyDisplayedAmount(String creditNoteAmount) throws InterruptedException {
		WDWait(displayedAmount);
		String Amount=displayedAmount.getText();
		String shownAmount=String.valueOf(Amount.replaceAll("[^0-9.]", "")); 
		sAssert.assertEquals(shownAmount,creditNoteAmount);	
		sAssert.assertAll();
	}
	
	@Step("Click On Collapse Icon")
	public void clickCollapseIcon() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(userProfileIcon).build().perform();
		WDWait(collapseIcon);
		collapseIcon.click();
		Thread.sleep(2000);
	}	
	
	/*********************************************************
	 * Deposit Page objects manipulation methods
	 *********************************************************/
	@Step("Click on Deposit  Button")
	public void clickDepositButton(){
		wait.until(ExpectedConditions.elementToBeClickable(depositButton));
		depositButton.click();
	}
	
	@Step("Click on Advance Payment Button")
	public void clickAdvancePaymentButton(){
		wait.until(ExpectedConditions.elementToBeClickable(createButton));
		createButton.click();
		WDWait(advancePaymentButton);
		advancePaymentButton.click();
	}
	
	@Step("Select Contact for Make Payment")
	public void selectContactForMakePayment(String contactName){
		WDWait(contactListBox);
		contactListBox.click();
		WDWait(contact1FromListBox);
		contact1FromListBox.click();
	}
	
	@Step("Select Cash Option from Deposit To dropdown")
	public void selectCashOptionFromDepositToDropdown(){
		WDWait(depositToDropdown);
		depositToDropdown.click();
		WDWait(cashDropdownOption);
		cashDropdownOption.click();
	}
	
	@Step("Enter Payment Date")
	public void enterPaymentDate(){
		WDWait(paymentDate);
		paymentDate.clear();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		paymentDate.sendKeys(dtf.format(now));	
	}
	
	@Step("Click On Save Button On Advance Payment Page")
	public void clickSaveButtonOnAdvancePayment(){
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		WDWait(saveButtonOnAdvancePayment);
		saveButtonOnAdvancePayment.click();		
	}
	
	@Step("Verify Amount Paid ")
	public void verifyAmountPaid(String makePaymentAmount) throws InterruptedException {
		WDWait(amountPaid);
		String Amount=amountPaid.getText();
		String shownAmount=String.valueOf(Amount.replaceAll("[^0-9.]", "")); 
		sAssert.assertEquals(shownAmount,makePaymentAmount);	
		sAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
