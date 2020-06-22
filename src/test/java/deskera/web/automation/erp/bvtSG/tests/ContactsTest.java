package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.ContactsPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ ScreenShotListener.class })
public class ContactsTest extends DriverFactory {
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

	@TestRailId(testRailId = 20261)
	@Test
	@Description(value = "C20261 To verify that user is able to Add contacts")
	public void addContacts() throws InterruptedException{
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	

		String name= ReadPropertyUtil.readProperty("ContactName", confPath);
		String contactMail  = ReadPropertyUtil.readProperty("contactMail", confPath);
		String UENNumber= ReadPropertyUtil.readProperty("UEN_Number", confPath);
		String TAXNumber= ReadPropertyUtil.readProperty("TAX_Number", confPath);

		String address= ReadPropertyUtil.readProperty("address", confPath);
		String state= ReadPropertyUtil.readProperty("state", confPath);
		String postal= ReadPropertyUtil.readProperty("postal", confPath);
		String city= ReadPropertyUtil.readProperty("city", confPath);
		String country= ReadPropertyUtil.readProperty("country", confPath);


		// Create login Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.openURL(url);
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();

		// Create Page Object instance
		ContactsPage contactsPage = new ContactsPage(driver, wait);

		// Access Test methods
		contactsPage.verifyPageTitle();
		contactsPage.verifyContactElements();
		contactsPage.clickContactsButton();
	//	contactsPage.clickPopup();

		//contactsPage.clickPopup();
		contactsPage.clickAddContactButton();
		contactsPage.enterGeneralInfo(name, contactMail, UENNumber, TAXNumber);
		contactsPage.enterAccountingDetails();
		contactsPage.addressDetails();
		contactsPage.addAddressDetail(address, state, postal, city, country);
		contactsPage.clickSaveButton();
		//contactsPage.clickContactsButton();

		contactsPage.verifyAddedContacts(name, UENNumber, TAXNumber);



	}
	@TestRailId(testRailId = 20261)
	@Test
	@Description(value = "C20261 To verify that user is able to Add contacts")

	public void addContacts1() throws InterruptedException{
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	

		// Create login Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		loginPage.openURL(url);
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();

		String name= ReadPropertyUtil.readProperty("ContactName1", confPath);
		String contactMail  = ReadPropertyUtil.readProperty("contactMail1", confPath);
		String UENNumber= ReadPropertyUtil.readProperty("UEN_Number", confPath);
		String TAXNumber= ReadPropertyUtil.readProperty("TAX_Number", confPath);

		String address= ReadPropertyUtil.readProperty("address", confPath);
		String state= ReadPropertyUtil.readProperty("state", confPath);
		String postal= ReadPropertyUtil.readProperty("postal", confPath);
		String city= ReadPropertyUtil.readProperty("city", confPath);
		String country= ReadPropertyUtil.readProperty("country", confPath);

		ContactsPage contactsPage = new ContactsPage(driver, wait);

		contactsPage.clickContactsButton();
		contactsPage.clickAddContactButton();
		contactsPage.enterGeneralInfo(name, contactMail, UENNumber, TAXNumber);
		contactsPage.enterAccountingDetails();
		contactsPage.addressDetails();
		contactsPage.addAddressDetail(address, state, postal, city, country);
		contactsPage.clickSaveButton();
		contactsPage.verifyAddedContacts(name, UENNumber, TAXNumber);

	}}
