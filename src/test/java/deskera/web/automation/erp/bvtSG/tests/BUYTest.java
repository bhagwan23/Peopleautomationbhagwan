package deskera.web.automation.erp.bvtSG.tests;
//@Listeners({ ScreenShotListener.class })

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.BUYPage;
import deskera.web.automation.erp.bvtSG.pages.ContactsPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class BUYTest extends DriverFactory{
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "conf", "url" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}

	@TestRailId(testRailId = 20270)
	@Test
	@Description(value = "C20270 To verify that user is able to Create/Bill/Receive - Order")
	public void buyPage() throws InterruptedException{
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	

		// Create login Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.openURL(url);
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();

		// Create BUY Page Object instance
		BUYPage buy = new BUYPage(driver, wait);
		buy.clickBUYButton();
	}
}
