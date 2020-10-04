package deskera.web.automation.people.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.EditComponentPage;
import io.qameta.allure.Description;

public class EditComponentTest extends DriverFactory {
	
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
	@Description(value = "To verify that user is able to edit Component ")
	public void editComponent() throws InterruptedException {
		
		String eComponent = ReadPropertyUtil.readProperty("eComponent", confPath);
		//String ecName = ReadPropertyUtil.readProperty("ecName", confPath);


		EditComponentPage ec = new EditComponentPage(driver,wait);
		ec.clickComponentButton();
		ec.clickContextMenuIcon1();
		ec.clickEditbutton();
		ec.editComponentDetails(eComponent);
		ec.saveButton();
		ec.verifySuccessMessageForEditComponent();
		ec.verifyEditedComponent(eComponent);
		
	}
		

}
