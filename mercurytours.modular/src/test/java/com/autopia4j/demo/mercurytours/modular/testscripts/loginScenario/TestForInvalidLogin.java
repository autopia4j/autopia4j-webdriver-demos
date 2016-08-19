package com.autopia4j.demo.mercurytours.modular.testscripts.loginScenario;

import org.openqa.selenium.Platform;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.modular.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.modular.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.modular.testscripts.TestConfigurations;
import com.autopia4j.framework.core.IterationOptions;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.modular.ModularDriverScript;
import com.autopia4j.framework.webdriver.impl.modular.ModularTestScript;


/**
 * Test for login with invalid user credentials
 * @author vj
 */
public class TestForInvalidLogin extends ModularTestScript {
	private SignOnPage signOnPage;
	
	@Test(dataProvider="DesktopBrowsers", dataProviderClass=TestConfigurations.class)
	public void testRunner(String testInstance, ExecutionMode executionMode,
							String deviceName, Browser browser, Platform platform) {
		WebDriverTestParameters testParameters =
									new WebDriverTestParameters(currentModule, currentTest);
		testParameters.setCurrentTestDescription("Test for login with invalid user credentials");
		testParameters.setIterationMode(IterationOptions.RUN_ONE_ITERATION_ONLY);
		
		testParameters.setCurrentTestInstance(testInstance);
		testParameters.setExecutionMode(executionMode);
		testParameters.setDeviceName(deviceName);
		testParameters.setBrowser(browser);
		testParameters.setPlatform(platform);
		
		ModularDriverScript driverScript = new ModularDriverScript(testParameters);
		driverScript.driveTestExecution();
		assertTestPassed(driverScript);
	}
	
	@Override
	public void setUp() {
		report.addTestLogSection("Setup");
		
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		signOnPage = generalFlows.invokeApplication();
	}
	
	@Override
	public void executeTest() {
		signOnPage = signOnPage.loginAsInvalidUser();
		
		// Verify login failed for invalid user
		if(!signOnPage.isUserSignedOn()) {
			report.updateTestLog("Verify Login", "Login failed for invalid user", Status.PASS, true);
		} else {
			report.updateTestLog("Verify Login", "Login succeeded for invalid user", Status.FAIL, true);
			signOnPage.logout();
		}
	}
	
	@Override
	public void tearDown() {
		// Nothing to do
	}
}