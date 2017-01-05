package com.autopia4j.demo.mercurytours.pageObjectModel.dataNonIterative.testconfigs;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParamsBuilder;

public class TestConfigurations {
	
	@DataProvider(name = "DesktopBrowsers", parallel = true)
	public static Object[][] desktopBrowsers(Method currentMethod) {
		String currentModule = currentMethod.getDeclaringClass().getSimpleName();
		String currentTest = currentMethod.getName();
		currentTest = currentTest.substring(0, 1).toUpperCase().concat(currentTest.substring(1));
		
		return new Object[][] { 
			{ new WebDriverTestParamsBuilder(currentModule, currentTest).testInstance("Instance1").browser(Browser.CHROME).build() },
			{ new WebDriverTestParamsBuilder(currentModule, currentTest).testInstance("Instance2").browser(Browser.FIREFOX_MARIONETTE).build() }
		};
	}
	
	@DataProvider(name = "AllBrowsers", parallel = true)
	public static Object[][] allBrowsers(Method currentMethod) {
		String currentModule = currentMethod.getDeclaringClass().getSimpleName();
		String currentTest = currentMethod.getName();
		currentTest = currentTest.substring(0, 1).toUpperCase().concat(currentTest.substring(1));
		
		return new Object[][] { 
			{ new WebDriverTestParamsBuilder(currentModule, currentTest).testInstance("Instance1").browser(Browser.CHROME).build() },
			{ new WebDriverTestParamsBuilder(currentModule, currentTest).testInstance("Instance2").browser(Browser.FIREFOX_MARIONETTE).build() },
			{ new WebDriverTestParamsBuilder(currentModule, currentTest).testInstance("Instance3").executionMode(ExecutionMode.APPIUM_DEVICE).deviceName("Samsung Note 7").browser(Browser.APPIUM_CHROME).build() },
			{ new WebDriverTestParamsBuilder(currentModule, currentTest).testInstance("Instance4").executionMode(ExecutionMode.PERFECTO_DEVICE).deviceName("Apple iPad 4").browser(Browser.PERFECTO_MOBILE_SAFARI).build() }
		};
	}
}