package com.apttus.aic.operationalReports.Tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.apttus.aic.operationalReports.uiLibrary.HomePage;
import com.apttus.aic.operationalReports.uiLibrary.ListOfReportsPage;
import com.apttus.aic.operationalReports.uiLibrary.OpReportinit;
import com.apttus.helpers.JavaHelpers;
import com.apttus.selenium.WebDriverUtils;

public class ReportsTests {

	public WebDriver driver;
	public OpReportinit opReportinit;
	public HomePage homePage;
	ListOfReportsPage listOfReportsPage;
	String quickReportName;
	String sortReportName;
	String reportWizardName;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "runParallel", "environment", "browser", "hubURL" })
	public void LoginToAdminApp(String runParallel, String environment, String browser, String hubURL)
			throws Exception {
		WebDriverUtils utils = new WebDriverUtils();
		utils.initializeDriver(browser, "");
		Properties configProperties = JavaHelpers.loadPropertyFile(environment);
		utils.microsoftLogin(configProperties);
		driver = utils.getDriver();
		opReportinit = new OpReportinit(driver);
		homePage = opReportinit.landOnHomepage();
	}

	@Test(description = "To Create a Quick Report Chart", groups = "smoke")
	public void quickCreateReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			long ln = JavaHelpers.generateRandomNumber();
			quickReportName = testData.get("reportName") + ln;
			listOfReportsPage.createQuickReport(quickReportName, testData.get("reportDescp"),
					testData.get("reportQuery"), testData.get("reportConfigQuery"), testData.get("fieldLink"),
					testData.get("chartValue"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { quickReportName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-281 Filter Reports By Active Status", groups = "smoke")
	public void FilterReportWithActiveStatus()
			throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterReportByDropDown(testData.get("statusReport"), testData.get("filterValue")).verifyReportDetails();
			assertThat(new String[] { listOfReportsPage.txtReportStatus.getText() },
					is(new String[] { testData.get("verifyStatusReport") }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description = "GAA-281 Filter Reports By Inactive Status", groups = "smoke")
	public void FilterReportWithInactiveStatus()
			throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterReportByDropDown(testData.get("statusReport"), testData.get("filterValue")).verifyReportDetails();
			assertThat(new String[] { listOfReportsPage.txtReportStatus.getText() },
					is(new String[] { testData.get("verifyStatusReport") }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-281 Filter Report with Report Visualization Type", groups = "smoke")
	public void FilterReportWithReportVisualizationType() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterReportByDropDown(testData.get("typeReport"), testData.get("filterValue")).verifyReportDetails();
			assertThat(new String[] { listOfReportsPage.txtVisualizationType.getText() },
					is(new String[] { testData.get("filterValue") }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description = "GAA-281 Filter Report with Chart Visualization Type", groups = "smoke")
	public void FilterReportWithChartVisualizationType() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterReportByDropDown(testData.get("typeReport"), testData.get("filterValue")).verifyReportDetails();
			assertThat(new String[] { listOfReportsPage.txtVisualizationType.getText() },
					is(new String[] { testData.get("filterValue") }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-281 Filter Reports By Name", groups = "smoke")
	public void FilterReportsByName() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("filterLink"), testData.get("searchText"));
				assertThat(new boolean[] { listOfReportsPage.reportName.getText().contains(testData.get("searchText")) },
						is(new boolean[] { true }));
			} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Test(description = "GAA-281 Filter Reports By Description", groups = "smoke")
	public void FilterReportsByDescription() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("filterLink"), testData.get("searchText"));
			listOfReportsPage.verifyReportDetails();
				assertThat(new boolean[] { listOfReportsPage.txtDetailsDescription.getText().contains(testData.get("searchText")) },
						is(new boolean[] { true }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Hyperlink of the Tabular Reports", groups = "regression")
	public void quickCreateReportwithHyperlink() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonElement("reports.json", "quickCreateReport");
			long ln = JavaHelpers.generateRandomNumber();
			quickReportName = testData.get("reportName") + ln;
			listOfReportsPage.createQuickReport(quickReportName, testData.get("reportDescp"),
					testData.get("reportQuery"), testData.get("reportConfigQuery"), testData.get("fieldLink"),
					testData.get("reportTypes"));
			listOfReportsPage.selectHyperLink(testData.get("systemLink"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { quickReportName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the custom URL linked in the Quick create Page for Tabular Reports", groups = "regression")
	public void quickCreateReportwithCustomlink() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonElement("reports.json", "quickCreateReport");
			long ln = JavaHelpers.generateRandomNumber();
			quickReportName = testData.get("reportName") + ln;
			listOfReportsPage.createQuickReport(quickReportName, testData.get("reportDescp"),
					testData.get("reportQuery"), testData.get("reportConfigQuery"), testData.get("fieldLink"),
					testData.get("reportTypes"));
			listOfReportsPage.selectHyperLink(testData.get("customLink"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { quickReportName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Reports Clone Functionality", groups = "smoke", dependsOnMethods = "quickCreateReport")
	public void createCloneReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("cmbFilterName"), quickReportName);
			String updatedName = listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() },
					is(new String[] { "CLONE - " + quickReportName + updatedName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Delete Functionality of the Reports Fields", groups = "smoke", dependsOnMethods = "createCloneReport")
	public void DeleteReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("cmbFilterName"), quickReportName);
			String deletedReport = listOfReportsPage.reportName.getText();
			listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			listOfReportsPage.filterByReports(testData.get("NoneFilter"));
			listOfReportsPage.filterByReports(testData.get("cmbFilterName"), deletedReport);
			assertThat(new boolean[] { listOfReportsPage.NoDataFound.isDisplayed() }, is(new boolean[] { true }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify Quick Edit Functionality of the already generated Reports", groups = "smoke", dependsOnMethods = "DeleteReport")
	public void quickEditReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("cmbFilterName"), quickReportName);
			String updatedName = listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() },
					is(new String[] { quickReportName + updatedName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Rename Functionality of the Reports", groups = "smoke", dependsOnMethods = "quickEditReport")
	public void renameReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("cmbFilterName"), quickReportName);
			String renamedReport = listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			assertThat(new boolean[] { listOfReportsPage.reportName.getText().contains(renamedReport) },
					is(new boolean[] { true }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Export functionality of the Reports Module", groups = "smoke", dependsOnMethods = "renameReport")
	public void ExportToCSV() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
			listOfReportsPage.filterByReports(testData.get("cmbFilterName"), testData.get("searchText"));
			listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			assertThat(new boolean[] { listOfReportsPage.btnReportRunStatus.isDisplayed() },
					is(new boolean[] { true }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-281 To verify the Deactivate Functionality of the Reports Fields", groups = "smoke")
	public void DeActivateReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = new HashMap<String, String>();
			testData.put("fieldName", "Deactivate");
			testData.put("status", "Inactive");
			sortReportName = listOfReportsPage.reportName.getText();
			listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			assertThat(new String[] { listOfReportsPage.txtReportStatus.getText() },
					is(new String[] { testData.get("status") }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-281 To verify the Activate Functionality of the Reports Fields", groups = "smoke", dependsOnMethods = "DeActivateReport")
	public void ActivateReport() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"filteredReportData");
			testData.put("fieldName", "Activate");
			testData.put("status", "Active");
			listOfReportsPage.filterByReports(testData.get("filterLink"), sortReportName);
			listOfReportsPage.selectFieldLink(testData.get("fieldName"));
			assertThat(new String[] { listOfReportsPage.txtReportStatus.getText() },
					is(new String[] { testData.get("status") }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Tabular Reports created using Report Wizard", groups = "smoke")
	public void CreateTabularReportWizard() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"CreateReportWizard");
			testData.put("name", "Automated Tabular Report 1-");
			testData.put("chartType", "Tabular");
			long ln = JavaHelpers.generateRandomNumber();
			reportWizardName = testData.get("name") + ln;
			listOfReportsPage.createReportSelectDataSource(testData.get("fieldLink"), testData.get("viewOptionField"),
					reportWizardName, testData.get("descp")).createReportSelectFields(testData.get("objName"),
							testData.get("fieldName"), testData.get("fieldName1"));
			listOfReportsPage.btnNext.click();
			listOfReportsPage.selectReportVisualizationType(testData.get("chartType"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-208 To create a Pie Chart using Report Wizard", groups = "smoke")
	public void CreatePieChartWizard() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"CreateReportWizard");
			testData.put("name", "Automated Pie Chart 1-");
			testData.put("chartType", "Pie");
			long ln = JavaHelpers.generateRandomNumber();
			reportWizardName = testData.get("name") + ln;
			listOfReportsPage.createReportSelectDataSource(testData.get("fieldLink"), testData.get("viewOptionField"),
					reportWizardName, testData.get("descp")).createReportSelectFields(testData.get("objName"),
							testData.get("fieldName"), testData.get("fieldName1"));
			listOfReportsPage.btnNext.click();
			listOfReportsPage.selectReportVisualizationType(testData.get("chartType"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-208 To create a Horizontal Bar Chart using Report Wizard", groups = "smoke")
	public void CreateHorizontalBarChartWizard() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"CreateReportWizard");
			testData.put("name", "Automated Horizontal Bar Chart 1-");
			testData.put("chartType", "Bar");
			long ln = JavaHelpers.generateRandomNumber();
			reportWizardName = testData.get("name") + ln;
			listOfReportsPage.createReportSelectDataSource(testData.get("fieldLink"), testData.get("viewOptionField"),
					reportWizardName, testData.get("descp")).createReportSelectFields(testData.get("objName"),
							testData.get("fieldName"), testData.get("fieldName1"));
			listOfReportsPage.btnNext.click();
			listOfReportsPage.selectReportVisualizationType(testData.get("chartType"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To create an Aggregated Data Tabular Report", groups = "smoke")
	public void CreatePivotChartWizard() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"CreateReportWizard");
			testData.put("name", "Automated Pivot Table 1-");
			testData.put("chartType", "AggregatedDataTable");
			long ln = JavaHelpers.generateRandomNumber();
			reportWizardName = testData.get("name") + ln;
			listOfReportsPage
					.createReportSelectDataSource(testData.get("fieldLink"), testData.get("viewOptionField"),
							reportWizardName, testData.get("descp"))
					.createReportSelectFields(testData.get("objName"), testData.get("fieldName"),
							testData.get("fieldName1"))
					.setReportWizardFilters(testData.get("objName"), testData.get("filterName"),
							testData.get("operatorValue"), testData.get("value"), testData.get("value1"))
					.selectReportVisualizationType(testData.get("chartType"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To create a Line Chart using Report Wizard", groups = "smoke")
	public void CreateLineChartWizard() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"CreateReportWizard");
			testData.put("name", "Automated Line Chart 1-");
			testData.put("chartType", "Line");
			long ln = JavaHelpers.generateRandomNumber();
			reportWizardName = testData.get("name") + ln;
			listOfReportsPage.createReportSelectDataSource(testData.get("fieldLink"), testData.get("viewOptionField"),
					reportWizardName, testData.get("descp")).createReportSelectFields(testData.get("objName"),
							testData.get("fieldName"), testData.get("fieldName1"));
			listOfReportsPage.btnNext.click();
			listOfReportsPage.selectReportVisualizationType(testData.get("chartType"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "GAA-208 To create a Vertical Bar Chart using Report Wizard", groups = "smoke")
	public void CreateVerticalBarChartWizard() throws Exception {
		try {
			listOfReportsPage = homePage.navigateToListOfReportsPage();
			HashMap<String, String> testData = (HashMap<String, String>) JavaHelpers.readJsonElement("reports.json",
					"CreateReportWizard");
			testData.put("name", "Automated Vertical Bar Chart 1-");
			testData.put("chartType", "Column");
			long ln = JavaHelpers.generateRandomNumber();
			reportWizardName = testData.get("name") + ln;
			listOfReportsPage.createReportSelectDataSource(testData.get("fieldLink"), testData.get("viewOptionField"),
					reportWizardName, testData.get("descp")).createReportSelectFields(testData.get("objName"),
							testData.get("fieldName"), testData.get("fieldName1"));
			listOfReportsPage.btnNext.click();
			listOfReportsPage.selectReportVisualizationType(testData.get("chartType"));
			assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Test(description = "To verify the Edit Functionality of Report Wizard", groups = "smoke", dependsOnMethods = "CreateVerticalBarChartWizard")
	public void EditReportWizard() throws Exception {
		listOfReportsPage = homePage.navigateToListOfReportsPage();
		Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");
		listOfReportsPage.filterByReports(testData.get("cmbFilterName"), reportWizardName);
		listOfReportsPage.selectFieldLink(testData.get("fieldName"));
		listOfReportsPage.btnNext.click();
		listOfReportsPage.selectAggregateFunction(testData.get("aggregateValue"));
		assertThat(new String[] { listOfReportsPage.reportName.getText() }, is(new String[] { reportWizardName }));

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
