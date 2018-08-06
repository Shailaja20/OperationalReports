package com.apttus.aic.operationalReports.uiLibrary;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apttus.helpers.JavaHelpers;

public class ListOfReportsPage extends OpReportinit{
	
	@FindBy(id="masterDetailsFilterBy")
	@CacheLookup
	public WebElement cboFilterBy;
	
	@FindBy(xpath="//input[@ng-model='vm.searchText']")
	@CacheLookup
	public WebElement txtSearch;
	
	@FindBy(xpath="//*[text()='Actions']/..")
	@CacheLookup
	public WebElement btnActions;
	
	@FindBy(css=".master-details-description.ellipsis-text.flex")
	@CacheLookup
	public WebElement filteredReportResults;
	
	private String btnActionLinks = "//*[text()='{param}']/..";
	
	@FindBy(xpath="//*[@ng-model='vm.formData.reportDefForm.Name']")
	@CacheLookup
	public WebElement txtName;
	
	@FindBy(xpath="//*[@ng-model='vm.formData.reportDefForm.Description']")
	@CacheLookup
	public WebElement txtDescription;
	
	@FindBy(xpath="//*[@ng-model='vm.formData.reportDefForm.Type']")
	@CacheLookup
	public WebElement cboVisualizationType;
	
	@FindBy(xpath="(//div//pre)[3]") 
	@CacheLookup
	public WebElement txaReportconfig;
	
	@FindBy(css="div.expression-editor-container pre")  
	@CacheLookup
	public WebElement txaReportQuery;
	
	@FindBy(xpath="//*[text()='Format']/..")
	@CacheLookup
	public WebElement btnFormat;
	
	@FindBy(xpath="//*[text()='Save']/..")
	@CacheLookup
	public WebElement btnSave;
	
	@FindBy(id="openMenuBtn")
	@CacheLookup
	public WebElement btnMenu;
	
	@FindBy(xpath="//*[@id='cloneDialogDesc']//input")
	@CacheLookup
	public WebElement txtCloneReportName;
	
	@FindBy(id="cloneDialogSaveBtn")
	@CacheLookup
	public WebElement btnDialOk;
	
	@FindBy(id="confirmDialogActionBtn")
	@CacheLookup
	public WebElement btnDialConfirm;
	
	@FindBy(id="reportName")
	@CacheLookup
	public WebElement txtReportName;
	
	@FindBy(id="reportDescription")
	@CacheLookup
	public WebElement txtReportDescp;
	
	@FindBy(id="selectDataset")
	@CacheLookup
	public WebElement cmbSelectView;
	
	@FindBy(id="multiStepNextBtn")
	@CacheLookup
	public WebElement btnNext;
	
	@FindBy(id="selectObject")
	@CacheLookup
	public WebElement cmbSelectObject;
	
	@FindBy(xpath="//div[2]/div[2]//div//*[@id='selectObject']")
	@CacheLookup
	public WebElement cmbSelectObject1;
	
	@FindBy(xpath="//div[3]//div[3]//div//*[@id='selectObject']")
	@CacheLookup
	public WebElement cmbSelectObject2;
		
	@FindBy(id="selectField")
	@CacheLookup
	public WebElement cmbSelectField;
	
	@FindBy(xpath="//div[2]/div[2]//div//*[@id='selectField']")
	@CacheLookup
	public WebElement cmbSelectField1;
	
	@FindBy(xpath="//div[3]//div[3]//div//*[@id='selectField']")
	@CacheLookup
	public WebElement cmbSelectField2;
		
	@FindBy(xpath="//*[@class='filter-row' and @style=\"\"]//*[@id='selectObject']")
	@CacheLookup
	public WebElement cmbFilterSelectObject;
	
	@FindBy(xpath="//*[@class='filter-row' and @style=\"\"]//*[@id='selectField']")
	@CacheLookup
	public WebElement cmbFilterSelectField;
	
	@FindBy(xpath="//*[@class='filter-row' and @style=\"\"]//*[@ng-change='vm.onChangeOperator(row)']")
	@CacheLookup
	public WebElement cmbSelectOperator;
	
	@FindBy(xpath="//*[@class='filter-row' and @style=\"\"]//*[@ng-model='row.value']")
	@CacheLookup
	public WebElement selectFilterValue;
	
