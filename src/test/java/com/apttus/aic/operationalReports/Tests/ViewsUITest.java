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
import com.apttus.helpers.JavaHelpers;
import com.apttus.selenium.NGHelper;
import com.apttus.selenium.WebDriverUtils;
import com.apttus.aic.operationalReports.uiLibrary.HomePage;
import com.apttus.aic.operationalReports.uiLibrary.ListOfReportsPage;
import com.apttus.aic.operationalReports.uiLibrary.OpReportinit;
import com.apttus.aic.operationalReports.uiLibrary.ViewPage;

public class ViewsUITest {
	
	public WebDriver driver;
	public OpReportinit opReportinit;
	public HomePage homePage;
	public boolean needsLoginFlag = true;
	public NGHelper ngHelper;
	public ListOfReportsPage listOfReportsPage;
	public ViewPage viewPage;
	
	public ViewsUITest viewUITest;
	public Properties configProperties;
	String quickViewstr;
	String WdVwStr;
	String EdVwStr;
	
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
	
	@Test(description="To Test Quick Create View Functionality", groups= {"Views"},dependsOnMethods="VerifyViewFilterPageEdt")
	public void CreateQuickView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			quickViewstr = viewPage.QuickViewcreate(testData.get("viewName")+ln,testData.get("viewDesp"),testData.get("QuickQuery"),testData.get("ConfigQuery"));
			assertEquals(quickViewstr,viewPage.DetailViewName.getText());
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST-04_Fill Details in Create Data Set-Select Object Page", groups= {"Views"})
	public void VerifyManadatoryField() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			viewPage.FillDetailsCreateData(testData.get("Name"), testData.get("Descp"), testData.get("Anchor"));
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="RT-05_Verify Anchor Object Dropdown", groups= {"Views"})
	public void VerifyAnchorObjects() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			viewPage.VerfyAnchorObjects(testData.get("Anchor"));
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST-07_Verify Create Dataset-Set Fields Page", groups= {"Views"})
	public void VerifyViewFieldsPage() throws Exception {
		try {
			
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			viewPage.VerifyVwFieldsPage(testData.get("Name")+ln, testData.get("Descp"), testData.get("Anchor"),
		    testData.get("OjName"),testData.get("FldName"),testData.get("Opertor"),testData.get("Value"));
						
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	@Test(description="ST-07_Verify Create Dataset-Set Fields Page", groups= {"Views"},dependsOnMethods="VerifyViewFieldsPage")
		public void VerifyViewFieldPageEdt() throws Exception {
			try {
				viewPage = homePage.navigateToView();
				Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");		
				viewPage.VerifyVwsField(testData.get("Anchor"));
							
			} catch (Exception e) {
				throw new Exception(e);
			}
	}
	@Test(description="ST-07_Verify Create Dataset-Set Fields Page", groups= {"Views"})
	public void VerifyViewFilterPage() throws Exception {
		try {
			
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			viewPage.VerifyVwFilterPage(testData.get("Name")+ln, testData.get("Descp"), testData.get("Anchor"),
		    testData.get("OjName"),testData.get("FldName"),testData.get("Opertor"),testData.get("Value"));
									
		} catch (Exception e) {
			throw new Exception(e);
			}
		}
		@Test(description="ST-07_Verify Create Dataset-Set Fields Page", groups= {"Views"},dependsOnMethods="VerifyViewFilterPage")
		public void VerifyViewFilterPageEdt() throws Exception {
			try {
				
				viewPage = homePage.navigateToView();
				Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");		
				viewPage.VerifyVwsFiltr(testData.get("Anchor"),testData.get("OjName"),testData.get("FldName"),testData.get("Opertor"),testData.get("Value"));
							
			} catch (Exception e) {
				throw new Exception(e);
			}
	}
	@Test(description="RT-06_Verify Lookup and Child Objects in Select Objects Page", groups= {"Views"})
	public void VerifyLookUpsChildObjects() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			viewPage.VerfyChildLookupsObjects(testData.get("Anchor"));
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST-10_Verify Create Dataset-Preview Page", groups= {"Views"})
	public void VerifyPreviewPage() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			viewPage.VerifyPreviewPage(testData.get("Name")+ln, testData.get("Descp"), testData.get("Anchor"),
		    testData.get("OjName"),testData.get("FldName"),testData.get("Opertor"),testData.get("Value"));
			//assertEquals(WdVwStr,viewPage.DetailViewName.getText());
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	
	@Test(description="Filter a new view", groups= {"Views"},dependsOnMethods="CreateQuickView")
	public void FilterNewWidget() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			viewPage.FilterViewcreate(testData.get("filtervalue"),quickViewstr);
			assertEquals(quickViewstr,viewPage.DetailViewName.getText());
		
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="To Test Quick Edit View Functionality", groups= {"Views"},dependsOnMethods="DeleteNewView")
    public void EditQuickView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			 	
			viewPage.QuickViewEdit(testData.get("viewName")+ln,testData.get("viewDesp"));
								
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="ST-14_Creating Custom based dataset", groups= {"Views"},dependsOnMethods="FilterNewWidget")
	public void CreateNewWigdetView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
			long ln = JavaHelpers.generateRandomNumber();
			WdVwStr=viewPage.NewWidgetView(testData.get("Name")+ln, testData.get("Descp"), testData.get("Anchor"),
		    testData.get("OjName"),testData.get("FldName"),testData.get("Opertor"),testData.get("Value"));
			assertEquals(WdVwStr,viewPage.DetailViewName.getText());
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="To Test Quick Edit View Functionality", groups= {"Views"},dependsOnMethods="CreateNewWigdetView")
	public void EditNewView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			Map<String, String> testData = JavaHelpers.readJsonFile("ViewDashboard.json");
		    EdVwStr=viewPage.EditNewViewWidget(testData.get("viewNameEdt"), testData.get("viewDespEdt"), 
		    testData.get("OjName"),  testData.get("FldName") , testData.get("Opertor"),testData.get("Value"));
		     assertEquals(viewPage.UpdtQkVw,viewPage.DetailViewName.getText());
			
		} catch (Exception e) {
			throw new Exception(e);
		}	
    }
	
    @Test(description="Datasets Master Details View", groups= {"Views"},dependsOnMethods="CloneNewView")
	public void DeleteNewView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.DeleteViewcreate();
			assertNotEquals(viewPage.AfrDeletedView,viewPage.BfrDeletedView);		
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
    
    @Test(description="Datasets Master Details View", groups= {"Views"},dependsOnMethods="DeleteNewView")
	public void DeleteNewWgView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.DeleteViewcreate();
			assertNotEquals(viewPage.AfrDeletedView,viewPage.BfrDeletedView);		
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
   
    @Test(description="Datasets Master Details View", groups= {"Views"},dependsOnMethods="EditNewView")
	public void RenameNewView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.RenameViewcreate("Renameview");
			assertEquals(viewPage.AfRenameView,viewPage.NewRenameView);
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
   
    @Test(description="Datasets Master Details View", groups= {"Views"},dependsOnMethods="EditNewView")
	public void DeactivatedNewView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.DeactivatedViewcreate();
			assertEquals(viewPage.Status,"Activate");
				
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
   
    @Test(description="Datasets Master Details View", groups= {"Views"},dependsOnMethods="DeactivatedNewView")
	public void ActivatedNewView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.ActivatedViewcreate();
			assertEquals(viewPage.Status,"Deactivate");
						
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
		
	@Test(description="Verify the Cloning of Dataset", groups= {"Views"},dependsOnMethods="DeactivatedNewView")
	public void CloneNewView() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.CloneViewcreate();
			assertEquals(viewPage.AfrCloneView,viewPage.NewCloneView);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description="Remove View Config and Leverage AQL Query to Obtain Related Objects", groups= {"Views"})
	public void RemoveViewConfig() throws Exception {
		try {
			viewPage = homePage.navigateToView();
			viewPage.ViewConfigRemove();
						
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
		opReportinit.closeBrowser();
	}

}
