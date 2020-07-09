package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

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

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class EditContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public EditContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);

		
	}

	/******************************* EDIT CONTACT PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']")
	
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Edit')]")
	
	private WebElement editButton;
	@FindBy(xpath= "//input[@formcontrolname='name']")
	
	private WebElement name;
	@FindBy(xpath= "//input[@formcontrolname='email']")
	
	private WebElement emailAddress;
	@FindBy(xpath= "//input[@formcontrolname='uen']")
	
	private WebElement contactUEN;
	@FindBy(xpath= "//input[@formcontrolname='tax']")
	
	private WebElement taxNumber;
	
	@FindBy(xpath= "//div[contains(text(),'Address')]")
	
	private WebElement address;
	@FindBy(xpath= "//textarea[@formcontrolname='address1']")
	
	private WebElement enterAddress;
	@FindBy(xpath= "//input[@formcontrolname='state']")
	
	private WebElement state;
	@FindBy(xpath= "//input[@formcontrolname='postalCode']")
	
	private WebElement postalCode;
	@FindBy(xpath= "//input[@formcontrolname='city']")
	
	private WebElement city;
	@FindBy(xpath= "//input[@formcontrolname='country']")
	
	private WebElement country;
	
	@FindBy(xpath= "//span[contains(text(),'Save Changes')]")
	
	private WebElement saveChangeButton;
	
	@FindBy(xpath= "//span[text()='Contact is successfully Updated']")
	
	private WebElement updateContactSuccessMessage;
	
	@FindBy(xpath= "//input[@placeholder='Search Records']")
	
	private WebElement searchRecord;
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/mat-table/mat-row[1]/mat-cell[3]")
	
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
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
	}
	@Step("Click on Context Menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		WDWait(contextMenuIcon);
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
		contextMenuIcon.isDisplayed();
		contextMenuIcon.click();
	}
	@Step("Click on Edit button")
	public void clickEditButton(){
		
		WDWait(editButton);
		wait.until(ExpectedConditions.elementToBeClickable(editButton));
		editButton.isDisplayed();
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
