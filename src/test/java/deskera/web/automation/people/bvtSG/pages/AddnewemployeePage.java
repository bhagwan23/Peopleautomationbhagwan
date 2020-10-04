package deskera.web.automation.people.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import deskera.people.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class AddnewemployeePage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public AddnewemployeePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);

	}

	/*******************************
	 * CREATE EMPLOYEE PAGE ELEMENTS LOCATORS
	 *******************/

	// this.driver=driver;
	@FindBy(xpath = "//span[text()='Employees']")
	WebElement Employeeclick;

	@FindBy(xpath = "//span[contains(text(),'Employee List')]")
	WebElement Employeelist;

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

	@FindBy(xpath = "//span[@class='wtf2-button-wrapper'][contains(.,'NEXT')]")
	WebElement EmployeedetailsNext;

	@FindBy(xpath = "(//h5[contains(.,'Basic/Salary')])[2]")
	WebElement Basicsalarytext;

	// @FindBy(xpath = "//button[contains(.,'NEXT')]")
	// WebElement ComponentNext;

	@FindBy(xpath = "//span[@class='mx-3']")
	WebElement compNextClick;

	@FindBy(xpath = "(//div[contains(.,'Compliance Details')])[17]")
	WebElement Compilencedetailclick;

	/*******************************
	 * VERIFY COMPILENCE DETAILS PAGE
	 *******************/
	@FindBy(xpath = "(//wtf2-panel-title[@class='wtf2-expansion-panel-header-title' and text()=' Immigration Details ']")
	WebElement Verifycompilencedetailspage;

	/*******************************
	 * CREATE EMPLOYEE PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//input[@ng-reflect-name='nric']")
	WebElement NRIC;

	@FindBy(xpath = "//input[@ng-reflect-name='nationality']")
	WebElement Nationality;

	@FindBy(xpath = "//span[contains(.,'Singaporean')]")
	WebElement Nationalityselect;

	@FindBy(xpath = "//input[@ng-reflect-name='countryOfOrigin']")
	WebElement Country;

	@FindBy(xpath = "//span[contains(.,'Singapore')]")
	WebElement Countryselect;

	@FindBy(xpath = "//input[@ng-reflect-name='startOfPermanentResident']")
	WebElement StartofPermanentResident;

	@FindBy(xpath = "//div[@class='wtf2-form-field-infix'][contains(.,'Employee Qualification *')]")
	WebElement Empqualification;

	@FindBy(xpath = "//span[contains(.,'Full Employer and Partial (also known as Graduated) Employee rates')]")
	WebElement qualificationtype;
	// span[@class='wtf2-select-placeholder ng-tns-c28-215 ng-star-inserted']
	@FindBy(xpath = "(//div[contains(.,'Race *')])[26]")
	WebElement race;

	@FindBy(xpath = "//span[@class='wtf2-option-text' and text()=' Indian ']")
	WebElement racetype;

	@FindBy(xpath = "(//div[contains(.,'Religion *')])[25]")
	// @FindBy(xpath="//wtf2-select[@id='wtf2-select-17']//div[@class='wtf2-select-value']")

	WebElement Religion;

	@FindBy(xpath = "//span[contains(text(),'Hinduism')]")
	WebElement Religionselect;

	@FindBy(xpath = "//span[text()='SAVE']")
	WebElement Savebutton;

	@FindBy(xpath = "//div[text()='Employee updated successfully.']")
	private WebElement updateSucessMessage;

	/*******************************
	 * NEW EMPLOYEE VERIFICATION PAGE ELEMENTS LOCATORS
	 *******************/

	@FindBy(xpath = "//span[@class='nav-link-title ng-star-inserted'][contains(.,'Employees')]")
	WebElement Employeebutton;

	@FindBy(xpath = "(//span[@class='font-weight-700'])[1]")
	private WebElement empnameverify;

	@FindBy(xpath = "(//span[@class='currency-main'])[1]")
	private WebElement empsalverify;

	@FindBy(xpath = "//wtf2-row[1]//wtf2-cell[6]//div[1]")
	private WebElement empstatus;

	/*******************************
	 * Add employee Object Manipulation Methods
	 *******************/

	// Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	public void clickEmployeeButton() throws InterruptedException {
		WDWait(Employeeclick);
		Thread.sleep(7000);
		wait.until(ExpectedConditions.elementToBeClickable(Employeeclick));
		// Thread.sleep(3000);
		Employeeclick.click();
		WDWait(Employeelist);
		Employeelist.click();

	}

	public void Addempbuttonclick() {
		WDWait(Addempbutton);
		Addempbutton.click();
	}

	public void clickname() {
		WDWait(Name);
		Name.click();
	}

	public void Entername(String fname, String lname, String email, String desg, String dob, String doj,
			String basicsal) {
		WDWait(FirstName);
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		EmailID.sendKeys(email);
		Designation.sendKeys(desg);
		Dateofbirth.sendKeys(dob);
		Dateofjoining.sendKeys(doj);
		Basicsal.sendKeys(basicsal);

	}

	public void Empnext() {
		WDWait(EmployeedetailsNext);

		EmployeedetailsNext.click();

	}

	/*
	 * public void verifycomponentscreen() { WDWait(Basicsalarytext);
	 * 
	 * Basicsalarytext.isDisplayed();
	 * 
	 * // Estimatetext.isDisplayed();
	 * 
	 * }
	 */

	public void componentnextclick() throws InterruptedException {
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		// Actions action = new Actions(driver);
		WDWait(compNextClick);
		compNextClick.click();
		// wait.until(ExpectedConditions.elementToBeClickable(Compilencedetailclick));
		// action.moveToElement(compNextClick).perform();

		// WDWait(compNextClick);
		// wait.until(ExpectedConditions.elementToBeClickable(compNextClick));
		// wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[contains(.,'NEXT')]"))));

		// //Thread.sleep(3000);
		//
		// //
		// wait.until(ExpectedConditions.elementToBeClickable(Compilencedetailclick));
		// Compilencedetailclick.click();
		// //Compilencedetailclick.click();
		sAssert.assertAll();

	}

	public void Verifycompliancepage() {
		WDWait(Verifycompilencedetailspage);

		Verifycompilencedetailspage.isDisplayed();
	}

	@Step("Enter Immagration details")
	public void Immagrationdeatils(String nric, String nationality, String country, String sop)
			throws InterruptedException {
		WDWait(NRIC);

		NRIC.sendKeys(nric);
		Nationality.sendKeys(nationality);
		WDWait(Nationalityselect);

		Nationalityselect.click();
		Country.sendKeys(country);
		Countryselect.click();

		StartofPermanentResident.sendKeys(sop);
		Empqualification.click();
		qualificationtype.click();

		wait.until(ExpectedConditions.elementToBeClickable(race));
		WDWait(race);

		race.click();
		wait.until(ExpectedConditions.elementToBeClickable(racetype));

		WDWait(racetype);
		racetype.click();

		WDWait(Religion);
		wait.until(ExpectedConditions.elementToBeClickable(Religion));

		Religion.click();
		Thread.sleep(3000);

		Religionselect.click();

		sAssert.assertAll();

	}

	@Step("Save User information")
	public void clickonsavebutton() throws InterruptedException {
		WDWait(Savebutton);

		Savebutton.click();
		sAssert.assertAll();
	}

	@Step("Verify Adduser success message")
	public void verifySuccessMessageForAdduser() throws InterruptedException {
		WDWait(updateSucessMessage);
		sAssert.assertTrue(updateSucessMessage.isDisplayed(), "Verify employee add success message");
		Thread.sleep(3000);

		// wait.until(ExpectedConditions.visibilityOf(deleteSucessMessage));
		sAssert.assertAll();

	}

	public void EmployeeButton() throws InterruptedException {
		WDWait(Employeebutton);
		Employeebutton.click();

	}

	@Step("Verify Added employee")
	public void verifyaddedEmployee(String fname, String basicsal) throws InterruptedException {
		WDWait(empnameverify);
		wait.until(ExpectedConditions.elementToBeClickable(empnameverify));
		System.out.println();
		sAssert.assertEquals(empnameverify.getText(), fname);
		sAssert.assertEquals(empsalverify.getText(), basicsal);
		sAssert.assertTrue(empstatus.isDisplayed(), "Verify employee status");
		System.out.println("employee name verified successfully");

	}
}