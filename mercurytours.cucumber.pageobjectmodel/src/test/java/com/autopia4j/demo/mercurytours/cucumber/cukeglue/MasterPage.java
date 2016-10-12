package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.utils.WebDriverUtil;

import cucumber.api.Scenario;


/**
 * MasterPage Abstract class
 * @author vj
 */
abstract class MasterPage {	
	protected static Scenario currentScenario;
	protected static WebDriverTestParameters testParameters;
	
	protected static WebDriver driver;
	protected static WebDriverUtil driverUtil;
	protected static Properties properties;
	
	protected static int passengerCount;
	
	// UI Map object definitions
	
	// Links
	protected final By lnkSignOff = By.linkText("SIGN-OFF");
	protected final By lnkRegister = By.linkText("REGISTER");
	
	
	protected void clickRegister() {
		driver.findElement(lnkRegister).click();
	}
}