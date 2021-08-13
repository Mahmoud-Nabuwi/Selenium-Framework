package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	public EmailPage(WebDriver driver) {
		super(driver);
	}
@FindBy(id = "FriendEmail")
WebElement emailFriendTxtBox;
@FindBy(id = "PersonalMessage")
WebElement personalMsgTxtBox;
@FindBy(css = "button.button-1.send-email-a-friend-button")
WebElement sendEmailBtn;
@FindBy(css = "div.result")
public WebElement msgSentResult;

public void sendEmailFriendProcess(String friendEmaiil , String personalMsg) {
	sendKeysTxt(emailFriendTxtBox, friendEmaiil);
	sendKeysTxt(personalMsgTxtBox, personalMsg);
	clickBtn(sendEmailBtn);
}
}
