package deskera.web.automation.erp.bvtSG.tests;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.CreateProductPage;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.bvtSG.pages.LoginPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class EditProductTest extends DriverFactory{

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
	
	@TestRailId(testRailId = 20263)
	@Test()
	@Description(value = "Edit Product ")
	public void editProductTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		String nonTrackedProductName = ReadPropertyUtil.readProperty("nonTrackedProductName", confPath);	
		//String barcode = ReadPropertyUtil.readProperty("barcode", confPath);	
		String description = ReadPropertyUtil.readProperty("description", confPath);
		Random rand = new Random();
		String barcode = String.format("%04d", rand.nextInt(1000));
		String purchasePrice = ReadPropertyUtil.readProperty("purchasePrice", confPath);	
		String salesPrice = ReadPropertyUtil.readProperty("salesPrice", confPath);	
		String defaultPurchaseAccount = ReadPropertyUtil.readProperty("defaultPurchaseAccount", confPath);	
		String defaultPurchasePrice = ReadPropertyUtil.readProperty("defaultPurchasePrice", confPath);	
		String defaultPurchaseTax = ReadPropertyUtil.readProperty("defaultPurchaseTax", confPath);	
		String defaultSalesAccount = ReadPropertyUtil.readProperty("defaultSalesAccount", confPath);	
		String defaultSalesPrice = ReadPropertyUtil.readProperty("defaultSalesPrice", confPath);
		String defaultSalesTax = ReadPropertyUtil.readProperty("defaultSalesTax", confPath);	
		String defaultUnitOfMeasurement = ReadPropertyUtil.readProperty("defaultUnitOfMeasurement", confPath);	
		
		// Create Page Object instance
		LoginPage loginPage = new LoginPage(driver, wait);
		HomePage homePage=new HomePage(driver, wait);
		CreateProductPage createProductPage=new CreateProductPage(driver,wait);
		// Access Test methods
		loginPage.openURL(url);
		loginPage.verifyPageTitle();
		loginPage.verifyLoginPageElements();
		loginPage.enterEmailandPassword(emailAddress, passWord);
		loginPage.clickSignIn();
		homePage.verifyPageTitle();
		homePage.clickProductsTab();
		createProductPage.clickThreeDotsOnFirstProduct();
		createProductPage.clickTEditButton();
		
		
		
}
}
