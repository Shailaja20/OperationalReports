package com.apttus.aic.operationalReports.Helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.apttus.aic.operationalReports.pojoClass.CreateDashboardPOJO;
import com.apttus.aic.operationalReports.pojoClass.CreateReportPOJO;
import com.apttus.aic.operationalReports.pojoClass.UpdateReportPOJO;
import com.apttus.aic.operationalReports.pojoClass.ViewReportPOJO;
import com.apttus.aic.operationalReports.utils.URLGenerator;
import com.apttus.customException.ApplicationException;
import com.apttus.restAssured.RestUtils;
import com.aventstack.extentreports.gherkin.model.Given;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.FilterableRequestSpecification;
import com.jayway.restassured.specification.FilterableResponseSpecification;
import com.jayway.restassured.specification.RequestSpecification;;

public class ReportHelper {
	URLGenerator urlGenerator;
	

		public ReportHelper(String baseURL) {
		urlGenerator = new URLGenerator(baseURL);
	}
	
	public JSONArray getValueFromJSON(String body) throws JSONException, ApplicationException{	
		JSONArray jsonArray;
		try {
			JSONObject jsonObj = new JSONObject(body);
			jsonArray = jsonObj.getJSONArray("result");
		} catch (Exception e) {
			throw new ApplicationException("Value fetching from json failed " +e);
		}
		return jsonArray;
	 }
	
	public Response generateReport(Map<String, String> testData) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.postData(urlGenerator.generateReportURL, urlGenerator.generateReportAppURL, new Gson().toJson(new ViewReportPOJO().createReportFilter(testData)));
		} catch (Exception e) {
			throw new ApplicationException("generate Report API call failed " +e);
		}
		return response;
	}
	
	
	public Response createReport(Map<String, String> createData) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.postData(urlGenerator.generateReportDefinitionUrl, urlGenerator.generateReportAppURL, new Gson().toJson(new CreateReportPOJO().createReportDefinition(createData)));
		} catch (Exception e) {
			throw new ApplicationException("Create Report API Failed " +e);
		}
		return response;
	}
	
	public Response cloneReport(String url, String appURL) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.get(url, appURL);
		} catch (Exception e) {
			throw new ApplicationException("Clone Report API failed " +e);
		}
		return response;		
	}
	
	public Response getReportDefinition(String url, String appURL) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.get(url, appURL);
		} catch (Exception e) {
			throw new ApplicationException("Get Report Definition By Id API is failed " +e);
		}
		return response;
	}
	
	public Response generateReportRun(String url) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.get(url,urlGenerator.generateReportAppURL);			
		} catch (Exception e) {
			throw new ApplicationException("Run Report API is failed " +e);
		}
		return response;
	}
	
	public Response updateReportDefinition(String url, Map<String, String> updateData) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.put(url, urlGenerator.generateReportAppURL, new Gson().toJson(new UpdateReportPOJO().updateReportDefinition(updateData)));
		} catch (Exception e) {
			throw new ApplicationException("Update Report Definition API Failed " +e);
		}
	return response;
}
	
	public Response deleteReportDefinition(String url) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.delete(url, urlGenerator.generateReportAppURL);
		} catch (Exception e) {
			throw new ApplicationException("Delete Report Definition API Failed " +e);
		}
		return response;
	}
	
	public Response exportReportDefnDetails(String url) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.get(url, urlGenerator.generateReportAppURL);
		} catch (Exception e) {
			throw new ApplicationException("Export CSV API is Failed " +e);
		}
		return response;
	}
	
	public Response createDashDefnDetails(Map<String, String> createData, String reportId) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.postData(urlGenerator.createDashboard, urlGenerator.generateReportAppURL, new Gson().toJson(new CreateDashboardPOJO().createDashboardDefn(createData, reportId)));
		} catch (Exception e) {
			throw new ApplicationException("Create Dashboard Definition API is Failed " +e);
		}
		return response;
	}
	
	public Response cloneDashboard(String url) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.get(url, urlGenerator.generateReportAppURL);
		} catch (Exception e) {
			throw new ApplicationException("Clone Dashboard Definition API is Failed " +e);
		}
		return response;
	}
	
	public Response getDashboardDetails(String url) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.get(url, urlGenerator.generateReportAppURL);
		} catch (Exception e) {
			throw new ApplicationException("Get Dashboard Details API is Failed " +e);
		}
		return response;
	}
	
	public Response updateDashboard(String url, Map<String, String> updateData) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.put(url, urlGenerator.generateReportAppURL, new Gson().toJson(new CreateDashboardPOJO().updateDashboard(updateData)));
		} catch (Exception e) {
			throw new ApplicationException("Update Dashboard Details API is Failed " +e);
		}
		return response;
	}
	
	public Response deleteDashboard(String url) throws ApplicationException {
		Response response;
		try {
			response = RestUtils.delete(url, urlGenerator.generateReportAppURL);
		} catch (Exception e) {
			throw new ApplicationException("Delete Dashboard API is Failed " +e);
		}
		return response;
	}
	
}
	
	