	@FindBy(xpath="//*[@ng-click='vm.addRow()']")
	@CacheLookup
	public WebElement btnAddRow;
	
	@FindBy(xpath="//*[@ng-click='vm.addNewFilter(vm.filters.length)']")
	@CacheLookup
	public WebElement btnFilterAddRow;
	
	@FindBy(id="customMultiStepBtn-1")
	@CacheLookup
	public WebElement btnActivateSaveReport;
	
	private String btnKebabMenuLinks = "//span[text()='{param}'][last()]";
	
	private String chkChartType = "//*[@value='{param}']"; 
	
	@FindBy(xpath=".//*[@class='md-select-value']//div[text()='{param}']")
	@CacheLookup
	public WebElement lnkAnchorObj;
	
	@FindBy(xpath="//*[@ng-model='vm.name']")
	@CacheLookup
	public WebElement txtRename;
	
	@FindBy(id="alertDialogCloseBtn")
	@CacheLookup
	public WebElement alertOK;
	
	@FindBy(xpath="//input[@ng-model='vm.searchObject']")
	@CacheLookup
	public WebElement drpdownSearch;
	
	@FindBy(xpath="//md-optgroup//md-option[1]")
	@CacheLookup
	public WebElement selectView;
	
	@FindBy(xpath="//label[@class='label flex-25'][text()='Anchor Object']")
	@CacheLookup
	public WebElement chkLabel;
	
	@FindBy(xpath="//label[@class='label flex-25'][text()='Anchor Object']//following::label[1]")
	@CacheLookup
	public WebElement lblrelatedAnchorValue;
	
	@FindBy(xpath="//*[@aria-label='Select Visualization']")
	@CacheLookup
	public WebElement selectVisualizationType;
	
	@FindBy(id="anchorField")
	@CacheLookup
	public WebElement selectAnchorField;
	
	@FindBy(xpath="//*[@ng-model='vm.metricFieldId']")
	@CacheLookup
	public WebElement selectYAxis;
	
	@FindBy(xpath="//*[@ng-model='vm.dimensionFieldId']")
	@CacheLookup
	public WebElement selectXAxis;
	
	@FindBy(xpath="//*[@ng-model='vm.visualizationOption.aggregateFunction']")
	@CacheLookup
	public WebElement selectAggregateFunc;
	
	@FindBy(xpath="//*[@ng-model='vm.visualizationOption.metricLabel']")
	@CacheLookup
	public WebElement txtYAxisDisplayLbl;
	
	@FindBy(xpath="//*[@ng-model='vm.visualizationOption.dimensionLabel']")
	@CacheLookup
	public WebElement txtXAxisDisplayLbl;
	
	@FindBy(xpath="//*[@ng-model='vm.visualizationOption.pivotConfig.aggregatedField.Id']")
	@CacheLookup
	public WebElement pivotAggregateField;
	
	@FindBy(xpath=".//*[@ng-model='vm.visualizationOption.pivotConfig.aggregateFunction']")
	@CacheLookup
	public WebElement pivotAggregateFunc;
	
	@FindBy(xpath="//*[@ng-model='vm.visualizationOption.pivotConfig.aggregatedField.AQLAliasName']")
	@CacheLookup
	public WebElement pivotAggregateAliasName;
	
	@FindBy(xpath="//*[@ng-model='field.Id']")
	@CacheLookup
	public WebElement pivotDataField;
	
	@FindBy(xpath="//*[@ng-model='field.AQLAliasName']")
	@CacheLookup
	public WebElement pivotDataAliasName;
	
	private String filterByOption = "//div[@class='md-text'][text()='{param}']";
	
	@FindBy(css="div.report-title.ellipsis-text")
	@CacheLookup
	public WebElement reportName;
	
	@FindBy(xpath="//*[text()='Seeded']//following::label[1]")
	@CacheLookup
	public WebElement txtSeededStatus;
	
	@FindBy(xpath="//*[text()='Details']")
	@CacheLookup
	public WebElement tabDetails;
	
	public String name;
	
	@FindBy(css=".md-padding")
	@CacheLookup
	public WebElement NoDataFound;
	
