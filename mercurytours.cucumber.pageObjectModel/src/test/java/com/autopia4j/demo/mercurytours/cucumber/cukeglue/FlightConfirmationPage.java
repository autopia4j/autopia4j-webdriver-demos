package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import static org.testng.Assert.*;


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
	
	
	@Then("^I should get a booking confirmation with a confirmation number$")
	public void verifyBooking() {
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driverUtil.isTextPresent("^[\\s\\S]*Your itinerary has been booked![\\s\\S]*$"));
		
		WebElement flightConfirmation = driver.findElement(lblConfirmationMessage);
		
		String flightConfirmationNumber = flightConfirmation.getText();
		flightConfirmationNumber = flightConfirmationNumber.split("#")[1].trim();
		currentScenario.write("The confirmation number is: " + flightConfirmationNumber);
	}
	
	public void backToFlights() {
		driver.findElement(imgFlights).click();
	}
}