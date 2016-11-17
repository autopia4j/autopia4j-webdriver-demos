package com.autopia4j.demo.mercurytours.keyword.flows;

import com.autopia4j.demo.mercurytours.keyword.pages.MasterPage;
import com.autopia4j.framework.core.AutopiaException;
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
	
	public void verifyLoginSuccessful() {
		MasterPage masterPage = new MasterPage(scriptHelper);
		
		if(masterPage.isUserSignedOn()) {
			report.updateTestLog("Verify Login", "Login succeeded for valid user", Status.PASS, true);
		} else {
			frameworkParameters.setStopExecution(true);
			throw new AutopiaException("Verify Login", "Login failed for valid user");
		}
	}
	
	public void verifyLoginFailed() {
		MasterPage masterPage = new MasterPage(scriptHelper);
		
		if(!masterPage.isUserSignedOn()) {
			report.updateTestLog("Verify Login", "Login failed for invalid user", Status.PASS, true);
		} else {
			report.updateTestLog("Verify Login", "Login succeeded for invalid user", Status.FAIL);
		}
	}
}