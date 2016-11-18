package com.autopia4j.demo.mercurytours.basic.pages;

import org.openqa.selenium.By;

import com.autopia4j.demo.mercurytours.basic.datamodel.User;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * UserRegistrationConfirmationPage class
 * @author vj
 */
public class UserRegistrationConfirmationPage extends MasterPage {
	
	// UI Map object definitions
	
	// Links
	private final By lnkSignIn = By.linkText("sign-in");
	
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public UserRegistrationConfirmationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Register")) {
			report.updateTestLog("Verify page title", "User Registration Confirmation page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public Boolean isUserRegistered(User newUser) {
		return driverUtil.isTextPresent("^[\\s\\S]*Dear " +
										newUser.getFirstName() + " " +
										newUser.getLastName() + "[\\s\\S]*$");
	}
	
	public SignOnPage clickSignIn() {
		report.updateTestLog("Click sign-in", "Click the sign-in link", Status.DONE);
		driver.findElement(lnkSignIn).click();
		
		return new SignOnPage(scriptHelper);
	}
}