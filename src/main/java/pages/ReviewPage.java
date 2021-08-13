package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends PageBase {

	public ReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxtBox;
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxtArea;
	@FindBy(id="addproductrating_4")
	WebElement ratingSelect;
	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitRefiewBtn;
	@FindBy(className = "div.result")
	public WebElement reviewResult;
	public void addReviewProcess(String reviewTitle , String reviewMessage) {
		sendKeysTxt(reviewTitleTxtBox, reviewTitle);
		sendKeysTxt(reviewTxtArea, reviewMessage);
		clickBtn(ratingSelect);
		clickBtn(submitRefiewBtn);
	}
	

}