	@FindBy(xpath="//*[@id='reportInfoContainer']/div[5]/label[2]")
	@CacheLookup
	public WebElement txtReportStatus;
	
	@FindBy(xpath="//*[@id='reportInfoContainer']/div[2]/label[2]")
	@CacheLookup
	public WebElement txtDetailsDescription;
	
	@FindBy(xpath="//*[@id='reportInfoContainer']/div[3]/label[2]")
	@CacheLookup
	public WebElement txtVisualizationType;
	
	@FindBy(css=".ands-btn.ands-primary.report-run-title-btn.md-button")
	@CacheLookup
	public WebElement btnReportRunStatus;
	
	@FindBy(id="quickManageDialogAnchor")
	@CacheLookup
	public WebElement cmbAnchorObjLink;
	
	@FindBy(xpath="//*[@class='md-select-menu-container md-active md-clickable']//md-option[last()]")
	public WebElement selectAnchorLink;
	
	@FindBy(xpath="//*[@value='system']")
	@CacheLookup
	public WebElement rdbtnSystemLink;
	
	@FindBy(xpath="//*[@value='custom']")
	@CacheLookup
	public WebElement rdbtnCustomLink;
	
	@FindBy(xpath="//*[@ng-model='vm.anchorFieldObject.hyperlink']")
	@CacheLookup
	public WebElement fieldUrl;
	
	private String selectReportType = "//*[@value='{param}']";
	
	private String rdbtnAnchorField = "//*[@value='{param}']";
	
	@FindBy(xpath="//*[@class='apt-data-grid-cell-contents cell-hyperlink']")
	@CacheLookup
	public WebElement clickHyperLinkField;
	
	private String searchCustomField = "//*[text()='{param}']";
	
	@FindBy(id="masterDetailsSearchSelectBox")
	@CacheLookup
	public WebElement ClickFilterSearchBoxDrpdwn;
	
	private String filterValueTF = "//*[@value='{param}']";
	
		
	public ListOfReportsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/** searching the reports from the filter options available*/
	public WebElement filterByReports(String filterLink, String searchText) throws Exception {
		WebElement selectFilterBy = ngHelper.findTheElement(By.xpath(filterByOption.replace("{param}", filterLink)));
		
		ngHelper.waitTillElementIsClickable(cboFilterBy, 30)
				.click(cboFilterBy)
				.click(selectFilterBy)
				.waitTillElementIsClickable(txtSearch, 30)
				.clickAndSendkeys(txtSearch, searchText);
		return filteredReportResults;
	}
	
	/** searching the reports from the filter options available*/
	public WebElement filterByReports(String filterLink) throws Exception {
		WebElement selectFilterBy = ngHelper.findTheElement(By.xpath(filterByOption.replace("{param}", filterLink)));
		
		ngHelper.waitTillElementIsClickable(cboFilterBy, 30)
				.click(cboFilterBy)
				.click(selectFilterBy);
		return filteredReportResults;
	}
	
	/** searching the report from the filter dropdown available 
	 * @return */
	public ListOfReportsPage filterReportByDropDown(String filterLink, String filterValue) throws Exception {
		WebElement selectFilterBy = ngHelper.findTheElement(By.xpath(filterByOption.replace("{param}", filterLink)));
		
		ngHelper.waitTillElementIsClickable(cboFilterBy, 30)
				.click(cboFilterBy)
				.click(selectFilterBy)
				.waitTillElementIsClickable(ClickFilterSearchBoxDrpdwn, 30)
				.click(ClickFilterSearchBoxDrpdwn);
		
		WebElement selectTF = ngHelper.findTheElement(By.xpath(filterValueTF.replace("{param}", filterValue)));
		
		ngHelper.click(selectTF);
		
		return PageFactory.initElements(driver, ListOfReportsPage.class);
	}
	
