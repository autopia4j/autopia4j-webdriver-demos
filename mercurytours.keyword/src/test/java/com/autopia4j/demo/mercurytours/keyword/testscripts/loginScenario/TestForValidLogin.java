package com.autopia4j.demo.mercurytours.keyword.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordDriverScript;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordTestScript;


/**
 * Test for login with valid user credentials
 * @author vj
 */
public class TestForValidLogin extends KeywordTestScript {
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
				new WebDriverTestParameters(currentModule, currentTestcase);
		testParameters.setCurrentTestDescription("Test for login with valid user credentials");
		
		KeywordDriverScript driverScript = new KeywordDriverScript(testParameters);
		driverScript.driveTestExecution();
		
		tearDownTestRunner(testParameters, driverScript);
	}
}