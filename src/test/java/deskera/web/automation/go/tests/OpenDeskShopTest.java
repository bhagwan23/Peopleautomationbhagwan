package deskera.web.automation.go.tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.go.pages.DashboardPage;
import deskera.web.automation.go.pages.DeskShopPage;
import deskera.web.automation.go.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ ScreenShotListener.class })
public class OpenDeskShopTest extends DriverFactory{
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
	
	@TestRailId(testRailId = 20571)
	@Test()
	@Description(value = "C20571 To verify user should be able to open Desk Shop from Dashboard..")
	public void openDeskShopTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboarPage=new DashboardPage(driver,wait);
		DeskShopPage deskShopPage=new DeskShopPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		dashboarPage.verifyPageTitle();
		dashboarPage.verifyDashboardPageElements();	
		dashboarPage.openDeskShopApp();
		deskShopPage.clickSetupShop();
		deskShopPage.verifyPageTitle();
		deskShopPage.verifyDeskShopPageElements();
		deskShopPage.closeDeskShopTab();
		dashboarPage.verifyPageTitle();
		dashboarPage.userLogout();
	}
	
}
