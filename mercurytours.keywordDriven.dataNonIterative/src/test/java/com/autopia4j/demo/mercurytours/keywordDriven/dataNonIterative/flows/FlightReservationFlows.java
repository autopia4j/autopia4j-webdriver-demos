package com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.flows;

import com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.pages.BookFlightPage;
import com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.pages.SelectFlightPage;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * Class for storing test flows related to the flight reservation functionality
 * @author vj
 */
public class FlightReservationFlows extends ReusableLibrary {
	
	public FlightReservationFlows(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void findAndBookFlights() {
		FlightFinderPage flightFinderPage = new FlightFinderPage(scriptHelper);
		SelectFlightPage selectFlightPage = new SelectFlightPage(scriptHelper);
		BookFlightPage bookFlightPage = new BookFlightPage(scriptHelper);
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(scriptHelper);
		
		flightFinderPage.findFlights();
		selectFlightPage.selectFlights();
		bookFlightPage.bookFlights();
		flightConfirmationPage.verifyBooking();
		flightConfirmationPage.backToFlights();
	}
}