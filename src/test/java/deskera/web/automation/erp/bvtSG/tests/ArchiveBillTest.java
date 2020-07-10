package deskera.web.automation.erp.bvtSG.tests;
//@Listeners({ ScreenShotListener.class })

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.BuyPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class ArchiveBillTest extends DriverFactory {
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

	@TestRailId(testRailId = 20299)
	@Test()
	@Description(value = "C20299 To verify user should be able to Archive/Reopen Order or Bill")
	public void archiveBillTest() throws InterruptedException {
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);

		String contactName = ReadPropertyUtil.readProperty("ContactName", confPath);
		String productName = ReadPropertyUtil.readProperty("ProductName", confPath);

		String quantity = ReadPropertyUtil.readProperty("quantity", confPath);
		String discount = ReadPropertyUtil.readProperty("discount", confPath);

		// Create login Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.openURL(url);
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();

		// Create buy Page Object instance
		BuyPage buy = new BuyPage(driver, wait);
		buy.verifybuytabElements();
		buy.clickbuytab();
		buy.verifyBuyPageElement();
		buy.clickCreatNew();
		buy.clickOnNewBill();
		buy.verifyCreateBillElements();
		buy.addContact(contactName);
		buy.verifyMultiCurrencyOptions();
		buy.addProduct(productName);
		buy.verifydefaultQuantityAndTax();
		buy.enterProductDetails(quantity, discount);
		buy.verifyTotalAmount();
		buy.clickSaveButton();
		buy.verifybillcreatedsuccessmessage();
		buy.clickOnBillCard();
		buy.searchCreatedOrder(contactName);

		// Click on Context Menu Icon
		buy.clickContextMenuIcon();
		buy.clickOnArchiveBillButton();
		Thread.sleep(4000);
		buy.clickOnArchiveCard();
		buy.archiveTotalCount();
		buy.verifyCancelledStatus();
		
		//Reopen bills
		buy.clickOnContextMenuOnArchivePage();
		buy.clickOnReopen();
		
		buy.noMatchingRecord();

	}
}