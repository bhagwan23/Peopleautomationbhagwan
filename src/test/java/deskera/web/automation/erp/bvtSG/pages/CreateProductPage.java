package deskera.web.automation.erp.bvtSG.pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(xpath = "//span[contains(.,'Products')]")
	@CacheLookup
	private WebElement productsTab;
	@FindBy(xpath = "//span[contains(.,'Start by Adding or Importing Your Products')]")
	@CacheLookup
	private List<WebElement> startByAddingOrImportingYourProducsText;
	@FindBy(xpath = "//i[contains(@class,'fa-times close-button m')]//self::i[1]")
	@CacheLookup
	private WebElement closeIcon;
	@FindBy(xpath = "//span[@class='action-button-text'][contains(.,'Create Product')]")
	@CacheLookup
	private WebElement createProductButton;
	@FindBy(xpath = "//span[contains(text(),'New Product')]")
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
	@FindBy(xpath = "//div[contains(text(),' Bill of Materials')]")
	@CacheLookup
	private WebElement billsOfMaterialTab;
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
    private static String pageTitleText = "Deskera Books";
	
	
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
	@FindBy(xpath = "(//div[@class='mat-checkbox-mixedmark']//following::span[text()='Price is tax inclusive'])[1]")
	@CacheLookup
	private WebElement priceIsTaxInclusiveCheckBox;
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
	@FindBy(xpath = "//span[contains(.,'Manufacturing cost')]")
	@CacheLookup
	private WebElement manufacturingCostInventoryAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Stock Adjustment Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement stockAdjustmentAccount;
	@FindBy(xpath = "//mat-label[contains(text(),' Manufacturing Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement manufacturingAccount;
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
	
	/***************  Bill Of Material tab ******************************************/
	
	@FindBy(xpath = "//div[contains(text(),'+ Add a Component Product')]")
	@CacheLookup
	private WebElement addComponentProductButton;
	@FindBy(xpath = "//div[contains(text(),' + Add an Additional Cost ')]")
	@CacheLookup
	private WebElement addAdditionalCostButton;
	@FindBy(xpath = "(//input[contains(@placeholder,'Select Product')])[1]")
	@CacheLookup
	private WebElement componentProduct1TextBox;
	@FindBy(xpath = "//mat-option//span[@class='mat-option-text']")
	@CacheLookup
	private WebElement componentProduct1Value;
	@FindBy(xpath = "(//input[contains(@placeholder,'Select Product')])[1]")
	@CacheLookup
	private WebElement componentProduct1;
	@FindBy(xpath = "(//input[contains(@placeholder,'Quantity')])[1]")
	@CacheLookup
	private WebElement component1Quantity;
	@FindBy(xpath = "(//input[contains(@placeholder,'Select Product')])[2]")
	@CacheLookup
	private WebElement componentProduct2TextBox;
	@FindBy(xpath = "//mat-option//span[2][@class='mat-option-text']")
	@CacheLookup
	private WebElement componentProduct2Value;
	@FindBy(xpath = "(//input[contains(@placeholder,'Quantity')])[2]")
	@CacheLookup
	private WebElement component2Quantity;
	
	
	/******************************* Crreated Product Verification  Elements ***********/
	
	@FindBy(xpath = "//input[contains(@placeholder,'SEARCH_RECORDS')]")
	@CacheLookup
	private WebElement searchRecordsBox;
	@FindBy(xpath = "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[2]//span")
	@CacheLookup
	private WebElement searchedRecord;
	@FindBy(xpath = "//div[text()='Product Name']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedProducName;
	@FindBy(xpath = "//div[text()='Product Type']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedProducType;
	@FindBy(xpath = "//div[text()='Description']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedDescription;
	
	
	
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
	
	public void clickNewProductButton() throws InterruptedException{
		
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]"))); 
		  //  driver.findElement(By.xpath("//div[@id='container-1']/dt-navbar/div/ul/li[10]/a/span")).click();
	        Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
	        // driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
	        for (int second = 0; second <= 30; second++) {
	            if (second == 30) {
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
		
	        newProductButton.click();
		
		
	
		
		/*Thread.sleep(2000);
		if(startByAddingOrImportingYourProducsText.size()!=0){
			WDWait(closeIcon);
			closeIcon.click();
			WDWait(newProductButton);
			newProductButton.click();
		}
		else{
			WDWait(newProductButton);
			newProductButton.click();
		}*/
		
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
    
    public void selectBOMProduct(){
    	productTypedropdown.click();
    	billsOfMaterialProductType.click();
    }
    public void enterProductDetails(String productname,String description){
    	ProductNameInputBox.sendKeys(productname);
    	Random rand = new Random();
		String id = String.format("%04d", rand.nextInt(1000));
		barcodeInputBox.sendKeys("P"+id);
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
	    priceIsTaxInclusiveCheckBox.isDisplayed();
		sellText.isDisplayed();
		Assert.assertEquals(salesAccount.getAttribute("value"), "Sales");
		Assert.assertEquals(salesPrice.getAttribute("value"), "0");
		salesTax.isDisplayed();		
	}
	
	public void verifyAccountingTabForBOMProduct(){
		buyText.isDisplayed();
		Assert.assertEquals(purchaseAccount.getAttribute("value"), "Purchases");
	    purchaseTax.isDisplayed();
	    priceIsTaxInclusiveCheckBox.isDisplayed();
		sellText.isDisplayed();
		Assert.assertEquals(salesAccount.getAttribute("value"), "Sales");
		Assert.assertEquals(salesPrice.getAttribute("value"), "0");
		salesTax.isDisplayed();		
	}
	
	public void enterAccountingInfo(String purchaseprice, String salesprice){
    	purchasePrice.sendKeys(purchaseprice);
    	salesPrice.sendKeys(salesprice);
    }
	
	public void enterAccountingInfoForBOMProduct(String salesprice){
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
	 
	 public void verifyInventoryTabForBOMProduct(){
	    	WDWait(unitOfMeasurement);
	    	unitOfMeasurement.isDisplayed();
	    	costOfGoodsSoldAccount.isDisplayed();
	    	inventoryAccount.isDisplayed();
	    	stockAdjustmentAccount.isDisplayed();
	    	manufacturingAccount.isDisplayed();
	    	Assert.assertEquals(openingQuanity.getAttribute("value"), "0");
	    	Assert.assertEquals(openingValuation.getAttribute("value"), "0");
	    	warehouse.isDisplayed();  	
	    }
	
		public void selectInventoryAccount(){
			inventoryAccount.click();
			WDWait(manufacturingCostInventoryAccount);
			manufacturingCostInventoryAccount.click();
		}
	 public void enterOpeningBalanceDetails(String openingquanity,String openingvaluation){
		 openingQuanity.sendKeys(openingquanity);
		 openingValuation.sendKeys(openingvaluation);
	 }
	 
	 public void clickBillOfMaterialTab(){
	    	WDWait(billsOfMaterialTab);
	    	billsOfMaterialTab.click();
	    }
	 
	 public void verifyBillOfMaterialTab(){
	    	WDWait(addComponentProductButton);
	    	addComponentProductButton.isDisplayed();
	    	addAdditionalCostButton.isDisplayed(); 
	    }
	 
	 public void enterBOMDetails(String quantity1, String quantity2){
		WDWait(addComponentProductButton);
		 addComponentProductButton.click();
		 WDWait(componentProduct1TextBox);
		 componentProduct1TextBox.click();
		 WDWait(componentProduct1Value);
		 componentProduct1Value.click();
		 component1Quantity.sendKeys(quantity1);
		
		 
		 
		// addComponentProductButton.click();
		// componentProduct2TextBox.click();
		//componentProduct2Value.click();
		// component2Quantity.sendKeys(quantity2);
	 }
	public void clickSaveButton(){
		saveButton.click();
	}
	
	public void verifyCreatedTrackedProduct(String productname, String description) throws InterruptedException{
		Thread.sleep(4000);
		if(startByAddingOrImportingYourProducsText.size()!=0){
	       wait.until(ExpectedConditions.elementToBeClickable(closeIcon));	
		//	WDWait(closeIcon);
			closeIcon.click();
		}
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		Assert.assertEquals(displayedProducName.getText(), productname);
		Assert.assertEquals(displayedProducType.getText(), "Tracked");
		Assert.assertEquals(displayedDescription.getText(), description);	
	}
	
	public void verifyCreatedNonTrackedProduct(String productname, String description) throws InterruptedException{
		Thread.sleep(4000);
		if(startByAddingOrImportingYourProducsText.size()!=0){
			Thread.sleep(2000);
		//	WDWait(closeIcon);
			closeIcon.click();
		}
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		Assert.assertEquals(displayedProducName.getText(), productname);
		Assert.assertEquals(displayedProducType.getText(), "Non-Tracked");
		Assert.assertEquals(displayedDescription.getText(), description);	
	}
	
	public void verifyCreatedBOMProduct(String productname, String description) throws InterruptedException{
		Thread.sleep(5000);
		if(startByAddingOrImportingYourProducsText.size()!=0){
			Thread.sleep(2000);
		//	WDWait(closeIcon);
			closeIcon.click();
		}
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		Assert.assertEquals(displayedProducName.getText(), productname);
		Assert.assertEquals(displayedProducType.getText(), "Bill of Materials");
		Assert.assertEquals(displayedDescription.getText(), description);	
	}
}
