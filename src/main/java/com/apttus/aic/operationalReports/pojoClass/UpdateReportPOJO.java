package com.apttus.aic.operationalReports.pojoClass;

import java.util.Map;

public class UpdateReportPOJO {
	
	private String Name;
	private boolean Active;
	private String Type;
	private boolean IsSystem;
	private boolean IsHidden;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public boolean isIsSystem() {
		return IsSystem;
	}
	public void setIsSystem(boolean isSystem) {
		IsSystem = isSystem;
	}
	public boolean isIsHidden() {
		return IsHidden;
	}
	public void setIsHidden(boolean isHidden) {
		IsHidden = isHidden;
	}
	
	public UpdateReportPOJO updateReportDefinition(Map<String, String> updateData) {
		UpdateReportPOJO updateReportPOJO=new UpdateReportPOJO();
		updateReportPOJO.setName(updateData.get("Name"));
		updateReportPOJO.setActive(Boolean.valueOf(updateData.get("Active")));
		updateReportPOJO.setType(updateData.get("Type"));
		updateReportPOJO.setIsSystem(Boolean.valueOf(updateData.get("IsSystem")));
		updateReportPOJO.setIsHidden(Boolean.valueOf(updateData.get("IsHidden")));
		return updateReportPOJO;
	}
	
	
	

}
