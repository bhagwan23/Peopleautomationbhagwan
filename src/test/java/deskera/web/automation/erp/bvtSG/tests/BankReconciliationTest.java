package deskera.web.automation.erp.bvtSG.tests;

import java.text.ParseException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.CreateBankPage;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.erp.bvtSG.pages.SellPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class BankReconciliationTest extends DriverFactory {

	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "conf", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}

	@TestRailId(testRailId = 20274)
	@Test
	@Description(value = "C20274 To verify that user is able to Bank Reconcile")

	public void bankReconciliationTest() throws InterruptedException, ParseException {
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		String unitPrice = ReadPropertyUtil.readProperty("unitPrice", confPath);
		String firstTransactionDate = ReadPropertyUtil.readProperty("firstTransactionDate", confPath);
		String secondTransactionDate = ReadPropertyUtil.readProperty("secondTransactionDate", confPath);
		// Create login Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		CreateBankPage bank = new CreateBankPage(driver, wait);
		HomePage homePage = new HomePage(driver, wait);
		SellPage sellPage = new SellPage(driver, wait);
		loginPage.openURL(url);
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		bank.clickOnBanktab();
		bank.clickthreeDots();
		bank.clickreconciliationButton();
		bank.writeDate(confPath);
		homePage.clickSellTab();
		sellPage.clickNewInvoiceButton();
		sellPage.selectContact();
		sellPage.selectProduct();
		sellPage.enterProductDetailsForInvoice(unitPrice);
		sellPage.clickSaveButton();
		sellPage.verifyCreateInvoiceSuccessMessage();
		sellPage.clickNewInvoiceButton();
		sellPage.selectContact();
		sellPage.selectProduct();
		sellPage.enterProductDetailsForInvoice(unitPrice);
		sellPage.clickSaveButton();
		sellPage.receivePaymentForFirstInvoce(firstTransactionDate);
		sellPage.clickReceiveButton();
		sellPage.receivePaymentForSecondInvoce(secondTransactionDate);
		sellPage.clickReceiveButton();
		bank.clickCollapseIcon();
		bank.clickOnBanktab();
		bank.clickthreeDots();
		bank.clickreconciliationButton();
		bank.selectBankAndDeskeraTransaction1();
		bank.clickMatchButton();
		bank.selectBankAndDeskeraTransaction2();
		bank.clickMatchButton();
		bank.clickNextButton();
		bank.verifyTwoTransactionsOnConfirmPage();
	}
}
