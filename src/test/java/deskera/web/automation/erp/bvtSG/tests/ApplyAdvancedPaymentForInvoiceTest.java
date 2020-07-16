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

public class ApplyAdvancedPaymentForInvoiceTest extends DriverFactory{

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
	
	@TestRailId(testRailId = 21102)
	@Test()
	@Description(value = "C21102 To verify that user is able to apply 'Advanced payment' for invoice")
	public void applyAdvancedPaymentForInvoiceTest() throws InterruptedException {
		// Read test specific data from config
		String contactName = ReadPropertyUtil.readProperty("ContactName", confContactsPath);
		String advancePaymentAmount = ReadPropertyUtil.readProperty("advancePaymentAmount", confPath);
		
		// Create Page Object instance
		HomePage homePage=new HomePage(driver, wait);
		AccountingPage accountingPage=new AccountingPage(driver,wait);
		SellPage sellPage=new SellPage(driver, wait);		
		// Access Test methods
		homePage.clickAccountingTab();
		accountingPage.clickDepositButton();
		accountingPage.clickAdvancePaymentButton();
		accountingPage.selectContactForMakePayment(contactName);
		accountingPage.selectCashOptionFromDepositToDropdown();
		accountingPage.enterPaymentDate();
		accountingPage.selectAccount();
		accountingPage.enterAmount(advancePaymentAmount);
		accountingPage.clickSaveButtonOnAdvancePayment();
		accountingPage.verifyAmountPaid(advancePaymentAmount);
		// Apply Credit Note
		homePage.clickSellTab();
		sellPage.clickInvoiceTab();
		sellPage.openFirstInvoice();
		sellPage.clickApplyAdvancePaymentButton();		
		sellPage.verifyApplyAdvancePaymentWindow(advancePaymentAmount);		
		sellPage.enterAdvancePaymentAmount(advancePaymentAmount);
		sellPage.clickApplyButton();
		sellPage.verifyApplyApplyAdvancePaymentSuccessMessage();
		sellPage.verifyAdvancePaymentAmount(advancePaymentAmount);
		
		
		
		

	//	sellPage.verifyPaymentsAmount(creditNoteAmount);
	
	}
}
