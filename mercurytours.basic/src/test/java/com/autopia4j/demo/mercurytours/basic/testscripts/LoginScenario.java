package com.autopia4j.demo.mercurytours.basic.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopia4j.demo.mercurytours.basic.datamodel.User;
import com.autopia4j.demo.mercurytours.basic.flows.GeneralFlows;
import com.autopia4j.demo.mercurytours.basic.pages.FlightFinderPage;
import com.autopia4j.demo.mercurytours.basic.pages.SignOnPage;
import com.autopia4j.demo.mercurytours.basic.pages.UserRegistrationConfirmationPage;
import com.autopia4j.demo.mercurytours.basic.pages.UserRegistrationPage;
import com.autopia4j.demo.mercurytours.basic.testconfigs.TestConfigurations;
import com.autopia4j.framework.assertions.TestNgWrappedAssertion;
import com.autopia4j.framework.webdriver.core.ScriptHelper;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.impl.basic.BasicTestScript;

public class LoginScenario extends BasicTestScript {
	
	// Avoid class level fields -> they get shared across test methods that run in parallel
	// If you must use them, make sure they are implemented as ThreadLocal variables
	
	@BeforeMethod
	public void setUp() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		GeneralFlows generalFlows = new GeneralFlows(scriptHelper);
		
		generalFlows.invokeApplication();
	}
	
	@Test(dataProvider="DesktopBrowsers", dataProviderClass=TestConfigurations.class)
	public void testForValidLogin(WebDriverTestParameters testParameters) {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(scriptHelper.getReport());
		
		User validUser = new User();
		validUser.setUserName("mercury");
		validUser.setPassword("mercury");
		
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser(validUser);
		strongly.assertTrue(flightFinderPage.isUserSignedOn(), "Is user signed in?");
		signOnPage = flightFinderPage.logout();
	}
	
	@Test
	public void testForInvalidLogin() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(scriptHelper.getReport());
		
		User invalidUser = new User();
		invalidUser.setUserName("labs");
		invalidUser.setPassword("labs");
		
		signOnPage = signOnPage.loginAsInvalidUser(invalidUser);
		strongly.assertFalse(signOnPage.isUserSignedOn(), "Is user signed in?");
	}
	
	@Test
	public void testForLoginWithNewlyRegisteredUser() {
		ScriptHelper scriptHelper = currentScriptHelper.get();
		SignOnPage signOnPage = new SignOnPage(scriptHelper);
		TestNgWrappedAssertion strongly = new TestNgWrappedAssertion(scriptHelper.getReport());
		
		User newUser = getNewUser();
		
		UserRegistrationPage userRegistrationPage = signOnPage.clickRegister();
		UserRegistrationConfirmationPage userRegistrationConfirmationPage = 
													userRegistrationPage.registerUser(newUser);
		strongly.assertTrue(userRegistrationConfirmationPage.isUserRegistered(newUser), "Is new user registered?");
		
		signOnPage = userRegistrationConfirmationPage.clickSignIn();
		FlightFinderPage flightFinderPage = signOnPage.loginAsValidUser(newUser);
		strongly.assertTrue(flightFinderPage.isUserSignedOn(), "Is user signed in?");
		signOnPage = flightFinderPage.logout();
	}
	
	private User getNewUser() {
		User newUser = new User();
		newUser.setFirstName("Autopia");
		newUser.setLastName("Labs");
		newUser.setPhone("1234567890");
		newUser.setEmail("support@autopia.com");
		newUser.setAddressLine1("100 Autopia Road");
		newUser.setCity("Autopia");
		newUser.setState("HV");
		newUser.setPostalCode("99999");
		newUser.setUserName("autopia2");
		newUser.setPassword("password-1");
		return newUser;
	}
}