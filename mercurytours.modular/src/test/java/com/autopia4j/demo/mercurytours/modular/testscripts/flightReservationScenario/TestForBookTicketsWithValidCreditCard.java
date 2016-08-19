package com.autopia4j.demo.mercurytours.modular.testscripts.flightReservationScenario;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.modular.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.modular.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.modular.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.modular.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.modular.testscripts.TestConfigurations;
import com.autopia4j.framework.core.IterationOptions;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.modular.ModularDriverScript;
import com.autopia4j.framework.webdriver.impl.modular.ModularTestScript;


/**
 * Test for book flight tickets and verify booking
 * @author vj
 */
public class TestForBookTicketsWithValidCreditCard extends ModularTestScript {
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
		
		ModularDriverScript driverScript = new ModularDriverScript(testParameters);
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
		
		verifyBooking(flightConfirmationPage);
		flightFinderPage = flightConfirmationPage.backToFlights();
	}
	
	private void verifyBooking(FlightConfirmationPage flightConfirmationPage) {
		if(flightConfirmationPage.isTicketBooked()) {
			report.updateTestLog("Verify Booking", "Tickets booked successfully", Status.PASS);
			flightConfirmationPage.extractFlightConfirmationNumber();
		} else {
			report.updateTestLog("Verify Booking", "Tickets booking failed", Status.FAIL);
		}
	}
	
	@Override
	public void tearDown() {
		report.addTestLogSection("Teardown");
		
		flightFinderPage.logout();
	}
}