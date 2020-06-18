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

public class AddBOMProductTest extends DriverFactory {
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
	
	@TestRailId(testRailId = 21022)
	@Test()
	@Description(value = "C21022 Create BOM Product ")
	public void addBOMProductTest() throws InterruptedException {
		// Read test specific data from config
		String emailAddress = ReadPropertyUtil.readProperty("userEmail", confPath);
		String passWord = ReadPropertyUtil.readProperty("userPass", confPath);	
		String BOMProductName = ReadPropertyUtil.readProperty("BOMProductName", confPath);	
		String description = ReadPropertyUtil.readProperty("description", confPath);	
		String salesPrice = ReadPropertyUtil.readProperty("salesPrice", confPath);	
		String openingQuanity = ReadPropertyUtil.readProperty("openingQuanity", confPath);	
		String openingValuation = ReadPropertyUtil.readProperty("openingValuation", confPath);
		
		String componentproduct1 = ReadPropertyUtil.readProperty("componentproduct1", confPath);	
		String componentproduct2 = ReadPropertyUtil.readProperty("componentproduct2", confPath);	
		String quantity1 = ReadPropertyUtil.readProperty("quantity1", confPath);	
		String quantity2 = ReadPropertyUtil.readProperty("quantity2", confPath);
		
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
		createProductPage.selectBOMProduct();
		createProductPage.enterProductDetails(BOMProductName,description);
		createProductPage.clickAccountingTab();
		createProductPage.verifyAccountingTabForBOMProduct();
		createProductPage.enterAccountingInfoForBOMProduct(salesPrice);	
		createProductPage.clickInventoryTab();
		createProductPage.verifyInventoryTabForBOMProduct();
		createProductPage.selectInventoryAccount();
		createProductPage.enterOpeningBalanceDetails(openingQuanity, openingValuation);
		createProductPage.clickBillOfMaterialTab();
		createProductPage.verifyBillOfMaterialTab();
		createProductPage.enterBOMDetails(quantity1, quantity2);
		createProductPage.clickSaveButton();	
		createProductPage.verifyCreatedBOMProduct(BOMProductName, description);
 }
}
