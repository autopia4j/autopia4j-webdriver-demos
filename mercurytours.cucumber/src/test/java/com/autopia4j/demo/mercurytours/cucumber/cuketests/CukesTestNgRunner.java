package com.autopia4j.demo.mercurytours.cucumber.cuketests;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		format = {"pretty",
				"html:target/cuke-reports/cucumber-htmlreport",
				"junit:target/cuke-reports/cucumber-junitreport.xml"},
		tags = {"@completed"},
		glue = "com.autopia4j.demo.mercurytours.cucumber.cukeglue"
		)
public class CukesTestNgRunner extends AbstractTestNGCucumberTests {

	@Test
	public void dummyTest() {
		
	}
}