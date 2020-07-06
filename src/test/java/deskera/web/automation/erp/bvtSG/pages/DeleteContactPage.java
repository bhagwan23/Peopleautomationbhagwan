package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

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

import deskera.web.automation.core.SoftAssertListner;
import io.qameta.allure.Step;

public class DeleteContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;
	private SoftAssertListner sAssert;


	public DeleteContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
		sAssert = new SoftAssertListner(driver);

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
	@FindBy(xpath= "//input[@placeholder='Search Records']")
	@CacheLookup
	private WebElement searchRecord;
	@FindBy(xpath= "//div[@class='no-records ng-star-inserted']")
	@CacheLookup
	private WebElement thereIsNoMatchingRecords;
	@FindBy(xpath= "//*[@id='container-3']/extn-content/ng-contact-list/div/div/div[2]/div[2]/div[1]/span[2]")
	@CacheLookup
	private WebElement allSummaryCount;
	
	
	/******************************* Contacts Delete Object Manipulation Methods *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("Click on Context menu icon")
	public void clickContextMenuIcon(){
		WDWait(contextMenuIcon);
		contextMenuIcon.isDisplayed();
		contextMenuIcon.click();
		WDWait(deleteButton);
		deleteButton.isDisplayed();
		deleteButton.click();
	}
	@Step("Verify success message")
	public void verifySuccessMessageForDelete(){
		WDWait(deleteSucessMessage);
		deleteSucessMessage.isDisplayed();
        wait.until(ExpectedConditions.invisibilityOf(deleteSucessMessage));
	}
	@Step("Search deleted contact")
	public void searchdeletedRecord(String cName) throws InterruptedException{
		WDWait(searchRecord);
		searchRecord.click();
		searchRecord.sendKeys(cName);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	@Step("Verify deleted contacts")
	public void verifyDeletedContact(){
		WDWait(thereIsNoMatchingRecords);
		thereIsNoMatchingRecords.isDisplayed();
	}
	@Step("Verify summary count after deletion of contact")
	public void verifysummarycount(){
		WDWait(allSummaryCount);
		allSummaryCount.isDisplayed();
		sAssert.assertEquals(allSummaryCount.getText(), "0");
		sAssert.assertAll();
	}
}
