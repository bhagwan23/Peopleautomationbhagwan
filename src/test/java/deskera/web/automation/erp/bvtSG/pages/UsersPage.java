package deskera.web.automation.erp.bvtSG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UsersPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public UsersPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
		
		
		/******************************* Users  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'addADD USER')]")
	@CacheLookup
	private WebElement addUsersButton;	
	@FindBy(xpath = "(//button[text()=' Name '])[1]")
	@CacheLookup
	private WebElement nameColumn;	
	@FindBy(xpath = "(//button[text()=' Email '])[1]")
	@CacheLookup
	private WebElement emailColumn;	
	@FindBy(xpath = "(//button[text()=' Role '])[1]")
	@CacheLookup
	private WebElement roleColumn;	
	private static String pageTitleText = "Deskera Books";
	
	
	/******************************* Add User Section  ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//input[contains(@placeholder,'First Name')]")
	@CacheLookup
	private WebElement firstName;
	@FindBy(xpath = "//input[@placeholder='Last name']")
	@CacheLookup
	private WebElement lastName;
	@FindBy(xpath = "//input[@placeholder='Email']")
	@CacheLookup
	private WebElement email;
	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	private WebElement password;
	@FindBy(xpath = "//input[@value='phoneNumber']")
	@CacheLookup
	private WebElement phoneNumber;
	@FindBy(xpath = "//div[@class='wtf2-form-field-infix'][contains(.,'Assign Roles  *')]")
	@CacheLookup
	private WebElement assignRolesDropdown;
	@FindBy(xpath = "//span[contains(.,'Business')]")
	@CacheLookup
	private WebElement businessRole;
	@FindBy(xpath = "//span[contains(.,'CANCEL')]")
	@CacheLookup
	private WebElement cancelButton;
	@FindBy(xpath = "//span[contains(text(),'SAVE')]")
	@CacheLookup
	private WebElement saveButton;
	

	/***********************************
	 * 
	 * Page objects manipulation methods
	* 
	 *********************************/
	public void verifyPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void verifyUsersPageElements(){
		WDWait(addUsersButton);
		addUsersButton.isDisplayed();
		WDWait(nameColumn);
		nameColumn.isDisplayed();
		emailColumn.isDisplayed();
		roleColumn.isDisplayed();
	}
	
	public void clickAddUserButton(){
		addUsersButton.click();
	}
	
	public void verifyAddUserPageElements(){
		WDWait(firstName);
		firstName.isDisplayed();
		lastName.isDisplayed();
		email.isDisplayed();
		password.isDisplayed();
		phoneNumber.isDisplayed();
		assignRolesDropdown.isDisplayed();
		cancelButton.isDisplayed();
		saveButton.isDisplayed();
	}
	
	public void enterUserDetails(String firstname,String lastname,String emailid,String passWord,String phone){
		WDWait(firstName);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(emailid);
		password.sendKeys(passWord);
		phoneNumber.sendKeys(phone);
		assignRolesDropdown.click();
		WDWait(businessRole);
		businessRole.click();
	}
	
	public void clickSaveButton(){
		saveButton.click();
	}
}

