package com.autopia4j.demo.mercurytours.simple.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.simple.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.simple.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.simple.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.simple.pages.SignOnPage;
import com.autopia4j.framework.assertions.TestNgWrappedAssertion;
import com.autopia4j.framework.webdriver.core.ScriptHelper;
import com.autopia4j.framework.webdriver.impl.simple.SimpleTestScript;
import com.autopia4j.framework.webdriver.reporting.WebDriverReport;

public class FlightReservationScenario extends SimpleTestScript {
	
	@BeforeMethod
	public void setUp() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		report.addTestLogSection("Setup");
		
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		SignOnPage signOnPage = generalFlows.invokeApplication();
		signOnPage.loginAsValidUser();
	}
	
	@Test
	public void testForBookTicketsWithValidCreditCard() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(report);
		report.addTestLogSection("Book flight tickets");
		
		FlightFinderPage flightFinderPage = new FlightFinderPage(scriptHelper);
		FlightConfirmationPage flightConfirmationPage = flightFinderPage.findFlights()
																		.selectFlights()
																		.bookFlights();
		
		strongly.assertTrue(flightConfirmationPage.isTicketBooked(), "Is ticket booked?");
		flightConfirmationPage.extractFlightConfirmationNumber();
		flightConfirmationPage.backToFlights();
	}
	
	@AfterMethod
	public void tearDown() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		report.addTestLogSection("Teardown");
		
		FlightFinderPage flightFinderPage = new FlightFinderPage(scriptHelper);
		flightFinderPage.logout();
	}
}