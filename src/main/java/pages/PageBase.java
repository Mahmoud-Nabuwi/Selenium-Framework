package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	public JavascriptExecutor js;
	public  Select options;
	public Actions builder;
	
// create constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	protected static void clickBtn(WebElement button) {
		button.click();
	}
	protected static void sendKeysTxt(WebElement textField , String value) {
		textField.sendKeys(value);
	}
	protected void scrollToBottom() {
		js.executeScript("scrollBy(0,2000)");
	} 
	
}
