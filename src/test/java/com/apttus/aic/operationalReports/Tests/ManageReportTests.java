package com.apttus.aic.operationalReports.Tests;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.apttus.aic.operationalReports.uiLibrary.HomePage;
import com.apttus.aic.operationalReports.uiLibrary.ManageReportsPage;
import com.apttus.aic.operationalReports.uiLibrary.OpReportinit;
import com.apttus.helpers.JavaHelpers;
import com.apttus.selenium.WebDriverUtils;

public class ManageReportTests {
	
	public WebDriver driver;
	public OpReportinit opReportinit;
	public HomePage homePage;
	ManageReportsPage manageReportsPage;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "runParallel", "environment", "browser", "hubURL" })
	public void LoginToAdminApp(String runParallel, String environment, String browser, String hubURL) throws Exception {
		WebDriverUtils utils = new WebDriverUtils();
        utils.initializeDriver(browser, "");
  //      Properties configProperties = JavaHelpers.loadPropertyFile(environment);
        Map<String, String> configProperties = JavaHelpers.readJsonElement("manageReports.json", "users");
        utils.microsoftLogin(configProperties.get("user1"));
        driver=utils.getDriver();
        opReportinit=new OpReportinit(driver);
        homePage=opReportinit.landOnHomepage();
	}
	
	//@Test
	public void searchReportsByFilter() throws Exception {
		manageReportsPage = homePage.navigateToManageReportsPage();
		Map<String, String> testData = JavaHelpers.readJsonElement("manageReports.json", "searchReportByFilter");
		manageReportsPage.searchReportByName(testData.get("name"));
	}
	
	/** Sharing single Report with Single User	 */
	@Test(description="", groups="smoke")
	public void verifyShareReportToSingleUser() throws Exception {
		try {
			manageReportsPage = homePage.navigateToManageReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonElement("manageReports.json", "reportUser");
			manageReportsPage.sortReportsByLastCreatedOn()
							 .selectReportsFromGrid(0)
							 .shareReportToUser(testData.get("userName"));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/** Sharing Multiple Report (Shared + UnShared) with Multiple User	 */
	@Test(description="", groups="regression", dependsOnMethods="verifyShareReportToSingleUser")
	public void verifyShareReportToMultipleUser() throws Exception {
		try {
			manageReportsPage = homePage.navigateToManageReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonElement("manageReports.json", "reportUser");
			manageReportsPage.sortReportsByLastCreatedOn()
							 .selectReportsFromGrid(0)
							 .selectReportsFromGrid(1)
							 .shareReportToUser(testData.get("userName"), testData.get("userName2"));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/** Sharing Single Report with single Group	 */
	@Test(description="", groups="smoke", dependsOnMethods="verifyShareReportToMultipleUser")
	public void verifyShareReportToSingleUserGroup() throws Exception {
		try {
			manageReportsPage = homePage.navigateToManageReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonElement("manageReports.json", "reportUserGroup");
			manageReportsPage.sortReportsByLastCreatedOn()
							 .selectReportsFromGrid(0)
							 .shareReportToGroup(testData.get("userGroup"));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/** Sharing Multiple Report (Shared + UnShared`) with Multiple Groups */
	@Test(description="", groups="regression", dependsOnMethods="verifyShareReportToSingleUserGroup")
	public void verifyShareReportToMultipleUserGroup() throws Exception {
		try {
			manageReportsPage = homePage.navigateToManageReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonElement("manageReports.json", "reportUserGroup");
			manageReportsPage.sortReportsByLastCreatedOn()
							 .selectReportsFromGrid(0)
							 .selectReportsFromGrid(1)
							 .shareReportToGroup(testData.get("userGroup"), testData.get("userGroup2"));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@AfterMethod(alwaysRun = true)
	@Parameters({ "environment" })
	public void cleanUp(String environment) throws Exception {
		homePage = homePage.navigateBackToHomepage(environment);
	}

	@AfterSuite(alwaysRun = true)
	public void quitDriver() {
		driver.quit();
	}
}
