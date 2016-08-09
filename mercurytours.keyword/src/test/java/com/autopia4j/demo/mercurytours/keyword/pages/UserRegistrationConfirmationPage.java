package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.utils.FrameworkException;
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
		String userName = dataTable.getData("General_Data", "Username");
		
		if(driverUtil.isTextPresent("^[\\s\\S]*Dear " +
					dataTable.getExpectedResult("FirstName") + " " +
					dataTable.getExpectedResult("LastName") + "[\\s\\S]*$")) {
			report.updateTestLog("Verify Registration",
										"User " + userName + " registered successfully", Status.PASS);
		} else {
			throw new FrameworkException("Verify Registration",
											"User " + userName + " registration failed");
		}
	}
	
	public void clickSignIn() {
		report.updateTestLog("Click sign-in", "Click the sign-in link", Status.DONE);
		driver.findElement(lnkSignIn).click();
	}
}