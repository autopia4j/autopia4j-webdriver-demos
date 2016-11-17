package com.autopia4j.demo.mercurytours.simple.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.simple.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.simple.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.simple.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.simple.pages.SignOnPage;
import com.autopia4j.framework.reporting.Status;
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
		report.addTestLogSection("Book flight tickets");
		
		FlightFinderPage flightFinderPage = new FlightFinderPage(scriptHelper);
		FlightConfirmationPage flightConfirmationPage = flightFinderPage.findFlights()
																		.selectFlights()
																		.bookFlights();
		
		verifyBooking(flightConfirmationPage, report);
		flightConfirmationPage.backToFlights();
	}
	
	private void verifyBooking(FlightConfirmationPage flightConfirmationPage,
														WebDriverReport report) {
		if(flightConfirmationPage.isTicketBooked()) {
			report.updateTestLog("Verify Booking", "Tickets booked successfully", Status.PASS, true);
			flightConfirmationPage.extractFlightConfirmationNumber();
		} else {
			report.updateTestLog("Verify Booking", "Tickets booking failed", Status.FAIL, true);
		}
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