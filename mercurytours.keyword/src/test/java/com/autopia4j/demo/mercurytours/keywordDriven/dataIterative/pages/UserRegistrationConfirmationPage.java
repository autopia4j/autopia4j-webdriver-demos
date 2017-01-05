package com.autopia4j.demo.mercurytours.keywordDriven.dataIterative.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.assertions.BlockingAssertion;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * UserRegistrationConfirmationPage class
 * @author vj
 */
public class UserRegistrationConfirmationPage extends ReusableLibrary {
	// UI Map object definitions
	
	// Links
	private final By lnkSignIn = By.linkText("sign-in");
	
	
	public UserRegistrationConfirmationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void verifyRegistration() {
		BlockingAssertion strongly = new BlockingAssertion(report);
		Boolean isUserRegistered = driverUtil.isTextPresent("^[\\s\\S]*Dear " +
									dataTable.getExpectedResult("FirstName") + " " +
									dataTable.getExpectedResult("LastName") + "[\\s\\S]*$");
		strongly.assertTrue(isUserRegistered, "Is new user registered?");
	}
	
	public void clickSignIn() {
		report.updateTestLog("Click sign-in", "Click the sign-in link", Status.DONE);
		driver.findElement(lnkSignIn).click();
	}
}