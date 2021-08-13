package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		builder = new Actions(driver);
	}
	@FindBy(linkText = "Register")
	WebElement RegisterLinke;
	@FindBy(linkText = "Log in")
	WebElement loginLinke;
	@FindBy(linkText = "Contact us")
	WebElement contactLink;
	@FindBy(id = "customerCurrency")
	WebElement selectCurrency;
	
	@FindBy(linkText = "Computers")
	WebElement comuterMenue;
	@FindBy(linkText = "Notebooks")
	WebElement noteBookLink;
	
	public void openRegisterPage() {
		clickBtn(RegisterLinke);
	}
	public void openLoginPage() {
		clickBtn(loginLinke);
	}
	public void openContactUsPage() {
		scrollToBottom();
		clickBtn(contactLink);
	}
	
	public void selectCurrencyProcess() {
		options = new Select(selectCurrency);
		options.selectByIndex(1);
		
	}
	public void selectNoteBooksMenu() {
		
		builder.moveToElement(comuterMenue).moveToElement(noteBookLink).click().build().perform();
	}
	
}