	/**creating a quick report*/
	public ListOfReportsPage createQuickReport(String reportName, String reportDescp, String reportQuery,String reportConfigQuery, String fieldLink, String reportTypes) throws Exception {
		WebElement btnQuickCreateReport = ngHelper.findTheElement(By.xpath(btnActionLinks.replace("{param}", fieldLink)));
		
		ngHelper.waitTillElementIsClickable(btnActions, 30)
				.click(btnActions)
				.click(btnQuickCreateReport)
				.clickAndSendkeys(txtName, reportName)
				.clickAndSendkeys(txtDescription, reportDescp)
				.click(cboVisualizationType);
		
		WebElement reportType = ngHelper.findTheElement(By.xpath(selectReportType.replace("{param}", reportTypes)));

		ngHelper.waitTillElementIsClickable(reportType, 30)
				.click(reportType)
				.click(txaReportQuery).sendTextKeys(reportQuery)
				.click(txaReportconfig).sendTextKeys(reportConfigQuery);
		
		if (reportType.getAttribute("value").equalsIgnoreCase("Chart")) {
			ngHelper.click(btnSave);
		}
		
		return PageFactory.initElements(driver, ListOfReportsPage.class);
	}

	/** To select a Field from the Kebab Menu	 
	 * @return */
	public String selectFieldLink(String fieldName) throws Exception {
		Map<String, String> testData = JavaHelpers.readJsonFile("reports.json");

		WebElement fieldLink = ngHelper.findTheElement(By.xpath(btnKebabMenuLinks.replace("{param}", fieldName)));
		
		ngHelper.waitTillElementIsClickable(btnMenu, 30)
				.click(btnMenu)
				.waitTillElementIsClickable(fieldLink, 30)
				.click(fieldLink);
		
		switch (fieldName) {
		case "Quick Edit":
			name = new ListOfReportsPage(driver).verifyQuickEditReport(testData.get("updatedReportName"), testData.get("updatedReportDescp"));
			break;
			
		case "Rename":
			name = new ListOfReportsPage(driver).renameReport(testData.get("reportRename"));
			break;
			
		case "Clone":
			name = new ListOfReportsPage(driver).verifyCloneReport(testData.get("cloneName"));
			break;
			
		case "Delete":
			new ListOfReportsPage(driver).verifyDeleteFunc();
			break;
			
		case "Export to CSV":
			new ListOfReportsPage(driver).verifyExportToCSV();
			break;
			
		case "Activate":
		case "Deactivate":
			new ListOfReportsPage(driver).verifyReportDetails();
			break;
			
		case "Edit":
			new ListOfReportsPage(driver).editReportFields(testData.get("objName"), testData.get("fieldName2"));
			break;
		}
		return name;
		
	}
	
	/** To verify Quick Edit Functionality of the already generated Reports
	 * @return */
	public String verifyQuickEditReport(String updatedReportName, String updatedReportDescp) throws Exception {
				
		ngHelper.waitTillElementIsClickable(txtName, 30)
				.click(txtName).sendBoardKeys(Keys.END)
				.sendTextKeys(updatedReportName)
				.clickAndSendkeys(txtDescription, updatedReportDescp)
				.click(btnSave);
		return updatedReportName;
	}
	
	public String verifyCloneReport(String cloneName) throws Exception {
		
		ngHelper.waitTillElementIsClickable(txtCloneReportName, 30)
				.click(txtCloneReportName).sendBoardKeys(Keys.END)
				.sendTextKeys(cloneName)
				.click(btnDialOk);
		return cloneName;
	}
	
	/** Rename a Report Definition 
	 * @return */
	public String renameReport(String reportRename) throws Exception {
		ngHelper.waitTillElementIsVisible(txtRename, 30)
				.click(txtRename).sendBoardKeys(Keys.END)
				.sendTextKeys(reportRename)
				.click(btnSave);
		return reportRename;
	}
	
	/** To delete a Report Definition	 */
	public void verifyDeleteFunc() throws Exception {
		ngHelper.click(btnDialConfirm);
	}
	
	/** To verify the Export Functionality of Report	 */
	public void verifyExportToCSV() throws Exception {
		ngHelper.waitTillElementIsClickable(alertOK, 30)
				.click(alertOK);
	}
	
	/** To verify the Report Current Status	 */
	public void verifyReportDetails() throws Exception {

		ngHelper.waitTillElementIsClickable(tabDetails, 30)
				.click(tabDetails);
	}
	
