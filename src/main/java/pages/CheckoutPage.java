package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
	

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement selectCountry;
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxtBox;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxtBox;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCodeTxtBox;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumbetextBox;
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement shippingNextBtn;
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement paymentNextBtn;
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement paymnetInfoNextBtn;
	@FindBy(className = "product-name")
	public WebElement productName;
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmOrderBtn;
	@FindBy(css = "div.title")
	public WebElement orderProceedResult;
	@FindBy(css = "button.button-1.order-completed-continue-button")
	WebElement completeContinueBtn;
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;
	
	public void checkoutInfoProcess(String city, String address , String zipCode , String phoneNumber ) throws InterruptedException {
		options = new Select(selectCountry);
		options.selectByIndex(5);
		sendKeysTxt(cityTxtBox, city);
		sendKeysTxt(addressTxtBox, address);
		sendKeysTxt(zipCodeTxtBox,zipCode );
		sendKeysTxt(phoneNumbetextBox, phoneNumber);
		clickBtn(continueBtn);
		Thread.sleep(3000);
		clickBtn(shippingNextBtn);
		Thread.sleep(3000);
		clickBtn(paymentNextBtn);
		Thread.sleep(3000);
		clickBtn(paymnetInfoNextBtn);
		
	}
	public void confirmOrder() {
		clickBtn(confirmOrderBtn);
	}
	public void openOrderDetails() {
		clickBtn(orderDetailsLink);
	}
	
	

}
