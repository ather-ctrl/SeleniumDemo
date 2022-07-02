package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsPage extends BasePage {
// 1. PAge Elements
	public WebDriver driver;
	public productsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//button[text()='Add to cart']")  //6 items 
	private List<WebElement> addToCart;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement backPack;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement shopingCart;
	
	// 2. PAge actions 
	public void ValidateProducts() {
		
		
	}
	
	public productDetailPage ChooseOneProduct() {
		click(backPack);
		return new productDetailPage(driver);
	}
	
	public cartPage clickShoppingCart() {
		click(shopingCart);
		return new cartPage(driver);
	}
	
	

}
