package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addressPage extends BasePage{

	public WebDriver driver;
	public addressPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id= "first-name")
	private WebElement firstName;
	
	@FindBy(id= "last-name")
	private WebElement lastName;
	
	@FindBy(id= "postal-code")
	private WebElement zipPostalCode;
	
	@FindBy(name = "continue")
	private WebElement continueBtn;
	
	public checkOutPage enterDetails(String fName, String lName, String zipCode) {
		enterText(firstName,  fName);
		enterText(lastName, lName);
		enterText(zipPostalCode,zipCode );
		click(continueBtn);
		return new checkOutPage(driver);
	}
	
	
	
}
