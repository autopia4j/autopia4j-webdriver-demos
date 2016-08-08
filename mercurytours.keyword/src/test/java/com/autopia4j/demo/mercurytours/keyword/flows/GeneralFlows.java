package com.autopia4j.demo.mercurytours.keyword.flows;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.ReusableLibrary;
import com.autopia4j.framework.webdriver.ScriptHelper;


/**
 * Class for storing component groups related to the flight reservation functionality
 * @author vj
 */
public class GeneralFlows extends ReusableLibrary {
	/**
	 * Constructor to initialize the component group library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link KeywordDriverScript}
	 */
	public GeneralFlows(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void invokeApplication() {
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
									properties.getProperty("ApplicationUrl"), Status.DONE);
		
		driver.get(properties.getProperty("ApplicationUrl"));
	}
}