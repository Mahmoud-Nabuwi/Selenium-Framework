package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
SearchPage searchObject;
ProductDetailsPage productDetailsObject;
CSVReader reader;
@Test
public void searchProductSucsess() throws FileNotFoundException, IOException, CsvValidationException {
	// get path of csv file 
	String csvFile = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\csvData.csv";
	reader = new CSVReader(new FileReader(csvFile));
	String[] csvCell;
	//while loop will be executed till the last line of csv file 
	while((csvCell = reader.readNext()) !=null) {
		String searchName = csvCell[0];
		searchObject = new SearchPage(driver);
		searchObject.productSearchProcess(searchName);
		searchObject.openProductDetails();
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productNameBreadCrumb.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch"));
	}
	
}
@Test(enabled=false)
public void searchProductUsingAutoSuggest() throws InterruptedException {
	searchObject = new SearchPage(driver);
	searchObject.productSearchProcesUsingAutoSuggest("Mac");
}
}
