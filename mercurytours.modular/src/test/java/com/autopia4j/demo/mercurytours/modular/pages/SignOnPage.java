package com.autopia4j.demo.mercurytours.modular.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.ScriptHelper;

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
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public SignOnPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Welcome") && !driver.getTitle().contains("Sign-on")) {
			report.updateTestLog("Verify page title", "Sign-on page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public FlightFinderPage loginAsValidUser() {	
		login();
		return new FlightFinderPage(scriptHelper);
	}
	
	private void login() {
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
	
	public SignOnPage loginAsInvalidUser() {	
		login(); 
		return new SignOnPage(scriptHelper);	// Return new object to indicate an actual page navigation
	}
}