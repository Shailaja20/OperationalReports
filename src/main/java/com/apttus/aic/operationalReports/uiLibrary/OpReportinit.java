package com.apttus.aic.operationalReports.uiLibrary;


import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apttus.selenium.NGHelper;

public class OpReportinit {

	public WebDriver driver;
	public NGHelper ngHelper;
	
	@FindBy(name="loginfmt")
	@CacheLookup
	public WebElement typeUsername;
	
	@FindBy(id="idSIButton9")
	@CacheLookup
	public WebElement clickNext;
	
	@FindBy(name="passwd")
	@CacheLookup
	public WebElement typePassword;
	
	@FindBy(id="idSIButton9")
	@CacheLookup
	public WebElement clickSubmit;
	
	@FindBy(css="span.loadImageText")
	public WebElement loaderGIFcsselem;
	
	@FindBy(xpath="//*[@id='ngProgress']")
	public WebElement progressBar;
	
	public OpReportinit(WebDriver driver) {
	   this.driver=driver;
	   ngHelper=new NGHelper(driver);
	   PageFactory.initElements(driver, this);
	}
	
	public HomePage landOnHomepage() throws Exception {
		return PageFactory.initElements(driver, HomePage.class);
	}
	

	public HomePage navigateBackToHomepage(Properties properties) throws Exception {
		ngHelper.NavigateTo(properties.getProperty("LoginURL"));
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	/*public void clickandWait(WebElement elem1, WebElement elem2) throws Exception {
		ngHelper.waitTillElementIsClickable(elem1, 30)
		.click(elem2);
		Thread.sleep(3000);
	}*/
	
	public void loginToApp(String username, String password) throws Exception {
		ngHelper.waitTillElementIsClickable(typeUsername, 60)
				.clickAndSendkeys(typeUsername, username)
				.click(clickNext)
				.waitTillElementIsClickable(typePassword, 60)
				.clickAndSendkeys(typePassword, password)
				.waitTillElementIsClickable(clickSubmit, 30)
				.click(clickSubmit);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	

	
	
}
