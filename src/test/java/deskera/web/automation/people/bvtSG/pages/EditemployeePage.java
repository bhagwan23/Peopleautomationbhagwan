package deskera.web.automation.people.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import deskera.people.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class EditemployeePage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public EditemployeePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);

	}

	/*******************************
	 * DELETE EMPLOYEE PAGE ELEMENTS LOCATORS
	 *******************/


	@FindBy(xpath = "//wtf2-row[1]//wtf2-cell[7]//button[1]//span[1]//wtf2-icon[1]")
	private WebElement contextMenuIcon;
	
    @FindBy(xpath = "//button[contains(.,'edit  Edit')]")
    private WebElement editButton1;
    
    @FindBy(xpath = "(//wtf2-icon[contains(.,'edit')])[2]")
    private WebElement enteredEmployeename;
    
    @FindBy(xpath = "//input[@formcontrolname='emailId']")
    private WebElement emailID;
    
    @FindBy(xpath = "//input[@formcontrolname='dateOfJoining']")
    private WebElement DOJ;
    
    @FindBy(xpath = "//div[@class='wtf2-form-field-infix'][contains(.,'First Name*')]")
    private WebElement enterFirstename;
    
    @FindBy(xpath = "(//h5[contains(.,'Basic/Salary')])[2]")
	WebElement enterBasicsalary;
    
    @FindBy(xpath = "//input[@formcontrolname='compensation']")
	WebElement Basicsal;
    
    @FindBy(xpath = "//span[@class='wtf2-button-wrapper'][contains(.,'NEXT')]")
	WebElement EmployeedetailsNext;
    
    @FindBy(xpath = "(//div[contains(.,'Compliance Details')])[17]")
	WebElement Compilencedetailclick;
    
    @FindBy(xpath = "//span[text()='SAVE']")
	WebElement Savebutton;
    
/******************************* Edit Employee Object Manipulation Methods *******************/
	
	
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	
	@Step("Click on Context menu icon")
	public void clickContextMenuIcon() throws InterruptedException{
		WDWait(contextMenuIcon);
		sAssert.assertTrue(contextMenuIcon.isDisplayed());
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(contextMenuIcon));
        contextMenuIcon.click();
		sAssert.assertAll();

    
    
	}
	
	@Step("Click on Edit button")
	public void clickEditButton1() throws InterruptedException{
		
		WDWait(editButton1);
		sAssert.assertTrue(editButton1.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(editButton1));
		Thread.sleep(2000);
		editButton1.click();	
		sAssert.assertAll();
		
	}
	
	@Step("Enter employee details")
	public void editEmployeeInfo(String bSal,String eEmail) throws InterruptedException{
		WDWait(emailID);

		emailID.clear();
		emailID.sendKeys(eEmail);
		//WDWait(enteredEmployeename);
		//wait.until(ExpectedConditions.elementToBeClickable(enteredEmployeename));

		//enteredEmployeename.click();
		//Thread.sleep(3000);

		//WDWait(enterFirstename);
		//wait.until(ExpectedConditions.elementToBeClickable(enterFirstename));

		//enterFirstename.clear();
		//enterFirstename.sendKeys(fName);
		//WDWait(DOJ);
		Thread.sleep(3000);

		//DOJ.clear();
		Thread.sleep(2000);
		//DOJ.sendKeys(eDoj);
		Actions action = new Actions(driver);

		WDWait(Basicsal);
		
		action.moveToElement(Basicsal).perform();

		wait.until(ExpectedConditions.elementToBeClickable(Basicsal));
		
		//WDWait(enterBasicsalary);
		Basicsal.clear();
		Basicsal.sendKeys(bSal);
		EmployeedetailsNext.click();
		Thread.sleep(2000);
		Compilencedetailclick.click();
		Thread.sleep(3000);

	}
	
	@Step("Save User information")
	public void clickonsavebutton() throws InterruptedException {
		WDWait(Savebutton);
        
        Savebutton.click();
		sAssert.assertAll();
		
	}
	
//	@Step("Scroll page")
//	public void scrollToElement(WebElement element)
//	{
//
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//		sAssert.assertAll();
//
//	}
		

}
