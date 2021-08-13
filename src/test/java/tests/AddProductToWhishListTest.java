package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WhishListPage;

public class AddProductToWhishListTest extends TestBase{
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	WhishListPage whishlistObject;
	@Test(priority = 0)
	public void searchProductUsingAutoSuggest() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.productSearchProcesUsingAutoSuggest("Mac");
	}
	@Test(priority = 1)
	public void addToWishListSuccess() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToWhishList();
		whishlistObject = new WhishListPage(driver);
		Assert.assertTrue(whishlistObject.productCell.isDisplayed());
		whishlistObject.removeProductWishListProcess();
		Assert.assertTrue(whishlistObject.removedResult.getText().contains("The wishlist is empty!"));
			
	}
}
