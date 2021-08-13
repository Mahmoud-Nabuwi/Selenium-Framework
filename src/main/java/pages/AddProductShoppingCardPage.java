package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductShoppingCardPage extends PageBase{

	public AddProductShoppingCardPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "button.remove-btn")
	WebElement removeProductBtn;
	@FindBy(css = "input.qty-input")
	WebElement quantityBox;
	@FindBy(css = "button.button-2.update-cart-button")
	WebElement updateBtn;
	@FindBy(css = "td.subtotal")
	public WebElement subTotalBox;
	@FindBy(id = "termsofservice")
	WebElement termsCheckBox;
	@FindBy(css = "button.button-1.checkout-button")
	WebElement checkoutBtn;
	public void updateProductQuantity(String quantity ) {
		quantityBox.clear();
		sendKeysTxt(quantityBox, quantity);
		clickBtn(updateBtn);
	}
	public void removeProductFromCard() {
		clickBtn(removeProductBtn);
	}
	public void openCheckoutPage() {
		clickBtn(termsCheckBox);
		clickBtn(checkoutBtn);
	}

}
