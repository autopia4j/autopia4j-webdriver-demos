package com.autopia4j.demo.mercurytours.simple.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.simple.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.simple.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.simple.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.simple.pages.UserRegistrationConfirmationPage;
import com.autopia4j.demo.mercurytours.simple.pages.UserRegistrationPage;
import com.autopia4j.demo.mercurytours.simple.testconfigs.TestConfigurations;
import com.autopia4j.framework.core.AutopiaException;
import com.autopia4j.framework.datatable.impl.SimpleDatatable;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.simple.SimpleTestScript;
import com.autopia4j.framework.webdriver.reporting.WebDriverReport;

public class LoginScenario extends SimpleTestScript {
	
	// Avoid class level fields -> they get shared across test methods that run in parallel
	// If you must use them, make sure they are implemented as ThreadLocal variables
	
	@BeforeMethod
	public void setUp() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		
		generalFlows.invokeApplication();
	}
	
	@Test(dataProvider="DesktopBrowsers", dataProviderClass=TestConfigurations.class)
	public void testForValidLogin(WebDriverTestParameters testParameters) {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		generalFlows.verifyLoginSuccessful(flightFinderPage);
		signOnPage = flightFinderPage.logout();
	}
	
	@Test
	public void testForInvalidLogin() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		
		signOnPage = signOnPage.loginAsInvalidUser();
		
		// Verify login failed for invalid user
		if(!signOnPage.isUserSignedOn()) {
			report.updateTestLog("Verify Login", "Login failed for invalid user", Status.PASS, true);
		} else {
			report.updateTestLog("Verify Login", "Login succeeded for invalid user", Status.FAIL, true);
			signOnPage.logout();
		}
	}
	
	@Test
	public void testForLoginWithNewlyRegisteredUser() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		
		UserRegistrationPage userRegistrationPage = signOnPage.clickRegister();
		UserRegistrationConfirmationPage userRegistrationConfirmationPage = 
													userRegistrationPage.registerUser();
		verifyRegistration(userRegistrationConfirmationPage, scriptHelper);
		signOnPage = userRegistrationConfirmationPage.clickSignIn();
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		generalFlows.verifyLoginSuccessful(flightFinderPage);
		signOnPage = flightFinderPage.logout();
	}
	
	private void verifyRegistration(UserRegistrationConfirmationPage confirmationPage, ScriptHelper scriptHelper) {
		SimpleDatatable dataTable = (SimpleDatatable) scriptHelper.getDataTable();
		WebDriverReport report = scriptHelper.getReport();
		
		String userName = dataTable.getData("General_Data", "Username");
		if(confirmationPage.isUserRegistered()) {
			report.updateTestLog("Verify Registration",
									"User " + userName + " registered successfully", Status.PASS, true);
		} else {
			throw new AutopiaException("Verify Registration",
											"User " + userName + " registration failed");
		}
	}
}