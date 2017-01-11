package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import java.util.Map;

import org.openqa.selenium.By;

import com.autopia4j.framework.webdriver.impl.cucumber.MasterStepDefs;

import static org.testng.Assert.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterUserStepDefs extends MasterStepDefs {
	
	@When("^I register a new user with the following details:$")
	public void registerUser(DataTable userData) {
		Map<String, String> newUser = userData.asMap(String.class, String.class);
		
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys(newUser.get("FirstName"));
		driver.findElement(By.name("lastName")).sendKeys(newUser.get("LastName"));		
		driver.findElement(By.name("phone")).sendKeys(newUser.get("Phone"));		
		driver.findElement(By.name("userName")).sendKeys(newUser.get("Email"));	
		driver.findElement(By.name("address1")).sendKeys(newUser.get("Address"));
		driver.findElement(By.name("city")).sendKeys(newUser.get("City"));
		driver.findElement(By.name("state")).sendKeys(newUser.get("State"));
		driver.findElement(By.name("postalCode")).sendKeys(newUser.get("PostalCode"));
		driver.findElement(By.name("email")).sendKeys(newUser.get("Username"));
		driver.findElement(By.name("password")).sendKeys(newUser.get("Password"));
		driver.findElement(By.name("confirmPassword")).sendKeys(newUser.get("Password"));
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		driver.findElement(By.name("register")).click();
	}
	
	@Then("^I should get a confirmation on successful registration$")
	public void i_should_get_registration_confirmation() {
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		assertTrue(driverUtil.isTextPresent("^[\\s\\S]*Thank you for registering.[\\s\\S]*$"));
	}
}