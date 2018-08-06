package com.apttus.aic.operationalReports.pojoClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class CreateReportPOJO {
	
	String ObjectId;
	String PackageId;
	String Name;
	String Type;
	boolean Active;
	boolean IsSystem;
	boolean IsTemplate;
	boolean IsAQLQuery;
	String ReportQuery;
	String Id;
	boolean IsActive;

	public String getObjectId() {
		return ObjectId;
	}

	public void setObjectId(String objectId) {
		ObjectId = objectId;
	}

	public String getPackageId() {
		return PackageId;
	}

	public void setPackageId(String packageId) {
		PackageId = packageId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public boolean isIsSystem() {
		return IsSystem;
	}

	public void setIsSystem(boolean isSystem) {
		IsSystem = isSystem;
	}

	public boolean isIsTemplate() {
		return IsTemplate;
	}

	public void setIsTemplate(boolean isTemplate) {
		IsTemplate = isTemplate;
	}

	public boolean isIsAQLQuery() {
		return IsAQLQuery;
	}

	public void setIsAQLQuery(boolean isAQLQuery) {
		IsAQLQuery = isAQLQuery;
	}
	
	public String getReportQuery() {
		return ReportQuery;
	}

	public void setReportQuery(String reportQuery) {
		this.ReportQuery = reportQuery;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	
	public CreateReportPOJO createReportDefinition (Map<String, String> createData)
	{
		CreateReportPOJO createReportPOJO=new CreateReportPOJO();
		CreateReportPOJO.ReportQuery createReportQueyData = createReportPOJO.new ReportQuery();
		
		createReportPOJO.setObjectId(createData.get("ObjectId"));
		createReportPOJO.setPackageId(createData.get("PackageId"));
		createReportPOJO.setName(createData.get("Name"));
		createReportPOJO.setType(createData.get("Type"));
		createReportPOJO.setActive(Boolean.valueOf(createData.get("Active")));
		createReportPOJO.setIsActive(Boolean.valueOf(createData.get("IsActive")));
		createReportPOJO.setIsTemplate(Boolean.valueOf(createData.get("IsTemplate")));
		createReportPOJO.setIsAQLQuery(Boolean.valueOf(createData.get("IsAQLQuery")));
		
		createReportPOJO.setId(createData.get("Id"));
		createReportPOJO.setIsActive(Boolean.valueOf(createData.get("IsActive")));
		
		/**	Adding data from ReportQuery */
		List<String> columns = new ArrayList<String>();
		
		createReportQueyData.setEntityName(createData.get("EntityName"));
		createReportQueyData.setDistinct(createData.get("Distinct"));
		createReportQueyData.setAutoExpandLookups(createData.get("AutoExpandLookups"));
		createReportQueyData.setTopRecords(Integer.parseInt(createData.get("TopRecords")));
		columns.add(createData.get("selectColumns"));
		columns.add(createData.get("selectColumns1"));
		createReportQueyData.setColumn(columns);

		createReportPOJO.setReportQuery(new Gson().toJson(createReportQueyData));
			
		return createReportPOJO;
	}
	

	
	public class ReportQuery{
		private String EntityName;
		private String Distinct;
		private String AutoExpandLookups;
		private int TopRecords;
		List<String> columns;
		
		public List<String> getColumn() {
			return columns;
		}
		public void setColumn(List<String> columns) {
			this.columns = columns;
		}
		
		public String getEntityName() {
			return EntityName;
		}
		public void setEntityName(String entityName) {
			EntityName = entityName;
		}
		public String getDistinct() {
			return Distinct;
		}
		public void setDistinct(String distinct) {
			Distinct = distinct;
		}
		public String getAutoExpandLookups() {
			return AutoExpandLookups;
		}
		public void setAutoExpandLookups(String autoExpandLookups) {
			AutoExpandLookups = autoExpandLookups;
		}
		public int getTopRecords() {
			return TopRecords;
		}
		public void setTopRecords(int topRecords) {
			TopRecords = topRecords;
		}
	

	}
	
}
