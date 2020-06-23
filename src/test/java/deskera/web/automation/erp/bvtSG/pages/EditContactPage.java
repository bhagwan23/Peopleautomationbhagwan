package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	/*******************************Edit Contacts Object Manipulation Methods *******************/
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	public void clickContextMenuIcon(){
		WDWait(contextMenuIcon);
		contextMenuIcon.isDisplayed();
		contextMenuIcon.click();
	}
	public void clickEditButton(){
		WDWait(editButton);
		editButton.isDisplayed();
		editButton.click();
	}
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
	
	public void clickSaveChangeButton(){
		WDWait(saveChangeButton);
		saveChangeButton.isDisplayed();
		saveChangeButton.click();
	}
	public void verifysuccessmessage(){
		WDWait(updateContactSuccessMessage);
		updateContactSuccessMessage.isDisplayed();
	}
	
}
