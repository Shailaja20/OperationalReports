package com.apttus.aic.operationalReports.uiLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageReportsPage extends OpReportinit {
	
	@FindBy(xpath="//*[@ng-click='vm.showSearchPanel()']")
	@CacheLookup
	public WebElement showSearchBar;
	
	@FindBy(name="Name")
	@CacheLookup
	public WebElement txtReportName;
	
	@FindBy(css=".button-action")
	@CacheLookup
	public WebElement btnSearch;
	
	@FindBy(name="CreatedById")
	@CacheLookup
	public WebElement txtCreatedById;
	
	@FindBy(name="ModifiedOn")
	@CacheLookup
	public WebElement dateModifiedOn;
	
	@FindBy(name="CreatedOn")
	@CacheLookup
	public WebElement dateCreatedOn;
	
	@FindBy(xpath="//*[@aria-label='Created On']")
	public WebElement clickCreatedOn;
	
	By chkboxselectReport = By.xpath("//*[@ng-model='vm.options.isSelected']");
	
	By getReportName = By.xpath("//*[@ng-class='col.cellClass'][2]");
	
	@FindBy(xpath="/tbody[@class='md-calendar-month']//tr[2]/td[6]")
	@CacheLookup
	public WebElement selectDate;
	
	@FindBy(xpath="//*[text()='Share']/..")
	@CacheLookup
	public WebElement btnShare;
	
	@FindBy(xpath="//*[text()='Cancel']//preceding::button[1]")
	@CacheLookup
	public WebElement btnShare1;
	
	@FindBy(xpath="//*[@aria-label='User']")
	@CacheLookup
	public WebElement rdbtnUser;
	
	@FindBy(xpath="//*[@aria-label='Group']")
	@CacheLookup
	public WebElement rdbtnGroup;
	
	@FindBy(xpath="//*[@ng-model='vm.user']")
	@CacheLookup
	public WebElement drpdwnSelectUser;
	
	@FindBy(xpath="//*[@ng-model='vm.searchObject']")
	@CacheLookup
	public WebElement txtsearchUser;
	
	@FindBy(xpath="//*[@class='md-checkbox-enabled'][1]")
//	@CacheLookup
	public WebElement selectUser;
	
	@FindBy(xpath="//*[text()='Share Report']")
	@CacheLookup
	public WebElement txtShareReport;
	
	@FindBy(xpath="//*[text()='Cancel']/..")
	@CacheLookup
	public WebElement btnCancel;
	
	@FindBy(xpath="//*[@grid-loader='vm.gridLoader'][last()]")
	public WebElement reportGridContent;
	
	@FindBy(id="confirmDialogActionBtn")
	@CacheLookup
	public WebElement btnConfirmYes;
	
	
	public ManageReportsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ManageReportsPage searchReportByName(String reportName) throws Exception {
		ngHelper.waitTillElementIsClickable(showSearchBar, 30)
				.click(showSearchBar)
				.waitTillElementIsClickable(txtReportName, 30)
				.clickAndSendkeys(txtReportName, reportName)
				.click(btnSearch);
		return PageFactory.initElements(driver, ManageReportsPage.class);
	}
	
	public ManageReportsPage searchReportByCreatedById(String selectCreatedByUser) throws Exception {
		ngHelper.waitTillElementIsClickable(showSearchBar, 30)
				.click(showSearchBar)
				.waitTillElementIsClickable(txtCreatedById, 30)
				.click(txtCreatedById)
		//		.waitTillElementIsVisible(selectCreatedByUser, 30)
				.selectComboOption(selectCreatedByUser)
		//		.click(selectCreatedByUser);
				.click(btnSearch);
		return PageFactory.initElements(driver, ManageReportsPage.class);		
	}
	
	public ManageReportsPage searchReportByModifiedOnDate() throws Exception {
		ngHelper.waitTillElementIsClickable(showSearchBar, 30)
				.click(showSearchBar)
				.waitTillElementIsClickable(dateModifiedOn, 30)
				.click(dateModifiedOn)
				.waitTillElementIsClickable(selectDate, 30)
				.click(selectDate)
				.click(btnSearch);
		return PageFactory.initElements(driver, ManageReportsPage.class);
	}
	
	public ManageReportsPage searchReportByCreatedOnDate() throws Exception {
		ngHelper.waitTillElementIsClickable(showSearchBar, 30)
				.click(showSearchBar)
				.waitTillElementIsClickable(dateCreatedOn, 30)
				.click(dateCreatedOn)
				.waitTillElementIsClickable(selectDate, 30)
				.click(selectDate)
				.click(btnSearch);
		return PageFactory.initElements(driver, ManageReportsPage.class);
	}
	
/*	public void SearchReportsByBasicSearch(String reportName) throws Exception {
		ngHelper.waitTillElementIsClickable(showSearchBar, 30)
				.click(showSearchBar);
		
		new ManageReportsPage(driver).searchReportByName(reportName);
		
	}*/
	
	public ManageReportsPage sortReportsByLastCreatedOn() throws Exception {
		ngHelper.waitTillElementIsClickable(reportGridContent, 30)
				.click(clickCreatedOn);
		Thread.sleep(3000);
		ngHelper.click(clickCreatedOn);
		Thread.sleep(3000);
		return PageFactory.initElements(driver, ManageReportsPage.class);		
	}
	
	public ManageReportsPage selectReportsFromGrid(int gridrow) throws Exception {
		List<WebElement> chkbox= ngHelper.findTheElements(chkboxselectReport);
		List<WebElement> txtReportName = ngHelper.findTheElements(getReportName);

		ngHelper.waitTillElementIsClickable(chkbox.get(gridrow), 30)
				.click(chkbox.get(gridrow));
		
		String getText = txtReportName.get(gridrow).getText();				
		return PageFactory.initElements(driver, ManageReportsPage.class);
	}
	
	/** Share Report with Single User */
	public void shareReportToUser(String userName) throws Exception {
		ngHelper.waitTillElementIsClickable(btnShare, 30)
				.click(btnShare)
				.waitTillElementIsClickable(rdbtnUser, 30)
				.click(rdbtnUser)
				.click(drpdwnSelectUser)
				.clickAndSendkeys(txtsearchUser, userName)
				.click(selectUser)
				.jsClick(btnShare1)
				.waitTillElementIsClickable(btnConfirmYes, 30)
				.jsClick(btnConfirmYes);
	}
	
	/** Share Report with Multiple User*/
	public void shareReportToUser(String userName, String userName2) throws Exception {
		ngHelper.waitTillElementIsClickable(btnShare, 30)
				.click(btnShare)
				.waitTillElementIsClickable(rdbtnUser, 30)
				.click(rdbtnUser)
				.click(drpdwnSelectUser)
				.clickAndSendkeys(txtsearchUser, userName)
				.click(selectUser)
				.click(txtsearchUser);
		txtsearchUser.clear();
		ngHelper.clickAndSendkeys(txtsearchUser, userName2)
				.click(selectUser)
				.jsClick(btnShare1)
				.waitTillElementIsClickable(btnConfirmYes, 30)
				.jsClick(btnConfirmYes);
	}
	
	/** Share Report with single group*/
	public void shareReportToGroup(String groupName) throws Exception {
		ngHelper.waitTillElementIsClickable(btnShare, 30)
				.click(btnShare)
				.waitTillElementIsClickable(rdbtnGroup, 30)
				.click(rdbtnGroup)
				.click(drpdwnSelectUser)
				.clickAndSendkeys(txtsearchUser, groupName)
				.click(selectUser)
				.jsClick(btnShare1)
				.waitTillElementIsClickable(btnConfirmYes, 30)
				.jsClick(btnConfirmYes);
		
	}
	
	/** Share Report with multiple groups*/
	public void shareReportToGroup(String groupName, String groupName2) throws Exception {
		ngHelper.waitTillElementIsClickable(btnShare, 30)
				.click(btnShare)
				.waitTillElementIsClickable(rdbtnGroup, 30)
				.click(rdbtnGroup)
				.click(drpdwnSelectUser)
				.clickAndSendkeys(txtsearchUser, groupName)
				.click(selectUser)
				.click(txtsearchUser);
		txtsearchUser.clear();
		ngHelper.clickAndSendkeys(txtsearchUser, groupName2)
				.click(selectUser)
				.jsClick(btnShare1)
				.waitTillElementIsClickable(btnConfirmYes, 30)
				.jsClick(btnConfirmYes);
		
	}

}
