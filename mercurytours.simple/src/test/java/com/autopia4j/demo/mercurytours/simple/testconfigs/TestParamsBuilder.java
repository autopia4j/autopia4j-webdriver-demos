package com.autopia4j.demo.mercurytours.simple.testconfigs;

import java.net.URL;

import org.openqa.selenium.Platform;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.DeviceType;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;

public class TestParamsBuilder {
	private final WebDriverTestParameters testParameters;
	
	
	public TestParamsBuilder(String module, String test) {
		this.testParameters = new WebDriverTestParameters(module, test);
	}
	
	public TestParamsBuilder testInstance(String testInstance) {
		this.testParameters.setCurrentTestInstance(testInstance);
		return this;
	}
	
	public TestParamsBuilder executionMode(ExecutionMode executionMode) {
		this.testParameters.setExecutionMode(executionMode);
		return this;
	}
	
	public TestParamsBuilder browser(Browser browser) {
		this.testParameters.setBrowser(browser);
		return this;
	}
	
	public TestParamsBuilder browserVersion(String browserVersion) {
		this.testParameters.setBrowserVersion(browserVersion);
		return this;
	}
	
	public TestParamsBuilder platform(Platform platform) {
		this.testParameters.setPlatform(platform);
		return this;
	}
	
	public TestParamsBuilder deviceType(DeviceType deviceType) {
		this.testParameters.setDeviceType(deviceType);
		return this;
	}
	
	public TestParamsBuilder deviceName(String deviceName) {
		this.testParameters.setDeviceName(deviceName);
		return this;
	}
	
	public TestParamsBuilder remoteUrl(URL remoteUrl) {
		this.testParameters.setRemoteUrl(remoteUrl);
		return this;
	}
	
	public TestParamsBuilder remoteUrl(String remoteUrl) {
		this.testParameters.setRemoteUrl(remoteUrl);
		return this;
	}
	
	public WebDriverTestParameters build() {
		return this.testParameters;
	}
}