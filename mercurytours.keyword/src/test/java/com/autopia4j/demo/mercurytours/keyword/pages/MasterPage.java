package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.ReusableLibrary;
import com.autopia4j.framework.webdriver.ScriptHelper;


/**
 * MasterPage class
 * @author vj
 */
public class MasterPage extends ReusableLibrary {	
	// UI Map object definitions
	
	// Links
	protected final By lnkSignOff = By.linkText("SIGN-OFF");
	private final By lnkRegister = By.linkText("REGISTER");
	
	
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link KeywordDriverScript}
	 */
	public MasterPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	
	public void clickRegister() {
		report.updateTestLog("Click Register", "Click on the REGISTER link", Status.DONE);
		driver.findElement(lnkRegister).click();
	}
	
	public void logout() {
		report.updateTestLog("Logout", "Click the sign-off link", Status.DONE);
		driver.findElement(lnkSignOff).click();
	}
}