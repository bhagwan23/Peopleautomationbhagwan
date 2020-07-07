package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.By;
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

public class BuyPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public BuyPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* BUY PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath ="//span[@class='ng-star-inserted'][contains(.,'Buy')]")
	@CacheLookup
	private WebElement buyTab;
	@FindBy(xpath ="//h1[contains(.,'Buy Records')]")
	@CacheLookup
	private WebElement buyRecordHeading;
	@FindBy(xpath = "//button[contains(.,'Create New')]")
	@CacheLookup
	private WebElement createNewButton;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Order Total')]")
	@CacheLookup
	private WebElement orderTotal;
	@FindBy(xpath = "//h5[contains(text(),'1')]")
	@CacheLookup
	private WebElement orderTotalCount;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Bills Total')]")
	@CacheLookup
	private WebElement billTotal;
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Archive Total')]")
	@CacheLookup
	private WebElement archiveTotal;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Number arrow_drop')]")
	@CacheLookup
	private WebElement numberColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Contact arrow_drop')]")
	@CacheLookup
	private WebElement contactColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Due Date arrow_drop')]")
	@CacheLookup
	private WebElement dueDateColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Total Amount')]")
	@CacheLookup
	private WebElement totalAmountColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Goods Received')]")
	@CacheLookup
	private WebElement goodsReceivedColumn;
	@FindBy(xpath = "//mat-header-cell[contains(.,'Quick Actions')]")
	@CacheLookup
	private WebElement quickAction;
	@FindBy(xpath = "//button[contains(.,'New Order')]")
	@CacheLookup
	private WebElement newOrderButton;
	private static String pageTitleText = "Deskera Books";
	
	/****************************CREATE NEW ORDER  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'Save')]")
	@CacheLookup
	private WebElement saveButton;
	@FindBy(xpath = "//span[contains(.,'+ Add a contact')]")
	@CacheLookup
	private WebElement addContactButton;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")
	@CacheLookup
	private WebElement orderDate;
	@FindBy(xpath = "//input[@formcontrolname='validTillDate']")
	@CacheLookup
	private WebElement dueDate;
	@FindBy(xpath = "//span[contains(.,'+ Add a Line Item')]")
	@CacheLookup
	private WebElement addLineItemButton;
	@FindBy(xpath = "//h5[contains(.,'Order Settings')]")
	@CacheLookup
	private WebElement orderSettingText;
	@FindBy(xpath = "//span[contains(.,'Customize Number Format')]")
	@CacheLookup
	private WebElement customizeNumberFormat;
	@FindBy(xpath = "//span[contains(.,'Global Custom Fields')]")
	@CacheLookup
	private WebElement globalCustomFields;
	@FindBy(xpath = "//span[contains(text(),'Multi-Currency Options')]")
	@CacheLookup
	private WebElement multiCurrencyOptions;
	@FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
	@CacheLookup
	private WebElement firstContact;
	@FindBy(xpath = "(//input[@aria-autocomplete='list'])[1]")
	@CacheLookup
	private WebElement typeHere;
	@FindBy(xpath = "(//input[@aria-autocomplete='list'])[1]")
	@CacheLookup
	private WebElement pTypeHere;
	@FindBy(xpath = "(//span[contains(@class,'mat-option-text')])[1]")
	@CacheLookup
	private WebElement firstProduct;
	@FindBy(xpath = "//input[@formcontrolname='productQuantity']")
	@CacheLookup
	private WebElement pQuantity;
	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	@CacheLookup
	private WebElement pTax;
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='unitPriceGstInclusive']")
	@CacheLookup
	private WebElement unitPriceIsTaxInclusive;
	@FindBy(xpath = "//input[@formcontrolname='unitPrice']")
	@CacheLookup
	private WebElement unitPriceTextBox;
	@FindBy(xpath = "//input[@formcontrolname='discountString']")
	@CacheLookup
	private WebElement discountTextBox;
	@FindBy(xpath = "(//div[@class='mat-form-field-infix']//div[@class='mat-input-element read-only-value'])[2]")
	@CacheLookup
	private WebElement amountSGD;	
	@FindBy(xpath= "//span[text()='Order has been saved successfully']")
	@CacheLookup
	private WebElement ordercreatedSuccessMessage;
	
	
	/****************************CONVERT ORDER TO BILL PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath= "//input[@placeholder='Search Records']")
	@CacheLookup
	private WebElement searchRecord;
	@FindBy(xpath= "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]")
	@CacheLookup
	private WebElement contactName;
	@FindBy(xpath= "//span[contains(text(),'Convert to Bill')]")
	@CacheLookup
	private WebElement convertToBillButton;
	@FindBy(xpath= "//div[@class='mat-dialog-title']//span[contains(text(),'Convert to Bill')]")
	@CacheLookup
	private WebElement convertToBillHeading;
	@FindBy(xpath= "//span[contains(text(),'Convert (Auto-Received)')]")
	@CacheLookup
	private WebElement convertAutoReceivedbutton;
	@FindBy(xpath="//span[contains(text(),'Convert Only')]")
	@CacheLookup
	private WebElement convertOnlyButton;
	@FindBy(xpath= "//span[contains(text(),'Order is billed successfully')]")
	@CacheLookup
	private WebElement convertBillSucessMsg;
	
	/****************************CREATE NEW BILL  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'New Bill')]")
	@CacheLookup
	private WebElement newBillButton;
	@FindBy(xpath = "//input[@formcontrolname='documentDate']")
	@CacheLookup
	private WebElement billDate;
	@FindBy(xpath = "//h5[contains(.,'Bill Settings')]")
	@CacheLookup
	private WebElement billSettingText;
	@FindBy(xpath = "//div[@class='canvas-title']")
	@CacheLookup
	private WebElement billText;
	@FindBy(xpath= "//span[text()='Bill has been saved successfully']")
	@CacheLookup
	private WebElement billcreatedSuccessMessage;
	@FindBy(xpath = "//h5[contains(text(),'1')]")
	@CacheLookup
	private WebElement billTotalCount;
	@FindBy(xpath = "//div[@class='tab-container activeTab ng-star-inserted']")
	@CacheLookup
	private WebElement billCard;
	/*******************************Buy Object Manipulation Methods *******************/
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
	@Step("verify buytab elements")
	public void verifybuytabElements(){
		WDWait(buyTab);
		buyTab.isDisplayed();

	}
	@Step("Click on buytab button")
	public void clickbuytab() throws InterruptedException{
		WDWait(buyTab);
		buyTab.click(); 
		clickPopup();
	}
	@Step("close popup on buy page")
	public void clickPopup() throws InterruptedException{	
		//driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted'][contains(.,'Buy')]"))); // Contact // link                                                                                                            // or                                                                                                            // Produ                                                                                                            // link
		driver.findElement(By.xpath("//span[@class='ng-star-inserted'][contains(.,'Buy')]")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found clickin on create new Button");
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
	}
	@Step("Verify Buy page elements")
	public void verifyBuyPageElement(){
		WDWait(buyRecordHeading);
		buyRecordHeading.isDisplayed();
		createNewButton.isDisplayed();
		orderTotal.isDisplayed();
		billTotal.isDisplayed();
		archiveTotal.isDisplayed();
		numberColumn.isDisplayed();
		contactColumn.isDisplayed();
		dueDateColumn.isDisplayed();
		totalAmountColumn.isDisplayed();
		goodsReceivedColumn.isDisplayed();
		quickAction.isDisplayed();
	}
	@Step("Click On Create New Button and then Click on New Order")
	public void clickCreatNew(){
		WDWait(createNewButton);
		wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
		createNewButton.click();
	}
	@Step(" Click on New Order")
	public void clickOnNewOrder(){
		WDWait(newOrderButton);
		wait.until(ExpectedConditions.elementToBeClickable(newOrderButton));
		newOrderButton.click();	
	}
	
	@Step("Verify create order page elements")
	public void verifyCreateOrderElements(){
		WDWait(saveButton);
		saveButton.isDisplayed();
		addContactButton.isDisplayed();
		orderDate.isDisplayed();
		dueDate.isDisplayed();
		addLineItemButton.isDisplayed();
		orderSettingText.isDisplayed();
		customizeNumberFormat.isDisplayed();
		globalCustomFields.isDisplayed();
		//unitPriceIsTaxInclusive.isDisplayed();
	}
	
	@Step("Add Contact")
	public void addContact(String cName) {
		wait.until(ExpectedConditions.elementToBeClickable(addContactButton));
		addContactButton.click();	
		WDWait(typeHere);
		typeHere.sendKeys(cName);
		WDWait(firstContact);
		firstContact.click();
	}
	@Step("Verify Multi currency options")
	public void verifyMultiCurrencyOptions(){
		WDWait(multiCurrencyOptions);
		multiCurrencyOptions.isDisplayed();
	}
	
	@Step("Add Product")
	public void addProduct(String pName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addLineItemButton));
		addLineItemButton.click();
		WDWait(pTypeHere);
		wait.until(ExpectedConditions.elementToBeClickable(pTypeHere));
		pTypeHere.sendKeys(pName);
		WDWait(firstProduct);
		firstProduct.click();
	}
	@Step("Verrify default quantity of products")
	public void verifydefaultQuantityAndTax(){
		WDWait(pQuantity);
		pQuantity.isDisplayed();
		Assert.assertEquals(pQuantity.getAttribute("value"), "1.00");
			
	}
	
	@Step("Enter Quantity and Discount ")
	public void enterProductDetails(String quantity, String discount) throws InterruptedException {
		WDWait(pQuantity);		
		Thread.sleep(2000);
		pQuantity.click();
		pQuantity.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		pQuantity.clear();
		
		pQuantity.sendKeys(quantity);
		WDWait(discountTextBox);
		discountTextBox.clear();
		discountTextBox.sendKeys(discount);
	}
	
	@Step("Verify Total Amount ")
	public void verifyTotalAmount() throws InterruptedException {	
		WDWait(pQuantity);
		
		String quantity= pQuantity.getAttribute("value");
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
		
		String tax=pTax.getAttribute("value");
		System.out.println("String tax="+tax);
	    String numberOnlytax= tax.replaceAll("[^0-9]", "");
	    System.out.println("Number only tax =" +numberOnlytax);
	    double tax1  = Double.parseDouble(numberOnlytax);
		System.out.println("Double tax1 =" +tax1);
		
		Thread.sleep(4000);
		
		String amount=amountSGD.getText();
		System.out.println("displayedTotal="+amount);
		double amount1  = Double.parseDouble(amount);
		System.out.println("Double displayedTotal1 =" +amount);
		
		double taxAmount=(quantity1*unitPrice1-discount1)*(tax1/100);
		System.out.println("Total Tax = " +taxAmount);
		double totalAmount=(quantity1*unitPrice1-discount1)+taxAmount;
		System.out.println("Total Amount="+totalAmount);
		
		Assert.assertEquals(amount1, totalAmount);
	}
	@Step("Click on Save Button")
	public void clickSaveButton() {	
		WDWait(saveButton);
		saveButton.click();
	}
	@Step("Verify success message")
	public void verifysuccessmessage(){
		WDWait(ordercreatedSuccessMessage);
		ordercreatedSuccessMessage.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(ordercreatedSuccessMessage));

	}
	@Step("Verify total order count")
	public void ordetTotalCount(){
		WDWait(orderTotalCount);
		orderTotalCount.isDisplayed();
	    Assert.assertEquals(orderTotalCount.getText(), "1");

	}
	@Step("Search created order")
	public void searchCreatedOrder(String cName){
	WDWait(searchRecord);
	searchRecord.click();
	searchRecord.sendKeys(cName);
	}
	@Step("Click on searched order")
	public void clickOnContact(String cName){
		WDWait(contactName);
		wait.until(ExpectedConditions.elementToBeClickable(contactName));
		Assert.assertEquals(contactName.getText(), cName);
		contactName.click();
	}
	@Step("Click on Convert to bill button")
	public void clickConvertToBillButton(){
		WDWait(convertToBillButton);
		convertToBillButton.isDisplayed();
		convertToBillButton.click();
	}
	@Step("Verify convert to bill popup")
	public void verifyConvertToBillPopupElements(){
		WDWait(convertToBillHeading);
		convertToBillHeading.isDisplayed();
		WDWait(convertAutoReceivedbutton);
		convertAutoReceivedbutton.isDisplayed();
		WDWait(convertOnlyButton);
		convertOnlyButton.isDisplayed();
	}
	@Step("Click on convert autoreceived button")
	public void clickConvertAutoReceivedButton(){
		WDWait(convertAutoReceivedbutton);
		convertAutoReceivedbutton.isDisplayed();
		convertAutoReceivedbutton.click();
	}
	@Step("Verify success message")
	public void verifyConvertBillsuccessmessage(){
		WDWait(convertBillSucessMsg);
		convertBillSucessMsg.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(convertBillSucessMsg));

	}
	
	/*******************************Create Bill Object Manipulation Methods *******************/
	
	@Step(" Click on New Bill button")
	public void clickOnNewBill(){
		WDWait(newBillButton);
		wait.until(ExpectedConditions.elementToBeClickable(newBillButton));
		newBillButton.click();	
	}
	@Step("Verify create order page elements")
	public void verifyCreateBillElements(){
		WDWait(saveButton);
		saveButton.isDisplayed();
		WDWait(billText);
		billText.isDisplayed();
		addContactButton.isDisplayed();
		billDate.isDisplayed();
		dueDate.isDisplayed();
		addLineItemButton.isDisplayed();
		billSettingText.isDisplayed();
		customizeNumberFormat.isDisplayed();
		globalCustomFields.isDisplayed();
		unitPriceIsTaxInclusive.isDisplayed();
	}
	@Step("Verify success message")
	public void verifybillcreatedsuccessmessage(){
		WDWait(billcreatedSuccessMessage);
		billcreatedSuccessMessage.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(billcreatedSuccessMessage));

	}
	@Step("Verify total bill count")
	public void billTotalCount(){
		WDWait(billTotalCount);
		billTotalCount.isDisplayed();
	    Assert.assertEquals(billTotalCount.getText(), "1");

	}
	@Step("Click on Bill Card")
	public void clickOnBillCard(){
	WDWait(billCard);
	billCard.isDisplayed();
	billCard.click();
	}
}