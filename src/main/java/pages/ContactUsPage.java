package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement fullNameTxtBox;
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	@FindBy(id = "Enquiry")
	WebElement enquiryTxtBox;
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement submitBtn;
	@FindBy(css = "div.result")
	public WebElement enquirySent;
	public void contactUsSendEnquiryProcess(String fullName , String email , String enquiry) {
		sendKeysTxt(fullNameTxtBox, fullName);
		sendKeysTxt(emailTxtBox, email);
		sendKeysTxt(enquiryTxtBox, enquiry);
		clickBtn(submitBtn);
	}

}
