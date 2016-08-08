package com.autopia4j.demo.mercurytours.modular;

import com.autopia4j.framework.core.FrameworkParameters;
import com.autopia4j.framework.core.FrameworkType;
import com.autopia4j.framework.webdriver.Allocator;

/**
 * Class to kick-start the batch execution of test scripts within the framework
 * @author vj
 */
public class BatchRunner {
	
	/**
	 * The entry point of the test batch execution <br>
	 * Exits with a value of 0 if the test passes and 1 if the test fails
	 * @param args Command line arguments to the Allocator (Not applicable)
	 */
	public static void main(String[] args) {
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		frameworkParameters.setFrameworkType(FrameworkType.MODULAR);
		frameworkParameters.setBasePackageName(BatchRunner.class.getPackage().getName());
		
		Allocator allocator = new Allocator();
		int testBatchStatus = allocator.driveBatchExecution();
		System.exit(testBatchStatus);
	}
}