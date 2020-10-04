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

public class AddEarningComponentPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public AddEarningComponentPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}

	/*******************************
	 * ADD NEW COMPONENT ELEMENTS LOCATORS
	 *******************/

	// this.driver=driver;
	@FindBy(xpath = "//span[contains(text(),'Components')]")
	WebElement ComponentButton;

	@FindBy(xpath = "//span[contains(text(),'Add Component')]")
	WebElement AddComponentButton;
	
	@FindBy(xpath = "//input[@formcontrolname='name']")
	WebElement componentName;
	
	@FindBy(xpath = "//wtf2-select[@formcontrolname='type']")
	WebElement selectTypefield;
	
	@FindBy(xpath = "//span[contains(.,'Earning')]")
	WebElement selectEarningtype;
	
	@FindBy(xpath = "//span[@class='mx-2 contact-bottom-button' and text()='SAVE']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[text()=' Component added successfully. ']")
	private WebElement earningSucessMessage;
	
	/******************************* Verify Added Earning component elements *******************/
	
    @FindBy(xpath= "(//div[contains(@class,'ellipsis ng-star-inserted')])[1]")
	private WebElement addedComponentName;
    
    @FindBy(xpath= "(//wtf2-chip[contains(@role,'option')])[1]")
	private WebElement addedComponentType;
    
    
	
    
	
	//@FindBy(xpath="//div[text()='Component added successfully. ")
	
	


//Common util for webdriver wait
	@Step("Wait Element to be Visible")
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	@Step("click on component button")
	public void clickComponentButton() throws InterruptedException {
		WDWait(ComponentButton);
		wait.until(ExpectedConditions.elementToBeClickable(ComponentButton));
		//WDWait(ComponentButton);
		ComponentButton.click();
		sAssert.assertAll();


	}
	@Step("click on Add component button")
	public void clickAddComponentButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(AddComponentButton));
		WDWait(AddComponentButton);
		AddComponentButton.click();
		Thread.sleep(4000);
		sAssert.assertAll();


	}
	
	@Step("Add component details for earning type")
	public void componentDetailsearning(String coName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(componentName));
		WDWait(componentName);
		componentName.sendKeys(coName);
		Thread.sleep(4000);
		WDWait(selectTypefield);
		wait.until(ExpectedConditions.elementToBeClickable(selectTypefield));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", selectTypefield);
		
	

		WDWait(selectEarningtype);
		WDWait(selectEarningtype);
		wait.until(ExpectedConditions.elementToBeClickable(selectEarningtype));
		
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", selectEarningtype);
	
		sAssert.assertAll();


       
	}
	
	@Step("Click on save button")
	public void saveButton() throws InterruptedException {
		WDWait(saveButton);
		Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", saveButton);
		Thread.sleep(9000);
		sAssert.assertAll();


		//saveButton.click();
}
	
	

       
	
	
	@Step("Verify success message")
	public void verifySuccessMessageForEarning() throws InterruptedException{
		WDWait(earningSucessMessage);
        wait.until(ExpectedConditions.elementToBeClickable(earningSucessMessage));

		sAssert.assertTrue(earningSucessMessage.isDisplayed(), "Verify Earning component success message");
        Thread.sleep(3000);

       // wait.until(ExpectedConditions.visibilityOf(deleteSucessMessage));
		sAssert.assertAll();

	}
	
	@Step("Verify added EarningComponent")
	public void verifyAddedEarningComponent(String coName) throws InterruptedException{
		WDWait(addedComponentName);
		wait.until(ExpectedConditions.elementToBeClickable(addedComponentName));
	//	String Txt = addedComponentName.getText();
	//	System.out.println(Txt);
	
		sAssert.assertEquals(addedComponentName.getText(), coName);
		
		Thread.sleep(3000);
		sAssert.assertTrue(addedComponentType.isDisplayed());
		sAssert.assertAll();

	
}
}
