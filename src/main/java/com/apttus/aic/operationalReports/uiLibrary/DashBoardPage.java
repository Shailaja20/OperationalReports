package com.apttus.aic.operationalReports.uiLibrary;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends OpReportinit {
	
	@FindBy(xpath="//*[@class='ands-btn ands-primary md-button']")
	@CacheLookup
	public WebElement btnAction;
		
	@FindBy(xpath="//*[text()='Save Dashboard']")
	@CacheLookup
	public WebElement btnSaveDashBoard;
	
	@FindBy(xpath="//*[text()='Add']")
	@CacheLookup
	public WebElement btnAddDashBoard;
	
	@FindBy(xpath="//*[@id='menu_container_81']/md-menu-content/md-menu-item[1]/button")
	@CacheLookup
	public WebElement crtedashboard;  
	
	@FindBy(xpath="//*[@class='fa fa-plus-circle']/preceding::input[1]")
	@CacheLookup
	public WebElement AddReport2;
	
	@FindBy(xpath=".//*[@class='fa fa-ellipsis-v']")
	@CacheLookup
	public WebElement untitledAddReport2;
	
	@FindBy(xpath="html/body/div[9]/md-dialog/md-dialog-content/div/md-input-container/md-select")
	@CacheLookup
	public WebElement AddReportdropdown2;
		
	@FindBy(xpath="//*[@class='fa fa-ellipsis-v']")
	@CacheLookup
	public WebElement untitledAddReport;   
	
	@FindBy(xpath="//*[@id='associateReportDialogSaveBtn']")
	@CacheLookup
	public WebElement saveReport;
	
    @FindBy(css="md-dialog md-select")
	@CacheLookup
	public WebElement AddReportdropdown;
	
	@FindBy(xpath="//*[@id='createDashboardDialogSaveBtn']")
	public WebElement SaveCreateDashboard;
	
	@FindBy(id="createDashboardDialogSaveBtn")
	public WebElement SaveCreateDashboard1;   
	
	@FindBy(id="createDashboardDialogAddBtn")
	public WebElement AddnewReport;

	@FindBy(css="#dialogContent_associateReportDialog")
	@CacheLookup
	public WebElement clickDashboard;
	
	@FindBy(xpath="//*[text()='Add Report']")
	@CacheLookup
	public WebElement AddReport;
	
	@FindBy(xpath="//span[text()='Create Dashboard']")
	@CacheLookup
	public WebElement btnCreateDashBoard;
	
	@FindBy(xpath="//*[@ng-model='vm.name']")
	@CacheLookup
	public WebElement txtClone;
		
	@FindBy(xpath="//span[text()='Name']")
	@CacheLookup
	public WebElement btnRenameDashBoard;
	
	@FindBy(css="#dashboardSettingDialog input")
	@CacheLookup
	public List<WebElement> txtSaveDialog;
	
	@FindBy(css=".option-card-title")
	public List<WebElement> DashSearch;
			
	@FindBy(id="dashboardSettingDialogSaveBtn")
	@CacheLookup
	public WebElement btnSaveDashboardtitle;
	
	@FindBy(xpath="//*[text()='Description']")
	@CacheLookup
	public WebElement Enterdescp;
	
	@FindBy(xpath="//*[@class='md-select-icon']")
	@CacheLookup
	public WebElement SearchDropdown;
	
	@FindBy(xpath="//*[@class='md-select-value']//h4/span")
	public WebElement DashboardFltr;  
	
	@FindBy(css=".ands-toast-content>pre")
	@CacheLookup
	public WebElement ToastMsz;
	
	@FindBy(xpath="//*[@type='search']")
	@CacheLookup
	public WebElement Searchtxtdropdown;
	
	@FindBy(xpath="//*[@class='fa fa-clone']")
	@CacheLookup
	public WebElement CloneActionClick;
	
	@FindBy(xpath="//*[text()='Rename']")
	@CacheLookup
	public WebElement RenameActionClick;
	
	@FindBy(xpath="//*[text()='Delete']")
	@CacheLookup
	public WebElement DeleteActionClick;
	
	@FindBy(xpath="//*[text()='Edit']")
	@CacheLookup
	public WebElement EditActionClick;
	
	@FindBy(xpath="//*[text()='Delete Block']")
	@CacheLookup
	public WebElement DeleteBlockClick;
	
	public String AddReportvalue="//div[text()='OPTIONS']";

	@FindBy(xpath="//*[text()='Ok']")
	@CacheLookup
	public WebElement OkSave;

	@FindBy(xpath=".//*[@class='ng-pristine ng-valid md-input ng-not-empty ng-valid-required ng-touched']")
	//@CacheLookup
	public WebElement CloneTitleName;
	
	@FindBy(xpath=".//*[@id='cloneDialogSaveBtn']")
	@CacheLookup
	public WebElement CloneOk;
	
	@FindBy(xpath=".//*[@id='renameDialogRenameBtn']")
	@CacheLookup
	public WebElement RenameOk;
	
	@FindBy(xpath=".//*[@id='confirmDialogActionBtn']")
	public WebElement DeleteOk;
	
	@FindBy(css=".md-select-icon")
	@CacheLookup
	public WebElement dpdash;
		
	public String DeleteDash;
	public String NewDashboard;
	public static String EdText="Edit";
    public static String RnmeText="Rename";
	public static String clText="Clone";
	public static String  DtText="Delete";
	public static String crtDashText="Create Dashboard";
	
	public static String MaxCountValidation="Can not add more than 10 blocks.";
	
	public DashBoardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToCreateDashboardPage() throws Exception {
		ngHelper.waitTillElementIsClickable(btnCreateDashBoard, 30).
				 click(btnCreateDashBoard);
	}
	
	public String addNewWidget(String title, String descp) throws Exception {
		ngHelper.click(btnAction).
				 waitTillElementIsClickable(btnCreateDashBoard, 60).
		         click(btnCreateDashBoard).
		         waitTillElementIsClickable(untitledAddReport, 60).
		         click(untitledAddReport).click(AddReport).
		         click(AddReportdropdown).
		         selectComboOption("AQL Pie N").
		         waitTillElementIsClickable(saveReport,30).
		         click(saveReport).
		         waitTillElementIsClickable(SaveCreateDashboard,30).
		         click(SaveCreateDashboard).
		         waitTillElementIsVisible(txtSaveDialog.get(0), 30).
		         clickAndSendkeys(txtSaveDialog.get(0),title).
		         waitTillElementIsVisible(txtSaveDialog.get(1), 30).
		         clickAndSendkeys(txtSaveDialog.get(1),descp).
		         click(btnSaveDashboardtitle);
		
		
		
		return title;
				
	}
	
	public String CloneWidget(String cloneDashName) throws Exception {
		ngHelper.click(btnAction).waitTillElementIsClickable(CloneActionClick, 20).
				 click(CloneActionClick);
		txtClone.clear();
				 ngHelper.clickAndSendkeys(txtClone, cloneDashName).
				 click(CloneOk);
				 
				 return cloneDashName;

    }
	
	public void DeleteWidgetDashboard() throws Exception {
		
		
		DeleteDash=DashboardFltr.getText();
		ngHelper.click(btnAction).
		         click(DeleteActionClick).
		         click(DeleteOk);
		Thread.sleep(6000);
		NewDashboard=DashboardFltr.getText();
		
	}
	
	public String EditcreatedDashboard(String title) throws Exception{
		ngHelper.click(btnAction).
		         click(EditActionClick).
		         click(untitledAddReport2).
				 click(AddReport).
				 click(AddReportdropdown).selectComboOption("AQL Bar N").
				 waitTillElementIsClickable(saveReport,30).click(saveReport).
				 waitTillElementIsClickable(SaveCreateDashboard,30).click(SaveCreateDashboard).
				 waitTillElementIsVisible(txtSaveDialog.get(0), 30);
		
		txtSaveDialog.get(0).clear();
		
		ngHelper.clickAndSendkeys(txtSaveDialog.get(0),title).
				 click(btnSaveDashboardtitle);
		return title;
	}
	
	public String RenamecreatedDashboard(String RenameDashboard) throws Exception {
		ngHelper.click(btnAction).
		         click(RenameActionClick).waitTillElementIsVisible(txtClone, 10);
		txtClone.clear();
		         ngHelper.clickAndSendkeys(txtClone, RenameDashboard).
		         click(RenameOk);
		         
		         return RenameDashboard;
	}
	
	public void MaxDashCount() throws Exception {
		ngHelper.click(btnAction).
				 waitTillElementIsClickable(btnCreateDashBoard, 60).
		         click(btnCreateDashBoard).
		         waitTillElementIsClickable(untitledAddReport, 60);
		         
		if(AddnewReport.isDisplayed()==true)
			for (int i = 0; i <= 10; i++) {
				ngHelper.click(AddnewReport);
			}
		         
		assertEquals(MaxCountValidation, ToastMsz.getText());   
	    
	}
	
	public String SearchOrderdash(String title, String descp) throws Exception {
		
		ngHelper.click(btnAction).
		         waitTillElementIsClickable(btnCreateDashBoard, 60).
                 click(btnCreateDashBoard).
                 waitTillElementIsClickable(untitledAddReport, 60).
                 click(untitledAddReport).click(AddReport).
                 click(AddReportdropdown).
                 selectComboOption("AQL Pie N").
                 waitTillElementIsClickable(saveReport,30).
                 click(saveReport).
                 waitTillElementIsClickable(SaveCreateDashboard,30).
                 click(SaveCreateDashboard).
                 waitTillElementIsVisible(txtSaveDialog.get(0), 30).
                 clickAndSendkeys(txtSaveDialog.get(0),title).
                 waitTillElementIsVisible(txtSaveDialog.get(1), 30).
                 clickAndSendkeys(txtSaveDialog.get(1),descp).
                 click(btnSaveDashboardtitle);
		  		
		return title;
				
	}

	public void DeleteTopDashboard() throws Exception {
		
		ngHelper.click(btnAction).
		         click(DeleteActionClick).
		         click(DeleteOk);
			
	}

	public String EndUserVerifyDashboardPage(String title, String descp) throws Exception {
	ngHelper.click(btnAction)
             .waitTillElementIsClickable(btnCreateDashBoard, 60).
             click(btnCreateDashBoard).
             waitTillElementIsClickable(untitledAddReport, 60).
             click(untitledAddReport).click(AddReport).
             click(AddReportdropdown).
             selectComboOption("AQL Pie N").
             waitTillElementIsClickable(saveReport,30).
             click(saveReport).
             waitTillElementIsClickable(SaveCreateDashboard,30).
             click(SaveCreateDashboard).
             waitTillElementIsVisible(txtSaveDialog.get(0), 30).
             clickAndSendkeys(txtSaveDialog.get(0),title).
             waitTillElementIsVisible(txtSaveDialog.get(1), 30).
             clickAndSendkeys(txtSaveDialog.get(1),descp).
             click(btnSaveDashboardtitle);

       return title;
	
}

	public void dashboardviewer() throws Exception {
	ngHelper.click(DashSearch.get(0)).
	       waitTillElementIsVisible(DashSearch.get(4), 10).
	      click(DashSearch.get(4));
	       
	
}

}
