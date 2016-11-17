package com.autopia4j.demo.mercurytours.simple.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * UserRegistrationPage class
 * @author vj
 */
public class UserRegistrationPage extends MasterPage {
	private static final String GENERAL_DATA = "General_Data";
	private static final String REGISTER_USER_DATA = "RegisterUser_Data";
	
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
	
	public UserRegistrationConfirmationPage registerUser() {
		report.updateTestLog("Enter user details", "Enter new user details for registration", Status.DONE);
		driver.findElement(txtFirstName).sendKeys(dataTable.getData(REGISTER_USER_DATA,"FirstName"));
		driver.findElement(txtLastName).sendKeys(dataTable.getData(REGISTER_USER_DATA,"LastName"));		
		driver.findElement(txtPhone).sendKeys(dataTable.getData(REGISTER_USER_DATA,"Phone"));		
		driver.findElement(txtEmail).sendKeys(dataTable.getData(REGISTER_USER_DATA,"Email"));	
		driver.findElement(txtAddressLine1).sendKeys(dataTable.getData(REGISTER_USER_DATA,"Address"));
		driver.findElement(txtCity).sendKeys(dataTable.getData(REGISTER_USER_DATA,"City"));
		driver.findElement(txtState).sendKeys(dataTable.getData(REGISTER_USER_DATA,"State"));
		driver.findElement(txtPostalCode).sendKeys(dataTable.getData(REGISTER_USER_DATA,"PostalCode"));
		driver.findElement(txtUsername).sendKeys(dataTable.getData(GENERAL_DATA, "Username"));
		String password = dataTable.getData(GENERAL_DATA, "Password");
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(txtConfirmPassword).sendKeys(password);
		
		report.updateTestLog("Register", "Click on Register User", Status.DONE, true);
		driver.findElement(btnRegister).click();
		
		return new UserRegistrationConfirmationPage(scriptHelper);
	}
}