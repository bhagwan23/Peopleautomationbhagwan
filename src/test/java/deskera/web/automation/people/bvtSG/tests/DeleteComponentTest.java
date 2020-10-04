package deskera.web.automation.people.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.DeleteComponentPage;
import io.qameta.allure.Description;

public class DeleteComponentTest extends DriverFactory {
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
	
	
	@TestRailId(testRailId = 20212)
	@Test
	@Description(value = "To verify that user is able to delete Component ")
	public void deleteComponent() throws InterruptedException {
		DeleteComponentPage dc = new DeleteComponentPage(driver,wait);
		dc.clickComponentButton();
		dc.clickContextMenuIcon1();
		dc.deleteButton();
		dc.verifySuccessMessageForDelete();
		
	}

}
