package com.apttus.aic.operationalReports.pojoClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewReportPOJO {
	List<String> select;
	int offset;
	int limit;
	List<String> orderby;
	boolean getcount;
	
	public List<String> getSelect() {
		return select;
	}
	public void setSelect(List<String> select) {
		this.select = select;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<String> getOrderby() {
		return orderby;
	}
	public void setOrderby(List<String> orderby) {
		this.orderby = orderby;
	}
	public boolean isGetcount() {
		return getcount;
	}
	public void setGetcount(boolean getcount) {
		this.getcount = getcount;
	}
	
	public ViewReportPOJO createReportFilter(Map<String, String> testData) {
		ViewReportPOJO reportsFilterPOJO = new ViewReportPOJO();
		List<String> selectData = new ArrayList<String>();
		List<String> orderBy=new ArrayList<String>();
		selectData.add(testData.get("selectData"));
		reportsFilterPOJO.setSelect(selectData);
		reportsFilterPOJO.setOffset(Integer.parseInt(testData.get("offset")));
		reportsFilterPOJO.setLimit(Integer.parseInt(testData.get("limit")));
		reportsFilterPOJO.setOrderby(orderBy);
		reportsFilterPOJO.setGetcount(Boolean.valueOf(testData.get("getCount")));
		return reportsFilterPOJO;
	}

}
