package com.autopia4j.demo.mercurytours.keyword.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordDriverScript;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordTestScript;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends KeywordTestScript {
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
					new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		KeywordDriverScript driverScript = new KeywordDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
}