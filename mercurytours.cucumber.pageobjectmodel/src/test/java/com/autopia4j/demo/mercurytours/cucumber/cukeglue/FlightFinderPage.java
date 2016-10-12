package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


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
	
	
	@Then("^The application should log me in and navigate to the Flight Finder page")
	public void VerifyPageTitle() {
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driver.getTitle().contains("Find a Flight"));
	}
	
	@Given("^I search for flights using the following criteria:$")
	public void findFlights(DataTable searchCriteriaData) {
		List<Map<String, String>> searchCriteria =
				searchCriteriaData.asMaps(String.class, String.class);
		Map<String,String> searchCriteria1 = searchCriteria.get(0);
		
		passengerCount = Integer.parseInt(searchCriteria1.get("PassengerCount"));
		
		driver.findElement(cmbPassengerCount).sendKeys(searchCriteria1.get("PassengerCount"));
		driver.findElement(cmbDepartFrom).sendKeys(searchCriteria1.get("FromPort"));
		driver.findElement(cmbDepartMonth).sendKeys(searchCriteria1.get("FromMonth"));
		driver.findElement(cmbDepartDate).sendKeys(searchCriteria1.get("FromDate"));
		driver.findElement(cmbArriveAt).sendKeys(searchCriteria1.get("ToPort"));
		driver.findElement(cmbArriveMonth).sendKeys(searchCriteria1.get("ToMonth"));
		driver.findElement(cmbArriveDate).sendKeys(searchCriteria1.get("ToDate"));
		driver.findElement(cmbAirline).sendKeys(searchCriteria1.get("Airline"));
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		driver.findElement(btnContinue).click();
	}
}