package com.apttus.aic.operationalReports.uiLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDashboardPage extends OpReportinit{
	
	@FindBy(xpath="//*[@ng-click='vm.showSearchPanel()']")
	@CacheLookup
	public WebElement showSearchBar;
	
	@FindBy(name="Name")
	@CacheLookup
	public WebElement txtDashboardName;
	
	@FindBy(css=".button-action")
	@CacheLookup
	public WebElement btnSearch;
	
	
	public ManageDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	

}
