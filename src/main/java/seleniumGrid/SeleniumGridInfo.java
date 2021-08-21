package seleniumGrid;

public class SeleniumGridInfo {
//is a memeber of selenium suite and is running multiple tests across different browser , os and machins
//is is based on hub - node concept.it specified that all tests should run on single machine called hub but they get executed on different machines called nodes
// run on firefox on ubonto - ie on windows - safari on mac - android
//benefits : running on different browsers,os at same time	
//ensure the the app has fully compatibility  with a wide range of browser - os
//saves time in execution of test suites
//the hub is a central point where run tests - one hub in a grid - launched only on single machine like windows chrome
//nodes: executes the tests the you loaded on hub - one or more nodes with different browsers and platforms.
// download selenium grid server standalone version
	/*
	 * Java – jar selenium-server-standalone-3.141.59.jar –role hub Java
	 * -Dwebdriver.gecko.driver=“C:\Users\dod\eclipse-workspace\PageObjectModel\
	 * Selenium-Framework\drivers\geckodriver.exe” -jar
	 * selenium-server-standalone-3.141.59.jar -role webdriver -hub
	 * http://192.168.100.3:4444/grid/register -port 5556
	 */	
	// selenium paramters port - iphost- maxsession - timeout 
	
}
