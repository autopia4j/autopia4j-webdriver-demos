autopia4j is an open source automation framework, designed to work with any Java based automation tool. The most prominent implementation of the framework is on top of Selenium WebDriver. A SoapUI implementation is also available.

The autopia4j-webdriver-demos project contains demo projects containing automated scripts developed using the autopia4j framework over Selenium WebDriver. Note that this project depends on the autopia4j-webdriver library, which in turn depends on the autopia4j-core library.

How to build and run the tests from source:
1. Check out the latest version from BitBucket
2. Configure the test.run.configurations.xls file as appropriate, and run the tests using the BatchRunner.java file
2. Alternatively, navigate to the testscripts package and run individual tests as required using TestNG