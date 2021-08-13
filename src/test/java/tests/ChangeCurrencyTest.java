package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
HomePage homeObject;
ProductDetailsPage productDetailsObject;
SearchPage searchObject;
@Test(priority = 0)
public void userCanChangeCurrency() {
	homeObject = new HomePage(driver);
	homeObject.selectCurrencyProcess();
}
@Test(priority = 1)
public void searchProductUsingAutoSuggest() throws InterruptedException {
	searchObject = new SearchPage(driver);
	searchObject.productSearchProcesUsingAutoSuggest("Mac");
	productDetailsObject = new ProductDetailsPage(driver);
	Assert.assertTrue(productDetailsObject.productPriceLabel.getText().contains("€"));
}
}
