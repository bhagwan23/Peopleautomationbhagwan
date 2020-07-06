package deskera.web.automation.erp.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.ContactsPage;
import deskera.web.automation.erp.bvtSG.pages.DeleteContactPage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

//@Listeners({ ScreenShotListener.class })
public class DeleteContactTest extends DriverFactory{
	String confPath, url;
	ReadPropertyUtil rProp = new ReadPropertyUtil();

	/**
	 * Get common details required for test
	 * 
	 * @param conf
	 * @param URL
	 */
	@BeforeClass
	@Parameters({ "conf", "environment" })
	public void getConf(String conf, String URL) {
		confPath = conf;
		url = URL;
	}

	@TestRailId(testRailId = 20261)
	@Test
	@Description(value = "To verify that user is able to Delete contacts")
	public void deleteContacts() throws InterruptedException{
		/*
		 * String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		 * String passWord = ReadPropertyUtil.readProperty("userPass", confPath);
		 */
		
		String name= ReadPropertyUtil.readProperty("UpdatedContactName", confPath);
		//String UENNumber= ReadPropertyUtil.readProperty("UEN_Number", confPath);
		//String TAXNumber= ReadPropertyUtil.readProperty("TAX_Number", confPath);
		
		// Create login Page Object instance
		/*
		 * LoginPage loginPage = new LoginPage(driver, wait); loginPage.openURL(url);
		 * loginPage.enterEmailandPassword(emailAddress, passWord);
		 * loginPage.clickSignIn();
		 */	
		//Create Contact page object instance
		ContactsPage contactsPage = new ContactsPage(driver, wait);
		contactsPage.clickContactsButton();
		
		// Create Delete Page Object instance
		DeleteContactPage deletecontact = new DeleteContactPage(driver, wait);
		deletecontact.clickContextMenuIcon();
		deletecontact.verifySuccessMessageForDelete();
		
		//Click on searchbox and search deleted contact
		deletecontact.searchdeletedRecord(name);
		
		//Verify deleted contact
		deletecontact.verifyDeletedContact();
		
		//verify all summary count after deletion of contact
		deletecontact.verifysummarycount();
}
}