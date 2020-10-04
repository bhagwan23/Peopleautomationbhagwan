package deskera.web.automation.people.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import deskera.people.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class Pr1EmployeePayrunPage {
	
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public Pr1EmployeePayrunPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}
	
	/*******************************
	 * CREATE NEW EMPLOYEE PAGE ELEMENTS LOCATORS
	 *******************/

	// this.driver=driver;
	@FindBy(xpath = "//span[@class='nav-link-title ng-star-inserted'][contains(.,'Employees')]")
	WebElement Employeeclick;

	@FindBy(xpath = "//button[@tour_title='Add Employee']")
	WebElement Addempbutton;

	// Employee Details
	@FindBy(xpath = "//span[contains(.,'Name*')]")
	WebElement Name;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	WebElement EmailID;

	@FindBy(xpath = "//input[@formcontrolname='designation']")
	WebElement Designation;

	@FindBy(xpath = "//input[@formcontrolname='dateOfBirth']")
	WebElement Dateofbirth;

	@FindBy(xpath = "//input[@formcontrolname='dateOfJoining']")
	WebElement Dateofjoining;

	@FindBy(xpath = "//input[@formcontrolname='compensation']")
	WebElement Basicsal;

	@FindBy(xpath = "//span[@class='mx-3' and text()='NEXT']")
	WebElement EmployeedetailsNext;

//	@FindBy(xpath = "(//h5[contains(.,'Basic/Salary')])[2]")
//	WebElement Basicsalarytext;
//
//	//@FindBy(xpath = "//button[contains(.,'NEXT')]")
//	//WebElement ComponentNext;
//
//	@FindBy(xpath = "//span[@class='mx-3'][contains(.,'NEXT')]")
//	WebElement CompNext;

	@FindBy(xpath = "(//input[@formcontrolname='amount'])[5]")
	WebElement AllowanceAmount;
	
	@FindBy(xpath = "(//input[contains(@formcontrolname,'amount')])[6]")
	WebElement DeductionAmount;
	
	@FindBy(xpath = "//button[contains(.,'NEXT')]")
	WebElement CompNext;
	
	/*******************************
	 * CREATE EMPLOYEE PAGE ELEMENTS LOCATORS
	 *******************/
	
	@FindBy(xpath = "(//div[contains(.,'Permanent ResidentImmigration Status *')])[26]")
	WebElement immigrationStatus;
	
	@FindBy(xpath = "//span[contains(.,'Singapore Citizen')]")
	WebElement Selectstatus;

	@FindBy(xpath = "//input[@ng-reflect-name='nric']")
	WebElement NRIC;

	

	@FindBy(xpath = "//input[@ng-reflect-name='countryOfOrigin']")
	WebElement Country;

	@FindBy(xpath = "//span[@class='wtf2-option-text']")
	WebElement Countryselect;
	
	@FindBy(xpath="(//div[contains(@ng-reflect-ng-switch,'true')])[6]")
	WebElement races;

	@FindBy(xpath = "//span[@class='wtf2-option-text' and text()=' Indian ']")
	WebElement racetypes;

	@FindBy(xpath = "//div[@class='wtf2-form-field-infix'][contains(.,'Religion *')]")
     WebElement Religion;

	@FindBy(xpath = "//span[@class='wtf2-option-text'][contains(.,'Hinduism')]")
	WebElement Religionselect;
	
	@FindBy(xpath = "(//span[contains(.,'SAVE')])[2]")
	WebElement Saveclick;
	
	/*******************************
	 * RUN PAYROLL PAGE ELEMENTS LOCATORS
	 ***************************/
	@FindBy(xpath = "//span[contains(@ng-reflect-translate,'Payrun')]")
	WebElement Payrunclick;
	
	@FindBy(xpath = "//span[@class='nav-link-title ng-star-inserted'][contains(.,'Payrun')]")
	WebElement Payrunaddbutton;
	
	@FindBy(xpath = "(//span[contains(.,'ADD PAYRUN')])[2]")
	WebElement Addpayrunclick;
	


// Common util for webdriver wait
@Step("Wait Element to be Visible")
public void WDWait(WebElement we) {
	wait.until(ExpectedConditions.visibilityOf(we));
}

public void clickEmployeeButton() throws InterruptedException {
	WDWait(Employeeclick);
	wait.until(ExpectedConditions.elementToBeClickable(Employeeclick));
	Thread.sleep(3000);
	Employeeclick.click();

}

public void Addempbuttonclick() {
	WDWait(Addempbutton);
	Addempbutton.click();
}

public void clickname() {
	WDWait(Name);
	Name.click();
}

public void Entername(String fnames, String lnames, String email, String desg, String dob, String doj,
		String basicsal) {
	WDWait(FirstName);
	FirstName.sendKeys(fnames);
	LastName.sendKeys(lnames);
	EmailID.sendKeys(email);
	Designation.sendKeys(desg);
	Dateofbirth.sendKeys(dob);
	Dateofjoining.sendKeys(doj);
	Basicsal.sendKeys(basicsal);

}

public void Empnext() throws InterruptedException {
	WDWait(EmployeedetailsNext);
	wait.until(ExpectedConditions.elementToBeClickable(EmployeedetailsNext));
	EmployeedetailsNext.click();
	
	

}

public void Componentdata(String allowancea, String deductiona) throws InterruptedException{
	WDWait(AllowanceAmount);
	wait.until(ExpectedConditions.elementToBeClickable(AllowanceAmount));
	//Thread.sleep(2000);

	AllowanceAmount.clear();
	AllowanceAmount.sendKeys(allowancea);
	wait.until(ExpectedConditions.elementToBeClickable(DeductionAmount));
	DeductionAmount.clear();
	DeductionAmount.sendKeys(deductiona);
	Thread.sleep(7000);


}

public void compoNextClick() throws InterruptedException {
	WDWait(CompNext);
	wait.until(ExpectedConditions.elementToBeClickable(CompNext));
	CompNext.click();
	
}

@Step("Enter Immigration details")
public void Immigrationdeatils(String nric, String nationality, String country) throws InterruptedException {
	WDWait(immigrationStatus);
	immigrationStatus.click();
	WDWait(Selectstatus);
	Selectstatus.click();
	WDWait(NRIC);

	NRIC.sendKeys(nric);
	
	Country.sendKeys(country);
	Thread.sleep(2000);
	Countryselect.click();
	
	wait.until(ExpectedConditions.elementToBeClickable(races));
	WDWait(races);

	races.click();
	wait.until(ExpectedConditions.elementToBeClickable(racetypes));

	WDWait(racetypes);
	racetypes.click();

	WDWait(Religion);
	wait.until(ExpectedConditions.elementToBeClickable(Religion));
  
    Religion.click();
    Thread.sleep(3000);

	Religionselect.click();
	
	sAssert.assertAll();
	Saveclick.click();
    Thread.sleep(3000);


}

public void Addsgpayroll() throws InterruptedException {
	
	Payrunclick.click();
    Thread.sleep(3000);
    WDWait(Payrunaddbutton);
	wait.until(ExpectedConditions.elementToBeClickable(Payrunaddbutton));
	Payrunaddbutton.click();
	Addpayrunclick.click();
    Thread.sleep(3000);

}
}