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
import deskera.web.automation.people.bvtSG.pages.Pr1EmployeePayrunPage;
import io.qameta.allure.Description;

public class Pr1EmployeePayrunTest extends DriverFactory {

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

	@Description(value = "To verify that user is able to Add PR1 employee")
	@Test
	public void addpr1user() throws InterruptedException {

		DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
		Date dateobj = new Date();
		ReadPropertyUtil.writeProperty("email", confPath, "testauto_" + df.format(dateobj) + "@getnada.com");

		String fnames = ReadPropertyUtil.readProperty("fnames", confPath);
		String lnames = ReadPropertyUtil.readProperty("lnames", confPath);
		String email = ReadPropertyUtil.readProperty("email", confPath);
		String desg = ReadPropertyUtil.readProperty("desg", confPath);
		String dob = ReadPropertyUtil.readProperty("dob", confPath);
		String doj = ReadPropertyUtil.readProperty("doj", confPath);
		String basicsal = ReadPropertyUtil.readProperty("basicsal", confPath);
		String allowancea = ReadPropertyUtil.readProperty("allowancea", confPath);
		String deductiona = ReadPropertyUtil.readProperty("deductiona", confPath);

		String nric = ReadPropertyUtil.readProperty("nric", confPath);
		String nationality = ReadPropertyUtil.readProperty("nationality", confPath);
		String country = ReadPropertyUtil.readProperty("country", confPath);

		Pr1EmployeePayrunPage pp = new Pr1EmployeePayrunPage(driver, wait);
		pp.clickEmployeeButton();
		pp.Addempbuttonclick();
		pp.clickname();

		pp.Entername(fnames, lnames, email, desg, dob, doj, basicsal);
		pp.Empnext();
		pp.Componentdata(allowancea, deductiona);
		pp.compoNextClick();
		pp.Immigrationdeatils(nric, nationality, country);
		pp.Addsgpayroll();
	}

	@Test
	public void addsgpayroll() throws InterruptedException {

		Pr1EmployeePayrunPage pp = new Pr1EmployeePayrunPage(driver, wait);
		// pp.Addsgpayroll();

	}
}