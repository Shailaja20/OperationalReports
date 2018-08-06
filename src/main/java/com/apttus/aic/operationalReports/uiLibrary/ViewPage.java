package com.apttus.aic.operationalReports.uiLibrary;
import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ViewPage extends OpReportinit {
	
	@FindBy(css="button[class^='ands']")
	@CacheLookup
	public WebElement Actionview;
	
	@FindBy(css=".button-set-section.layout-align-end-center.layout-row.flex>a")
	@CacheLookup
	public WebElement Prevwbtn;
	
	@FindBy(css=".ands-dialog-title")
	@CacheLookup
	public WebElement PrvwQuerytxt;
	
	@FindBy(xpath="//*[@class='fa fa-flash']")
	@CacheLookup
	public WebElement ActionQuickcreate;  
	
	@FindBy(xpath="//*[text()='Create View']")
	@CacheLookup
	public WebElement ActncreateVwWidget;
		
	@FindBy(xpath="//*[@ng-model='vm.formData.objectsForm.data.name']")
	@CacheLookup
	public WebElement NameVwWidget;
	
	@FindBy(xpath="//*[@ng-model='vm.formData.objectsForm.data.description']")
	@CacheLookup
	public WebElement DescpVwWidget;
	
	@FindBy(xpath="//*[@ng-model='vm.formData.objectsForm.data.selectedEntity']")
	@CacheLookup
	public WebElement AnchorVwWidget;
	
	@FindBy(id="objectsForm")
	public List<WebElement> crteVwObjects;
		
	@FindBy(xpath="//*[@type='checkbox']")
	public List<WebElement> AnchorCheckbx;
	
	@FindBy(css="#quickManageDialogName > input")
	public WebElement viewNametxt;
	
	@FindBy(tagName="textarea")
	@CacheLookup
	public WebElement viewDescptxt;
		
	@FindBy(css="pre.CodeMirror-line")
	public List<WebElement> txtAreaQuery;
	
	@FindBy(xpath="//*[@ng-model='vm.formData.reportDefForm.Name']")
	@CacheLookup
	public WebElement NameQuickvw;
		
	@FindBy(xpath="//*[text()='Save']")
	@CacheLookup
	public WebElement btnSave;
	
	@FindBy(xpath="//*[@ng-model='vm.searchText']")
	@CacheLookup
	public WebElement Searchdpdown;
		
	@FindBy(xpath=".//*[@class='md-select-value']")
	@CacheLookup
	public WebElement Filterdpdown;
	
	@FindBy(css="#openMenuBtn")
	public List<WebElement> lftMenu;
	
	@FindBy(xpath="html/body/div[5]//*[text()='delete']")
	@CacheLookup
	public WebElement Deletebtn;

	@FindBy(css="#confirmDialogActionBtn")
	@CacheLookup
	public WebElement ConfirmDelete;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Clone']")
	@CacheLookup
	public WebElement Clonebtn;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Deactivate']")
	public WebElement Deactivatebtn;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Activate']")
	public WebElement Actdbtn;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Edit']")
	@CacheLookup
	public WebElement VwEditbtn;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Edit']")
	@CacheLookup
	public WebElement VwEditbtn1;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Quick Edit']")
	@CacheLookup
	public WebElement Editbtn;
	
	@FindBy(xpath="html/body/div[5]//*[text()='Rename']")
	@CacheLookup
	public WebElement Renamebtn;
	
	@FindBy(xpath="//*[@ng-required='true']")
	@CacheLookup
	public WebElement Clonetxt;
	
	@FindBy(id="cloneDialogSaveBtn")
	@CacheLookup
	public WebElement CloneOkbtn;
	
	@FindBy(id="renameDialogRenameBtn")
	@CacheLookup
	public WebElement RenameOkbtn;

	@FindBy(xpath="//*[@class='ands-input-container flex md-input-has-value']/input")
	@CacheLookup
	public WebElement Renametxt;
		
	@FindBy(css=".master-details-title.ellipsis-text.flex-30")
	@CacheLookup
	public WebElement SerchdElme;
		 
	@FindBy(xpath="//*[contains(text(),'successfully')]")
	public WebElement successRsp;
		
	@FindBy(xpath="//*[@id='reportInfoContainer']/div[1]/label[2]")
	public WebElement DetailViewName;
	
	@FindBy(xpath="//*[text()='Next']")
	@CacheLookup
	public WebElement Nextbtn;
	
	@FindBy(xpath="//*[text()='Activate and Exit']")
	@CacheLookup
	public WebElement Activatebtn;
	
	@FindBy(xpath="//*[text()='Add Row']")
	@CacheLookup
	public WebElement AddRowlnk;
	
	@FindBy(id="selectObject")
	@CacheLookup
	public WebElement ObjName;
	
	@FindBy(id="selectField")
	@CacheLookup
	public WebElement ObjField;
	
	@FindBy(xpath="//*[@ng-change='vm.onChangeOperator(row)']")
	@CacheLookup
	public WebElement Operatordropdn;
	
	@FindBy(xpath="//*[@ng-repeat='row in vm.filters track by $index']//*[text()='delete']")
	@CacheLookup
	public WebElement DeleteFltr;
	
	@FindBy(xpath="//*[@ng-model='row.value']")
	@CacheLookup
	public WebElement Valuetxt;
		
	public String BfrDeletedView;
	public String AfrDeletedView;

	public String BfrCloneView;
	public String AfrCloneView;
	public String NewCloneView;
	
	public String BfrRenameView;
	public String AfRenameView;
	public String NewRenameView;
	
	public String Status;
	public String BfUpdtQkVw;
	public String UpdtQkVw;
	
	public ViewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String QuickViewcreate(String viewName, String viewDesp,String QuickQuery,String ConfigQuery) throws Exception {
		ngHelper.click(Actionview)
		        .click(ActionQuickcreate)
		        .waitTillElementIsVisible(viewNametxt, 20)
		        .clickAndSendkeys(viewNametxt, viewName)
		        .waitTillElementIsVisible(viewDescptxt, 20)
		        .clickAndSendkeys(viewDescptxt, viewDesp)
		        .waitTillElementIsVisible(txtAreaQuery.get(0), 30)
		        .click(txtAreaQuery.get(0))
		        .sendTextKeys(QuickQuery)
		        .click(btnSave);
		
		DetailViewName.getText();

		return viewName;
	}
	
	public void QuickViewEdit(String viewName, String viewDesp) throws Exception {
		
		BfUpdtQkVw=DetailViewName.getText();
		UpdtQkVw=BfUpdtQkVw+viewName;
		
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30)
                .click(lftMenu.get(0))
		        .click(Editbtn)
		        .waitTillElementIsVisible(viewNametxt, 20).click(viewNametxt);
		viewNametxt.clear();
		ngHelper.clickAndSendkeys(viewNametxt, viewName)
		        .waitTillElementIsVisible(viewDescptxt, 20).clickAndSendkeys(viewDescptxt, viewDesp)
		        .click(btnSave);
		 
	}
	
	public void FilterViewcreate(String filtervalue,String quickViewstr) throws Exception {
		ngHelper.click(Filterdpdown).
		        selectComboOption("Name").
		        click(Searchdpdown).
		        sendKeysTo(Searchdpdown, quickViewstr).checkVisibility(SerchdElme);	
		        DetailViewName.getText();
	}
	
	public void DeleteViewcreate() throws Exception {
		
	   BfrDeletedView=DetailViewName.getText();

		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                click(lftMenu.get(0)).
                click(Deletebtn).
                click(ConfirmDelete);
		 AfrDeletedView=DetailViewName.getText();
		
	}
	
	public void CloneViewcreate() throws Exception {
		
		BfrCloneView=DetailViewName.getText();
		ngHelper.click(lftMenu.get(0)).
		         click(Clonebtn).click(CloneOkbtn);	
		        Thread.sleep(1000);
		        AfrCloneView="CLONE - "+BfrCloneView;
		        NewCloneView=DetailViewName.getText();
		        
	}
	
	public void DeactivatedViewcreate() throws Exception {
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                 click(lftMenu.get(0)).
                 click(Deactivatebtn);  
		Thread.sleep(8000);
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                click(lftMenu.get(0));
		
		Status=Actdbtn.getText();	
	}
	
	public void ActivatedViewcreate() throws Exception {
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                 click(lftMenu.get(0)).
                 click(Actdbtn);    
		
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                 click(lftMenu.get(0));
		Status=Deactivatebtn.getText();
                
	}
	
	public void RenameViewcreate(String Renameview) throws Exception {
			
		BfrRenameView=DetailViewName.getText();
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                 click(lftMenu.get(0)).
                 click(Renamebtn).
                 click(Renametxt).
                 sendBoardKeys(Keys.END).
                 sendTextKeys(Renameview).
                 click(RenameOkbtn);
		         AfRenameView=BfrRenameView+"Renameview";
                 Thread.sleep(1000);
                 NewRenameView=DetailViewName.getText();
	}  
	
	public String EditNewViewWidget(String viewNameEdt, String viewDespEdt,String OjName, String FldName ,String Opertor, String Value) throws Exception {
		
		BfUpdtQkVw=DetailViewName.getText();
		UpdtQkVw=BfUpdtQkVw+viewNameEdt;
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                click(lftMenu.get(0)).
                click(VwEditbtn).waitTillElementIsClickable(NameVwWidget, 60).
                click(NameVwWidget).
                sendBoardKeys(Keys.END).
                sendTextKeys(viewNameEdt).
                
                waitTillElementIsVisible(DescpVwWidget, 20).
                click(DescpVwWidget).
                sendBoardKeys(Keys.END).
                sendTextKeys(viewDespEdt).
                
                click(Nextbtn).waitTillElementIsClickable(DeleteFltr, 50).
                click(DeleteFltr).
                waitTillElementIsVisible(AddRowlnk, 20).
		        click(AddRowlnk).waitTillElementIsVisible(ObjField, 10).
		        click(ObjName).selectComboOption(OjName).
		        click(ObjField).selectComboOption(FldName).
		        click(Operatordropdn).selectComboOption(Opertor).
		        clickAndSendkeys(Valuetxt, Value).
		        click(Activatebtn);
		
		return viewNameEdt;
                 
	}
	
	public String NewWidgetView(String Name, String Descp, String Anchor,String OjName,String FldName,String Opertor,String Value) throws Exception {
		
		ngHelper.click(Actionview).
		         click(ActncreateVwWidget).
		         clickAndSendkeys(NameVwWidget, Name).
		         clickAndSendkeys(DescpVwWidget, Descp).
		         click(AnchorVwWidget).
		         selectComboOption(Anchor).
		         click(AnchorCheckbx.get(0)).
		         click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).
		         click(AddRowlnk).waitTillElementIsVisible(ObjField, 10).
		         click(ObjName).selectComboOption(OjName).
		         click(ObjField).selectComboOption(FldName).
		         click(Operatordropdn).selectComboOption(Opertor).
		         clickAndSendkeys(Valuetxt, Value).
		         click(Activatebtn);	
		
		DetailViewName.getText();
		
		return Name;
	}

	public void FilterView(String filtervalue,String quickViewstr) throws Exception {
		ngHelper.click(Filterdpdown).
		        selectComboOption("Name").
		        click(Searchdpdown).
		        sendKeysTo(Searchdpdown,quickViewstr);
		
	}
	public void ViewConfigRemove() throws Exception {
		ngHelper.click(Actionview)
		        .click(ActionQuickcreate);
			
		assertEquals(1, txtAreaQuery.size(), "Only View Query is available and View Config is not removed");
		
	}

	public void FillDetailsCreateData(String Name, String Descp, String Anchor) throws Exception {
		
		ngHelper.click(Actionview).
                click(ActncreateVwWidget).
                clickAndSendkeys(NameVwWidget, Name).
                clickAndSendkeys(DescpVwWidget, Descp).
                click(AnchorVwWidget).
                selectComboOption(Anchor).
                click(AnchorCheckbx.get(0)).
                click(Nextbtn);
	}

	public void VerfyAnchorObjects( String Anchor) throws Exception {
		ngHelper.click(Actionview).
                 click(ActncreateVwWidget).
                 click(AnchorVwWidget).
                 selectComboOption(Anchor).
                 click(AnchorCheckbx.get(0));
		if(AnchorCheckbx.size()>0)
		
			for (int i = 0; i <=AnchorCheckbx.size()-1; i++) {
				ngHelper.click(AnchorCheckbx.get(i));
			}
               
	}
	
	public void VerifyVwFieldsPage( String Name, String Descp, String Anchor, String OjName, String FldName, String Opertor, String Value) throws Exception {
		ngHelper.click(Actionview).
                 click(ActncreateVwWidget).
                 clickAndSendkeys(NameVwWidget, Name).
                 clickAndSendkeys(DescpVwWidget, Descp).
                 click(AnchorVwWidget).
                 selectComboOption(Anchor).
                 click(AnchorCheckbx.get(0)).
                 click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).
                 click(AddRowlnk).waitTillElementIsVisible(ObjField, 10).
                 click(ObjName).selectComboOption(OjName).
                 click(ObjField).selectComboOption(FldName).
                 click(Operatordropdn).selectComboOption(Opertor).
                 clickAndSendkeys(Valuetxt, Value).
                 click(Activatebtn);	
		
		/*ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                 click(lftMenu.get(0)).
                 click(VwEditbtn).
                 waitTillElementIsVisible(NameVwWidget, 20).
                 click(AnchorVwWidget).
                 selectComboOption(Anchor);
		
		if(AnchorCheckbx.size()>0)
		
			for (int i = 0; i <=AnchorCheckbx.size()/2; i++) {
				ngHelper.click(AnchorCheckbx.get(i));
			}
		ngHelper.click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).click(Activatebtn);*/
               
	}
	
	public void VerifyVwFilterPage( String Name, String Descp, String Anchor, String OjName, String FldName, String Opertor, String Value) throws Exception {
		ngHelper.click(Actionview).
                 click(ActncreateVwWidget).
                 clickAndSendkeys(NameVwWidget, Name).
                 clickAndSendkeys(DescpVwWidget, Descp).
                 click(AnchorVwWidget).
                 selectComboOption(Anchor).
                 click(AnchorCheckbx.get(0)).
                 click(Nextbtn).
                 click(Activatebtn);	
		
		/*ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
                click(lftMenu.get(0)).
                click(VwEditbtn).
                waitTillElementIsVisible(NameVwWidget, 20).
                click(AnchorVwWidget).
                selectComboOption(Anchor);
		
		if (AnchorCheckbx.size() > 0)

			for (int i = 0; i <= AnchorCheckbx.size()/ 2; i++) {
				ngHelper.click(AnchorCheckbx.get(i));
			}
		ngHelper.click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).
		         click(AddRowlnk).waitTillElementIsVisible(ObjField, 10).
		         click(ObjName).selectComboOption(OjName).click(ObjField).
				 selectComboOption(FldName).click(Operatordropdn).selectComboOption(Opertor).
				 clickAndSendkeys(Valuetxt, Value).click(Activatebtn);*/

	}
	public void VerfyChildLookupsObjects( String Anchor) throws Exception {
		ngHelper.click(Actionview).
                 click(ActncreateVwWidget).
                 click(AnchorVwWidget).
                 selectComboOption(Anchor).
                 click(AnchorCheckbx.get(0));
		if(AnchorCheckbx.size()>0)
		
			for (int i = 0; i <=AnchorCheckbx.size()-1; i++) {
				ngHelper.click(AnchorCheckbx.get(i));
			}         
	}
