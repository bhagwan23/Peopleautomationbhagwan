package deskera.web.automation.people.bvtSG.tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.SoftAssertListner;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.AddPayschedule;
import deskera.web.automation.people.bvtSG.pages.AddnewemployeePage;
import io.qameta.allure.Description;

public class AddPayscheduleTest extends DriverFactory {
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
	
	
	@Description(value = "To verify that user is able to Add Payschedule")
	@Test
	public void addpayschedule() throws InterruptedException {
		
		String spay = ReadPropertyUtil.readProperty("spay", confPath);
		String dateVal = ReadPropertyUtil.readProperty("dateVal", confPath);
		//String element = ReadPropertyUtil.readProperty("dateVal", confPath);
		AddPayschedule ap = new AddPayschedule(driver,wait);
		ap.clickPayscheduleButton();
		ap.ClickAddPaySchedulebutton();
		ap.Enterpayscheduledetails(spay);
		//ap.SelectDateByJS(dateVal);
		ap.ClickOnSaveButton();
}
}
