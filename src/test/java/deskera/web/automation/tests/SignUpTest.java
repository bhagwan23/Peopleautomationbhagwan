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

	@TestRailId(testRailId = 16960)
	@Test()
	@Description(value = "C16960 To verify user should be able to sign up with Email and  Phone Number.")
	public void testSignUpPage() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String phone = ReadPropertyUtil.readProperty("phone", confPath);
		String countryCode = ReadPropertyUtil.readProperty("countryCode", confPath);
		String accountName = ReadPropertyUtil.readProperty("userFirstName", confPath);
		String passWord = ReadPropertyUtil.readProperty("password", confPath);
		String company = ReadPropertyUtil.readProperty("company", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.enterEmailandPhone(emailAddress, countryCode, phone);
		signUpPage.clickCreateACcountButton();
		signUpPage.verifyAccountDetailsPageElements();
		signUpPage.enterAccountDetails(accountName, passWord, company);
		signUpPage.clickNextButton();
		signUpPage.verifyPersonalizeAccountPageElements();
		signUpPage.enterPersonalizeAccountDetails();
		signUpPage.clickNext();
		signUpPage.verifySuccessPageElements();
		signUpPage.clickResentEmailButton();
		signUpPage.verifyPageElementsAfterResentEmail();
	}
	
	@TestRailId(testRailId = 20565)
	@Test
	@Description(value = "C20565 To verify user should be able to sign up without Phone Number.")
	public void testSignUpWithoutPhoneNumber() throws InterruptedException {
		// Read test specific data from config
		String accountName = ReadPropertyUtil.readProperty("userFirstName", confPath);
		String passWord = ReadPropertyUtil.readProperty("password", confPath);
		String company = ReadPropertyUtil.readProperty("company", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.enterEmailId();
		signUpPage.clickCreateACcountButton();
		signUpPage.verifyAccountDetailsPageElements();
		signUpPage.enterAccountDetails(accountName, passWord, company);
		signUpPage.clickNextButton();
		signUpPage.verifyPersonalizeAccountPageElements();
		signUpPage.enterPersonalizeAccountDetails();
		signUpPage.clickNext();
		signUpPage.verifySuccessPageElements();
		signUpPage.clickResentEmailButton();
		signUpPage.verifyPageElementsAfterResentEmail();
	}
	
	@TestRailId(testRailId = 20566)
	@Test()
	@Description(value = "C20566 To verify user should be able to sign up for Deskera Bookkeeper with Phone Number")
	public void testSignUpForDeskeraBookkeeper() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String phone = ReadPropertyUtil.readProperty("phone", confPath);
		String countryCode = ReadPropertyUtil.readProperty("countryCode", confPath);
		String accountName = ReadPropertyUtil.readProperty("userFirstName", confPath);
		String passWord = ReadPropertyUtil.readProperty("password", confPath);
		String company = ReadPropertyUtil.readProperty("company", confPath);
		// Create Page Object instance
		SignUpPage signUpPage = new SignUpPage(driver, wait);
		// Access Test methods
		signUpPage.openURL(url);
		signUpPage.verifyPageTitle();
		signUpPage.verifySignUpPageElements();
		signUpPage.clickSignUpForBookkeeper();
		signUpPage.verifyBookkeeperSignUpPageElements();
		signUpPage.enterEmailandPhone(emailAddress, countryCode, phone);
		signUpPage.clickCreateACcountButton();
		signUpPage.verifyAccountDetailsPageElements();
		signUpPage.enterAccountDetails(accountName, passWord, company);
		signUpPage.clickNextButton();
		signUpPage.verifyPersonalizeAccountPageElements();
		signUpPage.enterPersonalizeAccountDetails();
		signUpPage.clickNext();
		signUpPage.verifySuccessPageElements();
		signUpPage.clickResentEmailButton();
		signUpPage.verifyPageElementsAfterResentEmail();
	}
}