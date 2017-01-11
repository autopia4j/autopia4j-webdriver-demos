package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;


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
	
	
	@And("^I book the tickets using the following passenger details:$")
	public void enterPassengerInfo(DataTable passengerInfoData) {
		List<Map<String, String>> passengerInfo =
				passengerInfoData.asMaps(String.class, String.class);
		
		for(int i=0; i<passengerCount; i++) {
			Map<String,String> currentPassengerInfo = passengerInfo.get(i);
			
			driver.findElement(By.name(txtFirstName + i)).sendKeys(currentPassengerInfo.get("FirstName"));
			driver.findElement(By.name(txtLastName + i)).sendKeys(currentPassengerInfo.get("LastName"));
		}
	}
	
	@And("^I use the following credit card details:$")
	public void makePayment(DataTable creditCardInfoData) {
		List<Map<String, String>> creditCardInfo =
				creditCardInfoData.asMaps(String.class, String.class);
		Map<String,String> creditCardInfo1 = creditCardInfo.get(0);

		driver.findElement(cmbCreditCard).sendKeys(creditCardInfo1.get("CreditCardType"));
		driver.findElement(txtCardNo).sendKeys(creditCardInfo1.get("CreditCardNumber"));
		
		currentScenario.embed(driverUtil.captureScreenshotAsByteArray(), "image/png");
		
		driver.findElement(btnSecurePurchase).click();
	}
}