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

public class CreateNewBillTest extends DriverFactory{
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


	@TestRailId(testRailId = 20270)
	@Test()
	@Description(value = "C20270 To verify that user is able to Create/Bill/Receive - Order")
	public void createBillTest() throws InterruptedException {
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
		BuyPage buy= new BuyPage(driver, wait);
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
		buy.verifyamountInGrid();
		//buy.billTotalCount();
		
		
		//Receive bills
		buy.clickOnBillCard();
		buy.searchCreatedOrder(contactName);
		buy.clickOnContact(contactName);
		buy.clickReceivedGoodsButton();
		buy.verifyReceivedGoodsElements();
		buy.clickReceiveButton();
		
		//Pay Bills
		buy.clickMakePaymentButton();
		buy.verifyMakePaymentElement();
		buy.clickPayFormDropDown();
		buy.verifyCurrency();
		buy.clickOnNext();
		buy.verifyConfirmPaymentElements();
		buy.ClickOnCloseButton();
		buy.verifyPaymentReceivedsuccessmessage();
	}
}
