package com.autopia4j.demo.mercurytours.modular.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.modular.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.modular.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.modular.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.modular.pages.UserRegistrationConfirmationPage;
import com.autopia4j.demo.mercurytours.modular.pages.UserRegistrationPage;
import com.autopia4j.framework.assertions.BlockingAssertion;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.modular.ModularDriverScript;
import com.autopia4j.framework.webdriver.impl.modular.ModularTestScript;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends ModularTestScript {
	private SignOnPage signOnPage;
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
									new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		ModularDriverScript driverScript = new ModularDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
	
	@Override
	public void setUp() {
		report.addTestLogSection("Setup");
		
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		signOnPage = generalFlows.invokeApplication();
	}
	
	@Override
	public void executeTest() {
		UserRegistrationPage userRegistrationPage = signOnPage.clickRegister();
		UserRegistrationConfirmationPage userRegistrationConfirmationPage = 
													userRegistrationPage.registerUser();
		BlockingAssertion strongly = new BlockingAssertion(report);
		strongly.assertTrue(userRegistrationConfirmationPage.isUserRegistered(), "Is new user registered?");
		signOnPage = userRegistrationConfirmationPage.clickSignIn();
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser();
		strongly.assertTrue(flightFinderPage.isUserSignedOn(), "Is user signed on?");
		signOnPage = flightFinderPage.logout();
	}
	
	@Override
	public void tearDown() {
		// Nothing to do
	}
}