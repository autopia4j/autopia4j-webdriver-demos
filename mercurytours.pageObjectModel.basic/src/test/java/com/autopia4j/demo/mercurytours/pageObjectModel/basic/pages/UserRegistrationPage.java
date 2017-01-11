package com.autopia4j.demo.mercurytours.pageObjectModel.basic.pages;

import org.openqa.selenium.By;

import com.autopia4j.demo.mercurytours.pageObjectModel.basic.datamodel.User;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


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
	
	
	/**
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public UserRegistrationPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Register")) {
			report.updateTestLog("Verify page title", "User Registration page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public UserRegistrationConfirmationPage registerUser(User user) {
		report.updateTestLog("Enter user details", "Enter new user details for registration", Status.DONE);
		driver.findElement(txtFirstName).sendKeys(user.getFirstName());
		driver.findElement(txtLastName).sendKeys(user.getLastName());		
		driver.findElement(txtPhone).sendKeys(user.getPhone());		
		driver.findElement(txtEmail).sendKeys(user.getEmail());	
		driver.findElement(txtAddressLine1).sendKeys(user.getAddressLine1());
		driver.findElement(txtCity).sendKeys(user.getCity());
		driver.findElement(txtState).sendKeys(user.getState());
		driver.findElement(txtPostalCode).sendKeys(user.getPostalCode());
		driver.findElement(txtUsername).sendKeys(user.getUserName());
		driver.findElement(txtPassword).sendKeys(user.getPassword());
		driver.findElement(txtConfirmPassword).sendKeys(user.getPassword());
		
		report.updateTestLog("Register", "Click on Register User", Status.DONE, true);
		driver.findElement(btnRegister).click();
		
		return new UserRegistrationConfirmationPage(scriptHelper);
	}
}