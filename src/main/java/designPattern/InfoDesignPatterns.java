package designPattern;

public class InfoDesignPatterns {
// represent the best practices used by experienced object oriented software developer
//are solutions to general problems that developers facing
//selenium design patterns 
	//1- record playback pattern - selenium IDE (firefox)- MS coded UI 
	//Adv:fast test growth-no previous experience-element lookup easily
	//disAdv : bad locator find (absolute path)- inflexible test -  hardcoded test data- poorly written tests-duplicate code
	//2- the spaghetti Pattern
	//lack of preceived architecture and design 
	//impossible to understand - code dependent on each other
	//each test is not self sufficient and independent
	//adv : quick start - smaller code base - smoke tests
	//disADV: anti-pattern - tight coupling - no random order - no reusability - duplication
	// no parallel test runs - covers up failures - no resilience
	//3- DRY testing pattern
	//don't repeat yourself - no duplication - reduce long term maintenance 
	// remove duplicate code - test goal(avoid testing any functionality not related to the current test
	//Adv : modular test : self sufficient tests - reduce duplication - fast updates - no junk code
	//disADV : complicated project structure - lack of a good ide - constant upkeep - programming skills
	//4- data driven test design pattern
	//no hardcoded - no repeating identical steps
	//Adv : url - hardcoded - private user data on multiple environment
	//hiding test data from tests - seperated files
	//5- Behavior Driven Development design pattern
	//Adv: better test understanding - modular implementation 
	//disAdv : consistent specification language - which tool to use:cucumber - jbehave - specflow for c# .net - learning curve
	//6- page objects design pattern
	//describe any web page in terms of domain specific language (DSL).
    // DSL helps to hide implementation of the page the test is no longer allowed to directly interact with a given page 
	// make page object mapping all elements of given page
	//adv: DSL framework - modular and reusable
	//disAdv: complexity 
	// steps: 1- create a class to hold all driver lifecycle mangament codes 
	//2- analyze AUT(POM for every page)
	//3- POM - pageFactory library to initialize Elements
	//4-write tests

}
