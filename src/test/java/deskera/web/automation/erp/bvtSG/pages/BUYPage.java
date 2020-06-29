package deskera.web.automation.erp.bvtSG.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class BUYPage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;
	private WebDriverWait wait;

	public BUYPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}

	/******************************* BUY PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath= "//span[contains(text(),'Buy')]")
	@CacheLookup
	private WebElement buyTabButton;
	@FindBy(xpath= "//button[@class='parent mat-menu-trigger']")
	@CacheLookup
	private WebElement createNewButton;
	
	
	
	/******************************* BUY PAGE Object Manipulation Methods *******************/
	@Step("Open URL")
	public void openURL(String URL) {
		driver.get(URL);
	}
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	@Step("close popup on contacts page")
	public void clickPopup() throws InterruptedException{	
		//driver.get("https://reality-qa.deskera.xyz/book-keeper/client");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Buy')]"))); // Contact // link                                                                                                            // or                                                                                                            // Produ                                                                                                            // link
		driver.findElement(By.xpath("//span[contains(text(),'Buy')]")).click();
		Thread.sleep(3000); // THis is important because popup gets loaded and then disappears
		// driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click();
		for (int second = 0; second <= 15; second++) {
			if (second == 15) {
				System.out.println("Popup Not found clickin on new Contact Button");
				break;
			}
			try {
				if (driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).isDisplayed()) {
					System.out.println("closig popup now 1");
					driver.findElement(By.cssSelector("i.fas.fa-times.close-button.mt-2")).click(); //popup close button
					System.out.println("closed popup  1");
					break;
				}
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		// driver.findElement(By.xpath("//button[3]/span")).click(); // Create new contact button

	}
	@Step("Click on BUY tab button")
	public void clickBUYButton() throws InterruptedException{
		WDWait(buyTabButton);
		buyTabButton.click(); 
		clickPopup();
	}
}
