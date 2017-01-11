package com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.UserRegistrationConfirmationPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.UserRegistrationPage;
import com.autopia4j.framework.assertions.BlockingAssertion;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.modular.dataIterative.ModularIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.modular.dataIterative.ModularIterativeTestScript;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends ModularIterativeTestScript {
	private SignOnPage signOnPage;
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
									new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		ModularIterativeDriverScript driverScript = new ModularIterativeDriverScript(testParameters);
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