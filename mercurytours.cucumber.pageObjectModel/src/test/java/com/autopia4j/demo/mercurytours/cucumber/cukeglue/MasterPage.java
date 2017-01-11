package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import org.openqa.selenium.By;
import com.autopia4j.framework.webdriver.impl.cucumber.MasterStepDefs;


/**
 * MasterPage Abstract class
 * @author vj
 */
abstract class MasterPage extends MasterStepDefs {
	
	protected static int passengerCount;
	
	// UI Map object definitions
	
	// Links
	protected final By lnkSignOff = By.linkText("SIGN-OFF");
	protected final By lnkRegister = By.linkText("REGISTER");
	
	protected void clickRegister() {
		driver.findElement(lnkRegister).click();
	}
}