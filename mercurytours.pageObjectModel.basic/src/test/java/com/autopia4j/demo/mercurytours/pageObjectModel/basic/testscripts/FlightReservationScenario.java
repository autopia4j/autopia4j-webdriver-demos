package com.autopia4j.demo.mercurytours.pageObjectModel.basic.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel.CreditCard;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel.FlightJourney;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel.Passenger;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel.User;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.pageObjectModel.basic.pages.SignOnPage;
import com.autopia4j.framework.assertions.TestNgWrappedAssertion;
import com.autopia4j.framework.webdriver.core.ScriptHelper;
import com.autopia4j.framework.webdriver.impl.modular.basic.ModularBasicTestScript;
import com.autopia4j.framework.webdriver.reporting.WebDriverReport;

public class FlightReservationScenario extends ModularBasicTestScript {
	
	@BeforeMethod
	public void setUp() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		report.addTestLogSection("Setup");
		
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		SignOnPage signOnPage = generalFlows.invokeApplication();
		
		User validUser = new User();
		validUser.setUserName("mercury");
		validUser.setPassword("mercury");
		
		signOnPage.loginAsValidUser(validUser);
	}
	
	@Test
	public void testForBookTicketsWithValidCreditCard() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		WebDriverReport report = scriptHelper.getReport();
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(report);
		report.addTestLogSection("Book flight tickets");
		
		FlightFinderPage flightFinderPage = new FlightFinderPage(scriptHelper);
		
		FlightJourney flightJourney = getFlightJourney();
		List<Passenger> passengers = getPassengers();
		CreditCard creditCard = getCreditCard();
		
		FlightConfirmationPage flightConfirmationPage = flightFinderPage.findFlights(flightJourney, passengers.size())
																		.selectFlights()
																		.bookFlights(passengers, creditCard);
		
		strongly.assertTrue(flightConfirmationPage.isTicketBooked(), "Is ticket booked?");
		flightConfirmationPage.extractFlightConfirmationNumber();
		flightConfirmationPage.backToFlights();
	}
	
	private FlightJourney getFlightJourney() {
		FlightJourney flightJourney = new FlightJourney();
		flightJourney.setOrigin("London");
		flightJourney.setDestination("Paris");
		flightJourney.setDepartureMonth("July");
		flightJourney.setDepartureDay("23");
		flightJourney.setReturnMonth("July");
		flightJourney.setReturnDay("29");
		flightJourney.setAirline("Unified Airlines");
		return flightJourney;
	}
	
	private List<Passenger> getPassengers() {
		List<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger1 = new Passenger();
		passenger1.setFirstName("QA");
		passenger1.setLastName("Automation");
		passengers.add(passenger1);
		return passengers;
	}
	
	private CreditCard getCreditCard() {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardType("Visa");
		creditCard.setCardNumber("9876543210");
		return creditCard;
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