package com.autopia4j.demo.mercurytours.keywordDriven.dataNonIterative.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataNonIterative.KeywordNonIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataNonIterative.KeywordNonIterativeTestScript;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends KeywordNonIterativeTestScript {
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
					new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		KeywordNonIterativeDriverScript driverScript = new KeywordNonIterativeDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
}