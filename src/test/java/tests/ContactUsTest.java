package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
HomePage homeObject;
ContactUsPage contactObject;
Faker fakeData = new Faker();
String fullName = fakeData.name().fullName() ;
String email = fakeData.internet().emailAddress();
String msg = fakeData.letterify("I need some details about");
@Test
public void contactUsTestSucsess() {
	homeObject = new HomePage(driver);
	homeObject.openContactUsPage();
	contactObject = new ContactUsPage(driver);
	contactObject.contactUsSendEnquiryProcess(fullName, email, msg);
	Assert.assertTrue(contactObject.enquirySent.getText().contains("successfully"));
}
}
