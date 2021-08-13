package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.ReadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class LoginTest extends TestBase {
LoginPage loginObject;
HomePage homeObject;
RegistrationPage registerObject;
String email = ReadProperties.userData.getProperty("email");
String pass = ReadProperties.userData.getProperty("pass");
@Test(priority = 0)
public void userLoginSuccess() {
	homeObject = new HomePage(driver);
	homeObject.openLoginPage();
	loginObject = new LoginPage(driver);
	loginObject.loginProcess(email, pass);
	registerObject = new RegistrationPage(driver);
	Assert.assertTrue(registerObject.logOutLink.isDisplayed());
}

}
