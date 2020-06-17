package deskera.web.automation.erp.bvtSG.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateProductPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CreateProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Create New Product PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[contains(.,'Start by Adding or Importing Your Products')]")
	@CacheLookup
	private List<WebElement> startByAddingOrImportingYourProducsText;
	@FindBy(xpath = "//div[@class='close-button-div']/i")
	@CacheLookup
	private WebElement closeIcon;
	@FindBy(xpath = "//button[contains(.,'New Product')]")
	@CacheLookup
	private WebElement newProductButton;
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'Create New Product')]")
	@CacheLookup
	private WebElement createNewProductText;
	@FindBy(xpath = "//div[contains(text(),' General Info ')]")
	@CacheLookup
	private WebElement generalInfoTab;
	@FindBy(xpath = "//div[contains(text(),' Accounting ')]")
	@CacheLookup
	private WebElement accountingTab;
	@FindBy(xpath = "//div[contains(text(),'Inventory')]")
	@CacheLookup
	private WebElement inventoryTab;
	@FindBy(xpath = "//div[contains(@class,'image-container d-flex')]")
	@CacheLookup
	private WebElement addImageArea;
	@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper']")
	@CacheLookup
	private WebElement productTypedropdown;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'Non-Tracked')]")
	@CacheLookup
	private WebElement nonTrackedProductType;
	@FindBy(xpath = "//span[@class='mat-option-text'][text()='Tracked']")
	@CacheLookup
	private WebElement trackedProductType;
	@FindBy(xpath = "//span[@class='mat-option-text'][text()='Bill of Materials']")
	@CacheLookup
	private WebElement billsOfMaterialProductType;
	@FindBy(xpath = "//input[contains(@placeholder,'Product Number')]")
	@CacheLookup
	private WebElement productNumber;
	@FindBy(xpath = "//input[@formcontrolname='name']")
	@CacheLookup
	private WebElement ProductNameInputBox;
	@FindBy(xpath = "//input[@formcontrolname='barcode']")
	@CacheLookup
	private WebElement barcodeInputBox;
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	@CacheLookup
	private WebElement descriptionInputBox;
	
	/***************  Accounting tab ******************************************/
	
	@FindBy(xpath = "//p[text()='Buy']")
	@CacheLookup
	private WebElement buyText;
	@FindBy(xpath = "//mat-label[contains(text(),'Purchase Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement purchaseAccount;
	@FindBy(xpath = "//mat-label[contains(text(),'Purchase Price')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement purchasePrice;
	@FindBy(xpath = "//mat-label[contains(text(),' Purchase Tax ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement purchaseTax;
	@FindBy(xpath = "//p[text()='Sell']")
	@CacheLookup
	private WebElement sellText;
	@FindBy(xpath = "//mat-label[contains(text(),' Sales Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement salesAccount;
	@FindBy(xpath = "//mat-label[contains(text(),'Sales Price')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement salesPrice;
	@FindBy(xpath = "//mat-label[contains(text(),' Sales Tax ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement salesTax;
	
	/***************  Inventory tab ******************************************/
	@FindBy(xpath = "//mat-label[contains(text(),'Unit of Measurement')]/parent::label/parent::span/parent::div")
	@CacheLookup
	private WebElement unitOfMeasurement;
	@FindBy(xpath = "//mat-label[contains(text(),' Cost of Goods Sold Account ')]/parent::label/parent::span/parent::div")
	@CacheLookup
	private WebElement costOfGoodsSoldAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Inventory Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement inventoryAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Stock Adjustment Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement stockAdjustmentAccount;
	@FindBy(xpath = "//mat-label[contains(text(),'Opening Quantity')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement openingQuanity;
	@FindBy(xpath = "//mat-label[contains(text(),'Opening Valuation')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement openingValuation;
	@FindBy(xpath = "//mat-label[contains(text(),'Warehouse')]/parent::label/parent::span/parent::div/mat-select")
	@CacheLookup
	private WebElement warehouse;
	
	@FindBy(xpath = "//button[contains(.,'Save')]")
	@CacheLookup
	private WebElement saveButton;
	
	
	private static String pageTitleText = "Deskera Books";
	
	
	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/

	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void clickNewProductButton(){
		if(startByAddingOrImportingYourProducsText.size()!=0){
			closeIcon.click();
			newProductButton.click();
		}
		else{
			newProductButton.click();
		}
		
	}
	
    public void verifyCreateNewProductPage(){
    	WDWait(createNewProductText);
    	createNewProductText.isDisplayed();
    	generalInfoTab.isDisplayed();
    	accountingTab.isDisplayed();
    	inventoryTab.isDisplayed();
    	addImageArea.isDisplayed();
    	productTypedropdown.isDisplayed();
    	productNumber.isDisplayed();
    	ProductNameInputBox.isDisplayed();
    	barcodeInputBox.isDisplayed();
    	descriptionInputBox.isDisplayed();	
	}
	
    public void selectNonTrackedProduct(){
    	productTypedropdown.click();
    	nonTrackedProductType.click();
    }
    
    public void selectTrackedProduct(){
    	productTypedropdown.click();
    	trackedProductType.click();
    }
    
    public void enterProductDetails(String productname, String barcode, String description){
    	ProductNameInputBox.sendKeys(productname);
    	barcodeInputBox.sendKeys(barcode);
    	descriptionInputBox.sendKeys(description);
    }
    
    public void clickAccountingTab(){
    	WDWait(accountingTab);
    	accountingTab.click();
    }
    
	public void verifyAccountingTab(){
		buyText.isDisplayed();
		Assert.assertEquals(purchaseAccount.getAttribute("value"), "Purchases");
	//	Assert.assertEquals(purchaseAccount.getText(), "Purchases");
		Assert.assertEquals(purchasePrice.getAttribute("value"), "0");
		purchaseTax.isDisplayed();
		sellText.isDisplayed();
		Assert.assertEquals(salesAccount.getAttribute("value"), "Sales");
		Assert.assertEquals(salesPrice.getAttribute("value"), "0");
		salesTax.isDisplayed();		
	}
	
	public void enterAccountingInfo(String purchaseprice, String salesprice){
    	purchasePrice.sendKeys(purchaseprice);
    	salesPrice.sendKeys(salesprice);
    }
	
	 public void clickInventoryTab(){
	    	WDWait(inventoryTab);
	    	inventoryTab.click();
	    }
	 
	 public void verifyInventoryTabForNonTrackedProduct(){
	    	WDWait(unitOfMeasurement);
	    	unitOfMeasurement.isDisplayed();
	    }
	 
	 public void verifyInventoryTabForTrackedProduct(){
	    	WDWait(unitOfMeasurement);
	    	unitOfMeasurement.isDisplayed();
	    	costOfGoodsSoldAccount.isDisplayed();
	    	inventoryAccount.isDisplayed();
	    	stockAdjustmentAccount.isDisplayed();
	    	Assert.assertEquals(openingQuanity.getAttribute("value"), "0");
	    	Assert.assertEquals(openingValuation.getAttribute("value"), "0");
	    	warehouse.isDisplayed();  	
	    }
	
	 public void enterOpeningBalanceDetails(String openingquanity,String openingvaluation){
		 openingQuanity.sendKeys(openingquanity);
		 openingValuation.sendKeys(openingvaluation);
	 }
	public void clickSaveButton(){
		saveButton.click();
	}
}
