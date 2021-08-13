package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password")
	WebElement changePasswordlink;
	@FindBy(id = "OldPassword")
	WebElement oldPassTxtBox;
	@FindBy(id = "NewPassword")
	WebElement newPassTxtBox;
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPassTxtBox;
	@FindBy(css ="button.button-1.change-password-button")
	 WebElement changhPassBtn ;
	@FindBy(css ="p.content")
	 public WebElement resultLabel ;
	@FindBy(css ="span.close")
	 public WebElement closeMark ;
	
	public void openChangePassPage() {
		clickBtn(changePasswordlink);
	}
	public void changePasswordProcess(String oldPass,String newPass) {
		sendKeysTxt(oldPassTxtBox, oldPass);
		sendKeysTxt(newPassTxtBox, newPass);
		sendKeysTxt(confirmNewPassTxtBox, newPass);
		clickBtn(changhPassBtn);
	}
	public void closeLabel() {
		clickBtn(closeMark);
	}


}
