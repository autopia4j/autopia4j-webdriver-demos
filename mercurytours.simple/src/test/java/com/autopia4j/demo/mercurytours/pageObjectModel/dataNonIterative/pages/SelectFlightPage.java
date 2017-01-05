package com.autopia4j.demo.mercurytours.pageObjectModel.dataNonIterative.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * SelectFlightPage class
 * @author vj
 */
public class SelectFlightPage extends MasterPage {
	// UI Map object definitions

	// Buttons
	private final By btnContinue = By.name("reserveFlights");
	
	
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public SelectFlightPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Select a Flight")) {
			report.updateTestLog("Verify page title", "Select a Flight page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public BookFlightPage selectFlights() {
		report.updateTestLog("Select Flights", "Select the first available flights", Status.DONE, true);
		driver.findElement(btnContinue).click();
		
		return new BookFlightPage(scriptHelper);
	}
}