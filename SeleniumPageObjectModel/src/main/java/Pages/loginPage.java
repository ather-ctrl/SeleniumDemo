package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage{   //BasePage is a parent class, loginPage child
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//1. Page Elements
	@FindBy(id = "user-name")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement pwd;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement errBtn;
	
	@FindBy(id = "uploadFile")
	private WebElement upload;
	
	public String getErrorMsg() {
		return getText(errBtn);
	}
	
	// 2 Page Actions
	public loginPage enterusername(String userNAme) {
		enterText(userName, userNAme);
		return this;
	}
	
	public void uploadFile() {
		enterText(upload, "C:\\Users\\EB933HU\\Downloads\\most-complete-webdriver-java-cheat sheet.pdf");
	}
	public loginPage enterpassword(String passWord) {
		enterText(pwd, passWord);
		return this;
	}
	
	public productsPage clickLogin() {
		click(loginBtn);
		return new productsPage(driver);
	}
	
}
