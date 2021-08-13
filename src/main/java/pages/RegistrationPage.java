package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "gender-male")
	WebElement genderBtn;
	@FindBy(id = "FirstName")
	WebElement fnameTxtBox;
	@FindBy(id = "LastName")
	WebElement lnameTxtBox;
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassTxtBox;
	@FindBy(id = "register-button")
	WebElement registerBtn;
	@FindBy(css = "div.result")
	public WebElement successNotification ;
	@FindBy(linkText ="Log out")
	public WebElement logOutLink ;
	@FindBy(linkText ="My account")
	public WebElement MyAccountLink ;
	
	public void registrationProcess(String fname,String lname,String email,String pass) {
		clickBtn(genderBtn);
		sendKeysTxt(fnameTxtBox, fname);
		sendKeysTxt(lnameTxtBox, lname);
		sendKeysTxt(emailTxtBox, email);
		sendKeysTxt(passwordTxtBox, pass);
		sendKeysTxt(ConfirmPassTxtBox, pass);
		clickBtn(registerBtn);
	}
	public void userLogOut() {
		clickBtn(logOutLink);
	}
	public void openMyAccountPage() {
		clickBtn(MyAccountLink);
	}
	
}
