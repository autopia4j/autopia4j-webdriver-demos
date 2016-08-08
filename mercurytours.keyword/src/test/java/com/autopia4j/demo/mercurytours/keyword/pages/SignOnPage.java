package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.utils.FrameworkException;
import com.autopia4j.framework.webdriver.core.ScriptHelper;

/**
 * SignOnPage class
 * @author vj
 */
public class SignOnPage extends MasterPage {	
	private static final String GENERAL_DATA = "General_Data";
	
	// UI Map object definitions
	
	// Text boxes
	private final By txtUsername = By.name("userName");
	private final By txtPassword = By.name("password");
	
	// Buttons
	private final By btnLogin = By.name("login");
	
	
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link KeywordDriverScript}
	 */
	public SignOnPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void login() {
		String userName = dataTable.getData(GENERAL_DATA, "Username");
		String password = dataTable.getData(GENERAL_DATA, "Password");
		
		report.updateTestLog("Enter user credentials", "Specify " +
										"username = " + userName + ", " +
										"password = " + password, Status.DONE);
		driver.findElement(txtUsername).sendKeys(userName);
		driver.findElement(txtPassword).sendKeys(password);
		
		report.updateTestLog("Login", "Click the sign-in button", Status.DONE, true);
		driver.findElement(btnLogin).click();
	}
	
	public void verifyLoginSuccessful() {
		if(driverUtil.objectExists(lnkSignOff)&&
				driver.findElement(lnkSignOff).isDisplayed()) {
			report.updateTestLog("Verify Login", "Login succeeded for valid user", Status.PASS, true);
		} else {
			frameworkParameters.setStopExecution(true);
			throw new FrameworkException("Verify Login", "Login failed for valid user");
		}
	}
	
	public void verifyLoginFailed() {
		if(!driverUtil.objectExists(lnkSignOff)) {
			report.updateTestLog("Verify Login", "Login failed for invalid user", Status.PASS, true);
		} else {
			report.updateTestLog("Verify Login", "Login succeeded for invalid user", Status.FAIL);
		}
	}
}