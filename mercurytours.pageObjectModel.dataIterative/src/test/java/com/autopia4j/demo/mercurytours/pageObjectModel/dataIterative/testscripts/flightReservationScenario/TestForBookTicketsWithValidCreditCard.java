package com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.testscripts.flightReservationScenario;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.testscripts.TestConfigurations;
import com.autopia4j.framework.assertions.BlockingAssertion;
import com.autopia4j.framework.core.IterationOptions;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.modular.dataIterative.ModularIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.modular.dataIterative.ModularIterativeTestScript;


/**
 * Test for book flight tickets and verify booking
 * @author vj
 */
public class TestForBookTicketsWithValidCreditCard extends ModularIterativeTestScript {
	private FlightFinderPage flightFinderPage;
	
	@Test(dataProvider="DesktopBrowsers", dataProviderClass=TestConfigurations.class)
	public void testRunner(String testInstance, ExecutionMode executionMode,
							String deviceName, Browser browser, Platform platform) {
		WebDriverTestParameters testParameters =
									new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for book flight tickets and verify booking");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setDeviceName(deviceName);
		testParameters.setBrowser(browser);
		testParameters.setPlatform(platform);
		
		ModularIterativeDriverScript driverScript = new ModularIterativeDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
	
	@Override
	public void setUp() {
		report.addTestLogSection("Setup");
		
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		SignOnPage signOnPage = generalFlows.invokeApplication();
		flightFinderPage = signOnPage.loginAsValidUser();
	}
	
	@Override
	public void executeTest() {
		/*
		// Typical usage of Page Object Model
		SelectFlightPage selectFlightPage = flightFinderPage.findFlights();
		BookFlightPage bookFlightPage = selectFlightPage.selectFlights();
		FlightConfirmationPage flightConfirmationPage = bookFlightPage.bookFlights();*/
		
		// Example of using chaining as an alternative to improve readability
		FlightConfirmationPage flightConfirmationPage = flightFinderPage.findFlights()
																		.selectFlights()
																		.bookFlights();
		
		BlockingAssertion strongly = new BlockingAssertion(report);
		strongly.assertTrue(flightConfirmationPage.isTicketBooked(), "Is ticket booked?");
		flightConfirmationPage.extractFlightConfirmationNumber();
		flightFinderPage = flightConfirmationPage.backToFlights();
	}
	
	@Override
	public void tearDown() {
		report.addTestLogSection("Teardown");
		
		flightFinderPage.logout();
	}
}