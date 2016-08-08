package com.autopia4j.demo.mercurytours.keyword.testscripts.loginScenario;

import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.keyword.testscripts.TestConfigurations;
import com.autopia4j.framework.core.IterationOptions;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordDriverScript;
import com.autopia4j.framework.webdriver.impl.keyword.TestScript;


/**
 * Test for login with invalid user credentials
 * @author vj
 */
public class TestForInvalidLogin extends TestScript {
	
	@Test(dataProvider="DesktopBrowsers", dataProviderClass=TestConfigurations.class)
	public void testRunner(String testInstance, ExecutionMode executionMode,
				String deviceName, Browser browser, int startIteration, int endIteration) {
		WebDriverTestParameters testParameters =
						new WebDriverTestParameters(currentModule, currentTestcase);
		testParameters.setCurrentTestDescription("Test for login with invalid user credentials");
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setDeviceName(deviceName);
		testParameters.setBrowser(browser);
		testParameters.setIterationMode(IterationOptions.RUN_RANGE_OF_ITERATIONS);
		testParameters.setStartIteration(startIteration);
		testParameters.setEndIteration(endIteration);
		
		KeywordDriverScript driverScript = new KeywordDriverScript(testParameters);
		driverScript.driveTestExecution();
		
		tearDownTestRunner(testParameters, driverScript);
	}
}