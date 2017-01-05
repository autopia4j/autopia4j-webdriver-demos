package com.autopia4j.demo.mercurytours.keywordDriven.dataIterative.testscripts.flightReservationScenario;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.keywordDriven.dataIterative.testscripts.TestConfigurations;
import com.autopia4j.framework.core.IterationOptions;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordDriverScript;
import com.autopia4j.framework.webdriver.impl.keyword.KeywordTestScript;


/**
 * Test for book flight tickets and verify booking
 * @author vj
 */
public class TestForBookTicketsWithValidCreditCard extends KeywordTestScript {
	
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
		
		KeywordDriverScript driverScript = new KeywordDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
}