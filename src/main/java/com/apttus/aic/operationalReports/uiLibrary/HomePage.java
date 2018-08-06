package com.apttus.aic.operationalReports.uiLibrary;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apttus.helpers.JavaHelpers;

public class HomePage extends OpReportinit{
	
	@FindBy(xpath="//*[@class='avatar']")
	@CacheLookup
	public WebElement btnAvtar;

	@FindBy(xpath="//*[text()='Logout']")
	@CacheLookup
	public WebElement btnLogout;
	
	@FindBy(linkText="Reports")
	@CacheLookup
	public WebElement btnClickListofReports;
	
	@FindBy(linkText="Views")
	@CacheLookup
	public WebElement linkViewsMenu;

	@FindBy(linkText="Dashboards")
	@CacheLookup
	public WebElement btnDashBoard;
	
	@FindBy(linkText="Manage Report")
	@CacheLookup
	public WebElement btnClickManageReport;

	/*@FindBy(xpath="//*[text()='Quick Create Report']/..")
	@CacheLookup
	public WebElement btnQuickCreateReport;*/
	
	@FindBy(xpath="//*[@aria-label='Open Hamburger Menu']")
//	@CacheLookup
	public WebElement mnuHamburger;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public HomePage navigateBackToHomepage(String environment) throws Exception {
		Properties configProperties = JavaHelpers.loadPropertyFile(environment);
		ngHelper.NavigateTo(configProperties.getProperty("LoginURL"));
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public HomePage navigateToCurrentUrl() throws Exception {
			String url = driver.getCurrentUrl();
			ngHelper.NavigateTo(url);
		return PageFactory.initElements(driver, HomePage.class);
	}
	

	public ListOfReportsPage navigateToListOfReportsPage() throws Exception {
		ngHelper.waitTillElementIsClickable(mnuHamburger, 60)
				.click(mnuHamburger)
				.waitTillElementIsClickable(btnClickListofReports, 60)
				.click(btnClickListofReports);
		return PageFactory.initElements(driver,ListOfReportsPage.class);
	}
	
	public DashBoardPage navigateToDashBoard() throws Exception {
		ngHelper.waitTillElementIsClickable(mnuHamburger, 60)
				.click(mnuHamburger)
				.click(btnDashBoard);
		
		return PageFactory.initElements(driver, DashBoardPage.class);
	}

	public void logout() throws Exception {
		ngHelper.click(btnAvtar)
		.click(btnLogout);
	}
	
	public ViewPage navigateToView() throws Exception {
		ngHelper.waitTillElementIsClickable(mnuHamburger, 60).
		         click(mnuHamburger).
		         click(linkViewsMenu);
		return PageFactory.initElements(driver, ViewPage.class);
		
	}
	
	public ManageReportsPage navigateToManageReportsPage() throws Exception {
		ngHelper.waitTillElementIsClickable(mnuHamburger, 60)
				.click(mnuHamburger)
				.waitTillElementIsClickable(btnClickManageReport, 60)
				.click(btnClickManageReport);
		return PageFactory.initElements(driver, ManageReportsPage.class);
	}

	
}
