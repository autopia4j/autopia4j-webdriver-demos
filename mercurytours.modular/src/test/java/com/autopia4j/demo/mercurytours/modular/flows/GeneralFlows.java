package com.autopia4j.demo.mercurytours.modular.flows;

import com.autopia4j.demo.mercurytours.modular.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.modular.pages.SignOnPage;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.utils.FrameworkException;
import com.autopia4j.framework.webdriver.ReusableLibrary;
import com.autopia4j.framework.webdriver.ScriptHelper;


/**
 * Class for storing general purpose reusable functions
 * @author vj
 */
public class GeneralFlows extends ReusableLibrary {
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public GeneralFlows(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public SignOnPage invokeApplication() {
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
									properties.getProperty("ApplicationUrl"), Status.DONE);
		
		driver.get(properties.getProperty("ApplicationUrl"));
		
		return new SignOnPage(scriptHelper);
	}
	
	public void verifyLoginSuccessful(FlightFinderPage flightFinderPage) {
		if(flightFinderPage.isUserSignedOn()) {
			report.updateTestLog("Verify Login", "Login succeeded for valid user", Status.PASS, true);
		} else {
			frameworkParameters.setStopExecution(true);
			throw new FrameworkException("Verify Login", "Login failed for valid user");
		}
	}
}