	/**To select the Hyperlink and Custom Fields */
	public void selectHyperLink(String anchorLinkType) throws Exception {
		
		ngHelper.waitTillElementIsClickable(cmbAnchorObjLink, 30)
				.click(cmbAnchorObjLink)
				.click(selectAnchorLink);
		
		WebElement rdbtnFieldType = ngHelper.findTheElement(By.xpath(rdbtnAnchorField.replace("{param}", anchorLinkType)));
		
		ngHelper.click(rdbtnFieldType);
		
		if (rdbtnSystemLink.getAttribute("aria-checked").equalsIgnoreCase("true")) {
			ngHelper.click(btnSave)
					.waitTillElementIsClickable(clickHyperLinkField, 30)
					.click(clickHyperLinkField);
			String originalWindow = driver.getWindowHandle();
			
			for (String newWindow : driver.getWindowHandles()) {
				if (!newWindow.equals(originalWindow)) {
					driver.switchTo().window(newWindow);
					if (driver.getTitle().contains("Apttus - Common Dashboard")) {
						driver.switchTo().window(originalWindow);
					}
				}
				
			}
		}else if (rdbtnCustomLink.getAttribute("aria-checked").equalsIgnoreCase("true")) {
			ngHelper.click(fieldUrl)
					.waitTillElementIsVisible(selectAnchorLink, 30);
			
			String anchorText = selectAnchorLink.getText();
			
			ngHelper.click(selectAnchorLink)
					.click(btnSave);
					
			By customField = By.xpath(searchCustomField.replace("{param}", anchorText));
			
			try {
				if (driver.findElement(customField).isDisplayed()==false) {
					System.out.println("Custom Hyperlink is working");
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}		
		}
		
	}
	
	/** To Enter Data Source Details in the Create Report Wizard */
	public ListOfReportsPage createReportSelectDataSource(String fieldLink, String viewOptionField, String name, String descp) throws Exception {
		WebElement btnCreateReportWizard = ngHelper.findTheElement(By.xpath(btnActionLinks.replace("{param}", fieldLink)));
		
		ngHelper.waitTillElementIsClickable(btnActions, 30)
				.click(btnActions)
				.waitTillElementIsClickable(btnCreateReportWizard, 30)
				.click(btnCreateReportWizard)
				.waitTillElementIsClickable(txtReportName, 30)
				.clickAndSendkeys(txtReportName, name)
				.clickAndSendkeys(txtReportDescp, descp)
				.click(cmbSelectView)
				.waitTillElementIsClickable(drpdownSearch, 30)
				.clickAndSendkeys(drpdownSearch, viewOptionField)
				.click(selectView);
		
		if (chkLabel.isDisplayed()) {
			String AnchorObj =lblrelatedAnchorValue.getText();
			if(!AnchorObj.equalsIgnoreCase("-"))
			{
				ngHelper.waitTillElementIsClickable(btnNext, 30)
						.click(btnNext);
			}else {
				System.out.println("Received null Anchor Object");
			}
		}
		
		return PageFactory.initElements(driver, ListOfReportsPage.class);
		}
	
	/** To select the Fields in the Create Report Wizard	 */
	public ListOfReportsPage createReportSelectFields(String objName, String fieldName, String fieldName1) throws Exception {
		
		ngHelper.click(btnAddRow)
				.click(cmbSelectObject)
				.selectComboOption(objName)
				.click(cmbSelectField)
				.selectComboOption(fieldName)	
				.click(btnAddRow)
				.waitTillElementIsClickable(cmbSelectObject1, 60)
				.click(cmbSelectObject1)
				.selectComboOption(objName)
				.click(cmbSelectField1)
				.selectComboOption(fieldName1)
				.click(btnNext);
		return PageFactory.initElements(driver, ListOfReportsPage.class);
	}
	
	/** To set the Filters in the Create/Edit Report Wizard	 */
	public ListOfReportsPage setReportWizardFilters(String objName, String fieldName, String operatorValue, String value, String value1) throws Exception {
		ngHelper.waitTillElementIsClickable(btnFilterAddRow, 30)
				.click(btnFilterAddRow)
				.waitTillElementIsClickable(cmbFilterSelectObject, 30)
				.click(cmbFilterSelectObject)
				.selectComboOption(objName)
				.click(cmbFilterSelectField)
				.selectComboOption(fieldName)
				.click(cmbSelectOperator)
				.selectComboOption(operatorValue)
				.click(selectFilterValue)
				.selectComboOption(value)
				.selectComboOption(value1)
				.jsClick(btnNext);
	
		return PageFactory.initElements(driver, ListOfReportsPage.class);
	}

	/** To select the Visualization Type in the Data Visualization step in the Create Report Wizard */
	public void selectReportVisualizationType(String chartType) throws Exception {
		Map<String, String > testData = JavaHelpers.readJsonFile("reports.json");

		WebElement selectChartType = ngHelper.findTheElement(By.xpath(chkChartType.replace("{param}", chartType)));
		
		ngHelper.waitTillElementIsClickable(selectVisualizationType, 30)
				.jsClick(selectVisualizationType)
				.waitTillElementIsClickable(selectChartType, 30)
				.click(selectChartType);
				
		switch (chartType) {
		case "Tabular":
			new ListOfReportsPage(driver).selectTabularReportDetails(testData.get("objName"), testData.get("anchField"));
			break;
			
		case "Pie" :	
		case "Bar" :	
		case "Line"	:
		case "Column" :
			new ListOfReportsPage(driver).selectBarChartDetails(testData.get("yAxisValue"), testData.get("aggregateValue"), testData.get("xAxisValue"));
			break;
		
		case "AggregatedDataTable" :	
			new ListOfReportsPage(driver).selectPivotChartDetails(testData.get("yAxisValue"), testData.get("aggregateValue"), testData.get("xAxisValue"));

		}

		ngHelper.waitTillElementIsVisible(btnActivateSaveReport, 30)
				.click(btnActivateSaveReport);
	}
	
	/** To select the Tabular Report Details in the Create Report Wizard */
	public void selectTabularReportDetails(String objName, String anchField) throws Exception {
		ngHelper.waitTillElementIsClickable(selectAnchorField, 30)
				.click(selectAnchorField)
				.selectComboOption(objName+anchField);
		
	}
	
	/** To select the Bar Chart Details in the Create Report Wizard */
	public void selectBarChartDetails(String yAxisValue, String aggregateValue, String xAxisValue) throws Exception {
		ngHelper.waitTillElementIsClickable(selectYAxis, 30)
				.click(selectYAxis)
				.selectComboOption(yAxisValue)
				.click(selectAggregateFunc)
				.selectComboOption(aggregateValue)
				.click(selectXAxis)
				.selectComboOption(xAxisValue);
	}
	
	/** To select the Pivot chart Details in the Create Report Wizard */
	public void selectPivotChartDetails(String yAxisValue, String aggregateValue, String xAxisValue) throws Exception {
		ngHelper.waitTillElementIsClickable(pivotAggregateField, 30)
				.click(pivotAggregateField)
				.selectComboOption(yAxisValue)
				.click(pivotAggregateFunc)
				.selectComboOption(aggregateValue)
				.click(pivotDataField)
				.selectComboOption(xAxisValue)
				.clickAndSendkeys(pivotDataAliasName, "Aggregate " +xAxisValue);
	}
	
	/** To select the Fields in the Edit Report Wizard	 */
	public ListOfReportsPage editReportFields(String objName, String fieldName2) throws Exception {
		
		if (chkLabel.isDisplayed()) {
			String text =lblrelatedAnchorValue.getText();
			if(!text.equalsIgnoreCase("-"))
			{
				ngHelper.waitTillElementIsClickable(btnNext, 30)
				.click(btnNext)
				.waitTillElementIsClickable(btnAddRow, 30)
				.click(btnAddRow)
				.waitTillElementIsClickable(cmbSelectObject2, 30)
				.click(cmbSelectObject2)
				.selectComboOption(objName)
				.click(cmbSelectField2)
				.selectComboOption(fieldName2)
				.click(btnNext);
			}else {
				System.out.println("Received null Anchor Object");
			}
		}
		
		
		return PageFactory.initElements(driver, ListOfReportsPage.class);
	}
	
	/** To select the Aggregate Function in the edit Report Wizard */
	public ListOfReportsPage selectAggregateFunction(String aggregateValue) throws Exception {
		ngHelper.waitTillElementIsClickable(selectAggregateFunc, 30)
				.click(selectAggregateFunc)
				.selectComboOption(aggregateValue)
				.click(btnActivateSaveReport);
		return PageFactory.initElements(driver, ListOfReportsPage.class);
	}
	
	
	

}
