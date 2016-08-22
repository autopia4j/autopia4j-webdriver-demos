package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * FlightConfirmationPage class
 * @author vj
 */
public class FlightConfirmationPage extends ReusableLibrary {
	// UI Map object definitions
	
	// Labels
	private final By lblConfirmationMessage =
									By.cssSelector("font > font > b > font");
									// By.xpath("//font/font/b/font");
	
	// Images
	private final By imgFlights = By.xpath("//a/img");
	
	
	public FlightConfirmationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void verifyBooking() {
		if(driverUtil.isTextPresent("^[\\s\\S]*Your itinerary has been booked![\\s\\S]*$")) {
			report.updateTestLog("Verify Booking", "Tickets booked successfully", Status.PASS, true);
			
			WebElement flightConfirmation = driver.findElement(lblConfirmationMessage);
			
			String flightConfirmationNumber = flightConfirmation.getText();
			flightConfirmationNumber = flightConfirmationNumber.split("#")[1].trim();
			dataTable.putData("Flights_Data", "FlightConfirmationNumber", flightConfirmationNumber);
			report.updateTestLog("Flight Confirmation",
									"The flight confirmation number is " + flightConfirmationNumber,
									Status.DONE);
		} else {
			report.updateTestLog("Verify Booking", "Tickets booking failed", Status.FAIL, true);
		}
	}
	
	public void backToFlights() {
		driver.findElement(imgFlights).click();
	}
}