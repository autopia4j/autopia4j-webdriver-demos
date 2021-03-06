package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import static org.testng.Assert.assertTrue;

import com.autopia4j.framework.webdriver.impl.cucumber.MasterStepDefs;

import cucumber.api.java.en.Given;

public class GeneralStepDefs extends MasterStepDefs {

	@Given("^I am in the login page of the application$")
	public void i_am_in_login_page() {
		driver.get(properties.getProperty("application.url"));
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driver.getTitle().contains("Welcome") ||
						driver.getTitle().contains("Sign-on"));
	}
}