package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.AccountingPage;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.SellPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ApplyCreditNoteForInvoiceTest extends DriverFactory{
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
	
	@TestRailId(testRailId = 20296)
	@Test()
	@Description(value = "C20296 To verify that user is able to 'Apply Credit Note' for Invoice")
	public void applyCreditNoteForInvoiceTest() throws InterruptedException {
		// Read test specific data from config
		String contactName = ReadPropertyUtil.readProperty("ContactName", confContactsPath);
		String creditNoteAmount = ReadPropertyUtil.readProperty("creditNoteAmount", confPath);
		// Create Page Object instance
		HomePage homePage=new HomePage(driver, wait);
		AccountingPage accountingPage=new AccountingPage(driver,wait);
		SellPage sellPage=new SellPage(driver, wait);		
		// Access Test methods
		homePage.clickAccountingTab();
		accountingPage.clickCreditNote();
		accountingPage.clickCreateCreditNote();
		accountingPage.selectContact(contactName);
		accountingPage.verifyCurrency();
		accountingPage.selectAccount();
		accountingPage.enterAmount(creditNoteAmount);
		accountingPage.clickSaveButton();
		accountingPage.verifyCreateCreditNoteSuccessMessage();	
		accountingPage.verifyDisplayedAmount(creditNoteAmount);
		// Apply Credit Note
		homePage.clickSellTab();
		sellPage.clickInvoiceTab();
		sellPage.openFirstInvoice();
		sellPage.clickApplyCreditNoteButton();
		sellPage.verifyApplyCreditNoteWindow(creditNoteAmount);
		sellPage.enterCreditNoteAmount(creditNoteAmount);
		sellPage.clickApplyButton();
		sellPage.verifyApplyCreditNoteSuccessMessage();
		sellPage.verifyCreditNoteAmount(creditNoteAmount);
	
	}

}
