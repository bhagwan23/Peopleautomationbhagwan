package deskera.web.automation.erp.imports.tests;

import java.awt.AWTException;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import deskera.web.automation.core.DriverFactory;
import deskera.web.automation.core.TestRailId;

import deskera.web.automation.erp.bvtSG.pages.HomePage;
import deskera.web.automation.erp.imports.pages.TrackedProductImportPage;
import deskera.web.automation.utils.ReadPropertyUtil;
import io.qameta.allure.Description;

public class Importtrackedproducttest extends DriverFactory {
	
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
	@Description(value = "Import tracked product using xlsx file")
	public void ImportxlsxfileoftrackedProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage=new TrackedProductImportPage(driver,wait);
		
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("TrackedProductexcelformat.xlsx");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
		
	}
	
	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using csv file")
	public void ImportcsvfileoftrackedProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage=new TrackedProductImportPage(driver,wait);
		
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("TrackedProductcsvformat.csv");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
	}
	
	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using xlsx file")
	public void ImportxlsxfileofnontrackedProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage=new TrackedProductImportPage(driver,wait);
		
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("NontrackedProductexcelformat.xlsx");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
	}
	@TestRailId(testRailId = 249082)
	@Test()
	@Description(value = "Import tracked product using csv file")
	public void ImportcsvfileofnontrackedProduct() throws InterruptedException, AWTException {
		
		HomePage homePage=new HomePage(driver, wait);
		TrackedProductImportPage trackedProductImportPage=new TrackedProductImportPage(driver,wait);
		
		homePage.clickProductsTab();
		trackedProductImportPage.ClickOnNewProductButton();
		trackedProductImportPage.verifyPageTitle();
		trackedProductImportPage.SelectTrackedProductObjectToImpot();
		trackedProductImportPage.UploadImportProductFile("NontrackedProductcsvformat.csv");
		trackedProductImportPage.MapheadersToImportProducts();
		trackedProductImportPage.ConfirmDataToImport();
		trackedProductImportPage.verifyProductImportSuccessMessage();
		
	}
	

}
