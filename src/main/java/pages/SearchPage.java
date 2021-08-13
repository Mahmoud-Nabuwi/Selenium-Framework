package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
	@FindBy(id = "ui-id-1")
	List<WebElement> productSuggest;
	@FindBy(linkText ="Apple MacBook Pro 13-inch")
	WebElement productLink;
	
	public void productSearchProcess(String productName) {
		sendKeysTxt(searchTxtBox, productName);
		clickBtn(searchBtn);
	}
	public void openProductDetails() {
		clickBtn(productLink);
	}
	public void productSearchProcesUsingAutoSuggest(String product) throws InterruptedException {
		sendKeysTxt(searchTxtBox, product);
		Thread.sleep(3000);
		productSuggest.get(0).click();
	}
}
