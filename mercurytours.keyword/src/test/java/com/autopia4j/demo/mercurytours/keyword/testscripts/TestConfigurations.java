package com.autopia4j.demo.mercurytours.keyword.testscripts;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;

import com.autopia4j.framework.webdriver.Browser;
import com.autopia4j.framework.webdriver.ExecutionMode;

public class TestConfigurations {
	
	@DataProvider(name = "AllBrowsers", parallel = true)
	public static Object[][] allBrowsers() {
		return new Object[][] {
			{ "Instance1", ExecutionMode.LOCAL, "N/A", Browser.CHROME, Platform.WINDOWS },
			{ "Instance2", ExecutionMode.LOCAL, "N/A", Browser.FIREFOX_MARIONETTE, Platform.WINDOWS },
			{ "Instance3", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Apple_iPhone_6", Browser.PERFECTO_MOBILE_OS, Platform.ANY },
			{ "Instance4", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Apple_iPad_4", Browser.PERFECTO_MOBILE_SAFARI, Platform.ANY },
			{ "Instance5", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Samsung_Galaxy_S5", Browser.PERFECTO_MOBILE, Platform.ANDROID },
			{ "Instance6", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Samsung_Galaxy_Note_10_1", Browser.PERFECTO_MOBILE_CHROME, Platform.ANDROID }
		};
	}
	
	@DataProvider(name = "DesktopBrowsers", parallel = true)
	public static Object[][] desktopBrowsers() {
		return new Object[][] {
			{ "Instance1", ExecutionMode.LOCAL, "N/A", Browser.CHROME, Platform.WINDOWS },
			{ "Instance2", ExecutionMode.LOCAL, "N/A", Browser.FIREFOX_MARIONETTE, Platform.WINDOWS },
		};
	}
	
	@DataProvider(name = "MobileBrowsers", parallel = true)
	public static Object[][] mobileBrowsers() {
		return new Object[][] {
			{ "Instance1", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Apple_iPhone_6", Browser.PERFECTO_MOBILE_OS, Platform.ANY },
			{ "Instance2", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Apple_iPad_4", Browser.PERFECTO_MOBILE_SAFARI, Platform.ANY },
			{ "Instance3", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Samsung_Galaxy_S5", Browser.PERFECTO_MOBILE, Platform.ANDROID },
			{ "Instance4", ExecutionMode.PERFECTO_REMOTEWEBDRIVER, "Samsung_Galaxy_Note_10_1", Browser.PERFECTO_MOBILE_CHROME, Platform.ANDROID }
		};
	}
}