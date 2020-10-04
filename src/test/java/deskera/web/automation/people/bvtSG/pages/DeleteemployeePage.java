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

public class DeleteemployeePage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;

	public DeleteemployeePage(WebDriver driver, WebDriverWait wait) {
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
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    
    private WebElement deleteButton;
	@FindBy(xpath="//span[contains(text(),'YES')]")
	
	private WebElement deleteConfirmationpopup;
	
    @FindBy(xpath="//div[text()=' Employee deleted successfully. ']")
	private WebElement deleteSucessMessage;

	
	
	
	

	/******************************* Employee Delete Object Manipulation Methods *******************/
	
	
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
		
		WDWait(deleteButton);
		sAssert.assertTrue(deleteButton.isDisplayed(), "Verify delete button");
		deleteButton.click();
		deleteConfirmationpopup.click();
		sAssert.assertAll();

	}
	
	@Step("Verify success message")
	public void verifySuccessMessageForDelete() throws InterruptedException{
		WDWait(deleteSucessMessage);
		sAssert.assertTrue(deleteSucessMessage.isDisplayed(), "Verify employee delete success message");
        Thread.sleep(3000);

       // wait.until(ExpectedConditions.visibilityOf(deleteSucessMessage));
		sAssert.assertAll();

	}
	

}
