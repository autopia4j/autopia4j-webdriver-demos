package com.autopia4j.demo.mercurytours.modular.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * FlightFinderPage class
 * @author vj
 */
public class FlightFinderPage extends MasterPage {
	private static final String FLIGHTS_DATA = "Flights_Data";
	private static final String PASSENGER_DATA = "Passenger_Data";
	
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
	
	public SelectFlightPage findFlights() {
		report.updateTestLog("Enter Search Criteria", "Enter the search criteria to search for flights", Status.DONE);
		
		driver.findElement(cmbPassengerCount).sendKeys(dataTable.getData(PASSENGER_DATA, "PassengerCount"));
		driver.findElement(cmbDepartFrom).sendKeys(dataTable.getData(FLIGHTS_DATA,"FromPort"));
		driver.findElement(cmbDepartMonth).sendKeys(dataTable.getData(FLIGHTS_DATA,"FromMonth"));
		driver.findElement(cmbDepartDate).sendKeys(dataTable.getData(FLIGHTS_DATA,"FromDay"));
		driver.findElement(cmbArriveAt).sendKeys(dataTable.getData(FLIGHTS_DATA,"ToPort"));
		driver.findElement(cmbArriveMonth).sendKeys(dataTable.getData(FLIGHTS_DATA,"ToMonth"));
		driver.findElement(cmbArriveDate).sendKeys(dataTable.getData(FLIGHTS_DATA,"ToDay"));
		driver.findElement(cmbAirline).sendKeys(dataTable.getData(FLIGHTS_DATA,"Airline"));
		
		report.updateTestLog("Find Flights", "Click on find flights", Status.DONE, true);
		driver.findElement(btnContinue).click();
		
		return new SelectFlightPage(scriptHelper);
	}
}