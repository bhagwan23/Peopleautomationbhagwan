package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateBankPage {

	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public CreateBankPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* CREATE BANK PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//*[@id='container-1']/dt-navbar/div/ul/li[9]/a/span")
	
	private WebElement bankButton;
	@FindBy(xpath= "//span[contains(text(),'ACC10001')]")
	
	private WebElement defaultbankcode;
	@FindBy(xpath= "//button[@class='wtf2-flat-button text-uppercase wtf2-primary pl-3 wtf2-button']")
	
	private WebElement addBankButton;
	@FindBy(xpath= "//input[@id='wtf2-input-0']")
	
	private WebElement code;
	@FindBy(xpath= "//input[@id='wtf2-input-1']")
	
	private WebElement name;
	@FindBy(xpath= "//input[@id='accdesc']")
	
	private WebElement description;
	@FindBy(xpath= "//*[@id='cdk-step-content-0-0']/form/div[4]/div/wtf2-form-field/div/div[1]/div[3]")
	
	private WebElement currency;
	@FindBy(xpath= "//wtf2-split-button-title[@class='wtf2-split-button-title']")
	
	private WebElement	selectAndConnectButton;
	@FindBy(xpath= "//span[contains(text(),'CANCEL')]")
	
	private WebElement cancelButton;
	@FindBy(xpath= "//wtf2-icon[@class='wtf2-accent-fg mt-2 wtf2-icon notranslate material-icons wtf2-icon-no-color']")
	
	private WebElement	crossIconButton;
	@FindBy(xpath= "//wtf2-icon[contains(text(),'keyboard_arrow_down')]")
	
	private WebElement dropDownButton;
	@FindBy(xpath= "//button[@class='ng-star-inserted']")
	
	private WebElement saveAndCloseButton;
	@FindBy(xpath= "//*[@id='AccountAccordionGrid']/wtf2-table/wtf2-row[1]/wtf2-cell[2]/span/wtf2-format-value/span")
	
	private WebElement accountHSBC;
	@FindBy(xpath= "//wtf2-row[1]//wtf2-cell[8]//span[1]//div[1]//button[1]//span[1]//wtf2-icon[1]")
	
	private WebElement accContextMenuButton;
	@FindBy(xpath= "//div[@class='cdk-overlay-container']//div[5]//button[1]")
	
	private WebElement connectButton;
	
	/******************************* Banks Object Manipulation Methods *******************/

	public void openURL(String URL) {
		driver.get(URL);
	}
	// Common util for webdriver wait
		public void WDWait(WebElement we) {
			wait.until(ExpectedConditions.visibilityOf(we));
		}
		
		public void clickOnBanktab(){
			WDWait(bankButton);
			bankButton.isDisplayed();
			bankButton.click();
		}
		public void verifyDefaultBank(){
			WDWait(defaultbankcode);
			defaultbankcode.isDisplayed();
			Assert.assertEquals(defaultbankcode.getText(), "ACC10001");
		}
		public void clickAddButton(){
			WDWait(addBankButton);
			addBankButton.isDisplayed();
			addBankButton.click();
		}
		public void verifyAccountDetailElements(){
			WDWait(code);
			code.isDisplayed();
			WDWait(name);
			name.isDisplayed();
			WDWait(description);
			description.isDisplayed();
			WDWait(currency);
			currency.isDisplayed();
			Assert.assertEquals(currency.getText(), "Singapore Dollar (SGD)");
			selectAndConnectButton.isDisplayed();
			cancelButton.isDisplayed();
			crossIconButton.isDisplayed();
			
		}
		public void enterAccountDetails(String code1, String name1, String Desc){
			WDWait(code);
			code.sendKeys(code1);
			name.sendKeys(name1);
			description.sendKeys(Desc);
			
		}
		public void clickSaveAndCloseButton(){
			WDWait(dropDownButton);
			dropDownButton.click();
			WDWait(saveAndCloseButton);
			saveAndCloseButton.click();
			driver.navigate().refresh();
		}
		public void verifySavedAccount(){
			WDWait(accountHSBC);
			accountHSBC.isDisplayed();
			WDWait(accContextMenuButton);
			accContextMenuButton.isDisplayed();
			accContextMenuButton.click();
		}
		public void clickOnConnectButton(){
			WDWait(connectButton);
			connectButton.isDisplayed();
			connectButton.click();
		}
}
