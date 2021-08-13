package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhishListPage extends PageBase{

	public WhishListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "a.product-name")
	public WebElement productCell;
	
	@FindBy(name = "updatecart")
	 WebElement removeProduct;
	
	@FindBy(css = "div.no-data")
	public WebElement removedResult;
	
	public void removeProductWishListProcess() {
		clickBtn(removeProduct);
	}
	

}
