package deskera.web.automation.people.bvtSG.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.AddDeductionComponentPage;
import deskera.web.automation.people.bvtSG.pages.AddEarningComponentPage;
import io.qameta.allure.Description;

public class AddDeductionComponentTest extends DriverFactory{
	
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
	@Description(value = "To verify that user is able to Add Deduction Component ")
	public void addDeductionComponent() throws InterruptedException {
		String dType = ReadPropertyUtil.readProperty("dType", confPath);
		AddDeductionComponentPage ac = new AddDeductionComponentPage(driver,wait);
		ac.clickComponentButton();
        ac.clickAddComponentButton();
		ac.componentDetailsdeduction(dType);
		ac.saveButton();
		ac.verifySuccessMessageForDeduction();
		ac.verifyAddedEarningComponent(dType);
	}
		

}
