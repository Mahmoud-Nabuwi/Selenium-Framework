package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="Email")
	WebElement emailTxtBox;
	@FindBy(id="Password")
	WebElement passTxtBox;
	@FindBy(css="button.button-1.login-button")
	WebElement loginBtn;
	public void loginProcess(String email, String pass) {
		sendKeysTxt(emailTxtBox, email);
		sendKeysTxt(passTxtBox, pass);
		clickBtn(loginBtn);
	}

}
