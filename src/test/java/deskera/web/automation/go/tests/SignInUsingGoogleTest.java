package deskera.web.automation.go.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.go.pages.DashboardPage;
import deskera.web.automation.go.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ TestListenerOnFailure.class })
public class SignInUsingGoogleTest extends DriverFactory{
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
	
	@TestRailId(testRailId = 20564)
	@Test()
	@Description(value = "C20564 To verify user should be able to SIgn In using Google")
	public void signInUsingGoogleTest() throws InterruptedException {
		// Read test specific data from config	
		String googleEmail = ReadPropertyUtil.readProperty("googleEmail", confPath);
		String googlePass = ReadPropertyUtil.readProperty("googlePass", confPath);	
		
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboarPage=new DashboardPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.clickSignInUsingGoogle();
		loginPage.enterGoogleEmailPassword(googleEmail, googlePass);
		dashboarPage.verifyPageTitle();
		dashboarPage.verifyDashboardPageElements();	
		dashboarPage.verifyLauncherBarPanelElements();
		dashboarPage.verifyUserProfilePanelElements();
		dashboarPage.userLogout();
	}
}
