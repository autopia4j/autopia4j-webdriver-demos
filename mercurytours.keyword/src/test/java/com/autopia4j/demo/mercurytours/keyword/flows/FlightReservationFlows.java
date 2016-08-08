package com.autopia4j.demo.mercurytours.keyword.flows;

import com.autopia4j.demo.mercurytours.keyword.pages.BookFlightPage;
import com.autopia4j.demo.mercurytours.keyword.pages.FlightConfirmationPage;
import com.autopia4j.demo.mercurytours.keyword.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.keyword.pages.SelectFlightPage;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * Class for storing component groups related to the flight reservation functionality
 * @author vj
 */
public class FlightReservationFlows extends ReusableLibrary {
	/**
	 * Constructor to initialize the component group library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link KeywordDriverScript}
	 */
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