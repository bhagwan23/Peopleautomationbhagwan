package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyContactPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public CopyContactPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* COPY CONTACT PAGE ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//mat-row[1]//mat-cell[8]//button[1]//mat-icon[1]")
	@CacheLookup
	private WebElement contextMenuIcon;
	@FindBy(xpath= "//button[contains(text(),'Copy')]")
	@CacheLookup
	private WebElement copyButton;
	@FindBy(xpath= "//button[@class='mat-flat-button mat-button-base mat-primary']")
	@CacheLookup
	private WebElement saveButton;
	@FindBy(xpath= "//span[text()='Contact Successfuly Added']")
	@CacheLookup
	private WebElement copyContactSuccessMessage;
	
	/*******************************Edit Contacts Object Manipulation Methods *******************/
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
	}
	public void clickCopyButton(){
		WDWait(copyButton);
		copyButton.isDisplayed();
		copyButton.click();
	}
	public void clickSaveButton(){
		WDWait(saveButton);
		saveButton.isDisplayed();
		saveButton.click();
	}
	public void verifysuccessmessage(){
		WDWait(copyContactSuccessMessage);
		copyContactSuccessMessage.isDisplayed();
	}
	
}
