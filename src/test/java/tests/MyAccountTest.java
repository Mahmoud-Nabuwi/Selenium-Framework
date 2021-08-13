package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class MyAccountTest extends TestBase {
MyAccountPage myAccountObject;
RegistrationPage registerObject;
HomePage homeObject;
LoginPage loginObject;
@Test
public void myAccountTestSuccess() {
	registerObject = new RegistrationPage(driver);
	registerObject.openMyAccountPage();
	myAccountObject = new MyAccountPage(driver);
	myAccountObject.openChangePassPage();
	myAccountObject.changePasswordProcess("mahmoud123", "mahmoud1234");
	Assert.assertTrue(myAccountObject.resultLabel.getText().contains("Password was changed"));
	myAccountObject.closeLabel();
	registerObject.userLogOut();
	homeObject =new HomePage(driver);
	homeObject.openLoginPage();
	loginObject = new LoginPage(driver);
	loginObject.loginProcess("mahmoud@yahoo.com", "mahmoud1234");
	Assert.assertTrue(registerObject.logOutLink.isDisplayed());
	
}
@Test(priority = 1)
public void registerdCanLogout() {
	registerObject = new RegistrationPage(driver);
	registerObject.userLogOut();
}
}
