package deskera.web.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestListenerOnFailure;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.pages.BillingPage;
import deskera.web.automation.pages.DashboardPage;
import deskera.web.automation.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

@Listeners({ TestListenerOnFailure.class })
public class OpenBillingPageTest extends DriverFactory {
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
	
	@TestRailId(testRailId = 17043)
	@Test()
	@Description(value = "C17043 To verify user should be able to view Billing Page.")
	public void openBillingPageTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		// Create Page Object instance
		
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboardPage=new DashboardPage(driver,wait);
		BillingPage billingPage=new BillingPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		dashboardPage.verifyPageTitle();
		dashboardPage.verifyDashboardPageElements();	
		dashboardPage.openBillingPage();
		billingPage.verifyPageTitle();
		billingPage.verifyBillingPageElements();
		dashboardPage.verifyPageTitle();
		dashboardPage.userLogout();
	}

}
