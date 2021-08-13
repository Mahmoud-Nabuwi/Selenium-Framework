package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
    @FindBy(css = "strong.current-item")
    public WebElement productNameBreadCrumb;
    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendLink;
    @FindBy(id = "price-value-4")
   public WebElement productPriceLabel;
    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWhishListLink;
    @FindBy(linkText = "Add your review")
    WebElement ReviewLink;
    @FindBy(linkText = "wishlist")
    WebElement openwhishListPage;
    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement compareLink;
    @FindBy(linkText = "product comparison")
    WebElement productComparisonAlert;
    @FindBy(css = "button.button-1.add-to-cart-button")
    WebElement addToCardBtn;
    @FindBy(className = "ico-cart")
    WebElement shoppingCardBtn;
    public void openSendEmailPage() {
    	clickBtn(emailFriendLink);
    }
    public void openReviewLink() {
    	clickBtn(ReviewLink);
    }
    public void addProductToWhishList() {
    	clickBtn(addToWhishListLink);
    	clickBtn(openwhishListPage);
    }
    public void addProductComparePage() {
    	clickBtn(compareLink);
    }
    public void openComparisonPage() {
    	clickBtn(productComparisonAlert);
    }
    public void addToCard() {
    	clickBtn(addToCardBtn);
    }
    public void openShoppingCardPage() {
    	clickBtn(shoppingCardBtn);
    }
    
    
    }

