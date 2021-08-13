package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "table.compare-products-table")
	WebElement compareTable;
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	@FindBy(tagName = "td")
	public List<WebElement> allColumn;
	@FindBy(className = "clear-list")
	WebElement clearBtn;
	@FindBy(css = "div.no-data")
	public WebElement noItemResult;
	
	public void clearCompareTable() {
		clickBtn(clearBtn);
	}
	public void compareProductProcess() {
		for(WebElement row : allRows) {
			System.out.println(row.getText() + "/n");
			for(WebElement col :allColumn) {
				System.out.println(col.getText() + "/n");

			}
		}
	}
	
	

}
