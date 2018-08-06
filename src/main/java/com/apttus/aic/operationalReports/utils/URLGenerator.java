package com.apttus.aic.operationalReports.utils;

public class URLGenerator {
	public String tokenURL;
	public String generateReportURL;
	public String generateReportAppURL;
	public String generateReportDefinitionUrl;
	public String generateCloneReportUrl;
	public String generateReportDefinitionByID;
	public String generateReportRun;
	public String updateReport;
	public String deleteReport;
	public String exportReportDetails;
	public String createDashboard;
	public String cloneDashboard;
	public String getDashboardDetail;
	public String updateDashboard;
	public String deleteDashboard;
	
	public URLGenerator(String baseURL) {
		tokenURL = baseURL + "ui/operationalReport/operationalReport/home";
		generateReportURL = baseURL + "api/generic/v1/search/advance/cmn_ReportDefinition";
		generateReportAppURL = baseURL + "/ui/operationalReport/operationalReport/home";
		generateReportDefinitionUrl = baseURL + "/api/generic/v1/ReportEngine/";
		generateCloneReportUrl = baseURL + "api/generic/v1/ReportEngine/{id}/clone";
		generateReportDefinitionByID = baseURL + "api/generic/v1/ReportEngine/{id}";
		generateReportRun = baseURL + "api/generic/v1/ReportEngine/{id}/run";
		updateReport = baseURL + "api/generic/v1/ReportEngine/{id}";
		deleteReport = baseURL + "api/generic/v1/ReportEngine/{id}";
		exportReportDetails = baseURL + "api/generic/v1/ReportEngine/{id}/export";
		createDashboard = baseURL + "api/generic/v1/Dashboard";
		cloneDashboard = baseURL + "api/generic/v1/Dashboard/{id}/clone";
		getDashboardDetail = baseURL + "api/generic/v1/Dashboard/{id}";
		updateDashboard = baseURL + "api/generic/v1/Dashboard/{id}";
		deleteDashboard = baseURL + "api/generic/v1/Dashboard/{id}";
	}

}
