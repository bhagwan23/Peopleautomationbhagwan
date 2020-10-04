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

public class DeleteComponentPage {
	
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public DeleteComponentPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		sAssert = new SoftAssertListner(driver);
	}

	/*******************************
	 * DELETE COMPONENT ELEMENTS LOCATORS
	 *******************/
	
	@FindBy(xpath = "//span[contains(text(),'Components')]")
	WebElement ComponentButton;
	
	@FindBy(xpath = "(//wtf2-icon[contains(.,'more_vert')])[1]")
	WebElement ClickonContextMenuButton;
	
	@FindBy(xpath = "//button[contains(.,'delete  Delete')]")
	WebElement ClickonDeleteButton;
	
    @FindBy(xpath="//span[contains(text(),'YES')]")
	private WebElement deleteConfirmationpopup;
	
    
    @FindBy(xpath="//div[text()=' Component deleted successfully. ']")
	private WebElement deleteSucessMessage;
    
	/******************************* Component Delete Object Manipulation Methods *******************/


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
		
		@Step("Click on Delete button")
		public void deleteButton() throws InterruptedException{
			WDWait(ClickonDeleteButton);
			sAssert.assertTrue(ClickonDeleteButton.isDisplayed());
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.elementToBeClickable(ClickonDeleteButton));
	        ClickonDeleteButton.click();
	        Thread.sleep(3000);
	        deleteConfirmationpopup.click();
	        Thread.sleep(3000);

			sAssert.assertAll();

}
		
		@Step("Verify success message")
		public void verifySuccessMessageForDelete() throws InterruptedException{
			WDWait(deleteSucessMessage);
			sAssert.assertTrue(deleteSucessMessage.isDisplayed(), "Verify component delete success message");
	        Thread.sleep(3000);

	       // wait.until(ExpectedConditions.visibilityOf(deleteSucessMessage));
			sAssert.assertAll();

		}

}
