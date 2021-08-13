package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {
	HomePage homeObject;
	RegistrationPage registerObject;
	@DataProvider(name = "testData")
	public static Object[][] userData(){
		return new Object[][] {
			{
			"mahmoud","nob","testation5@gmail.com","5060708090"	
			},{
				"Ahmed","Ali","testation6@gmail.com","50607080"	

			}
			};
	}
@Test(priority = 0,dataProvider = "testData")
public void registrationTest(String fname, String lname, String email, String pass) {
	homeObject = new HomePage(driver);
	homeObject.openRegisterPage();
	registerObject = new RegistrationPage(driver);
	registerObject.registrationProcess(fname, lname, email, pass);
	Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
	registerObject.userLogOut();

}
@Test(priority = 1 , enabled = false)
public void registerdCanLogout() throws InterruptedException {
	registerObject.userLogOut();
	Thread.sleep(6000);
}

}
