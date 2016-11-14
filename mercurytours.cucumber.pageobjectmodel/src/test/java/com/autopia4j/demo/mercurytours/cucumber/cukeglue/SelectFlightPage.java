package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;



/**
 * SelectFlightPage class
 * @author vj
 */
public class SelectFlightPage extends MasterPage {
	// UI Map object definitions
	
	// Buttons
	private final By btnContinue = By.name("reserveFlights");
	
	
	@And("^I select the first available flight$")
	public void selectFlights() {
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		driver.findElement(btnContinue).click();
	}
}