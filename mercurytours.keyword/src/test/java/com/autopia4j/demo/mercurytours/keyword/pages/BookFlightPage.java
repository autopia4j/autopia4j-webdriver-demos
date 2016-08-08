package com.autopia4j.demo.mercurytours.keyword.pages;

import org.openqa.selenium.By;

import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * BookFlightPage class
 * @author vj
 */
public class BookFlightPage extends MasterPage {
	private static final String PASSENGER_DATA = "Passenger_Data";
	
	// UI Map object definitions
	
	// Text boxes
	private final String txtFirstName = "passFirst";
	private final String txtLastName = "passLast";
	private final By txtCardNo = By.name("creditnumber");
	
	// Combo boxes
	private final By cmbCreditCard = By.name("creditCard");
	
	// Buttons
	private final By btnSecurePurchase = By.name("buyFlights");
	
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link KeywordDriverScript}
	 */
	public BookFlightPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	
	public void bookFlights() {
		report.updateTestLog("Enter Passenger Details", "Enter passenger details", Status.DONE);
		
		String[] passengerFirstNames = dataTable.getData(PASSENGER_DATA, "PassengerFirstNames").split(",");
		String[] passengerLastNames = dataTable.getData(PASSENGER_DATA, "PassengerLastNames").split(",");
		int passengerCount = Integer.parseInt(dataTable.getData(PASSENGER_DATA, "PassengerCount"));
		
		for(int i=0; i<passengerCount; i++) {
			driver.findElement(By.name(txtFirstName + i)).sendKeys(passengerFirstNames[i]);
			driver.findElement(By.name(txtLastName + i)).sendKeys(passengerLastNames[i]);
		}
		
		driver.findElement(cmbCreditCard).sendKeys(dataTable.getData(PASSENGER_DATA, "CreditCard"));
		driver.findElement(txtCardNo).sendKeys(dataTable.getData(PASSENGER_DATA, "CreditNumber"));
		
		report.updateTestLog("Book Tickets", "Click on book tickets", Status.DONE, true);
		driver.findElement(btnSecurePurchase).click();
		driverUtil.waitFor(500);	// to avoid StaleElementException (no idea why it occurs!)
	}
}