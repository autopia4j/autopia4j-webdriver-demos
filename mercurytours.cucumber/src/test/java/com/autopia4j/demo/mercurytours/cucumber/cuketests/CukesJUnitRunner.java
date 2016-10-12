package com.autopia4j.demo.mercurytours.cucumber.cuketests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty",
				"html:target/cuke-reports/cucumber-htmlreport",
				"junit:target/cuke-reports/cucumber-junitreport.xml"},
		tags = {"@completed"},
		glue = "com.autopia4j.demo.mercurytours.cucumber.cukeglue"
		)
public class CukesJUnitRunner {
	
}