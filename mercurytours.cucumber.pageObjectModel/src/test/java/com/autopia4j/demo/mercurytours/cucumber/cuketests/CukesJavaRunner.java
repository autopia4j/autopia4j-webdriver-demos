package com.autopia4j.demo.mercurytours.cucumber.cuketests;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CukesJavaRunner {
	
	public static void main(String[] args) throws IOException {
		/*String[] cukeArgs = {	"--format", "pretty",
								"--format", "html:target/cuke-reports/cucumber-htmlreport",
								"--format", "junit:target/cuke-reports/cucumber-junitreport.xml",
								"--tags", "@completed",
								"--glue", "com.mercurytours.cukeglue", "src\\test\\resources"
							};
		
		Main.run(cukeArgs, new ClassLoader() {
		});*/
		
		ExecutorService parallelExecutor = Executors.newFixedThreadPool(2);
		
		ParallelRunner testRunner = new ParallelRunner();
		parallelExecutor.execute(testRunner);
		
		parallelExecutor.shutdown();
		while(!parallelExecutor.isTerminated()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}