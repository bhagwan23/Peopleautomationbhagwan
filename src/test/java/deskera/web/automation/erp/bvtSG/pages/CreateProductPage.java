package deskera.web.automation.erp.bvtSG.pages;

import java.util.List;
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

import io.qameta.allure.Step;

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
	@FindBy(xpath = "//span[contains(.,'Purchase Return')]")
	@CacheLookup
	private WebElement purchaseReturnPurchaseAccount;
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
	@FindBy(xpath = "//span[contains(.,'Sales Return')]")
	@CacheLookup
	private WebElement salesReturnSalesAccount;
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
	@FindBy(xpath = "//span[contains(.,'Pieces')]")
	@CacheLookup
	private WebElement piecesUnitOfMeasurement;
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

	/**************************** Created Product Verification Elements ***********/
	@FindBy(xpath = "//span[text()='Non-Tracked']//following::span[1][@class='count']")
	@CacheLookup
	private WebElement nonTrackedProductCount;
	@FindBy(xpath = "//span[text()='Tracked Inventory']//following::span[1][@class='count']")
	@CacheLookup
	private WebElement trackedProductCount;
	@FindBy(xpath = "//span[text()='Bill of Materials']//following::span[1][@class='count']")
	@CacheLookup
	private WebElement BOMProductCount;
	
	@FindBy(xpath = "//span[contains(text(),'0')]//following::span[text()='Item with No Stock']")
	@CacheLookup
	private WebElement zeroItemWithNoStock;
	@FindBy(xpath = "//input[contains(@placeholder,'SEARCH_RECORDS') or contains(@ng-reflect-placeholder,'Search Records')]")
	@CacheLookup
	private WebElement searchRecordsBox;
	@FindBy(xpath = "//mat-table//mat-row[@class='mat-row ng-star-inserted']//mat-cell[3]//span[1]")
	@CacheLookup
	private WebElement searchedRecord;
	@FindBy(xpath = "//div[text()='Product Name']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedProducName;
	@FindBy(xpath = "//div[text()='Product Number']//following::div[@class='field-value'][1]")
	@CacheLookup
	private WebElement displayedProductNumber;
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
	@FindBy(xpath = "//mat-cell[text()=' Non-Tracked ']//following::mat-icon[contains(.,'more_vert')]")
	@CacheLookup
	private WebElement threeDotsOnNonTrackedProduct;
	@FindBy(xpath = "//mat-cell[text()=' Tracked ']//following::mat-icon[contains(.,'more_vert')]")
	@CacheLookup
	private WebElement threeDotsOnTrackedProduct;
	@FindBy(xpath = "//mat-cell[text()=' Bill of Materials ']//following::mat-icon[contains(.,'more_vert')]")
	@CacheLookup
	private WebElement threeDotsOnBOMProduct;
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	@CacheLookup
	private WebElement editButton;
	@FindBy(xpath = "//button[contains(.,'Copy')]")
	@CacheLookup
	private WebElement copyButton;
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	@CacheLookup
	private WebElement deleteButton;
	@FindBy(xpath = "//span[@class='ng-star-inserted'][contains(.,'Save Changes')]")
	@CacheLookup
	private WebElement saveChangesButton;
	@FindBy(xpath = "//span[text()='Product has been updated successfully']")
	@CacheLookup
	private WebElement editSuccessMessage;
	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to delete this product?')]")
	@CacheLookup
	private WebElement deleteConfirmationMessage;
	@FindBy(xpath = "//button[contains(.,'No')]")
	@CacheLookup
	private WebElement noButtonOnDeleteConfirmation;
	@FindBy(xpath = "//span[contains(.,'Yes')]")
	@CacheLookup
	private WebElement yesButtonOnDeleteConfirmation;
	@FindBy(xpath = "//span[text()='Product has been deleted successfully']")
	@CacheLookup
	private WebElement deleteSuccessMessage;

	/**************************** Custom Number Format  Elements ***********/
		
	@FindBy(xpath = "//mat-label[contains(.,'Preview')]")
	@CacheLookup
	private WebElement previewText;
	@FindBy(xpath = "//div//div[contains(@class,'result mt')]")
	@CacheLookup
	private WebElement previewResultBox;
	@FindBy(xpath = "//input[@placeholder='Enter prefix']")
	@CacheLookup
	private WebElement prefixTextBox;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[2]")
	@CacheLookup
	private WebElement separatorDropdown;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	@CacheLookup
	private WebElement hypenSeparator;
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(.,'-')]")
	@CacheLookup
	private WebElement hypenSeparatorAfterDigits;
	@FindBy(xpath = "//input[@placeholder='Enter display digits']")
	@CacheLookup
	private WebElement digitsTextBox;
	@FindBy(xpath = "(//div[@class='mat-select-arrow'])[3]")
	@CacheLookup
	private WebElement separatorDropdownAfterDigits;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter suffix')]")
	@CacheLookup
	private WebElement suffixTextBox;
	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']//following::span[contains(.,'Set as Default ')]")
	@CacheLookup
	private WebElement setAsDefaultCheckBox;
	@FindBy(xpath = "//span[contains(.,'Cancel')]")
	@CacheLookup
	private WebElement cancelCustomNumberFormat;
	@FindBy(xpath = "(//button[contains(.,'Save')])[2]")
	@CacheLookup
	private WebElement saveCustomNumberFormat;
	@FindBy(xpath = "//div[contains(text(),'is saved successfully')]")
	@CacheLookup
	private WebElement createCustomNumberFormatSuccessMessage;
	String customProductNumber="G-0001-A";

	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/

	@Step("Verify Page Title")
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("Click on New Product Button")
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

	@Step("Verify Create New Product Page")
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

	@Step("Select Non Tracked Product from Dropdown")
	public void selectNonTrackedProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(productTypedropdown));
		productTypedropdown.click();
		nonTrackedProductType.click();
	}

	@Step("Select Tracked Product from Dropdown")
	public void selectTrackedProduct() {
		productTypedropdown.click();
		trackedProductType.click();
	}

	@Step("Select BOM Product from Dropdown")
	public void selectBOMProduct() {
		productTypedropdown.click();
		billsOfMaterialProductType.click();
	}

	@Step("Enter Product Details")
	public void enterProductDetails(String productname, String description, String barcode) {
		ProductNameInputBox.sendKeys(productname);
		barcodeInputBox.sendKeys(barcode);
		descriptionInputBox.sendKeys(description);
	}

	@Step("Click On Accounting Tab")
	public void clickAccountingTab() {
		WDWait(accountingTab);
		accountingTab.click();
	}

	/**************
	 * Purchase account dropdown should not have Sales and Sales Return , Sales
	 * Account should not have Purchase and Purchase Return values
	 */
	
	@Step("Verify Purchase Account Dropdown Values")
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

	@Step("Verify Sales Account Dropdown Values")
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

	@Step("Verify Accounting Tab Elements")
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

	@Step("Verify Accounting Tab Elements for BOM Product")
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

	@Step("Enter Accounting Info")
	public void enterAccountingInfo(String purchaseprice, String salesprice) {
		purchasePrice.clear();
		purchasePrice.sendKeys(purchaseprice);
		salesPrice.clear();
		salesPrice.sendKeys(salesprice);
	}

	@Step("Enter Accounting Info for BOM Product")
	public void enterAccountingInfoForBOMProduct(String salesprice) {
		salesPrice.sendKeys(salesprice);
	}

	@Step("Click on Inventory Tab")
	public void clickInventoryTab() {
		WDWait(inventoryTab);
		inventoryTab.click();
	}

	@Step("Verify Inventory Tab For Non Tracked Product")
	public void verifyInventoryTabForNonTrackedProduct(String defaultUnitOfMeasurement) {
		WDWait(unitOfMeasurement);
		unitOfMeasurement.isDisplayed();
		Assert.assertEquals(unitOfMeasurement.getText(), defaultUnitOfMeasurement);

	}

	@Step("Verify Inventory Tab For Tracked Product")
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

	@Step("Verify Inventory Tab For BOM Product")
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


	@Step("Select Inventory Account")
	public void selectInventoryAccount() {
		inventoryAccount.click();
		WDWait(manufacturingCostInventoryAccount);
		manufacturingCostInventoryAccount.click();
	}

	@Step("Enter Opening Balance Details")
	public void enterOpeningBalanceDetails(String openingquanity, String openingvaluation) {
		openingQuanity.sendKeys(openingquanity);
		openingValuation.sendKeys(openingvaluation);
	}

	@Step("Click On Bills Of Material Tab")
	public void clickBillOfMaterialTab() {
		WDWait(billsOfMaterialTab);
		billsOfMaterialTab.click();
	}

	@Step("Verify On Bills Of Material Tab")
	public void verifyBillOfMaterialTab() {
		WDWait(addComponentProductButton);
		addComponentProductButton.isDisplayed();
		addAdditionalCostButton.isDisplayed();
	}

	@Step("Enter BOM Details")
	public void enterBOMDetails(String quantity1, String quantity2) {
		WDWait(addComponentProductButton);
		addComponentProductButton.click();
		WDWait(componentProduct1TextBox);
		componentProduct1TextBox.click();
		WDWait(componentProduct1Value);
		componentProduct1Value.click();
		component1Quantity.sendKeys(quantity1);
	}

	@Step("Click On Save Button")
	public void clickSaveButton() {
		WDWait(saveButton);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}

	@Step("Verify Create Product Success Message")
	public void verifyCreateProductSuccessMessage() {
		WDWait(createProductSuccessMessage);
		createProductSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(createProductSuccessMessage));
	}

	@Step("Verify Tracked Product Count")
	public void verifyTrackedProductCount() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(trackedProductCount);
		trackedProductCount.isDisplayed();
		Assert.assertEquals(trackedProductCount.getText(), "1");
		zeroItemWithNoStock.isDisplayed();		
	}

	@Step("Verify Non Tracked Product Count")
	public void verifyNonTrackedProductCount() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(nonTrackedProductCount);
		nonTrackedProductCount.isDisplayed();
		Assert.assertEquals(nonTrackedProductCount.getText(), "1");
		zeroItemWithNoStock.isDisplayed();	
	}

	@Step("Verify BOM Product Count")
	public void verifyBomProductCount() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(BOMProductCount);
		BOMProductCount.isDisplayed();
		Assert.assertEquals(BOMProductCount.getText(), "1");
		zeroItemWithNoStock.isDisplayed();	
	}

	@Step("Verify Created Tracked Product")
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

	@Step("Verify Created Non Tracked Product")
	public void verifyCreatedNonTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchRecordsBox));
		WDWait(searchRecordsBox);
		searchRecordsBox.click();
		searchRecordsBox.sendKeys(productname);
		Thread.sleep(5000);
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

	@Step("Verify Inventory Details For Created Non Tracked Product")
	public void verifyInventoryDetailsForCreatedNonTrackedProduct(String defaultUnitOfMeasurement) {
		Actions action = new Actions(driver);
		action.moveToElement(displayedUnitOfMeasurement).perform();
		Assert.assertEquals(displayedUnitOfMeasurement.getText(), defaultUnitOfMeasurement);
	}

	@Step("Verify Inventory Details For Created Tracked Product")
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

	@Step("Verify Created BOM Product")
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

	@Step("Verify Inventory Details For Created BOM Product")
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

	@Step("Select First Product")
	public void selectFirstProduct() {
		WDWait(firstProduct);
		firstProduct.click();
	}

	@Step("Click Three Dots On Non Tracked Product")
	public void clickThreeDotsOnNonTrackedProduct() {
		WDWait(threeDotsOnNonTrackedProduct);
		threeDotsOnNonTrackedProduct.click();
	}
	
	@Step("Click Three Dots On Tracked Product")
	public void clickThreeDotsOnTrackedProduct() {
		WDWait(threeDotsOnTrackedProduct);
		threeDotsOnTrackedProduct.click();
	}
	
	@Step("Click Three Dots On BOM Product")
	public void clickThreeDotsOnBOMProduct() {
		WDWait(threeDotsOnBOMProduct);
		threeDotsOnBOMProduct.click();
	}

	@Step("Click On Edit Button")
	public void clickEditButton() {
		WDWait(editButton);
		editButton.click();
	}
	
	@Step("Click On Copy Button")
	public void clickCopyButton() {
		WDWait(copyButton);
		copyButton.click();
	}
	
	@Step("Click On Delete Button")
	public void clickDeleteButton() {
		WDWait(deleteButton);
		deleteButton.click();
	}
	
	@Step("Edit General Information")
	public void editGeneralInfo(String productname,String barcode,String description) {
		WDWait(ProductNameInputBox);
		ProductNameInputBox.clear();
		ProductNameInputBox.sendKeys(productname);
		barcodeInputBox.clear();
		barcodeInputBox.sendKeys(barcode);
		descriptionInputBox.clear();
		descriptionInputBox.sendKeys(description);	
	}

	@Step("Edit Account Details")
	public void editAccountingDetails(String purchaseprice,String salesprice){
		WDWait(purchaseAccount);
		wait.until(ExpectedConditions.elementToBeClickable(purchaseAccount));
		purchaseAccount.click();
		WDWait(purchaseReturnPurchaseAccount);
		purchaseReturnPurchaseAccount.click();
		purchasePrice.clear();
		purchasePrice.sendKeys(purchaseprice);
		WDWait(salesAccount);
		wait.until(ExpectedConditions.elementToBeClickable(salesAccount));
		salesAccount.click();
		WDWait(salesReturnSalesAccount);
		salesReturnSalesAccount.click();
		salesPrice.clear();
		salesPrice.sendKeys(salesprice);	
	}
	
	@Step("Edit Inventory Details")
	public void editInventoryDetails(String updatedUnitOfMeasurement){
		WDWait(unitOfMeasurement);
		wait.until(ExpectedConditions.elementToBeClickable(unitOfMeasurement));
		unitOfMeasurement.click();
		WDWait(piecesUnitOfMeasurement);
		piecesUnitOfMeasurement.click();
	}
	
	@Step("Click On Save Changes Button")
	public void clickSaveChangesButton(){
		WDWait(saveChangesButton);
		saveChangesButton.click();
	}
	
	@Step("Verify Edit Success Message")
	public void verifyEditSuccessMessage(){
		WDWait(editSuccessMessage);
		editSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(editSuccessMessage));
	}
	
	@Step("Verify Edited Non Tracked Product")
	public void verifyEditedNonTrackedProduct(String productname, String description, String barcode,
			String updatedPurchaseAccount, String purchasePrice, String updatedSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchRecordsBox));
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
		Assert.assertEquals(displayedPurchaseAccount.getText(), updatedPurchaseAccount);
		action.moveToElement(displayedPurchasePrice).perform();
		Assert.assertEquals(displayedPurchasePrice.getText(), purchasePrice);
		action.moveToElement(displayedPurchaseTax).perform();
		Assert.assertEquals(displayedPurchaseTax.getText(), defaultPurchaseTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Buy.isDisplayed();
		action.moveToElement(displayedSalesAccount).perform();
		Assert.assertEquals(displayedSalesAccount.getText(), updatedSalesAccount);
		action.moveToElement(displayedSalesPrice).perform();
		Assert.assertEquals(displayedSalesPrice.getText(), salesPrice);
		action.moveToElement(displayedSalesTax).perform();
		Assert.assertEquals(displayedSalesTax.getText(), defaultSalesTax);
		uncheckedPriceIsTaxInclusiveCheckbox_Sell.isDisplayed();
	}
	
	@Step("Verify Tracked Product Count After Copy Product")
	public void verifyTrackedProductCountAfterCopyProduct() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(trackedProductCount);
		trackedProductCount.isDisplayed();
		Assert.assertEquals(trackedProductCount.getText(), "2");
	}
	
	@Step("Verify Copied Tracked Product")
	public void verifyCopiedTrackedProduct(String productname, String description, String barcode,
			String defaultPurchaseAccount, String purchasePrice, String defaultSalesAccount, String salesPrice,
			String defaultPurchaseTax, String defaultSalesTax) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchRecordsBox));
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
	
	@Step("Verify Delete Confirmation")
	public void verifyDeleteConfirmation(){
		WDWait(deleteConfirmationMessage);
		deleteConfirmationMessage.isDisplayed();
		noButtonOnDeleteConfirmation.isDisplayed();
		yesButtonOnDeleteConfirmation.isDisplayed();
	}
	
	@Step("Click Yes Button On Delete Confirmation")
	public void clickYesButtonOnDeleteConfirmation() throws InterruptedException{
	    WDWait(yesButtonOnDeleteConfirmation);
		wait.until(ExpectedConditions.elementToBeClickable(yesButtonOnDeleteConfirmation));
		yesButtonOnDeleteConfirmation.click();	
	}
	
	@Step("Verify Delete Product Success Message")
	public void verifyDeleteProductSuccessMessage() {
		WDWait(deleteSuccessMessage);
		deleteSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(deleteSuccessMessage));
	}
	
	@Step("Verify BOM Product Count After Delete")
	public void verifyBOMProductCountAfterDelete() throws InterruptedException {
		// Thread.sleep(5000);
		if (startByAddingOrImportingYourProducsText.size() != 0) {
			Thread.sleep(2000);
			closeIcon.click();
		}
		WDWait(BOMProductCount);
		BOMProductCount.isDisplayed();
		Assert.assertEquals(BOMProductCount.getText(), "0");
	}
	
	@Step("Verify Deleted Product")
	public void verifyDeletedProduct(String BOMProductName) {
		if (driver.getPageSource().contains(BOMProductName)){
			System.out.println("Product not deleted");
			Assert.fail();        
		}
		else{
			System.out.println("Product Deleted successfully");
		}
	}
	
	@Step("Click On Custom Number Format Button")
	public void clickCustomNumberFormat() {
		wait.until(ExpectedConditions.elementToBeClickable(customNumberFormat));
		customNumberFormat.click();
	}
	
	@Step("Verify Custom Number Format Page Elements ")
	public void verifyCustomNumberFormatPageElements() {
		WDWait(previewText);
		previewText.isDisplayed();
		previewResultBox.isDisplayed();
		prefixTextBox.isDisplayed();
		separatorDropdown.isDisplayed();
		digitsTextBox.isDisplayed();
		separatorDropdownAfterDigits.isDisplayed();
		suffixTextBox.isDisplayed();
		setAsDefaultCheckBox.isDisplayed();
		cancelCustomNumberFormat.isDisplayed();
		saveCustomNumberFormat.isDisplayed();
	}
	
	@Step("Enter / Select Custom Number format details ")
	public void enterCustomNumberFormat() {
		WDWait(prefixTextBox);
		prefixTextBox.sendKeys("G");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdown));
		separatorDropdown.click();
		WDWait(hypenSeparator);
		hypenSeparator.click();
		digitsTextBox.clear();
		digitsTextBox.sendKeys("4");
		wait.until(ExpectedConditions.elementToBeClickable(separatorDropdownAfterDigits));
		separatorDropdownAfterDigits.click();
		WDWait(hypenSeparatorAfterDigits);
		hypenSeparatorAfterDigits.click();
		WDWait(suffixTextBox);
		suffixTextBox.sendKeys("A");	
	}
	
	@Step("Preview Custom Number format")
	public void previewCustomNumberFormat() {
		WDWait(previewResultBox);
		Assert.assertEquals(previewResultBox.getText(), customProductNumber);	
	}
	
	@Step("Click on Save Button on Custom Number Format Page")
	public void clickSaveCustomNumberFormat() throws InterruptedException {
		WDWait(saveCustomNumberFormat);
		saveCustomNumberFormat.click();
		Thread.sleep(4000);
	}
	
	@Step("Verify Custom Number Format In Product Number")
	public void verifyCustomNumberFormatInProductNumber() throws InterruptedException {
		WDWait(productNumber);
		Thread.sleep(5000);
		Assert.assertEquals(productNumber.getAttribute("value"), customProductNumber);		
	}
	
	@Step("Verify Create Custom Number Format Success Message")
	public void verifyCustomNumberFormatSuccessMessage() {
		WDWait(createCustomNumberFormatSuccessMessage);
		createCustomNumberFormatSuccessMessage.isDisplayed();
		wait.until(ExpectedConditions.invisibilityOf(createCustomNumberFormatSuccessMessage));
	}
	
	@Step("Verify Dispalyed Product Number and Format")
	public void verifyDisplayedProductNumber() {
		WDWait(displayedProductNumber);
		Actions action = new Actions(driver);
		action.moveToElement(displayedProductNumber).perform();
        Assert.assertEquals(displayedProductNumber.getText(), customProductNumber);
	}
}
