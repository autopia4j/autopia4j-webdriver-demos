package com.autopia4j.demo.mercurytours.simple.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.simple.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.simple.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.simple.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.simple.pages.UserRegistrationConfirmationPage;
import com.autopia4j.demo.mercurytours.simple.pages.UserRegistrationPage;
import com.autopia4j.demo.mercurytours.simple.testconfigs.TestConfigurations;
import com.autopia4j.framework.assertions.TestNgWrappedAssertion;
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
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(scriptHelper.getReport());
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		strongly.assertTrue(flightFinderPage.isUserSignedOn(), "Is user signed in?");
		signOnPage = flightFinderPage.logout();
	}
	
	@Test
	public void testForInvalidLogin() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(report);
		
		signOnPage = signOnPage.loginAsInvalidUser();
		strongly.assertFalse(signOnPage.isUserSignedOn(), "Is user signed in?");
	}
	
	@Test
	public void testForLoginWithNewlyRegisteredUser() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(scriptHelper.getReport());
		
		UserRegistrationPage userRegistrationPage = signOnPage.clickRegister();
		UserRegistrationConfirmationPage userRegistrationConfirmationPage = 
													userRegistrationPage.registerUser();
		strongly.assertTrue(userRegistrationConfirmationPage.isUserRegistered(), "Is new user registered?");
		signOnPage = userRegistrationConfirmationPage.clickSignIn();
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		strongly.assertTrue(flightFinderPage.isUserSignedOn(), "Is user signed in?");
		signOnPage = flightFinderPage.logout();
	}
}