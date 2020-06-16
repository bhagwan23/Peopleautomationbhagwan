package deskera.web.automation.go.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.go.pages.DashboardPage;
import deskera.web.automation.go.pages.DeskeraChatPage;
import deskera.web.automation.go.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ TestListenerOnFailure.class })
public class CreateChannelTest extends DriverFactory {
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
	
	@TestRailId(testRailId =16963 )
	@Test()
	@Description(value = "C16963 To verify user should be able to open Chat and create channels.")
	public void createChannelTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		// Create Page Object instance
		
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboardPage=new DashboardPage(driver,wait);
		DeskeraChatPage deskeraChatPage=new DeskeraChatPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		dashboardPage.verifyPageTitle();
		dashboardPage.verifyDashboardPageElements();	
		dashboardPage.clickChatIcon();
		deskeraChatPage.verifyPageTitle();
		deskeraChatPage.verifyDeskeraChatPageElements();
		deskeraChatPage.clickAddChannelIcon();
		deskeraChatPage.verifyCreateChannelWindowElements();
		deskeraChatPage.enterPublicChannelDetails();
		deskeraChatPage.clickCreateChannelButton();
		deskeraChatPage.verifyCreatedChannel();
		dashboardPage.userLogout();
	}
}
