package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.ScriptHelper;


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
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link KeywordDriverScript}
	 */
	public SelectFlightPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	
	public void selectFlights() {
		report.updateTestLog("Select Flights", "Select the first available flights", Status.DONE, true);
		driver.findElement(btnContinue).click();
	}
}