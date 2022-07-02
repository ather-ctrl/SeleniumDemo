package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutPage extends BasePage{
	public WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(name= "finish")
	private WebElement finish;
	
	public completePage clickFinish() {
		click(finish);
		return new completePage(driver);
	}
}
