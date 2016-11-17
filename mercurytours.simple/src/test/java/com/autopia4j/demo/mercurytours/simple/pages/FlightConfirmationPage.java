package com.autopia4j.demo.mercurytours.simple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * FlightConfirmationPage class
 * @author vj
 */
public class FlightConfirmationPage extends MasterPage {
	// UI Map object definitions
	
	// Labels
	private final By lblConfirmationMessage =
									By.cssSelector("font > font > b > font");
									// By.xpath("//font/font/b/font");
	
	// Images
	private final By imgFlights = By.xpath("//a/img");
	
	
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public FlightConfirmationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Flight Confirmation")) {
			report.updateTestLog("Verify page title", "Flight Confirmation page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public Boolean isTicketBooked() {
		return driverUtil.isTextPresent("^[\\s\\S]*Your itinerary has been booked![\\s\\S]*$");
	}
	
	public FlightConfirmationPage extractFlightConfirmationNumber() {
		WebElement flightConfirmation = driver.findElement(lblConfirmationMessage);
		
		String flightConfirmationNumber = flightConfirmation.getText();
		flightConfirmationNumber = flightConfirmationNumber.split("#")[1].trim();
		dataTable.putData("Flights_Data", "FlightConfirmationNumber", flightConfirmationNumber);
		report.updateTestLog("Flight Confirmation",
								"The flight confirmation number is " + flightConfirmationNumber,
								Status.DONE);
		
		return this;	// No need to instantiate a new object, since there is no actual page navigation involved here
	}
	
	public FlightFinderPage backToFlights() {
		driver.findElement(imgFlights).click();
		return new FlightFinderPage(scriptHelper);
	}
}