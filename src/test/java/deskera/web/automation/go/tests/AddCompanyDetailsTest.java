package deskera.web.automation.go.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestListenerOnFailure;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.go.pages.CompanyDetailsPage;
import deskera.web.automation.go.pages.DashboardPage;
import deskera.web.automation.go.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ TestListenerOnFailure.class })
public class AddCompanyDetailsTest extends DriverFactory {
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
	
	@TestRailId(testRailId = 17041)
	@Test()
	@Description(value = "C17041 To verify user should be able to fill Company details.")
	public void addCompanyDetailsTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		String address1 = ReadPropertyUtil.readProperty("address1", confPath);
		String address2 = ReadPropertyUtil.readProperty("address2", confPath);
		String city = ReadPropertyUtil.readProperty("city", confPath);
		String zip = ReadPropertyUtil.readProperty("zip", confPath);
		String state = ReadPropertyUtil.readProperty("state", confPath);
		String country = ReadPropertyUtil.readProperty("country", confPath);
		String phoneNumber = ReadPropertyUtil.readProperty("phoneNumber", confPath);
		String fax = ReadPropertyUtil.readProperty("fax", confPath);
		String website = ReadPropertyUtil.readProperty("website", confPath);
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		DashboardPage dashboardPage=new DashboardPage(driver,wait);
		CompanyDetailsPage companyDetailsPage=new CompanyDetailsPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		dashboardPage.verifyPageTitle();
		dashboardPage.openCompanyDetailsPage();
		companyDetailsPage.verifyPageTitle();
		companyDetailsPage.verifyCompanyDetailsPageElements();
	    //companyDetailsPage.uploadCompanyLogo();
		companyDetailsPage.addCompanyDetails(address1, address2, city, zip, state, country);
		companyDetailsPage.addContactInformation(phoneNumber, fax, website);
		companyDetailsPage.clickSaveButton();
		companyDetailsPage.verifySuccessMessage();
		//companyDetailsPage.refreshPage();
		//companyDetailsPage.verifyAddedCompanyDetails(address1, address2, city, zip, state, country);
	    //companyDetailsPage.verifyAddedContactInformation(phoneNumber, fax, website);
		dashboardPage.userLogout();
	}
}
