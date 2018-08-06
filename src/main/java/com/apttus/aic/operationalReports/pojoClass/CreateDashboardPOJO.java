package com.apttus.aic.operationalReports.pojoClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;


public class CreateDashboardPOJO {
	CreateDashboardPOJO createDashboardPOJO;
	private String Name;
	private String Description;
	
	String dashboardLayout;

	public String getDashboardLayout() {
		return dashboardLayout;
	}
	public void setDashboardLayout(String dashboardLayout) {
		this.dashboardLayout = dashboardLayout;
	}

	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public CreateDashboardPOJO createDashboardDefn(Map<String, String> createData, String reportId) {
		createDashboardPOJO=new CreateDashboardPOJO();
		CreateDashboardPOJO.DashboardLayout createDashboardData = createDashboardPOJO.new DashboardLayout();
	
	
		createDashboardPOJO.setName(createData.get("Name"));
		createDashboardPOJO.setDescription(createData.get("Description"));
		
		createDashboardData.setSizeY(Integer.parseInt(createData.get("sizeY")));
		createDashboardData.setSizeX(Integer.parseInt(createData.get("sizeX")));
		createDashboardData.setReportId(reportId);
		createDashboardData.setRow(Integer.parseInt(createData.get("row")));
		createDashboardData.setCol(Integer.parseInt(createData.get("col")));
		
		List<DashboardLayout> dashboardLayout = new ArrayList<CreateDashboardPOJO.DashboardLayout>();
		dashboardLayout.add(createDashboardData);
		createDashboardPOJO.setDashboardLayout(new Gson().toJson(dashboardLayout));	
		
		return createDashboardPOJO;
	}
	
	public CreateDashboardPOJO updateDashboard(Map<String, String> updateData) {
		createDashboardPOJO = new CreateDashboardPOJO();
		createDashboardPOJO.setName(updateData.get("Name"));
		createDashboardPOJO.setDescription(updateData.get("Description"));
		
		return createDashboardPOJO;
	}
	
	public class DashboardLayout{
		private int sizeY;
		private int sizeX;
		private String reportId;
		private int row;
		private int col;
		
		public int getSizeY() {
			return sizeY;
		}
		public void setSizeY(int sizeY) {
			this.sizeY = sizeY;
		}
		public int getSizeX() {
			return sizeX;
		}
		public void setSizeX(int sizeX) {
			this.sizeX = sizeX;
		}
		public String getReportId() {
			return reportId;
		}
		public void setReportId(String reportId) {
			this.reportId = reportId;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getCol() {
			return col;
		}
		public void setCol(int col) {
			this.col = col;
		}
		
	}
	

}
