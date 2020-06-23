package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public DeleteContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* DELETE CONTACTS PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	@CacheLookup
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[@class='mat-menu-item ng-star-inserted'][contains(text(),'Delete')]")
	@CacheLookup
	private WebElement deleteButton;
	@FindBy(xpath="//span[text()='Contact Deleted']")
	@CacheLookup
	private WebElement deleteSucessMessage;
	@FindBy(xpath= "//div[@class='no-records ng-star-inserted']")
	@CacheLookup
	private WebElement thereIsNoMatchingRecords;
	
	/******************************* Contacts Delete Object Manipulation Methods *******************/
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	public void clickContextMenuIcon(){
		WDWait(contextMenuIcon);
		contextMenuIcon.isDisplayed();
		contextMenuIcon.click();
		WDWait(deleteButton);
		deleteButton.isDisplayed();
		deleteButton.click();
	}
	public void verifySuccessMessageForDelete(){
		WDWait(deleteSucessMessage);
		deleteSucessMessage.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(deleteSucessMessage));
	}
	public void verifyDeletedContact(){
		WDWait(thereIsNoMatchingRecords);
		thereIsNoMatchingRecords.isDisplayed();
	}
}
