package deskera.web.automation.people.bvtSG.tests;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.people.automation.core.DriverFactory;
import deskera.people.automation.core.TestRailId;
import deskera.people.automation.utils.ReadPropertyUtil;
import deskera.web.automation.people.bvtSG.pages.AddnewemployeePage;

import io.qameta.allure.Description;




public class AddnewemployeeTest extends DriverFactory {
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
	
	
	@Description(value = "To verify that user is able to Add employee")
	@Test
	public void addemp() throws InterruptedException {
	
		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
	    Date dateobj = new Date();
		ReadPropertyUtil.writeProperty("email", confPath, "testauto_" + df.format(dateobj) + "@getnada.com");
		
		String fname = ReadPropertyUtil.readProperty("fname", confPath);
		String lname = ReadPropertyUtil.readProperty("lname", confPath);
		String email = ReadPropertyUtil.readProperty("email", confPath);
		String desg = ReadPropertyUtil.readProperty("desg", confPath);
		String dob = ReadPropertyUtil.readProperty("dob", confPath);
		String doj = ReadPropertyUtil.readProperty("doj", confPath);
		String basicsal = ReadPropertyUtil.readProperty("basicsal", confPath);
		String nric = ReadPropertyUtil.readProperty("nric", confPath);
		String nationality = ReadPropertyUtil.readProperty("nationality", confPath);
		String country = ReadPropertyUtil.readProperty("country", confPath);
		String sop = ReadPropertyUtil.readProperty("sop", confPath);



		
		//AddnewemployeePages ae = new AddnewemployeePages(driver,wait);
		AddnewemployeePage ae = new AddnewemployeePage(driver,wait);
		ae.clickEmployeeButton();
		ae.Addempbuttonclick();
		ae.clickname();
		ae.Entername(fname, lname, email, desg, dob, doj, basicsal);
		ae.Empnext();;
		//ae.verifycomponentscreen();
		ae.componentnextclick();
		//ae.Verifycompliancepage();
		ae.Immagrationdeatils(nric, nationality, country, sop);
	    ae.clickonsavebutton();
	   // ae.verifySuccessMessageForAdduser();
	    ae.clickEmployeeButton();
	    ae.EmployeeButton();
	    ae.verifyaddedEmployee(fname, basicsal);
	    
	

	}
}
	
	//AddnewemployeePages ae = new AddnewemployeePages(driver);
	
	

