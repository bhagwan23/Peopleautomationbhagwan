package deskera.web.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestListenerOnFailure;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.pages.SignUpPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

@Listeners({ TestListenerOnFailure.class })
public class SignUpTest extends DriverFactory {
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

	@TestRailId(testRailId = 13667)
	@Test
	@Description(value = "C13667 To verify user should be able navigate to Sign Up page.")
	public void testSignUpPage() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String phone = ReadPropertyUtil.readProperty("phone", confPath);
		String countryCode = ReadPropertyUtil.readProperty("countryCode", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.enterEmailandPhone(emailAddress, countryCode, phone);
		signUpPage.clickCreateACcountButton();
	}
}