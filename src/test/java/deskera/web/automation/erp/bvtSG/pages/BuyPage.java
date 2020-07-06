package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//div[@class='summary-title'][contains(.,'Bill Total')]")
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
	@FindBy(xpath = "(//input[@aria-autocomplete='list'])[2]")
	@CacheLookup
	private WebElement pTax;
	@FindBy(xpath= "//span[text()='Order has been saved successfully']")
	@CacheLookup
	private WebElement ordercreatedSuccessMessage;
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
	public void clickOnNewOrder(){
		WDWait(createNewButton);
		wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
		createNewButton.click();
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
		/*WDWait(pTax);
		pTax.isDisplayed();
		Assert.assertEquals(pTax.getText(), "TX(7%)");*/
			
	}
	@Step("Verify Total Amount ")
	public void verifyTotalAmount1() throws InterruptedException {	
		
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
	
	
}