package deskera.web.automation.people.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import deskera.people.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class EditComponentPage {
	
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public EditComponentPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}

	/*******************************
	 *  EDIT COMPONENT ELEMENTS LOCATORS
	 *******************/
	
	@FindBy(xpath = "//span[contains(text(),'Components')]")
	WebElement ComponentButton;
	
	@FindBy(xpath = "(//wtf2-icon[contains(.,'more_vert')])[1]")
	WebElement ClickonContextMenuButton;
	
	@FindBy(xpath = "//button[contains(.,'edit  Edit')]")
	WebElement ClickonEditButton;
	
	@FindBy(xpath = "//input[@formcontrolname='name']")
	WebElement ComponentName;
	

	@FindBy(xpath = "//span[@class='mx-2 contact-bottom-button' and text()='SAVE']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[text()=' Component updated successfully. ']")
	private WebElement editSucessMessage;
	

	/******************************* Verify Edited component elements *******************/
	
    @FindBy(xpath= "(//div[contains(@class,'ellipsis ng-star-inserted')])[1]")
	private WebElement editedComponentName;
    
    
    
	/******************************* Component Edit Object Manipulation Methods *******************/


	//Common util for webdriver wait
		@Step("Wait Element to be Visible")
		public void WDWait(WebElement we) {
			wait.until(ExpectedConditions.visibilityOf(we));
		}

		@Step("click on component button")
		public void clickComponentButton() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(ComponentButton));
			WDWait(ComponentButton);
			ComponentButton.click();
			Thread.sleep(5000);
			sAssert.assertAll();


		}
		
		@Step("Click on Context menu icon")
		public void clickContextMenuIcon1() throws InterruptedException{
			WDWait(ClickonContextMenuButton);
			sAssert.assertTrue(ClickonContextMenuButton.isDisplayed());
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(ClickonContextMenuButton));
	        ClickonContextMenuButton.click();
			sAssert.assertAll();

}
		
		@Step("Click on Edit button")
		public void clickEditbutton() throws InterruptedException{
			WDWait(ClickonEditButton);
			sAssert.assertTrue(ClickonEditButton.isDisplayed());
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(ClickonEditButton));
	        ClickonEditButton.click();
			sAssert.assertAll();

}
		
		@Step("Edit Component Details")
		public void editComponentDetails(String eComponent) throws InterruptedException{
			WDWait(ComponentName);
			sAssert.assertTrue(ComponentName.isDisplayed());
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(ComponentName));
	        ComponentName.clear();
	        Thread.sleep(3000);
            ComponentName.sendKeys(eComponent);
			sAssert.assertAll();

}
		@Step("Click on save button")
		public void saveButton() throws InterruptedException {
			WDWait(saveButton);
			Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", saveButton);
			//Thread.sleep(6000);
			sAssert.assertAll();


			//saveButton.click();
	}
		@Step("Verify success message")
		public void verifySuccessMessageForEditComponent() throws InterruptedException{
			WDWait(editSucessMessage);
	        wait.until(ExpectedConditions.elementToBeClickable(editSucessMessage));
	        wait.until(ExpectedConditions.visibilityOf(editSucessMessage));
			sAssert.assertTrue(editSucessMessage.isDisplayed(), "Verify edit component success message");
			Thread.sleep(3000);


	       // wait.until(ExpectedConditions.visibilityOf(deleteSucessMessage));
			sAssert.assertAll();

		}
		
		@Step("Verify edited Component")
		public void verifyEditedComponent(String eComponent) throws InterruptedException{
			WDWait(editedComponentName);
			wait.until(ExpectedConditions.elementToBeClickable(editedComponentName));
		//	String editedComponentName = addedComponentName.getText();
		//	System.out.println(editedComponentName);
		    System.out.println(editedComponentName.getText());
			sAssert.assertEquals(editedComponentName.getText(), eComponent);
			
			Thread.sleep(3000);
			sAssert.assertTrue(editedComponentName.isDisplayed());
			sAssert.assertAll();

		
	}
}
