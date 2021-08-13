package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCpmpareTest extends TestBase{
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ComparePage compareObject;
	@Test(priority = 0)
	public void comparisonTestSuccess() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.productSearchProcesUsingAutoSuggest("Mac");
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductComparePage();
		searchObject = new SearchPage(driver);
		searchObject.productSearchProcesUsingAutoSuggest("asus");
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductComparePage();
		productDetailsObject.openComparisonPage();
		compareObject = new ComparePage(driver);
		compareObject.compareProductProcess();
		compareObject.clearCompareTable();
		Assert.assertTrue(compareObject.noItemResult.getText().contains("no items"));
	}
}
