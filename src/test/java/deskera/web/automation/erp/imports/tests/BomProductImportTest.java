package deskera.web.automation.erp.imports.tests;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;
import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.imports.pages.BOMProductimportPage;

import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class BomProductImportTest extends DriverFactory {
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
	
	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import BOM product using xlsx file")
	public void ImportxlsxfileofBOMProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
		BOMProductimportPage BOMProductimportPage=new BOMProductimportPage(driver,wait);
		
		homePage.clickProductsTab();
		
		BOMProductimportPage.clickNewProductButton();
		BOMProductimportPage.verifyPageTitle();
		BOMProductimportPage.selectTrackedProductobjecttoimpot();
		BOMProductimportPage.uploadImportproductfile("BOMProductexcelformat.xlsx");
		BOMProductimportPage.Mapheaderstoimportproducts();
		BOMProductimportPage.confirmdatatoimport();
		BOMProductimportPage.verifyProductimportSuccessMessage();
		
	}
	
	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import BOM product using csv file")
	public void ImportcsvfileofBOMProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
        BOMProductimportPage BOMProductimportPage=new BOMProductimportPage(driver,wait);
		
		homePage.clickProductsTab();
		
		BOMProductimportPage.clickNewProductButton();
		BOMProductimportPage.verifyPageTitle();
		BOMProductimportPage.selectTrackedProductobjecttoimpot();
		BOMProductimportPage.uploadImportproductfile("BOMProductcsvformat.csv");
		BOMProductimportPage.Mapheaderstoimportproducts();
		BOMProductimportPage.confirmdatatoimport();
		BOMProductimportPage.verifyProductimportSuccessMessage();
		
	}
	

}
