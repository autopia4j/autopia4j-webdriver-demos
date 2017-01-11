package com.autopia4j.demo.mercurytours.keywordDriven.dataSubIterative.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataSubIterative.KeywordSubIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataSubIterative.KeywordSubIterativeTestScript;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends KeywordSubIterativeTestScript {
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
					new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		KeywordSubIterativeDriverScript driverScript = new KeywordSubIterativeDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
}