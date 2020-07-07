package deskera.web.automation.erp.bvtSG.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class SellPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public SellPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	

	/******************************* Sell  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//h1[contains(.,'Sell Records')]")
	
	private WebElement sellRecordsText;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Quote Total')]")
	
	private WebElement quoteTotalButton;
	@FindBy(xpath = "//h5[contains(.,'Invoice')]")
	
	private WebElement invoiceTotalButton;
	@FindBy(xpath = "//h5[contains(.,'Archive')]")
	
	private WebElement archiveTotalButton;
	@FindBy(xpath = "//button[contains(.,'Create New')]")
	
	private WebElement exportButton;
	@FindBy(xpath = "//button[contains(.,'Create New')]")
	
	private WebElement createNewButton;
	@FindBy(xpath = "//button[contains(.,'New Quote')]")
	
	private WebElement newQuoteButton;
	@FindBy(xpath = "//button[contains(.,'New Invoice')]")
	
	private WebElement newInvoiceButton;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Number arrow_drop')]")
	
	private WebElement numberColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Contact arrow_drop')]")
	
	private WebElement contactColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Due Date arrow_drop')]")
	
	private WebElement dueDateColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Total Amount')]")
	
	private WebElement totalAmountColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Fulfillment')]")
	
	private WebElement fullfillmentColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]")
	
	private WebElement quickActionsColumn;
	private static String pageTitleText = "Deskera Books";
	

	/******************************* Create New Quote/Invoice  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'Save')]")
	
	private WebElement saveButton;
	@FindBy(xpath = "//h5[contains(.,'Quote Settings')]")
	
	private WebElement quoteSettingText;
	@FindBy(xpath = "//span[contains(.,'Customize Number Format')]")
	
	private WebElement customizeNumberFormat;
	@FindBy(xpath = "//span[contains(.,'Global Custom Fields')]")
	
	private WebElement globalCustomFields;
	@FindBy(xpath = "//span[contains(.,'+ Add a contact')]")
	
	private WebElement addContactButton;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")
	
	private WebElement quoteDate;
	@FindBy(xpath = "//input[@formcontrolname='fulfillmentDate']")
	
	private WebElement receivedInDate;
	@FindBy(xpath = "//input[@formcontrolname='validTillDate']")
	
	private WebElement dueDate;
	@FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
	
	private WebElement firstContact;
	@FindBy(xpath = "//span[contains(.,'+ Add a Line Item')]")
	
	private WebElement addLineItemButton;
	@FindBy(xpath = "(//span[contains(@class,'mat-option-text')])[1]")
	
	private WebElement firstProduct;
	@FindBy(xpath = "//textarea[@placeholder='Description Optional']")
	
	private WebElement descriptionTextArea;
	@FindBy(xpath = "//input[@formcontrolname='productQuantity']")
	
	private WebElement quantityTextBox;
	@FindBy(xpath = "//input[@formcontrolname='unitPrice']")
	
	private WebElement unitPriceTextBox;
	@FindBy(xpath = "//input[@formcontrolname='discountString']")
	
	private WebElement discountTextBox;
	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	
	private WebElement taxTextBox;
	@FindBy(xpath = "(//div[@class='mat-form-field-infix']//div[@class='mat-input-element read-only-value'])[2]")
	
	private WebElement totalAmount;
	
	
	

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	@Step("Verify Sell Page Title")
	public void verifyPageTitle() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	@Step("Verify Sell Page Elements ")
	public void verifySellPageElements () {
		WDWait(sellRecordsText);
		sellRecordsText.isDisplayed();
		createNewButton.isDisplayed();
		quoteTotalButton.isDisplayed();
		invoiceTotalButton.isDisplayed();
		archiveTotalButton.isDisplayed();
		numberColumn.isDisplayed();
		contactColumn.isDisplayed();
		dueDateColumn.isDisplayed();
		totalAmountColumn.isDisplayed();
		fullfillmentColumn.isDisplayed();
		quickActionsColumn.isDisplayed();
	}
	
	@Step("Click On Create New Button and then Click on New Quote")
	public void clickNewQuoteButton() {
		WDWait(createNewButton);
		wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
		createNewButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(newQuoteButton));
		newQuoteButton.click();	
	}
	
	@Step("Verify Create Quote Page Elements ")
	public void verifyCreateQuotePageElements () {
		WDWait(saveButton);
		saveButton.isDisplayed();
		addContactButton.isDisplayed();
		quoteDate.isDisplayed();
		receivedInDate.isDisplayed();
		dueDate.isDisplayed();
		addLineItemButton.isDisplayed();
		quoteSettingText.isDisplayed();
		customizeNumberFormat.isDisplayed();
		globalCustomFields.isDisplayed();
	}
	
	
	
	
	@Step("Select Contact")
	public void selectContact() {
		wait.until(ExpectedConditions.elementToBeClickable(addContactButton));
		addContactButton.click();	
		WDWait(firstContact);
		firstContact.click();
	}
	
	@Step("Verify Quote Date, Ship By Date , Valid till Date ")
	public void verifyDisplayedDates() throws InterruptedException {	
		Thread.sleep(2000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		 LocalDateTime now = LocalDateTime.now();  
		  System.out.println(dtf.format(now));  
		  
		  System.out.println(quoteDate.getAttribute("value"));
		  Assert.assertEquals(quoteDate.getAttribute("value"), dtf.format(now));
		  System.out.println(receivedInDate.getAttribute("value"));
		  Assert.assertEquals(receivedInDate.getAttribute("value"), dtf.format(now));
		  
		  
		
	}
	@Step("Select Product")
	public void selectProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(addLineItemButton));
		addLineItemButton.click();	
		WDWait(firstProduct);
		firstProduct.click();
	}
	
	@Step("Enter Quantity and Discount ")
	public void enterProductDetails(String quantity, String discount) throws InterruptedException {
		WDWait(quantityTextBox);		
		Thread.sleep(2000);
		quantityTextBox.click();
		quantityTextBox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		quantityTextBox.clear();
		
		quantityTextBox.sendKeys(quantity);
		WDWait(discountTextBox);
		discountTextBox.clear();
		discountTextBox.sendKeys(discount);
	}
	
	
	@Step("Click on Save Button")
	public void clickSaveButtont() {	
		WDWait(saveButton);
		saveButton.click();
	}
	
	
	
	@Step("Verify Total Amount ")
	public void verifyTotalAmount() throws InterruptedException {	
	
		Thread.sleep(3000);
		String quantity=quantityTextBox.getAttribute("value");
		System.out.println("String Quantity="+quantity);
		int quantity1  = Integer.parseInt(quantity.substring(0, quantity.length() - 3));
		System.out.println("Int Quantity1 =" +quantity1);
		
		String unitPrice=unitPriceTextBox.getAttribute("value");
		System.out.println("String unitPrice="+unitPrice);
		int unitPrice1  = Integer.parseInt(unitPrice.substring(0, unitPrice.length() - 3));
		System.out.println("Int unitPrice1 =" +unitPrice1);
		
		String tax=taxTextBox.getAttribute("value");
		System.out.println("String tax="+tax);
	    String numberOnlytax= tax.replaceAll("[^0-9]", "");
	    System.out.println("Number only tax =" +numberOnlytax);
		int tax1  = Integer.parseInt(numberOnlytax);
		System.out.println("Int tax1 =" +tax1);
		
		Thread.sleep(4000);
			
		String displayedTotal=totalAmount.getText();
		System.out.println("displayedTotal="+displayedTotal);
		int displayedTotal1  = Integer.parseInt(displayedTotal.substring(0, displayedTotal.length() - 3));
		System.out.println("Int displayedTotal1 =" +displayedTotal1);
		
		double taxAmount=(quantity1*unitPrice1*tax1)/100;
		System.out.println("Total Tax = " +taxAmount);
		double totalAmount=(quantity1*unitPrice1)+taxAmount;
		System.out.println("Total Amount="+totalAmount);
		
		Assert.assertEquals(displayedTotal1, totalAmount);		
	}
	
	
	@Step("Verify Total Amount ")
	public void verifyTotalAmount1() throws InterruptedException {	
	
		Thread.sleep(3000);
		String quantity=quantityTextBox.getAttribute("value");
		System.out.println("String Quantity="+quantity);
		double quantity1  = Double.parseDouble(quantity);
		System.out.println("Double Quantity1 =" +quantity1);
		
		String unitPrice=unitPriceTextBox.getAttribute("value");
		System.out.println("String unitPrice="+unitPrice);
		double unitPrice1  = Double.parseDouble(unitPrice);
		System.out.println("Double unitPrice1 =" +unitPrice1);
		
		String discount=discountTextBox.getAttribute("value");
		System.out.println("String discount="+discount);
		double discount1  = Double.parseDouble(discount);
		System.out.println("Double discount1 =" +discount1);
		
		String tax=taxTextBox.getAttribute("value");
		System.out.println("String tax="+tax);
	    String numberOnlytax= tax.replaceAll("[^0-9]", "");
	    System.out.println("Number only tax =" +numberOnlytax);
	    double tax1  = Double.parseDouble(numberOnlytax);
		System.out.println("Double tax1 =" +tax1);
		
		Thread.sleep(4000);
			
		String displayedTotal=totalAmount.getText();
		System.out.println("displayedTotal="+displayedTotal);
		double displayedTotal1  = Double.parseDouble(displayedTotal);
		System.out.println("Double displayedTotal1 =" +displayedTotal1);
		
		double taxAmount=(quantity1*unitPrice1-discount1)*(tax1/100);
		System.out.println("Total Tax = " +taxAmount);
		double totalAmount=(quantity1*unitPrice1-discount1)+taxAmount;
		System.out.println("Total Amount="+totalAmount);
		
		Assert.assertEquals(displayedTotal1, totalAmount);		
	}
	
	

	
	
}
