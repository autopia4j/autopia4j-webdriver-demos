package com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.SignOnPage;
import com.autopia4j.framework.assertions.BlockingAssertion;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.modular.dataIterative.ModularIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.modular.dataIterative.ModularIterativeTestScript;


/**
 * Test for login with valid user credentials
 * @author vj
 */
public class TestForValidLogin extends ModularIterativeTestScript {
	
	private GeneralFlows generalFlows;
	private SignOnPage signOnPage;
	
	@Test()
	public void testRunner() {
		WebDriverTestParameters testParameters =
									new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with valid user credentials");
		
		ModularIterativeDriverScript driverScript = new ModularIterativeDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
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
		BlockingAssertion strongly = new BlockingAssertion(report);
		strongly.assertTrue(flightFinderPage.isUserSignedOn(), "Is user signed on?", true);
		
		//generalFlows.verifyLoginSuccessful(flightFinderPage);
		signOnPage = flightFinderPage.logout();
	}
	
	@Override
	public void tearDown() {
		// Nothing to do
	}
}