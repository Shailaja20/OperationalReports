package com.apttus.aic.operationalReports.Tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.apttus.aic.operationalReports.uiLibrary.DashBoardPage;
import com.apttus.aic.operationalReports.uiLibrary.HomePage;
import com.apttus.aic.operationalReports.uiLibrary.OpReportinit;
import com.apttus.helpers.JavaHelpers;
import com.apttus.selenium.NGHelper;
import com.apttus.selenium.WebDriverUtils;


public class DashboardUITest {
	
	
	public WebDriver driver;
    public OpReportinit opReportinit;
	public HomePage homePage;
	public boolean needsLoginFlag = true;
	public NGHelper ngHelper;
	public DashBoardPage dashBoardPage;
	public Properties configProperties;
	public static String DashStr;
	public static String DashStr1;
	private static String crtDashText;
	private static String RnmeText;
	private static String EdText;
	private static String DtText;
	private static String clText;
	
	public String fltdashboard;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "runParallel", "environment", "browser", "hubURL" })
	public void LoginToAdminApp(String runParallel, String environment, String browser, String hubURL) throws Exception {
		WebDriverUtils utils = new WebDriverUtils();
        utils.initializeDriver(browser, "");
        configProperties = JavaHelpers.loadPropertyFile(environment);
        utils.microsoftLogin(configProperties);
        driver=utils.getDriver();
        opReportinit=new OpReportinit(driver);
        homePage=opReportinit.landOnHomepage();
   
	}	
	
	@Test(description="ST01_To Create and Save a Dashboard", groups= {"Dashboard"})
	public void CreateNewWidget() throws Exception {
		try {
			dashBoardPage = homePage.navigateToDashBoard();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			DashStr=dashBoardPage.addNewWidget(testData.get("title")+ln, testData.get("descp"));
			assertEquals(DashStr, dashBoardPage.DashboardFltr.getText());
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST_05 To verify the Dashboard Clone Functionality", groups= {"Dashboard"},dependsOnMethods="EditDashboard")
	public void CloneNewWidget() throws Exception {
		try {
			dashBoardPage = homePage.navigateToDashBoard();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			DashStr=dashBoardPage.CloneWidget(testData.get("cloneDashName")+ln);
			assertEquals(DashStr, dashBoardPage.DashboardFltr.getText());
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
     @Test(description="ST_07 To verify the Dashboard Delete Functionality", groups= {"Dashboard"},dependsOnMethods="EditDashboard")
    public void DeleteNewWidget() throws Exception {
		try {
			
			dashBoardPage = homePage.navigateToDashBoard();
			dashBoardPage.DeleteWidgetDashboard();
			assertNotEquals(dashBoardPage.DeleteDash, dashBoardPage.NewDashboard);
						
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
     
	@Test(description="ST_04 To verify the Dashboard Edit Functionality", groups= {"Dashboard"},dependsOnMethods="CreateNewWidget")
	public void EditDashboard() throws Exception{
		try {
			dashBoardPage=homePage.navigateToDashBoard();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			DashStr=dashBoardPage.EditcreatedDashboard(testData.get("title")+ln);
			
			assertEquals(DashStr, dashBoardPage.DashboardFltr.getText());
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
		
	@Test(description="ST_06 To verify the Dashboard Rename Functionality", groups= {"Dashboard"},dependsOnMethods="EditDashboard")
	public void RenameDashboard() throws Exception{
		try {
			dashBoardPage=homePage.navigateToDashBoard();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			fltdashboard=dashBoardPage.RenamecreatedDashboard(testData.get("RenameDashboard")+ln);
		}catch (Exception e) {
			throw new Exception(e);
		}
	
	}
	
	@Test(description="To verify the Number of Blocks set per Dashboard", groups= {"Dashboard"})
	public void MaxDashboardCount() throws Exception {
		try {
			dashBoardPage = homePage.navigateToDashBoard();
			JavaHelpers.readJsonFile("ViewDashboard.json");
			dashBoardPage.MaxDashCount();
		
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
		
	@Test(description="ST_08 To verify the Create Dashboard Functionality", groups= {"Dashboard"})
	public void SearchOrderDashboard() throws Exception {
		try {
						
			dashBoardPage = homePage.navigateToDashBoard();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			DashStr=dashBoardPage.SearchOrderdash(testData.get("title")+ln, testData.get("descp"));
			System.out.println("str"+DashStr+" str " +dashBoardPage.DashboardFltr.getText());
		
			assertEquals(DashStr, dashBoardPage.DashboardFltr.getText());
			
		
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST_03 To verify the dashboard viewer Page", groups= {"Dashboard"})
	public void VerifydashboardviewerPage() throws Exception {
		try {
				
			dashBoardPage = homePage.navigateToDashBoard();
			dashBoardPage.dashboardviewer();
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST_08 To verify the Create Dashboard Functionality", groups= {"Dashboard"},dependsOnMethods="SearchOrderDashboard")
	public void DeleteTopDashboard() throws Exception {
		try {
				
			dashBoardPage = homePage.navigateToDashBoard();
			dashBoardPage.DeleteWidgetDashboard();
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@AfterMethod(alwaysRun=true)
	public void cleanUp() throws Exception {
		homePage=opReportinit.navigateBackToHomepage(configProperties);
	}
	
	@AfterClass(alwaysRun=true)
	public void quitDriver() {
		driver.quit();
	}

}
