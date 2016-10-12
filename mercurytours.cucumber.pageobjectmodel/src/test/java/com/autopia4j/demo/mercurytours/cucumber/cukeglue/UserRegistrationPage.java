package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;


/**
 * UserRegistrationPage class
 * @author vj
 */
public class UserRegistrationPage extends MasterPage {
	// UI Map object definitions
	
	// Text boxes
	private final By txtFirstName = By.name("firstName");
	private final By txtLastName = By.name("lastName");
	private final By txtPhone = By.name("phone");
	private final By txtEmail = By.name("userName");
	private final By txtAddressLine1 = By.name("address1");
	private final By txtCity = By.name("city");
	private final By txtState = By.name("state");
	private final By txtPostalCode = By.name("postalCode");
	private final By txtUsername = By.name("email");
	private final By txtPassword = By.name("password");
	private final By txtConfirmPassword = By.name("confirmPassword");
	
	//Buttons
	private final By btnRegister = By.name("register");
	
	
	@When("^I register a new user with the following details:$")
	public UserRegistrationConfirmationPage registerUser(DataTable userData) {
		clickRegister();
		
		Map<String, String> newUser = userData.asMap(String.class, String.class);
		
		driver.findElement(txtFirstName).sendKeys(newUser.get("FirstName"));
		driver.findElement(txtLastName).sendKeys(newUser.get("LastName"));
		driver.findElement(txtPhone).sendKeys(newUser.get("Phone"));
		driver.findElement(txtEmail).sendKeys(newUser.get("Email"));
		driver.findElement(txtAddressLine1).sendKeys(newUser.get("Address"));
		driver.findElement(txtCity).sendKeys(newUser.get("City"));
		driver.findElement(txtState).sendKeys(newUser.get("State"));
		driver.findElement(txtPostalCode).sendKeys(newUser.get("PostalCode"));
		driver.findElement(txtUsername).sendKeys(newUser.get("Username"));
		driver.findElement(txtPassword).sendKeys(newUser.get("Password"));
		driver.findElement(txtConfirmPassword).sendKeys(newUser.get("Password"));
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		driver.findElement(btnRegister).click();
		
		return new UserRegistrationConfirmationPage();
	}
}