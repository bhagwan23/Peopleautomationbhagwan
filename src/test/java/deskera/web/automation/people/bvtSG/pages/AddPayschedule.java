package deskera.web.automation.people.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import deskera.people.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class AddPayschedule {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;
	
	public AddPayschedule(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}
	/*******************************
	 * ADD EMPLOYEE PAGE ELEMENTS LOCATORS
	 *******************/
	// this.driver=driver;
		@FindBy(xpath = "//span[contains(.,'Pay Schedules')]")
		WebElement PayScheduleclick;
		
		@FindBy(xpath = "(//span[contains(.,'ADD PAY SCHEDULE')])[2]")
		WebElement AddPaySchedulebutton;
		
		@FindBy(xpath = "//input[@formcontrolname='name']")
		WebElement PayScheduleName;
		
		@FindBy(xpath = "//input[contains(@formcontrolname,'workPeriod')]")
		WebElement Workperiod;
		
		@FindBy(xpath = "(//div[@class='wtf2-calendar-body-cell-content'][contains(.,'3')])[1]")
		WebElement Fromdate;
		
		@FindBy(xpath = "(//div[@class='wtf2-calendar-body-cell-content'][contains(.,'30')])[2]")
		WebElement Todate;
		
		@FindBy(xpath = "//button[contains(.,'Apply')]")
		WebElement Apply;
		
		@FindBy(xpath = "//span[@class='mx-2 contact-bottom-button'][contains(.,'SAVE')]")
		WebElement savebutton;
		
		//WebElement date = driver.findElement(By.xpath("//span[@class='mx-2 contact-bottom-button'][contains(.,'SAVE')]"));
		//String dateval ="01/08/2020 - 31/08/2020";
		
		
		
		/*******************************
		 * Add employee Object Manipulation Methods
		 *******************/

		// Common util for webdriver wait
		@Step("Wait Element to be Visible")
		public void WDWait(WebElement we) {
			wait.until(ExpectedConditions.visibilityOf(we));
		}

		public void clickPayscheduleButton() throws InterruptedException {
			WDWait(PayScheduleclick);
			wait.until(ExpectedConditions.elementToBeClickable(PayScheduleclick));
			Thread.sleep(3000);
			PayScheduleclick.click();

		}

		public void ClickAddPaySchedulebutton() throws InterruptedException {
			WDWait(AddPaySchedulebutton);
			wait.until(ExpectedConditions.elementToBeClickable(AddPaySchedulebutton));
			Thread.sleep(3000);
			AddPaySchedulebutton.click();

		}

		public void Enterpayscheduledetails(String spay) throws InterruptedException {
			WDWait(PayScheduleName);
			wait.until(ExpectedConditions.elementToBeClickable(PayScheduleName));
			//Thread.sleep(3000);
			PayScheduleName.sendKeys(spay);
			Workperiod.click();
			Fromdate.click();
			Todate.click();
			Apply.click();
			Thread.sleep(3000);

		}
		
//		public void SelectDateByJS(String dateVal) throws InterruptedException {
//			 JavascriptExecutor js = (JavascriptExecutor )driver; 
//			 js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",Date);
//			 Thread.sleep(5000);
//		}
//		
		public void ClickOnSaveButton() throws InterruptedException {
			WDWait(savebutton);
			wait.until(ExpectedConditions.elementToBeClickable(savebutton));
			
			savebutton.click();
			Thread.sleep(7000);
		}
}
