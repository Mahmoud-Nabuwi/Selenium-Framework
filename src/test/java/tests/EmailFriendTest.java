package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;

public class EmailFriendTest extends TestBase {



	HomePage homeObject;
	RegistrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	EmailPage emailFriendObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] sendProductToFriendData() throws IOException{
		//get data from excel reader
		ExcelReader er = new ExcelReader();
			return er.getExcelData();
	}
	
	// user registration test
@Test(priority = 0,dataProvider = "ExcelData")
public void registrationTest(String fname, String lname , String email , String pass) {
	homeObject = new HomePage(driver);
	homeObject.openRegisterPage();
	registerObject = new RegistrationPage(driver);
	registerObject.registrationProcess(fname, lname, email, pass);
	Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
}
//search for product test
@Test(priority = 1, dataProvider = "ExcelData")

public void searchProductUsingAutoSuggest(String searchName) throws InterruptedException {
	searchObject = new SearchPage(driver);
	searchObject.productSearchProcesUsingAutoSuggest(searchName);
}

//email to friend test
@Test(priority = 2, dataProvider = "ExcelData")
public void registeredUserSendFriendEmail(String email , String msg) {
	productDetailsObject = new ProductDetailsPage(driver);
	productDetailsObject.openSendEmailPage();
	emailFriendObject = new EmailPage(driver);
	emailFriendObject.sendEmailFriendProcess(email, msg);
	Assert.assertTrue(emailFriendObject.msgSentResult.getText().contains("has been sent"));
}


//Logout Test

@Test(priority = 3)
public void registerdCanLogout() {
	registerObject.userLogOut();
}
}
