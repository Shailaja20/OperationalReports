package com.apttus.aic.operationalReports.Tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.apttus.aic.operationalReports.Helper.ReportHelper;
import com.apttus.aic.operationalReports.utils.URLGenerator;
import com.apttus.helpers.GetAccessToken;
import com.apttus.helpers.JavaHelpers;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class PlatformToolsTests {
	ReportHelper reportHelper;
	URLGenerator urlGenerator;
	GetAccessToken accessTokenGenerator;
	String reportId;
	String dashboardId;
	
	@BeforeClass(alwaysRun = true)
    @Parameters({ "runParallel", "environment", "hubURL" })
    public void tokenGenerations(String runParallel, String environment,
    		String hubURL) throws Exception
    { 
		  Properties property = JavaHelpers.loadPropertyFile(environment);
		  Map<String, String> testData=new HashMap<String,String>();
		  testData.put("url", property.getProperty("url")+property.getProperty("tenantId")+"/oauth2/token");
		  testData.put("client_id", property.getProperty("clientId"));
		  testData.put("client_secret", property.getProperty("clientSecret"));
		  accessTokenGenerator = new GetAccessToken(testData);	  
		  urlGenerator = new URLGenerator(property.getProperty("baseURL"));
          reportHelper = new ReportHelper(property.getProperty("baseURL"));
    }
	
	 @Test(description="Get All Reports", groups="Smoke")
	   public void getAllReports() throws Exception {
		   Map<String, String> testData = JavaHelpers.readJsonFile("APItestData.json");
		   Assert.assertEquals(reportHelper.generateReport(testData).getStatusCode(), 200);
	   } 
	  
	  @Test(description="Create Reports Definition", groups="Smoke")
	  public void createReport() throws Exception {
		  Map<String, String> createData = JavaHelpers.readJsonFile("APItestData.json");
		  Response response = reportHelper.createReport(createData);
		  this.reportId = response.body().asString();
		  this.reportId = this.reportId.substring(1, this.reportId.length()-1);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }

	  @Test(description = "Clone Report Definition", groups="Smoke", dependsOnMethods="createReport")
	  public void cloneReport() throws Exception {
		  String url = urlGenerator.generateCloneReportUrl.replace("{id}", this.reportId);
		  Response response = reportHelper.cloneReport(url, urlGenerator.generateReportAppURL);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	  @Test(description = "Get the Report definition by Id", groups = "Smoke", dependsOnMethods="createReport")
	  public void getReportDefinition() throws Exception {
		  String url = urlGenerator.generateReportDefinitionByID.replace("{id}", this.reportId);
		  Response response = reportHelper.getReportDefinition(url, urlGenerator.generateReportAppURL);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	  @Test(description = "Run the Report", groups = {"Smoke"}, dependsOnMethods="createReport")
	  public void generateReportRun() throws Exception {
		  String url =urlGenerator.generateReportRun.replace("{id}", this.reportId);
		  Response response = reportHelper.generateReportRun(url);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	   @Test(description = "Update the Report Details", groups = "Smoke", dependsOnMethods = "createReport")
	  public void updateReportDefn() throws Exception {
		  Map<String, String> updateData = JavaHelpers.readJsonFile("APItestData.json");
		  String url = urlGenerator.updateReport.replace("{id}", this.reportId);
		  String response = reportHelper.updateReportDefinition(url,updateData).getBody().asString();
		  Assert.assertEquals(response, "\"Report Updated\"", "Response received mismatched from the Actual");
	  }
	   
	   @Test(description = "Delete the Report Definition",dependsOnGroups = "Smoke")
	   public void deleteReportDefn() throws Exception {
		   String url = urlGenerator.deleteReport.replace("{id}", this.reportId);
		   String response = reportHelper.deleteReportDefinition(url).getBody().asString();
		   Assert.assertEquals(response, "\"Report deleted\"", "Response received mismatched from the Actual" );
	   }
	   
	   @Test(description = "Export CSV File Details", groups="Smoke", dependsOnMethods="createReport")
	   public void exportReportDetails() throws Exception {
		   String url = urlGenerator.exportReportDetails.replace("{id}", this.reportId);
		   String response = reportHelper.exportReportDefnDetails(url).getBody().asString();
		   String reportStatus = JsonPath.from(response).get("ReportRunStatus");
		   Assert.assertEquals(reportStatus,"Running", "Report Status received is mismatched from the Response");
	   }
	  
	  @Test(description="Create Dashboard Definition", groups="Smoke")
	  public void createDashboardDefn() throws Exception {
		  Map<String, String> createData = JavaHelpers.readJsonFile("APItestData.json");
		  Response response = reportHelper.createDashDefnDetails(createData, reportId);
		  this.dashboardId = response.body().asString();
		  this.dashboardId = this.dashboardId.substring(1, this.dashboardId.length()-1);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	  @Test(description="Clone Dashboard",groups="Smoke", dependsOnMethods="createDashboardDefn")
	  public void cloneDashboardDefn() throws Exception {
		  String url = urlGenerator.cloneDashboard.replace("{id}", this.dashboardId);
		  Response response = reportHelper.cloneDashboard(url);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	  @Test(description="Get Dashboard details",groups="Smoke", dependsOnMethods="createDashboardDefn")
	  public void getDashboardDetailsDefn() throws Exception {
		  String url = urlGenerator.getDashboardDetail.replace("{id}", this.dashboardId);
		  Response response = reportHelper.getDashboardDetails(url);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	  
	  @Test(description="Update Dashboard Definition details", groups="Smoke", dependsOnMethods="createDashboardDefn")
	  public void updateDashboardDefn() throws Exception {
		  Map<String, String> updateData = JavaHelpers.readJsonFile("APItestData.json");
		  String url = urlGenerator.updateDashboard.replace("{id}", this.dashboardId);
		  Response response = reportHelper.updateDashboard(url, updateData);
		  Assert.assertEquals(response.getStatusCode(), 202);
	  }
	  
	  @Test(description="Delete Dashboard", dependsOnGroups="Smoke")
	  public void deleteDashboard() throws Exception {
		  String url = urlGenerator.deleteDashboard.replace("{id}", this.dashboardId);
		  Response response = reportHelper.deleteDashboard(url);
		  Assert.assertEquals(response.getStatusCode(), 200);
	  }
	 
}

