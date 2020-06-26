package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class EditContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public EditContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* EDIT CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	@CacheLookup
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Edit')]")
	@CacheLookup
	private WebElement editButton;
	@FindBy(id= "mat-input-1")
	@CacheLookup
	private WebElement name;
	@FindBy(xpath= "//input[@id='mat-input-2']")
	@CacheLookup
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@id='mat-input-5']")
	@CacheLookup
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@id='mat-input-6']")
	@CacheLookup
	private WebElement taxNumber;

	@FindBy(xpath= "//div[contains(text(),'Address')]")
	@CacheLookup
	private WebElement address;
	@FindBy(xpath= "//textarea[@id='mat-input-7']")
	@CacheLookup
	private WebElement enterAddress;
	@FindBy(xpath= "//input[@id='mat-input-10']")
	@CacheLookup
	private WebElement state;
	@FindBy(xpath= "//input[@id='mat-input-8']")
	@CacheLookup
	private WebElement postalCode;
	@FindBy(xpath= "//input[@id='mat-input-9']")
	@CacheLookup
	private WebElement city;
	@FindBy(xpath= "//input[@id='mat-input-11']")
	@CacheLookup
	private WebElement country;

	@FindBy(xpath= "//span[contains(text(),'Save Changes')]")
	@CacheLookup
	private WebElement saveChangeButton;

	@FindBy(xpath= "//span[text()='Contact is successfully Updated']")
	@CacheLookup
	private WebElement updateContactSuccessMessage;

	@FindBy(xpath= "//input[@placeholder='Search Records']")
	@CacheLookup
	private WebElement searchRecord;
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/mat-table/mat-row[1]/mat-cell[3]")
	@CacheLookup
	private WebElement enteredName;

	/*******************************Edit Contacts Object Manipulation Methods *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("Search contact to edit")
	public void searchRecord(String cName) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		Thread.sleep(5000);
		/*Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();*/

	}
	@Step("Click on Context Menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		WDWait(contextMenuIcon);
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		contextMenuIcon.isDisplayed();
		//Thread.sleep(2000);
		contextMenuIcon.click();
	}
	@Step("Click on Edit button")
	public void clickEditButton() throws InterruptedException{

		//WDWait(editButton);
		//wait.until(ExpectedConditions.visibilityOf(editButton));
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		editButton.isDisplayed();
		//Thread.sleep(2000);
		editButton.click();	

	}
	@Step("Enter new general info")
	public void editGeneralInfo(String cname,String email, String uenno, String taxno){

		WDWait(name);
		name.clear();
		name.sendKeys(cname);

		WDWait(emailAddress);
		emailAddress.clear();
		emailAddress.sendKeys(email);

		WDWait(contactUEN);
		contactUEN.clear();
		contactUEN.sendKeys(uenno);

		WDWait(taxNumber);
		taxNumber.clear();
		taxNumber.sendKeys(taxno);
	}
	@Step("Enter new address info")
	public void editAddressInfo(String addr, String state1,String postal, String city1, String country1){ 
		WDWait(address);
		address.isDisplayed();
		address.click();

		WDWait(enterAddress);
		enterAddress.clear();
		enterAddress.sendKeys(addr);

		WDWait(state);
		state.clear();
		state.sendKeys(state1);

		WDWait(postalCode);
		postalCode.clear();
		postalCode.sendKeys(postal);

		WDWait(city);
		city.clear();
		city.sendKeys(city1);

		WDWait(country);
		country.clear();
		country.sendKeys(country1);
	}
	@Step("Click on save and change button")
	public void clickSaveChangeButton(){
		WDWait(saveChangeButton);
		saveChangeButton.isDisplayed();
		saveChangeButton.click();
	}
	@Step("Verify success message")
	public void verifysuccessmessage(){
		WDWait(updateContactSuccessMessage);
		updateContactSuccessMessage.isDisplayed();
	}

}
