package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends BasePage {

	public WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id= "checkout")
	private WebElement checkout;
	
	public addressPage clickCheckOut() {
		click(checkout);
		return new addressPage(driver);
	}
}
