package com.autopia4j.demo.mercurytours.cucumber.cuketests;

import java.io.IOException;

import cucumber.api.cli.Main;

/**
 * Class to facilitate parallel execution of test scripts
 * @author vj
 */
public class ParallelRunner implements Runnable {
	private static int testBatchStatus = 0;
	
	
	/**
	 * Function to get the overall test batch status
	 * @return The test batch status (0 = Success, 1 = Failure)
	 */
	public int getTestBatchStatus() {
		return testBatchStatus;
	}
	
	public void run() {
		String[] cukeArgs = {	"--format", "pretty",
				"--format", "html:Results/cucumber-htmlreport",
				"--format", "junit:Results/cucumber-junitreport.xml",
				"--tags", "@completed",
				"--glue", "com.mercurytours.cukeglue", "src\\test\\resources"
			};
		
		try {
			Main.run(cukeArgs, new ClassLoader() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}