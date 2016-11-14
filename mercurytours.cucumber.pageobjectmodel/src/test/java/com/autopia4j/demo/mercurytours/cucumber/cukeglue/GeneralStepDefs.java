package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Given;

public class GeneralStepDefs extends MasterPage {

	@Given("^I am in the login page of the application$")
	public void openApplication() {
		driver.get(properties.getProperty("application.url"));
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driver.getTitle().contains("Welcome") ||
						driver.getTitle().contains("Sign-on"));
	}
}