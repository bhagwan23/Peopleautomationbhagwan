package deskera.web.automation.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.ScreenShotListener;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.pages.DashboardPage;
import deskera.web.automation.pages.DeskeraSalesPage;
import deskera.web.automation.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ ScreenShotListener.class })
public class OpenDeskeraSalesTest extends DriverFactory {

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
	
	@TestRailId(testRailId = 20570)
	@Test()
	@Description(value = "C20570 To verify user should be able to open Deskera Sales from Dashboard.")
	public void openDeskeraSalesTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboarPage=new DashboardPage(driver,wait);
		DeskeraSalesPage deskeraSalesPage=new DeskeraSalesPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		dashboarPage.verifyPageTitle();
		dashboarPage.verifyDashboardPageElements();	
		dashboarPage.openDeskeraSalesApp();
		deskeraSalesPage.verifyPageTitle();
		deskeraSalesPage.verifyDeskeraSalesPageElements();
		deskeraSalesPage.closeDeskeraSalesTab();
		dashboarPage.verifyPageTitle();
		dashboarPage.userLogout();
	}
}
