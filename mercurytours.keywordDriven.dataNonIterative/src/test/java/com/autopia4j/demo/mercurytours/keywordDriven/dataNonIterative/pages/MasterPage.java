package com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.assertions.BlockingAssertion;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * MasterPage class
 * @author vj
 */
public class MasterPage extends ReusableLibrary {	
	// UI Map object definitions
	
	// Links
	protected final By lnkSignOff = By.linkText("SIGN-OFF");
	private final By lnkRegister = By.linkText("REGISTER");
	
	
	public MasterPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	
	public void clickRegister() {
		report.updateTestLog("Click Register", "Click on the REGISTER link", Status.DONE);
		driver.findElement(lnkRegister).click();
	}
	
	public void verifyLoginSuccessful() {
		BlockingAssertion strongly = new BlockingAssertion(report);
		strongly.assertTrue(isUserSignedOn(), "Is user signed on?", true);
	}
	
	private Boolean isUserSignedOn() {
		return driverUtil.objectExists(lnkSignOff) &&
				driver.findElement(lnkSignOff).isDisplayed();
	}
	
	public void verifyLoginFailed() {
		BlockingAssertion strongly = new BlockingAssertion(report);
		strongly.assertFalse(isUserSignedOn(), "Is user signed on?");
	}
	
	public void logout() {
		report.updateTestLog("Logout", "Click the sign-off link", Status.DONE);
		driver.findElement(lnkSignOff).click();
	}
}