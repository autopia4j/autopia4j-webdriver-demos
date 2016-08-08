package com.autopia4j.demo.mercurytours.keyword.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.framework.webdriver.Browser;
import com.autopia4j.framework.webdriver.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.keyword.KeywordDriverScript;
import com.autopia4j.framework.webdriver.keyword.TestCase;


/**
 * Test for login with newly registered user
 * @author vj
 */
public class TestForLoginWithNewlyRegisteredUser extends TestCase {
	
	@Test
	public void testRunner() {
		WebDriverTestParameters testParameters =
					new WebDriverTestParameters(currentModule, currentTestcase);
		testParameters.setCurrentTestDescription("Test for login with newly registered user");
		testParameters.setBrowser(Browser.CHROME);
		
		KeywordDriverScript driverScript = new KeywordDriverScript(testParameters);
		driverScript.driveTestExecution();
		
		tearDownTestRunner(testParameters, driverScript);
	}
}