public void VerifyPreviewPage(String Name, String Descp, String Anchor,String OjName,String FldName,String Opertor,String Value) throws Exception {
		
		ngHelper.click(Actionview).
		         click(ActncreateVwWidget).
		         clickAndSendkeys(NameVwWidget, Name).
		         clickAndSendkeys(DescpVwWidget, Descp).
		         click(AnchorVwWidget).
		         selectComboOption(Anchor).
		         click(AnchorCheckbx.get(0)).
		         click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).
		         click(AddRowlnk).waitTillElementIsVisible(ObjField, 10).
		         click(ObjName).selectComboOption(OjName).
		         click(ObjField).selectComboOption(FldName).
		         click(Operatordropdn).selectComboOption(Opertor).
		         clickAndSendkeys(Valuetxt, Value).
		         click(Prevwbtn);
		
}

public void VerifyVwsFiltr(String Anchor,String  OjName ,String FldName, String Opertor,String Value) throws Exception {
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).
		        click(lftMenu.get(0)).
		        click(VwEditbtn1).
				waitTillElementIsVisible(NameVwWidget, 20).
				click(AnchorVwWidget).selectComboOption(Anchor);

		if (AnchorCheckbx.size() > 0)

			for (int i = 0; i <= AnchorCheckbx.size() / 2; i++) {
				ngHelper.click(AnchorCheckbx.get(i));
			}
ngHelper.click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).
         click(AddRowlnk).waitTillElementIsVisible(ObjField, 10).
         click(ObjName).selectComboOption(OjName).click(ObjField).
	     selectComboOption(FldName).click(Operatordropdn).selectComboOption(Opertor).
	     clickAndSendkeys(Valuetxt, Value).click(Activatebtn);
	
}

public void VerifyVwsField(String Anchor) throws Exception {
		ngHelper.waitTillElementIsVisible(lftMenu.get(0), 30).click(lftMenu.get(0)).click(VwEditbtn)
				.waitTillElementIsVisible(NameVwWidget, 20).click(AnchorVwWidget).selectComboOption(Anchor);

		if (AnchorCheckbx.size() > 0)

			for (int i = 0; i <= AnchorCheckbx.size() / 2; i++) {
				ngHelper.click(AnchorCheckbx.get(i));
			}
		ngHelper.click(Nextbtn).waitTillElementIsVisible(AddRowlnk, 20).click(Activatebtn);
	
}
}
