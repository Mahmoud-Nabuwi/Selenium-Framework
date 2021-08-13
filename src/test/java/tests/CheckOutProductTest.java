package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductShoppingCardPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailedPage;
import pages.ProductDetailsPage;
import pages.RegistrationPage;
import pages.SearchPage;

public class CheckOutProductTest extends TestBase{
	HomePage homeObject;
	RegistrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	AddProductShoppingCardPage shoppingCardObject;
	CheckoutPage checkoutObject;
	OrderDetailedPage orderObject;
@Test(priority = 0)
public void registrationTest() {
	homeObject = new HomePage(driver);
	homeObject.openRegisterPage();
	registerObject = new RegistrationPage(driver);
	registerObject.registrationProcess("mahmoud", "nabawy", "test13@gmail.com", "10203040");
	Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
}
@Test(priority = 1)
public void searchProductUsingAutoSuggest() throws InterruptedException {
	searchObject = new SearchPage(driver);
	searchObject.productSearchProcesUsingAutoSuggest("Mac");
}
@Test(priority = 2)
public void checkoutTestSuccess() throws InterruptedException {
	productDetailsObject = new ProductDetailsPage(driver);
	productDetailsObject.addToCard();
	Thread.sleep((long) 5000.0);
	productDetailsObject.openShoppingCardPage();
	shoppingCardObject = new AddProductShoppingCardPage(driver);
	shoppingCardObject.openCheckoutPage();
	checkoutObject = new CheckoutPage(driver);
	checkoutObject.checkoutInfoProcess("riyadh", "alyarmouk exit 9 ", "11111", "055555555");
	Thread.sleep((long) 5000.0);
	Assert.assertTrue(checkoutObject.productName.getText().contains("Apple MacBook Pro 13-inch"));
	checkoutObject.confirmOrder();
	//Assert.assertTrue(checkoutObject.orderProceedResult.getText().contains("successfully"));
	checkoutObject.openOrderDetails();
	orderObject = new OrderDetailedPage(driver);
	orderObject.downloadInvoice();
	orderObject.printInvoice();
	
}



@Test(priority = 3)
public void registerdCanLogout() {
	registerObject.userLogOut();
}
}
