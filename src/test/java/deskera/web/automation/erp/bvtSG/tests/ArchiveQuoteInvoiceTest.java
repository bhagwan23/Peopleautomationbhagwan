package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.SellPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ArchiveQuoteInvoiceTest extends DriverFactory {
	String confPath, url,confProductsPath,confContactsPath;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "conf", "environment","confProducts","confContacts"})
	public void getConf(String conf, String URL,String confProducts,String confContacts) {
		confPath = conf;
		url = URL;
		confProductsPath=confProducts;
		confContactsPath=confContacts;
	}
	
	@TestRailId(testRailId = 20298)
	@Test()
	@Description(value = "C20298 To verify user should be able to Archive/Reopen quotes or Invoice")
	public void archiveQuoteInvoiceTest() throws InterruptedException {
		// Read test specific data from config
		String quantity = ReadPropertyUtil.readProperty("quantity", confPath);
		String discount = ReadPropertyUtil.readProperty("discount", confPath);
		String trackedProductName = ReadPropertyUtil.readProperty("trackedProductName", confProductsPath);	
		String contactName = ReadPropertyUtil.readProperty("ContactName", confContactsPath);
		// Create Page Object instance
		HomePage homePage=new HomePage(driver, wait);
		SellPage sellPage=new SellPage(driver, wait);		
		// Create Quote		
		homePage.clickSellTab();
		sellPage.verifyPageTitle();
		sellPage.verifySellPageElements();
		sellPage.clickNewQuoteButton();
		sellPage.verifyCreateQuotePageElements();
		sellPage.selectContact(contactName);
        sellPage.verifyDisplayedDates();
		sellPage.selectProduct(trackedProductName);		
		sellPage.enterProductDetails(quantity, discount);
		sellPage.verifyTotalAmount();
		sellPage.clickSaveButton();
		sellPage.verifyCreateQuoteSuccessMessage();
		sellPage.verifyCreatedQuote();
		//Archive Quote
		sellPage.verifyCountOfArchiveBefore();
		sellPage.clickThreeDots();
		sellPage.clickArchiveQuoteButton();
		sellPage.verifyCountOfArchiveAfter();
		sellPage.clickArchiveTab();
		sellPage.verifyArchiveStatusForQuote();
		sellPage.openCancelledQuoteArchive();
		sellPage.verifyArchivedQuote();
		//Create Invoice 
		sellPage.clickNewInvoiceButton();
		sellPage.verifyCreateInvoicePageElements();
		sellPage.selectContact(contactName);
        sellPage.verifyDisplayedDates();
		sellPage.selectProduct(trackedProductName);		
		sellPage.enterProductDetails(quantity, discount);
		sellPage.verifyTotalAmount();
		sellPage.clickSaveButton();
		sellPage.verifyCreateInvoiceSuccessMessage();
		sellPage.verifyCreatedInvoice();
		//Archive Invoice
		sellPage.verifyCountOfArchiveBefore();
		sellPage.clickThreeDots();
		sellPage.clickArchiveInvoiceButton();
		sellPage.verifyCountOfArchiveAfter();
		sellPage.clickArchiveTab();
		sellPage.verifyArchiveStatusForInvoice();
		sellPage.openCancelledInvoiceArchive();
		sellPage.verifyArchivedInvoice();
		//Reopen Quote
		sellPage.verifyCountOfQuoteBefore();
		sellPage.clickThreeDotsOnCancelledQuote();
		sellPage.clickReopenButton();
		sellPage.verifyCountOfQuoteAfter();
		// Reopen Invoice
		sellPage.verifyCountOfInvoiceBefore();
		sellPage.clickThreeDotsOnCancelledInvoice();
		sellPage.clickReopenButton();
		sellPage.verifyCountOfInvoiceAfter();
		
		
		
		
		
	}
}
