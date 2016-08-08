package com.autopia4j.demo.mercurytours.modular.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.modular.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.modular.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.modular.pages.SignOnPage;
import com.autopia4j.framework.webdriver.modular.TestCase;


/**
 * Test for login with valid user credentials
 * @author vj
 */
public class TestForValidLogin extends TestCase {
	
	private GeneralFlows generalFlows;
	private SignOnPage signOnPage;
	
	@Test()
	public void testRunner() {
		testParameters.setCurrentTestDescription("Test for login with valid user credentials");
		
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
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		generalFlows.verifyLoginSuccessful(flightFinderPage);
		signOnPage = flightFinderPage.logout();
	}
	
	@Override
	public void tearDown() {
		// Nothing to do
	}
}