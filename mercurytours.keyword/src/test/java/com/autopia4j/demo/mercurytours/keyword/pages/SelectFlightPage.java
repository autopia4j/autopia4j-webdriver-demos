package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * SelectFlightPage class
 * @author vj
 */
public class SelectFlightPage extends ReusableLibrary {
	// UI Map object definitions

	// Buttons
	private final By btnContinue = By.name("reserveFlights");
	
	
	public SelectFlightPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	
	public void selectFlights() {
		report.updateTestLog("Select Flights", "Select the first available flights", Status.DONE, true);
		driver.findElement(btnContinue).click();
	}
}