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

	/*******************************
	 * Create New Product PAGE ELEMENTS LOCATORS
	 *******************/
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
	@FindBy(xpath = "//mat-icon[@ng-reflect-message='Info']")
	@CacheLookup
	private WebElement infoIcon;
	@FindBy(xpath = "//mat-icon[@ng-reflect-message='Chat']")
	@CacheLookup
	private WebElement chatIcon;
	@FindBy(xpath = "//mat-icon[@ng-reflect-svg-icon='notification']")
	@CacheLookup
	private WebElement notificationIcon;
	@FindBy(xpath = "//h5[contains(.,'Quick Actions')]")
	@CacheLookup
	private WebElement quickActionsText;
	@FindBy(xpath = "//span[contains(.,'Custom Number Format')]")
	@CacheLookup
	private WebElement customNumberFormat;
	@FindBy(xpath = "(//span[contains(.,'Custom Fields')])[2]")
	@CacheLookup
	private WebElement customFields;
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

	/*************** Accounting tab ******************************************/

	@FindBy(xpath = "//p[text()='Buy']")
	@CacheLookup
	private WebElement buyText;
	@FindBy(xpath = "//mat-label[contains(text(),'Purchase Account ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement purchaseAccount;
	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']//div//mat-option//span")
	@CacheLookup
	private List<WebElement> purchaseAccountDropdownValues;
	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']//div//mat-option//span")
	@CacheLookup
	private List<WebElement> salesAccountDropdownValues;
	@FindBy(xpath = "//mat-label[contains(text(),'Purchase Price')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement purchasePrice;
	@FindBy(xpath = "//mat-label[contains(text(),' Purchase Tax ')]/parent::label/parent::span/parent::div/input")
	@CacheLookup
	private WebElement purchaseTax;
	@FindBy(xpath = "(//div[@class='mat-checkbox-mixedmark']//following::span[text()='Price is tax inclusive'])[1]")
	@CacheLookup
	private WebElement priceIsTaxInclusiveCheckBox_Buy;
	@FindBy(xpath = "(//div[@class='mat-checkbox-mixedmark']//following::span[text()='Price is tax inclusive'])[2]")
	@CacheLookup
	private WebElement priceIsTaxInclusiveCheckBox_Sell;
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

	/*************** Inventory tab ******************************************/
	@FindBy(xpath = "//mat-label[contains(text(),'Unit of Measurement')]/parent::label/parent::span/parent::div/mat-select")
	@CacheLookup
	private WebElement unitOfMeasurement;
	@FindBy(xpath = "//mat-label[contains(text(),' Cost of Goods Sold Account ')]/parent::label/parent::span/parent::div/input")
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
	@FindBy(xpath = "//mat-label[contains(text(),'Warehouse')]/parent::label/parent::span/parent::div/mat-select/div/div/span/span")
	@CacheLookup
	private WebElement warehouse;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	@CacheLookup
	private WebElement saveButton;
	@FindBy(xpath = "//span[text()='Product has been saved successfully']")
	@CacheLookup
	private WebElement createProductSuccessMessage;

	/***************
	 * Bill Of Material tab
	 ******************************************/

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

	/*******************************
	 * Created Product Verification Elements
	 ***********/
	@FindBy(xpath = "//span[text()='Non-Tracked']//following::span[1][@class='count']")
	@CacheLookup
	private WebElement nonTrackedProductCount;
	@FindBy(xpath = "//span[text()='Tracked Inventory']//following::span[1][@class='count']")
	@CacheLookup
	private WebElement trackedProductCount;
	@FindBy(xpath = "//span[text()='Bill of Materials']//following::span[1][@class='count']")
	@CacheLookup
	private WebElement BOMProductCount;
	@FindBy(xpath = "//input[contains(@placeholder,'SEARCH_RECORDS')]")
	@CacheLookup
	private WebElement searchRecordsBox;
	@FindBy(xpath = "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]//span[1]")
	@CacheLookup
	private WebElement searchedRecord;
	@FindBy(xpath = "//div[text()='Product Name']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedProducName;
	@FindBy(xpath = "//div[text()='Product Type']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedProducType;
	@FindBy(xpath = "//div[text()='Barcode']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedBarcode;
	@FindBy(xpath = "//div[text()='Description']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedDescription;
	@FindBy(xpath = "//div[text()='Purchase Account']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedPurchaseAccount;
	@FindBy(xpath = "//div[text()='Product Price']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedPurchasePrice;
	@FindBy(xpath = "//div[text()='Purchase Tax']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedPurchaseTax;
	@FindBy(xpath = "//div[text()='Sales Account']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedSalesAccount;
	@FindBy(xpath = "//div[text()='Sales Price']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedSalesPrice;
	@FindBy(xpath = "//div[text()='Sales Tax']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedSalesTax;
	@FindBy(xpath = "(//span[contains(.,'Price is tax inclusive')]//ancestor::div[1]//input[@type='checkbox' and @aria-checked='false' ])[1]")
	@CacheLookup
	private WebElement uncheckedPriceIsTaxInclusiveCheckbox_Buy;
	@FindBy(xpath = "(//span[contains(.,'Price is tax inclusive')]//ancestor::div[1]//input[@type='checkbox' and @aria-checked='false' ])[2]")
	@CacheLookup
	private WebElement uncheckedPriceIsTaxInclusiveCheckbox_Sell;
	@FindBy(xpath = "//div[text()=' Unit of Measurement ']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedUnitOfMeasurement;
	@FindBy(xpath = "//div[text()=' Cost of Goods Account ']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedCostOfGoodsAccount;
	@FindBy(xpath = "//div[text()='Inventory Account']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedInventoryAccount;
	@FindBy(xpath = "//div[text()=' Stock Adjustment Account ']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedStockAdjustmentAccount;
	@FindBy(xpath = "//div[text()='Warehouse']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedWarehouse;
	@FindBy(xpath = "//div[text()='Opening Quantity']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedOpeningQuantity;
	@FindBy(xpath = "//div[text()='Opening Valuation']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedOpeningValuation;
	@FindBy(xpath = "//mat-table[contains(@class,'deskera-grid deskera-grid-products')]//following::mat-cell[2]//span[@class='text-elipsis']")
	@CacheLookup
	private WebElement firstProduct;
	@FindBy(xpath = "(//mat-icon[contains(.,'more_vert')])[1]")
	@CacheLookup
	private WebElement threeDotsOnFirstProduct;
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	@CacheLookup
	private WebElement editButton;
	@FindBy(xpath = "//button[contains(.,'Copy')]")
	@CacheLookup
	private WebElement copyButton;
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	@CacheLookup
	private WebElement deleteButton;

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

	public void clickNewProductButton() throws InterruptedException {

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]")));
		// driver.findElement(By.xpath("//div[@id='container-1']/dt-navbar/div/ul/li[10]/a/span")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and
							// then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 10; second++) {
			if (second == 10) {
				System.out.println("Popup Not found clickin on new Contact Button");
				break;
			}
			try {
				if (driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).isDisplayed()) {
					System.out.println("closig popup now 1");
					driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click(); // popup
																									// close
																									// button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		newProductButton.click();
	}

	public void verifyCreateNewProductPage() {
		WDWait(createNewProductText);
		createNewProductText.isDisplayed();
		generalInfoTab.isDisplayed();
		accountingTab.isDisplayed();
		inventoryTab.isDisplayed();
		infoIcon.isDisplayed();
		chatIcon.isDisplayed();
		notificationIcon.isDisplayed();
		quickActionsText.isDisplayed();
		customNumberFormat.isDisplayed();
		customFields.isDisplayed();
		addImageArea.isDisplayed();
		productTypedropdown.isDisplayed();
		productNumber.isDisplayed();
		ProductNameInputBox.isDisplayed();
		barcodeInputBox.isDisplayed();
		descriptionInputBox.isDisplayed();
		saveButton.isDisplayed();
	}

	public void selectNonTrackedProduct() {
		productTypedropdown.click();
		nonTrackedProductType.click();
	}

	public void selectTrackedProduct() {
		productTypedropdown.click();
		trackedProductType.click();
	}

	public void selectBOMProduct() {
		productTypedropdown.click();
		billsOfMaterialProductType.click();
	}

	public void enterProductDetails(String productname, String description, String barcode) {
		ProductNameInputBox.sendKeys(productname);
		barcodeInputBox.sendKeys(barcode);
		descriptionInputBox.sendKeys(description);
	}

	public void clickAccountingTab() {
		WDWait(accountingTab);
		accountingTab.click();
	}

	/**************
	 * Purchase account dropdown should not have Sales and Sales Return , Sales
	 * Account should not have Purchase and Purchase Return values
	 */
	public void verifyPurchaseAccountDropdownValues() {
		purchaseAccount.click();
		for (WebElement we : purchaseAccountDropdownValues) {
			for (int i = 0; i < purchaseAccountDropdownValues.size(); i++) {
				if (we.getText().equalsIgnoreCase("Sales") || we.getText().equalsIgnoreCase("Sales Return")) {
					Assert.fail();
				}
			}
		}
		accountingTab.click();
	}

	public void verifySalesAccountDropdownValues() {
		salesAccount.click();

		for (WebElement we : salesAccountDropdownValues) {
			for (int i = 0; i < salesAccountDropdownValues.size(); i++) {
				if (we.getText().equalsIgnoreCase("Purchases") || we.getText().equalsIgnoreCase("Purchase Return")) {
					Assert.fail();
				}
			}
		}
		accountingTab.click();
	}

	public void verifyAccountingTab(String defaultPurchaseAccount, String defaultPurchasePrice,
			String defaultPurchaseTax, String defaultSalesAccount, String defaultSalesPrice, String defaultSalesTax) {
		WDWait(buyText);
		buyText.isDisplayed();
		Assert.assertEquals(purchaseAccount.getAttribute("value"), defaultPurchaseAccount);
		Assert.assertEquals(purchasePrice.getAttribute("value"), defaultPurchasePrice);
		purchaseTax.isDisplayed();
		Assert.assertEquals(purchaseTax.getAttribute("value"), defaultPurchaseTax);
		priceIsTaxInclusiveCheckBox_Buy.isDisplayed();
		sellText.isDisplayed();
		Assert.assertEquals(salesAccount.getAttribute("value"), defaultSalesAccount);
		Assert.assertEquals(salesPrice.getAttribute("value"), defaultSalesPrice);
		salesTax.isDisplayed();
		Assert.assertEquals(salesTax.getAttribute("value"), defaultSalesTax);
		priceIsTaxInclusiveCheckBox_Sell.isDisplayed();
	}

	public void verifyAccountingTabForBOMProduct(String defaultPurchaseAccount, String defaultPurchaseTax,
			String defaultSalesAccount, String defaultSalesPrice, String defaultSalesTax) {
		WDWait(buyText);
		buyText.isDisplayed();
		Assert.assertEquals(purchaseAccount.getAttribute("value"), defaultPurchaseAccount);
		purchaseTax.isDisplayed();
		Assert.assertEquals(purchaseTax.getAttribute("value"), defaultPurchaseTax);
		priceIsTaxInclusiveCheckBox_Buy.isDisplayed();
		sellText.isDisplayed();
		Assert.assertEquals(salesAccount.getAttribute("value"), defaultSalesAccount);
		Assert.assertEquals(salesPrice.getAttribute("value"), defaultSalesPrice);
		salesTax.isDisplayed();
		Assert.assertEquals(salesTax.getAttribute("value"), defaultSalesTax);
		priceIsTaxInclusiveCheckBox_Sell.isDisplayed();
	}

	public void enterAccountingInfo(String purchaseprice, String salesprice) {
		purchasePrice.sendKeys(purchaseprice);
		salesPrice.sendKeys(salesprice);
	}

	public void enterAccountingInfoForBOMProduct(String salesprice) {
		salesPrice.sendKeys(salesprice);
	}

	public void clickInventoryTab() {
		WDWait(inventoryTab);
		inventoryTab.click();
	}

	public void verifyInventoryTabForNonTrackedProduct(String defaultUnitOfMeasurement) {
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		Assert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);

	}

	public void verifyInventoryTabForTrackedProduct(String defaultUnitOfMeasurement,
			String defaultCostOfGoodSoldAccount, String defaultInventoryAccount, String defaultStockAdjustmentAccount)
			throws InterruptedException {
		Thread.sleep(4000);
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		Assert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);
		costOfGoodsSoldAccount.isDisplayed();
		Assert.assertEquals(costOfGoodsSoldAccount.getAttribute("value"), defaultCostOfGoodSoldAccount);
		inventoryAccount.isDisplayed();
		Assert.assertEquals(inventoryAccount.getAttribute("value"), defaultInventoryAccount);
		stockAdjustmentAccount.isDisplayed();
		Assert.assertEquals(stockAdjustmentAccount.getAttribute("value"), defaultStockAdjustmentAccount);
		Assert.assertEquals(openingQuanity.getAttribute("value"), "0");
		Assert.assertEquals(openingValuation.getAttribute("value"), "0");
		warehouse.isDisplayed();
		Assert.assertEquals(warehouse.getText(), "Primary Warehouse");
	}

	public void verifyInventoryTabForBOMProduct(String defaultUnitOfMeasurement, String defaultCostOfGoodSoldAccount,
			String defaultManufacturingAccount, String defaultStockAdjustmentAccount) throws InterruptedException {
		Thread.sleep(4000);
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		Assert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);
		costOfGoodsSoldAccount.isDisplayed();
		Assert.assertEquals(costOfGoodsSoldAccount.getAttribute("value"), defaultCostOfGoodSoldAccount);
		inventoryAccount.isDisplayed();
		stockAdjustmentAccount.isDisplayed();
		Assert.assertEquals(stockAdjustmentAccount.getAttribute("value"), defaultStockAdjustmentAccount);
		manufacturingAccount.isDisplayed();
		Assert.assertEquals(manufacturingAccount.getAttribute("value"), defaultManufacturingAccount);
		Assert.assertEquals(openingQuanity.getAttribute("value"), "0");
		Assert.assertEquals(openingValuation.getAttribute("value"), "0");
		warehouse.isDisplayed();
		Assert.assertEquals(warehouse.getText(), "Primary Warehouse");
	}

	public void selectInventoryAccount() {
		inventoryAccount.click();
		WDWait(manufacturingCostInventoryAccount);
		manufacturingCostInventoryAccount.click();
	}

	public void enterOpeningBalanceDetails(String openingquanity, String openingvaluation) {
		openingQuanity.sendKeys(openingquanity);
		openingValuation.sendKeys(openingvaluation);
	}

	public void clickBillOfMaterialTab() {
		WDWait(billsOfMaterialTab);
		billsOfMaterialTab.click();
	}

	public void verifyBillOfMaterialTab() {
		WDWait(addComponentProductButton);
		addComponentProductButton.isDisplayed();
		addAdditionalCostButton.isDisplayed();
	}

	public void enterBOMDetails(String quantity1, String quantity2) {
		WDWait(addComponentProductButton);
		addComponentProductButton.click();
		WDWait(componentProduct1TextBox);
		componentProduct1TextBox.click();
		WDWait(componentProduct1Value);
		componentProduct1Value.click();
		component1Quantity.sendKeys(quantity1);
	}

	public void clickSaveButton() {
		WDWait(saveButton);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	public void verifyCreateProductSuccessMessage() {
		WDWait(createProductSuccessMessage);
		createProductSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(createProductSuccessMessage));
	}

	public void verifyTrackedProductCount() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(trackedProductCount);
		trackedProductCount.isDisplayed();
		Assert.assertEquals(trackedProductCount.getText(), "1");
	}

	public void verifyNonTrackedProductCount() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(nonTrackedProductCount);
		nonTrackedProductCount.isDisplayed();
		Assert.assertEquals(nonTrackedProductCount.getText(), "1");
	}

	public void verifyBomProductCount() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(BOMProductCount);
		BOMProductCount.isDisplayed();
		Assert.assertEquals(BOMProductCount.getText(), "1");
	}

	public void verifyCreatedTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		WDWait(searchRecordsBox);
		Thread.sleep(2000);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		searchedRecord.click();
		WDWait(displayedProducName);
		Assert.assertEquals(displayedProducName.getText(), productname);
		Assert.assertEquals(displayedProducType.getText(), "Tracked");
		Assert.assertEquals(displayedBarcode.getText(), barcode);
		Assert.assertEquals(displayedDescription.getText(), description);
		action.moveToElement(displayedPurchaseAccount).perform();
		Assert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		Assert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		Assert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		Assert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		Assert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		Assert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
	}

	public void verifyCreatedNonTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		// WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		Assert.assertEquals(displayedProducName.getText(), productname);
		Assert.assertEquals(displayedProducType.getText(), "Non-Tracked");
		Assert.assertEquals(displayedBarcode.getText(), barcode);
		Assert.assertEquals(displayedDescription.getText(), description);
		action.moveToElement(displayedPurchaseAccount).perform();
		Assert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		Assert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		Assert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		Assert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		Assert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		Assert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
	}

	public void verifyInventoryDetailsForCreatedNonTrackedProduct(String defaultUnitOfMeasurement) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		Assert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
	}

	public void verifyInventoryDetailsForCreatedTrackedProduct(String defaultUnitOfMeasurement,
			String defaultCostOfGoodSoldAccount, String defaultInventoryAccount, String defaultStockAdjustmentAccount,
			String defaultWarehouseCode, String openingQuanity, String openingValuation) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		Assert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
		action.moveToElement(displayedCostOfGoodsAccount).perform();
		Assert.assertEquals(displayedCostOfGoodsAccount.getText(), defaultCostOfGoodSoldAccount);
		action.moveToElement(displayedInventoryAccount).perform();
		Assert.assertEquals(displayedInventoryAccount.getText(), defaultInventoryAccount);
		action.moveToElement(displayedStockAdjustmentAccount).perform();
		Assert.assertEquals(displayedStockAdjustmentAccount.getText(), defaultStockAdjustmentAccount);
		action.moveToElement(displayedWarehouse).perform();
		Assert.assertEquals(displayedWarehouse.getText(), defaultWarehouseCode);
		action.moveToElement(displayedOpeningQuantity).perform();
		Assert.assertEquals(displayedOpeningQuantity.getText(), openingQuanity);
		action.moveToElement(displayedOpeningValuation).perform();
		Assert.assertEquals(displayedOpeningValuation.getText(), openingValuation);
	}

	public void verifyCreatedBOMProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String defaultSalesAccount, String salesPrice, String defaultPurchaseTax,
			String defaultSalesTax) throws InterruptedException {
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		// WDWait(searchedRecord);
		searchedRecord.click();
		WDWait(displayedProducName);
		Assert.assertEquals(displayedProducName.getText(), productname);
		Assert.assertEquals(displayedProducType.getText(), "Bill of Materials");
		Assert.assertEquals(displayedBarcode.getText(), barcode);
		Assert.assertEquals(displayedDescription.getText(), description);
		Thread.sleep(5000);
		action.moveToElement(displayedPurchaseAccount).perform();
		Assert.assertEquals(displayedPurchaseAccount.getText(), defaultPurchaseAccount);
		action.moveToElement(displayedPurchaseTax).perform();
		Assert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		Assert.assertEquals(displayedSalesAccount.getText(), defaultSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		Assert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		Assert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
	}

	public void verifyInventoryDetailsForCreatedBOMProduct(String defaultUnitOfMeasurement,
			String defaultCostOfGoodSoldAccount, String defaultStockAdjustmentAccount, String defaultWarehouseCode,
			String openingQuanity, String openingValuation) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		Assert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
		action.moveToElement(displayedCostOfGoodsAccount).perform();
		Assert.assertEquals(displayedCostOfGoodsAccount.getText(), defaultCostOfGoodSoldAccount);
		action.moveToElement(displayedInventoryAccount).perform();
		Assert.assertEquals(displayedInventoryAccount.getText(), "Manufacturing cost");
		action.moveToElement(displayedStockAdjustmentAccount).perform();
		Assert.assertEquals(displayedStockAdjustmentAccount.getText(), defaultStockAdjustmentAccount);
		action.moveToElement(displayedWarehouse).perform();
		Assert.assertEquals(displayedWarehouse.getText(), defaultWarehouseCode);
		action.moveToElement(displayedOpeningQuantity).perform();
		Assert.assertEquals(displayedOpeningQuantity.getText(), openingQuanity);
		action.moveToElement(displayedOpeningValuation).perform();
		Assert.assertEquals(displayedOpeningValuation.getText(), openingValuation);
	}

	/*****************************
	 * Edit Product Methods
	 ******************************/

	public void selectFirstProduct() {
		WDWait(firstProduct);
		firstProduct.click();
	}

	public void clickThreeDotsOnFirstProduct() {
		WDWait(threeDotsOnFirstProduct);
		threeDotsOnFirstProduct.click();
	}

	public void clickTEditButton() {
		WDWait(editButton);
		editButton.click();
	}

}
