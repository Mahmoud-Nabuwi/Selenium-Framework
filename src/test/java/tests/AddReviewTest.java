package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.ReviewPage;
import pages.SearchPage;

public class AddReviewTest extends TestBase {
	HomePage homeObject;
	RegistrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ReviewPage reviewObject;
	
	
	// user registration test
@Test(priority = 0)
public void registrationTest() throws FileNotFoundException, IOException, ParseException {
	JsonDataReader jsonR = new JsonDataReader();
	jsonR.jsonReader();
	homeObject = new HomePage(driver);
	homeObject.openRegisterPage();
	registerObject = new RegistrationPage(driver);
	registerObject.registrationProcess(jsonR.fname, jsonR.lname, jsonR.email, jsonR.pass);
}
//search for product test
@Test(priority = 1)
public void searchProductUsingAutoSuggest() throws InterruptedException, FileNotFoundException, IOException, ParseException {
	JsonDataReader jsonR = new JsonDataReader();
	jsonR.jsonReader();
	searchObject = new SearchPage(driver);
	searchObject.productSearchProcesUsingAutoSuggest(jsonR.searchName);
}

//add Review
@Test(priority = 2)
public void registeredUserReviewProduct() throws FileNotFoundException, IOException, ParseException {
	JsonDataReader jsonR = new JsonDataReader();
	jsonR.jsonReader();
	productDetailsObject = new ProductDetailsPage(driver);
	productDetailsObject.openReviewLink();
	reviewObject = new ReviewPage(driver);
	reviewObject.addReviewProcess(jsonR.reviewTitle, jsonR.review);
	//Assert.assertTrue(reviewObject.reviewResult.getText().contains("added"));
}


//Logout Test

@Test(priority = 3)
public void registerdCanLogout() {
	registerObject = new RegistrationPage(driver);
	registerObject.userLogOut();
}
}
