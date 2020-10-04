package deskera.web.automation.people.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.AddnewemployeePage;
import deskera.web.automation.people.bvtSG.pages.DeleteemployeePage;
import io.qameta.allure.Description;

public class DeleteemployeeTest extends DriverFactory {
	
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
	@Description(value = "To verify that user is able to Delete Employee")
	public void deleteEmployee() throws InterruptedException {
		
		
		AddnewemployeePage ae = new AddnewemployeePage(driver,wait);
		ae.clickEmployeeButton();
		DeleteemployeePage de = new DeleteemployeePage(driver,wait);
		de.clickContextMenuIcon();
		de.verifySuccessMessageForDelete();
		
		
	}

}
