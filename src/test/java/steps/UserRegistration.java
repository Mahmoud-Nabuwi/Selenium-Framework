package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	HomePage homeObject;
	RegistrationPage registerObject;
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		homeObject = new HomePage(driver);
		homeObject.openRegisterPage();
	}
	@When("I click on Register Link")
	public void i_click_on_register_link() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	   
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() { //
	 * Write code here that turns the phrase above into concrete actions
	 * registerObject = new RegistrationPage(driver);
	 * registerObject.registrationProcess("dod", "samir", "motaz@yahoo.com",
	 * "5201478"); }
	 */
	
	@When("I entered {string}, {string}, {string}, {string}")
	public void i_entered(String fname, String lname, String email, String pass) {
		registerObject = new RegistrationPage(driver);
		registerObject.registrationProcess(fname, lname, email,pass);
	}
	
	@Then("The Registration Page displayed successfully")
	public void the_registration_page_displayed_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		registerObject.userLogOut();
	}

}
