package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.utils.WebDriverUtil;

import cucumber.api.Scenario;

public abstract class MasterStepDefs {
	protected static Scenario currentScenario;
	protected static WebDriverTestParameters testParameters;
	
	protected static WebDriver driver;
	protected static WebDriverUtil driverUtil;
	protected static Properties properties;
	
	protected boolean isTextPresent(String textPattern) {
		if(driver.findElement(By.cssSelector("BODY")).getText().matches(textPattern)) {
			return true;
		} else {
			return false;
		}
	}
}