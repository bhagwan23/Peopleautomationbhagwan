package deskera.web.automation.erp.bvtSG.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Create Org  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//button[contains(.,'Getting Started')]")
	@CacheLookup
	private WebElement gettingStartedButton;
	@FindBy(xpath = "//button[contains(text(),'Demo Company')]")
	@CacheLookup
	private WebElement demoCompanyButton;
	@FindBy(xpath = "//span[text()='Switched to Demo Organization']")
	@CacheLookup
	private WebElement switchedToDemoCompanySuccessMessage;
	@FindBy(xpath = "//span[text()='Demo Company(SG)']")
	@CacheLookup
	private WebElement demoCompanyName;
	@FindBy(xpath = "//input[contains(@formcontrolname,'countryLookupCode')]")
	@CacheLookup
	private WebElement taxResidency;
	@FindBy(xpath = "//span[contains(.,'Singapore')]")
	@CacheLookup
	private WebElement singaporeTaxResidency;
	@FindBy(xpath = "//input[@formcontrolname='financialStartDate']")
	@CacheLookup
	private WebElement financialStartDate;
	@FindBy(xpath = "//input[@formcontrolname='bookBeginningStartDate']")
	@CacheLookup
	private WebElement bookBeginningDate;
	@FindBy(xpath = "//input[contains(@formcontrolname,'address1')]")
	@CacheLookup
	private WebElement addressLine1;
	@FindBy(xpath = "//input[@formcontrolname='address2']")
	@CacheLookup
	private WebElement addressLine2;
	@FindBy(xpath = "//input[@formcontrolname='city']")
	@CacheLookup
	private WebElement city;
	@FindBy(xpath = "//input[@formcontrolname='state']")
	@CacheLookup
	private WebElement state;
	@FindBy(xpath = "//input[@placeholder='Zip Code']")
	@CacheLookup
	private WebElement zipcode;
	@FindBy(xpath = "//input[@formcontrolname='gstNo']")
	@CacheLookup
	private WebElement gstNo;
	@FindBy(xpath = "//input[@formcontrolname='uenNo']")
	@CacheLookup
	private WebElement uenNo;
	@FindBy(xpath = "//button[contains(.,'Save')]")
	@CacheLookup
	private WebElement saveButton;
	@FindBy(xpath = "//div[@id='cdk-overlay-6']/snack-bar-container/simple-snack-bar/span")
	@CacheLookup
	private WebElement successMessage;	
	@FindBy(xpath = "(//button[contains(.,'Skip')])[2]")
	@CacheLookup
	private WebElement skipButton;	
	private static String pageTitleText = "Deskera Books";
	private static String createOrgSuccessMessageText = "Organization Added Successfully";
	
	
	/******************************* HOMEPAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span[contains(.,'Products')]")
	@CacheLookup
	private WebElement productsTab;
	@FindBy(xpath = "//span[contains(text(),'Settings')]")
	@CacheLookup
	private WebElement settingTab;
	@FindBy(xpath = "//span[contains(.,'Users')]")
	@CacheLookup
	private WebElement usersTab;
	
	
	
	

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
	
	public void verifyorgElements() {
		WDWait(taxResidency);
		taxResidency.isDisplayed();
		WDWait(financialStartDate);
		financialStartDate.isDisplayed();
		bookBeginningDate.isDisplayed();
		addressLine1.isDisplayed();
		addressLine2.isDisplayed();
		gstNo.isDisplayed();
		saveButton.isDisplayed();
	}
	
	public void enterOrgDetails(String taxresidency,String fstartdate,String bookbeginningdate,String addline1,String addline2,String City,String State,String Zipcode){
		taxResidency.click();
		taxResidency.clear();
		taxResidency.sendKeys(taxresidency);
		singaporeTaxResidency.click();
		financialStartDate.clear();
		financialStartDate.sendKeys(fstartdate);
		bookBeginningDate.clear();
		bookBeginningDate.sendKeys(bookbeginningdate);
		addressLine1.click();
		addressLine1.sendKeys(addline1);
		addressLine2.click();
		addressLine2.sendKeys(addline2);
		city.sendKeys(City);
		state.sendKeys(State);
		zipcode.sendKeys(Zipcode);
		gstNo.sendKeys("859558565856855");
		uenNo.sendKeys("5895685");
	}
	
	public void clickSaveButton(){
		saveButton.click();
	}
	
	public void verifyCreateOrgSuccessMessage(){
		System.out.println(successMessage.getText());
		Assert.assertEquals(successMessage.getText().contains(createOrgSuccessMessageText), true);
	}
	
	public void clickSkipButton(){
		WDWait(skipButton);
		skipButton.click();
	}
	
	public void clickProductsTab(){
		WDWait(productsTab);
		productsTab.click();
	}
	
	public void clickGettingStartedButton(){
		WDWait(gettingStartedButton);
		gettingStartedButton.click();
	}
	
	public void clickDemoCompany(){
		WDWait(demoCompanyButton);
		demoCompanyButton.click();
	}
	
	public void verifyDemoCompanySuccessMessage(){
		WDWait(switchedToDemoCompanySuccessMessage);
		switchedToDemoCompanySuccessMessage.click();
		WDWait(demoCompanyName);
		demoCompanyName.isDisplayed();
	}
	
	public void clickSettingTab() throws InterruptedException{
		//Thread.sleep(8000);
		//WDWait(settingTab); 
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", settingTab);
		 * settingTab.click();
		 */
		
		Actions builder = new Actions(driver);
        Action mouseOverSettings = builder
                .moveToElement(settingTab)
                .build();
        System.out.println("Before hover: ");
        mouseOverSettings.perform(); 
        System.out.println("First Hover done");
		//Actions action=new Actions(driver);
		//action.moveToElement(settingTab).click().perform();
		//settingTab.click();
	}
	
	public void clickUsersTab(){
		WDWait(usersTab);
		usersTab.click();
	}
	
}
