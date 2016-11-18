package com.autopia4j.demo.mercurytours.basic.pages;

import org.openqa.selenium.By;

import com.autopia4j.demo.mercurytours.basic.datamodel.FlightJourney;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * FlightFinderPage class
 * @author vj
 */
public class FlightFinderPage extends MasterPage {
	
	// UI Map object definitions
	
	// Combo boxes
	private final By cmbPassengerCount = By.name("passCount");
	private final By cmbDepartFrom = By.name("fromPort");
	private final By cmbDepartMonth = By.name("fromMonth");
	private final By cmbDepartDate = By.name("fromDay");
	private final By cmbArriveAt = By.name("toPort");
	private final By cmbArriveMonth = By.name("toMonth");
	private final By cmbArriveDate = By.name("toDay");
	private final By cmbAirline = By.name("airline");
	
	// Buttons
	private final By btnContinue = By.name("findFlights");
	
	
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public FlightFinderPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Find a Flight")) {
			report.updateTestLog("Verify page title", "Find a Flight page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public SelectFlightPage findFlights(FlightJourney flightJourney, int passengerCount) {
		report.updateTestLog("Enter Search Criteria", "Enter the search criteria to search for flights", Status.DONE);
		
		driver.findElement(cmbPassengerCount).sendKeys(String.valueOf(passengerCount));
		driver.findElement(cmbDepartFrom).sendKeys(flightJourney.getOrigin());
		driver.findElement(cmbDepartMonth).sendKeys(flightJourney.getDepartureMonth());
		driver.findElement(cmbDepartDate).sendKeys(flightJourney.getDepartureDay());
		driver.findElement(cmbArriveAt).sendKeys(flightJourney.getDestination());
		driver.findElement(cmbArriveMonth).sendKeys(flightJourney.getArrivalMonth());
		driver.findElement(cmbArriveDate).sendKeys(flightJourney.getArrivalDay());
		driver.findElement(cmbAirline).sendKeys(flightJourney.getAirline());
		
		report.updateTestLog("Find Flights", "Click on find flights", Status.DONE, true);
		driver.findElement(btnContinue).click();
		
		return new SelectFlightPage(scriptHelper);
	}
}