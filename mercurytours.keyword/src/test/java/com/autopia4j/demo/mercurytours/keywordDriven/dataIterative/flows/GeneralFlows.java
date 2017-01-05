package com.autopia4j.demo.mercurytours.keywordDriven.dataIterative.flows;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * Class for storing general purpose test flows
 * @author vj
 */
public class GeneralFlows extends ReusableLibrary {
	
	public GeneralFlows(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void invokeApplication() {
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
									properties.getProperty("application.url"), Status.DONE);
		
		driver.get(properties.getProperty("application.url"));
	}
}