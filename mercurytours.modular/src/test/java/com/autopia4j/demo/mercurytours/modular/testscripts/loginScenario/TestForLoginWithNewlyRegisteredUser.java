package com.autopia4j.demo.mercurytours.modular.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.modular.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.modular.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.modular.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.modular.pages.UserRegistrationConfirmationPage;
import com.autopia4j.demo.mercurytours.modular.pages.UserRegistrationPage;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.utils.FrameworkException;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.impl.modular.ModularTestScript;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends ModularTestScript {
	private GeneralFlows generalFlows;
	private SignOnPage signOnPage;
	
	@Test
	public void testRunner() {
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		driverScript.driveTestExecution();
	}
	
	@Override
	public void setUp() {
		report.addTestLogSection("Setup");
		
		generalFlows = new GeneralFlows(scriptHelper);
		signOnPage = generalFlows.invokeApplication();
	}
	
	@Override
	public void executeTest() {
		UserRegistrationPage userRegistrationPage = signOnPage.clickRegister();
		UserRegistrationConfirmationPage userRegistrationConfirmationPage = 
													userRegistrationPage.registerUser();
		verifyRegistration(userRegistrationConfirmationPage);
		signOnPage = userRegistrationConfirmationPage.clickSignIn();
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		generalFlows.verifyLoginSuccessful(flightFinderPage);
		signOnPage = flightFinderPage.logout();
	}
	
	private void verifyRegistration(UserRegistrationConfirmationPage confirmationPage) {
		String userName = dataTable.getData("General_Data", "Username");
		
		if(confirmationPage.isUserRegistered()) {
			report.updateTestLog("Verify Registration",
									"User " + userName + " registered successfully", Status.PASS, true);
		} else {
			throw new FrameworkException("Verify Registration",
											"User " + userName + " registration failed");
		}
	}
	
	@Override
	public void tearDown() {
		// Nothing to do
	}
}