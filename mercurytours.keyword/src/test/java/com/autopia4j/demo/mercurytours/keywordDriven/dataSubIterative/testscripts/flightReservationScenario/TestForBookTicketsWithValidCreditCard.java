package com.autopia4j.demo.mercurytours.keywordDriven.dataSubIterative.testscripts.flightReservationScenario;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.keywordDriven.dataSubIterative.testscripts.TestConfigurations;
import com.autopia4j.framework.core.IterationOptions;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataSubIterative.KeywordSubIterativeDriverScript;
import com.autopia4j.framework.webdriver.impl.keywordDriven.dataSubIterative.KeywordSubIterativeTestScript;


/**
 * Test for book flight tickets and verify booking
 * @author vj
 */
public class TestForBookTicketsWithValidCreditCard extends KeywordSubIterativeTestScript {
	
	@Test(dataProvider="DesktopBrowsers", dataProviderClass=TestConfigurations.class)
	public void testRunner(String testInstance, ExecutionMode executionMode,
							String deviceName, Browser browser, Platform platform) {
		WebDriverTestParameters testParameters =
					new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for book flight tickets and verify booking");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setDeviceName(deviceName);
		testParameters.setBrowser(browser);
		testParameters.setPlatform(platform);
		
		KeywordSubIterativeDriverScript driverScript = new KeywordSubIterativeDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
}