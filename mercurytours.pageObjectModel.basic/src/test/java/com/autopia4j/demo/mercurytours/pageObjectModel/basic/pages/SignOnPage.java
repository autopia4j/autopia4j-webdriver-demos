package com.autopia4j.demo.mercurytours.pageObjectModel.basic.pages;

import org.openqa.selenium.By;

import com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel.User;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;

/**
 * SignOnPage class
 * @author vj
 */
public class SignOnPage extends MasterPage {
	
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
	
	public FlightFinderPage loginAsValidUser(User validUser) {	
		login(validUser);
		return new FlightFinderPage(scriptHelper);
	}
	
	private void login(User user) {
		report.updateTestLog("Enter user credentials", "Specify " +
										"username = " + user.getUserName() + ", " +
										"password = " + user.getPassword(), Status.DONE);
		driver.findElement(txtUsername).sendKeys(user.getUserName());
		driver.findElement(txtPassword).sendKeys(user.getPassword());
		
		report.updateTestLog("Login", "Click the sign-in button", Status.DONE, true);
		driver.findElement(btnLogin).click();
	}
	
	public SignOnPage loginAsInvalidUser(User invalidUser) {	
		login(invalidUser); 
		return new SignOnPage(scriptHelper);	// Return new object to indicate an actual page navigation
	}
}