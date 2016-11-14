package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static org.testng.Assert.*;


/**
 * UserRegistrationConfirmationPage class
 * @author vj
 */
public class UserRegistrationConfirmationPage extends MasterPage {
	// UI Map object definitions
	
	// Links
	private final By lnkSignIn = By.linkText("sign-in");
	
	
	@Then("^I should get a confirmation on successful registration$")
	public void verifyRegistration() {
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driverUtil.isTextPresent("^[\\s\\S]*Thank you for registering.[\\s\\S]*$"));
	}
	
	@And("^I click on the sign in link$")
	public void clickSignIn() {
		driver.findElement(lnkSignIn).click();
	}
}