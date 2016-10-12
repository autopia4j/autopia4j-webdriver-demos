package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import org.openqa.selenium.By;

import static org.testng.Assert.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * SignOnPage class
 * @author vj
 */
public class SignOnPage extends MasterPage {	
	// UI Map object definitions
	
	// Text boxes
	private final By txtUsername = By.name("userName");
	private final By txtPassword = By.name("password");
	
	// Buttons
	private final By btnLogin = By.name("login");
	
	
	@Then("^The application should stay on the login page, and not log me in")
	public void VerifyPageTitle() {
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driver.getTitle().contains("Welcome") || driver.getTitle().contains("Sign-on"));
	}
	
	@When("^I login using the valid username (.*) and the valid password (.*)$")
	public void loginWithValidUserValidPassword(String userNameData, String passwordData) {	
		login(userNameData, passwordData);
	}
	
	@When("^I login using the invalid username (.*) and the invalid password (.*)$")
	public void loginWithInvalidUserInvalidPassword(String userNameData, String passwordData) {	
		login(userNameData, passwordData);
	}
	
	@When("^I login using the valid username (.*) and the invalid password (.*)$")
	public void loginWithValidUserInvalidPassword(String userNameData, String passwordData) {	
		login(userNameData, passwordData);
	}
	
	private void login(String userNameData, String passwordData) {
		driver.findElement(txtUsername).sendKeys(userNameData);
		driver.findElement(txtPassword).sendKeys(passwordData);
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		driver.findElement(btnLogin).click();
	}
}