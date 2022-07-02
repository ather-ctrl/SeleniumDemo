package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productDetailPage extends BasePage {
	
	public WebDriver driver;
	public productDetailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addToCart;
	
	public void clickAddToCart() {
		click(addToCart);
	}

	//2. PAge element
	// 3 page actions
	
	
}
