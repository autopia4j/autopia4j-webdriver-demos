package com.autopia4j.demo.mercurytours.basic.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.autopia4j.demo.mercurytours.basic.datamodel.CreditCard;
import com.autopia4j.demo.mercurytours.basic.datamodel.Passenger;
import com.autopia4j.framework.reporting.Status;
import com.autopia4j.framework.webdriver.core.ScriptHelper;


/**
 * BookFlightPage class
 * @author vj
 */
public class BookFlightPage extends MasterPage {
	
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
	 * Constructor to initialize the page
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link ModularDriverScript}
	 */
	public BookFlightPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		
		if(!driver.getTitle().contains("Book a Flight")) {
			report.updateTestLog("Verify page title", "Book a Flight page expected, but not displayed!", Status.WARNING, true);
		}
	}
	
	public FlightConfirmationPage bookFlights(List<Passenger> passengers, CreditCard creditCard) {
		report.updateTestLog("Enter Passenger Details", "Enter passenger details", Status.DONE);
		
		for(int i=0; i<passengers.size(); i++) {
			driver.findElement(By.name(txtFirstName + i)).sendKeys(passengers.get(i).getFirstName());
			driver.findElement(By.name(txtLastName + i)).sendKeys(passengers.get(i).getLastName());
		}
		
		driver.findElement(cmbCreditCard).sendKeys(creditCard.getCardType());
		driver.findElement(txtCardNo).sendKeys(creditCard.getCardNumber());
		
		report.updateTestLog("Book Tickets", "Click on book tickets", Status.DONE, true);
		driver.findElement(btnSecurePurchase).click();
		
		return new FlightConfirmationPage(scriptHelper);
	}
}