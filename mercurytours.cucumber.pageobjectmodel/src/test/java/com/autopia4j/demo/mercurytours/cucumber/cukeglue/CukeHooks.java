package com.autopia4j.demo.mercurytours.cucumber.cukeglue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autopia4j.framework.core.AutopiaException;
import com.autopia4j.framework.core.FrameworkParameters;
import com.autopia4j.framework.core.Settings;
import com.autopia4j.framework.webdriver.core.Browser;
import com.autopia4j.framework.webdriver.core.DeviceType;
import com.autopia4j.framework.webdriver.core.ExecutionMode;
import com.autopia4j.framework.webdriver.core.WebDriverTestParameters;
import com.autopia4j.framework.webdriver.mobile.AppiumWebDriverFactory;
import com.autopia4j.framework.webdriver.mobile.PerfectoWebDriverFactory;
import com.autopia4j.framework.webdriver.utils.WebDriverFactory;
import com.autopia4j.framework.webdriver.utils.WebDriverProxy;
import com.autopia4j.framework.webdriver.utils.WebDriverUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukeHooks extends MasterPage {
	
	Logger logger = LoggerFactory.getLogger(CukeHooks.class);
	
	@Before
	public void setUp(Scenario scenario) {
		currentScenario = scenario;
		
		initializeFrameworkParameters();
		initializeTestParameters();
		initializeWebDriver();
	}
	
	private void initializeFrameworkParameters() {
		String basePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		frameworkParameters.setBasePath(basePath);
		properties = Settings.getInstance();
		frameworkParameters.setExecutionEnvironment(properties.getProperty("execution.environment"));
	}
	
	private void initializeTestParameters() {
		logger.info("Initializing test parameters");
		
		testParameters =
				new WebDriverTestParameters(currentScenario.getId(), currentScenario.getName());
		
		ExecutionMode executionMode = ExecutionMode.valueOf(properties.getProperty("execution.mode.default"));
		testParameters.setExecutionMode(executionMode);
		
		Browser browser = Browser.valueOf(properties.getProperty("browser.default"));
		Platform platform = Platform.valueOf(properties.getProperty("platform.default"));
		testParameters.setBrowser(browser);
		testParameters.setBrowserVersion("1.0");
		testParameters.setPlatform(platform);
		
		testParameters.setRemoteUrl(properties.getProperty("remote.url.default"));
		testParameters.setDeviceName(properties.getProperty("device.name.default"));
		DeviceType deviceType = DeviceType.valueOf(properties.getProperty("device.type.default"));
		testParameters.setDeviceType(deviceType);
	}
	
	private void initializeWebDriver() {
		logger.info("Initializing WebDriver");
		
		switch(testParameters.getExecutionMode()) {
		case LOCAL:
			initializeWebDriverFactory();
			driver = WebDriverFactory.getWebDriver(testParameters.getBrowser());
			break;
			
		case REMOTE:
			initializeWebDriverFactory();
			driver = WebDriverFactory.getRemoteWebDriver(testParameters.getBrowser(),
															testParameters.getRemoteUrl());
			break;
			
		case LOCAL_EMULATED_DEVICE:
			initializeWebDriverFactory();
			testParameters.setBrowser(Browser.CHROME);	// Mobile emulation supported only on Chrome
			driver = WebDriverFactory.getEmulatedWebDriver(testParameters.getDeviceName());
			break;
			
		case REMOTE_EMULATED_DEVICE:
			initializeWebDriverFactory();
			testParameters.setBrowser(Browser.CHROME);	// Mobile emulation supported only on Chrome
			driver = WebDriverFactory.getEmulatedRemoteWebDriver(testParameters.getDeviceName(), 
																	testParameters.getRemoteUrl());
			break;
			
		case GRID:
			initializeWebDriverFactory();
			driver = WebDriverFactory.getRemoteWebDriver(testParameters.getBrowser(),
													testParameters.getBrowserVersion(),
													testParameters.getPlatform(),
													testParameters.getRemoteUrl());
			break;
			
		case PERFECTO_DEVICE:
			initializePerfectoWebDriverFactory();
			driver = PerfectoWebDriverFactory.getPerfectoRemoteWebDriver(testParameters.getPerfectoDeviceId(),
																testParameters.getDeviceType(),
																testParameters.getBrowser(),
																testParameters.getRemoteUrl());
			break;
			
		case APPIUM_DEVICE:
			driver = AppiumWebDriverFactory.getAppiumWebDriver(testParameters.getDeviceName(),
														testParameters.getScreenOrientation(),
														testParameters.getBrowser(),
														testParameters.getPlatform(),
														testParameters.getRemoteUrl());
			break;
			
		default:
			throw new AutopiaException("Unhandled Execution Mode!");
		}
		
		long objectSyncTimeout =
				Long.parseLong(properties.get("timeout.object.sync").toString());
		long pageLoadTimeout =
				Long.parseLong(properties.get("timeout.page.load").toString());
		driver.manage().timeouts().implicitlyWait(objectSyncTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		
		if(testParameters.getDeviceType().getValue().contains("desktop")) {
			driver.manage().window().maximize();
		}
		
		driverUtil = new WebDriverUtil(driver, objectSyncTimeout, pageLoadTimeout);
	}
	
	private void initializeWebDriverFactory() {
		logger.info("Initializing WebDriverFactory");
		
		WebDriverFactory.setAcceptAllSslCertificates(Boolean.parseBoolean(properties.getProperty("ssl.certs.accept.all")));
		WebDriverFactory.setIntroduceFlakinessInternetExplorer(Boolean.parseBoolean(properties.getProperty("internet.explorer.introduce.flakiness")));
		WebDriverFactory.setTurnOffPopupBlockerInternetExplorer(Boolean.parseBoolean(properties.getProperty("internet.explorer.popupblocker.turnoff")));
		
		Boolean proxyRequired = Boolean.parseBoolean(properties.getProperty("proxy.required"));
		WebDriverFactory.setProxyRequired(proxyRequired);
		
		if (proxyRequired) {
			WebDriverProxy proxy = new WebDriverProxy();
			proxy.setHost(properties.getProperty("proxy.host"));
			proxy.setPort(Integer.parseInt(properties.getProperty("proxy.port")));
			
			Boolean authRequired = Boolean.parseBoolean(properties.getProperty("proxy.auth.required"));
			proxy.setAuthRequired(authRequired);
			if(authRequired) {
				proxy.setDomain(properties.getProperty("proxy.auth.domain"));
				proxy.setUserName(properties.getProperty("proxy.auth.username"));
				proxy.setPassword(properties.getProperty("proxy.auth.password"));
			}
			WebDriverFactory.setProxy(proxy);
		}
	}
	
	private void initializePerfectoWebDriverFactory() {
		logger.info("Initializing PerfectoWebDriverFactory");
		
		PerfectoWebDriverFactory.setAcceptAllSslCertificates(Boolean.parseBoolean(properties.getProperty("ssl.certs.accept.all")));
		PerfectoWebDriverFactory.setUserName(properties.getProperty("perfecto.username"));
		PerfectoWebDriverFactory.setPassword(properties.getProperty("perfecto.password"));
	}
	
	@After
	public void logOffAndCloseBrowser() {
		if(driverUtil.objectExists(lnkSignOff)) {
			driver.findElement(lnkSignOff).click();
		}
		
		driver.quit();
	}
}