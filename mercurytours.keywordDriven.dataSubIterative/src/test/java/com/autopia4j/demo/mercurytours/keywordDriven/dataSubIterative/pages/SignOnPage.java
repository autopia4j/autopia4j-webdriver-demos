package com.autopia4j.demo.mercurytours.keywordDriven.dataSubIterative.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;

/**
 * SignOnPage class
 * @author vj
 */
public class SignOnPage extends ReusableLibrary {	
	private static final String GENERAL_DATA = "General_Data";
	
	// UI Map object definitions
	
	// Text boxes
	private final By txtUsername = By.name("userName");
	private final By txtPassword = By.name("password");
	
	// Buttons
	private final By btnLogin = By.name("login");
	
	
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
}