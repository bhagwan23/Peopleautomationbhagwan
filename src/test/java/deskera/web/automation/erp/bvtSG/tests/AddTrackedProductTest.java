package deskera.web.automation.erp.bvtSG.tests;

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

public class AddTrackedProductTest extends DriverFactory{

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
	
	@TestRailId(testRailId = 16961)
	@Test()
	@Description(value = "Create Organization ")
	public void addNonTrackedProductTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		String trackedProductName = ReadPropertyUtil.readProperty("trackedProductName", confPath);	
		String barcode = ReadPropertyUtil.readProperty("barcode", confPath);	
		String description = ReadPropertyUtil.readProperty("description", confPath);	
		String purchasePrice = ReadPropertyUtil.readProperty("purchasePrice", confPath);	
		String salesPrice = ReadPropertyUtil.readProperty("salesPrice", confPath);	
		String openingQuanity = ReadPropertyUtil.readProperty("openingQuanity", confPath);	
		String openingValuation = ReadPropertyUtil.readProperty("openingValuation", confPath);
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
		createProductPage.clickNewProductButton();
		createProductPage.verifyPageTitle();
		createProductPage.verifyCreateNewProductPage();
		createProductPage.selectTrackedProduct();
		createProductPage.enterProductDetails(trackedProductName, barcode, description);
		createProductPage.clickAccountingTab();
		createProductPage.verifyAccountingTab();
		createProductPage.enterAccountingInfo(purchasePrice, salesPrice);
		createProductPage.clickInventoryTab();
		createProductPage.verifyInventoryTabForTrackedProduct();
		createProductPage.enterOpeningBalanceDetails(openingQuanity, openingValuation);
		createProductPage.clickSaveButton();
 }
}
