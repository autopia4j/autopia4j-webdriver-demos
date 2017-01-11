package com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * MasterPage Abstract class
 * @author vj
 */
abstract class MasterPage extends ReusableLibrary {	
	// UI Map object definitions
	
	// Links
	protected final By lnkSignOff = By.linkText("SIGN-OFF");
	protected final By lnkRegister = By.linkText("REGISTER");
	
	
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularIterativeDriverScript}
	 */
	protected MasterPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public UserRegistrationPage clickRegister() {
		report.updateTestLog("Click Register", "Click on the REGISTER link", Status.DONE);
		driver.findElement(lnkRegister).click();
		
		return new UserRegistrationPage(scriptHelper);
	}
	
	public Boolean isUserSignedOn() {
		return driverUtil.objectExists(lnkSignOff) &&
				driver.findElement(lnkSignOff).isDisplayed();
	}
	
	public SignOnPage logout() {
		report.updateTestLog("Logout", "Click the sign-off link", Status.DONE);
		driver.findElement(lnkSignOff).click();
		
		return new SignOnPage(scriptHelper);
	}
}