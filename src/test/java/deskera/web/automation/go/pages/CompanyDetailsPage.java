package deskera.web.automation.go.pages;

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

public class CompanyDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CompanyDetailsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/******************************* Company Details  PAGE ELEMENTS LOCATORS *******************/

	@FindBy(xpath = "//img[contains(@class,'logo img-circle ng-star-inserted')]")
	
	private WebElement companyLogo;
	@FindBy(xpath = "//div[@class='ellipsis company-name']")
	
	private WebElement companyName;
	@FindBy(xpath = "//wtf2-icon[contains(.,'keyboard_arrow_down')]")
	
	private WebElement companyNameArrow;
	@FindBy(xpath = "//span[contains(.,'My Account')]")
	
	private WebElement myAccountTab;
	@FindBy(xpath = "//span[contains(.,'Company Details')]")
	
	private WebElement companyDetailsTab;
	@FindBy(xpath = "//span[contains(.,'Billing')]")
	
	private WebElement billingTab;
	@FindBy(xpath = "//span[contains(.,'User Management')]")
	
	private WebElement userManagementTab;
	@FindBy(xpath = "//wtf2-icon[contains(@wtf2tooltip,'Collapse')]")
	
	private WebElement collapseIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'home')])[2]")
	
	private WebElement homeIcon_CompanyDetailsPage;
	@FindBy(xpath = "//li[@aria-current='page'][contains(.,'My Account')]")
	
	private WebElement MyAccountText_CompanyDetailsPage;
	@FindBy(xpath = "(//h6[contains(text(),'Company Details')])[1]")
	
	private WebElement CompanyDetailsPageHeader;
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	
	private WebElement companyDetailsCancelButton;
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	
	private WebElement companyDetailsSavelButton;
	@FindBy(xpath = "//img[@id='company-logo']")
	
	private WebElement AddCompanyLogoIcon;
	@FindBy(xpath = "//h6[contains(text(),'Company logo')]")
	
	private WebElement CompanyLogoText;
	@FindBy(xpath = "//span[contains(text(),'Add your company logo here')]")
	
	private WebElement addYourCompanyLogoHereText;
	
	/****************** ADD/EDIT Company Details  Section Elements  *******************/
	
	@FindBy(xpath = "(//h6[contains(text(),'Company Details')])[2]")
	
	private WebElement CompanyDetailsText;
	@FindBy(xpath = "//label[contains(text(),' Company Name ')]")
	
	private WebElement companyNameLabel;
	@FindBy(xpath = "//input[@formcontrolname='name' and @placeholder='Company Name' ]")
	
	private WebElement companyNameInputBox;
	@FindBy(xpath = "//label[contains(text(),' Address Line 1 ')]")
	
	private WebElement addressLine1Label;
	@FindBy(xpath = "//input[contains(@formcontrolname,'addressLine1')]")
	
	private WebElement addressLine1InputBox;
	@FindBy(xpath = "//label[contains(text(),' Address Line 2 ')]")
	
	private WebElement addressLine2Label;
	@FindBy(xpath = "//input[contains(@formcontrolname,'addressLine2')]")
	
	private WebElement addressLine2InputBox;
	@FindBy(xpath = "//label[contains(text(),'City')]")
	
	private WebElement cityLabel;
	@FindBy(xpath = "//input[contains(@formcontrolname,'city')]")
	
	private WebElement cityInputBox;
	@FindBy(xpath = "//label[contains(text(),'Zipcode')]")
	
	private WebElement zipcodeLabel;
	@FindBy(xpath = "//input[@formcontrolname='zip']")
	
	private WebElement zipcodeInputBox;
	@FindBy(xpath = "//label[contains(text(),'State')]")
	
	private WebElement stateLabel;
	@FindBy(xpath = "//input[@formcontrolname='state']")
	
	private WebElement stateInputBox;
	@FindBy(xpath = "//label[contains(text(),'Country')]")
	
	private WebElement countryLabel;
	@FindBy(xpath = "//input[@formcontrolname='country']")
	
	private WebElement countryInputBox;
	
	/****************** Contact Information Section Elements  *******************/
	
	@FindBy(xpath = "//h6[contains(text(),'Contact Information')]")
	
	private WebElement contactInformationText;
	@FindBy(xpath = "//label[contains(text(),' Phone Number ')]")
	
	private WebElement phoneNumberLabel;
	@FindBy(xpath = "//span[@ng-reflect-klass='country-selector-flag flag']")
	
	private WebElement countryFlagIcon;
	@FindBy(xpath = "//span[@class='country-selector-code']")
	
	private WebElement countryCodeSelector;
	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button//div[contains(text(),'United States +1')]")
	
	private WebElement USCode;
	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button//div[contains(text(),'Singapore +65')]")
	
	private WebElement SGCode;
	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button//div[contains(text(),'India') and contains(text(),'+91')]")
	
	private WebElement INCode;
	@FindBy(xpath = "//input[contains(@value,'phoneNumber')]")
	
	private WebElement phoneNumberInputBox;
	@FindBy(xpath = "//label[contains(text(),'Email')]")
	
	private WebElement emailLabel;
	@FindBy(xpath = "//input[contains(@placeholder,'Email')]")
	
	private WebElement emailInputBox;
	@FindBy(xpath = "//label[contains(text(),'Fax Number ')]")
	
	private WebElement faxNumberLabel;
	@FindBy(xpath = "//input[contains(@placeholder,'Fax Number')]")
	
	private WebElement faxNumberInputBox;
	@FindBy(xpath = "//label[contains(text(),'Website')]")
	
	private WebElement websiteLabel;
	@FindBy(xpath = "//input[contains(@formcontrolname,'website')]")
	
	private WebElement websiteInputBox;
	@FindBy(xpath = "//h6[contains(text(),'Change Password')]")
	
	private WebElement changePasswordText;
	@FindBy(xpath = "//span[contains(text(),'Change Password')]")
	
	private WebElement changePasswordButton;
	@FindBy(xpath = "//div[@class='toast-top-right toast-container']")
	
	private WebElement addCompanyDetailsSuccessMessage;
	String successMessageText="Updated company details successfully";
	
	
	
	/******************************* Home PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//span//img[@class='logo']")
	
	private WebElement chatIcon;
	@FindBy(xpath = "//span//wtf2-icon[text()='home' or @wtf2tooltip='Your Deskera Apps' ]")
	
	private WebElement homeIcon;
	@FindBy(xpath = "//wtf2-icon[@role='img' and text()='apps']")
	
	private WebElement switchToIcon;
	@FindBy(xpath = "//span[@class='profile-pic-launchpad']//img")
	
	private WebElement userProfileIcon;
	private static String pageTitleText = "Deskera Cloud";

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
	
	public void verifyCompanyDetailsPageElements() {
		WDWait(companyLogo);
		companyLogo.isDisplayed();
		WDWait(companyName);
		companyName.isDisplayed();
		companyNameArrow.isDisplayed();
		myAccountTab.isDisplayed();
		companyDetailsTab.isDisplayed();
		billingTab.isDisplayed();
		userManagementTab.isDisplayed();
		collapseIcon.isDisplayed();
		homeIcon_CompanyDetailsPage.isDisplayed();
		WDWait(MyAccountText_CompanyDetailsPage);
		MyAccountText_CompanyDetailsPage.isDisplayed();
		CompanyDetailsPageHeader.isDisplayed();
		companyDetailsCancelButton.isDisplayed();
		companyDetailsSavelButton.isDisplayed();
		WDWait(AddCompanyLogoIcon);
		AddCompanyLogoIcon.isDisplayed();
		CompanyLogoText.isDisplayed();
		addYourCompanyLogoHereText.isDisplayed();
		CompanyDetailsText.isDisplayed();
		companyNameLabel.isDisplayed();
		companyNameInputBox.isDisplayed();
		addressLine1Label.isDisplayed();
		addressLine1InputBox.isDisplayed();
		addressLine2Label.isDisplayed();
		addressLine2InputBox.isDisplayed();
		cityLabel.isDisplayed();
		cityInputBox.isDisplayed();
		zipcodeLabel.isDisplayed();
		zipcodeInputBox.isDisplayed();
		stateLabel.isDisplayed();
	    stateInputBox.isDisplayed();
		countryLabel.isDisplayed();
		countryInputBox.isDisplayed();
		contactInformationText.isDisplayed();
		phoneNumberLabel.isDisplayed();
		countryFlagIcon.isDisplayed();	
		countryCodeSelector.isDisplayed();
		phoneNumberInputBox.isDisplayed();
		emailLabel.isDisplayed();
		emailInputBox.isDisplayed();
		faxNumberLabel.isDisplayed();
		faxNumberInputBox.isDisplayed();
		websiteLabel.isDisplayed();	
		websiteInputBox.isDisplayed();
		changePasswordText.isDisplayed();	
		changePasswordButton.isDisplayed();	
		chatIcon.isDisplayed();
		homeIcon.isDisplayed();
		switchToIcon.isDisplayed();
		userProfileIcon.isDisplayed();
	}
	
	public void uploadCompanyLogo() throws InterruptedException{
		WDWait(AddCompanyLogoIcon);
		AddCompanyLogoIcon.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action =new Actions(driver);
		action.sendKeys("C:\\Users\\krawler\\Desktop\\test.png").perform();
		action.sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.ENTER).perform();
		//AddCompanyLogoIcon.sendKeys("C:/Users/krawler/Desktop/test.png");
	}
	
	public void addCompanyDetails(String add1,String add2,String city,String zip,String state,String country){
		addressLine1InputBox.clear();
		addressLine1InputBox.sendKeys(add1);
		addressLine2InputBox.clear();
		addressLine2InputBox.sendKeys(add2);
		cityInputBox.clear();
		cityInputBox.sendKeys(city);
		zipcodeInputBox.clear();
		zipcodeInputBox.sendKeys(zip);
		stateInputBox.clear();
		stateInputBox.sendKeys(state);
		countryInputBox.clear();
		countryInputBox.sendKeys(country);
	}
	
	public void addContactInformation(String phone,String fax,String website){
		countryCodeSelector.click();
		INCode.click();
		phoneNumberInputBox.clear();
		phoneNumberInputBox.sendKeys(phone);
		faxNumberInputBox.clear();
		faxNumberInputBox.sendKeys(fax);
		websiteInputBox.clear();
		websiteInputBox.sendKeys(website);
	}
	
	public void clickSaveButton() throws InterruptedException{
		companyDetailsSavelButton.click();	
	}
	
	public void verifySuccessMessage() throws InterruptedException{
		WDWait(addCompanyDetailsSuccessMessage);
		Assert.assertEquals(addCompanyDetailsSuccessMessage.getText().contains(successMessageText), true);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.invisibilityOf(addCompanyDetailsSuccessMessage));
	}
	
	public void verifyAddedCompanyDetails(String add1,String add2,String city,String zip,String state,String country){
		WDWait(addressLine1InputBox);
		System.out.println("Add input =" +addressLine1InputBox.getText());
		System.out.println("Label= "+addressLine1Label.getText());
		System.out.println("Attribute ="+addressLine1InputBox.getAttribute(add1));
		Assert.assertEquals(addressLine1InputBox.getText(), "Address1");
		Assert.assertEquals(addressLine2InputBox.getText(), add2);
		Assert.assertEquals(cityInputBox.getText(), city);
		Assert.assertEquals(zipcodeInputBox.getText(), zip);
		Assert.assertEquals(stateInputBox.getText(), state);
		Assert.assertEquals(countryInputBox.getText(), country);
	}
	
	public void verifyAddedContactInformation(String phone,String fax,String website){
		Assert.assertEquals(phoneNumberInputBox.getText(), phone);
		Assert.assertEquals(faxNumberInputBox.getText(), fax);
		Assert.assertEquals(websiteInputBox.getText(), website);
	}

}
