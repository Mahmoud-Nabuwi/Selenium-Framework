package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;

public class UserRegistrationParallelTest extends TestBase2 {
	HomePage homeObject;
	RegistrationPage registerObject;
	@DataProvider(name = "testData")
	public static Object[][] userData(){
		return new Object[][] {
			{
			"mahmoud","nob","aa@gmail.com","5060708090"	
			},{
				"Ahmed","Ali","aaaa@gmail.com","50607080"	

			}
			};
	}
@Test(priority = 0,dataProvider = "testData")
public void registrationTest(String fname, String lname, String email, String pass) {
	homeObject = new HomePage(getDriver());
	homeObject.openRegisterPage();
	registerObject = new RegistrationPage(getDriver());
	registerObject.registrationProcess(fname, lname, email, pass);
	//Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
	registerObject.userLogOut();

}

}
