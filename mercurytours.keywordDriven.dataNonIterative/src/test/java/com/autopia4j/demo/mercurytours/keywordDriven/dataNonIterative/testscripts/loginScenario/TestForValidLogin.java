package com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataNonIterative.KeywordNonIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataNonIterative.KeywordNonIterativeTestScript;


/**
 * Test for login with valid user credentials
 * @author vj
 */
public class TestForValidLogin extends KeywordNonIterativeTestScript {
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
				new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with valid user credentials");
		
		KeywordNonIterativeDriverScript driverScript = new KeywordNonIterativeDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
}