package deskera.web.automation.go.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.go.pages.DashboardPage;
import deskera.web.automation.go.pages.DeskShopPage;
import deskera.web.automation.go.pages.DeskeraBooksPage;
import deskera.web.automation.go.pages.DeskeraSalesPage;
import deskera.web.automation.go.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ TestListenerOnFailure.class })
public class SwitchToOtherAppsTest extends DriverFactory{
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
	
	@TestRailId(testRailId = 16962)
	@Test()
	@Description(value = "C16962 To verify user should be able to switch to other applications through launcher bar.")
	public void switchToOtherAppsTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboardPage=new DashboardPage(driver,wait);
		DeskeraBooksPage deskeraBooksPage=new DeskeraBooksPage(driver,wait);
		DeskeraSalesPage deskeraSalesPage=new DeskeraSalesPage(driver,wait);
		DeskShopPage deskShopPage=new DeskShopPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		dashboardPage.verifyPageTitle();
		dashboardPage.launchDeskeraBooksApp();
		deskeraBooksPage.verifyPageTitle();
		deskeraBooksPage.verifyCompanyCreationPageElements();
		deskeraBooksPage.verifyDeskeraBooksPageElements();
		deskeraBooksPage.closeDeskeraBooksTab();
		dashboardPage.launchDeskeraSalesApp();
		deskeraSalesPage.verifyPageTitle();
		deskeraSalesPage.verifyDeskeraSalesPageElements();
		deskeraSalesPage.closeDeskeraSalesTab();
		dashboardPage.launchDeskShopApp();
		deskShopPage.clickSetupShop();
		deskShopPage.verifyPageTitle();
		deskShopPage.verifyDeskShopPageElements();
		deskShopPage.closeDeskShopTab();
		dashboardPage.verifyPageTitle();
		dashboardPage.userLogout();
	}
}
