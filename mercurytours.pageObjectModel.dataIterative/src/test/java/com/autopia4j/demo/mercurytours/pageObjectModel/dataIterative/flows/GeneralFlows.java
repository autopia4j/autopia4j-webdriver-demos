package com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.flows;

import com.autopia4j.demo.mercurytours.pageObjectModel.dataIterative.pages.SignOnPage;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ReusableLibrary;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * Class for storing general purpose reusable functions
 * @author vj
 */
public class GeneralFlows extends ReusableLibrary {
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularIterativeDriverScript}
	 */
	public GeneralFlows(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public SignOnPage invokeApplication() {
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
									properties.getProperty("application.url"), Status.DONE);
		
		driver.get(properties.getProperty("application.url"));
		
		return new SignOnPage(scriptHelper);
	}
}