package deskera.web.automation.people.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.AddnewemployeePage;
import deskera.web.automation.people.bvtSG.pages.EditemployeePage;
import io.qameta.allure.Description;

public class EditemployeeTest extends DriverFactory{
	
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
	@Description(value = "To verify that user is able to Edit Employee")
	public void editEmployee() throws InterruptedException {
		String eEmail = ReadPropertyUtil.readProperty("eEmail", confPath);
		String bSal = ReadPropertyUtil.readProperty("bSal", confPath);
		String eDoj = ReadPropertyUtil.readProperty("eDoj", confPath);
		AddnewemployeePage ae = new AddnewemployeePage(driver,wait);
		ae.clickEmployeeButton();
		
		EditemployeePage ee = new EditemployeePage(driver,wait);
		ee.clickContextMenuIcon();
		ee.clickEditButton1();
		ee.editEmployeeInfo(bSal, eEmail);
		//ee.scrollToElement();
	

	}
}
