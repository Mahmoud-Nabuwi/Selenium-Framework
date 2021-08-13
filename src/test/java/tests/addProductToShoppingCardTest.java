package tests;


import org.testng.annotations.Test;

import pages.AddProductShoppingCardPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class addProductToShoppingCardTest extends TestBase{
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	AddProductShoppingCardPage shoppingCardObject;
	@Test(priority = 1)
	public void searchProductUsingAutoSuggest() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.productSearchProcesUsingAutoSuggest("Mac");
	}
	@Test(priority = 2)
	public void addToShoppingCardTestSuccess() throws InterruptedException {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addToCard();
		Thread.sleep((long) 5000.0);
		productDetailsObject.openShoppingCardPage();
		shoppingCardObject = new AddProductShoppingCardPage(driver);
		shoppingCardObject.updateProductQuantity("2");
		shoppingCardObject.removeProductFromCard();
		//Assert.assertTrue(shoppingCardObject.subTotalBox.getText().contains("3600"));
	}
}
