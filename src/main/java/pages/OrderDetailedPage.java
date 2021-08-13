package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailedPage extends PageBase{

	public OrderDetailedPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement downloadInviceBtn;
	@FindBy(css = "a.button-2.print-order-button")
	WebElement printInvoiceBtn;
	
	public void printInvoice() {
		clickBtn(printInvoiceBtn);
	}
	public void downloadInvoice() {
		clickBtn(downloadInviceBtn);
	}
	
}
