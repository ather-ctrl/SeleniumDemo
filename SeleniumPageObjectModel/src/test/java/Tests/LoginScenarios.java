package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.loginPage;

public class LoginScenarios {

	public WebDriver driver;
	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe"); 
		driver = new ChromeDriver();   //Open the browser
		driver.get("https://www.saucedemo.com/"); 	
	}
	
	@Test()
	public void invalidlogin() {
		new loginPage(driver).enterusername("jadkljad");
		new loginPage(driver).enterpassword("secret_sauce");
		new loginPage(driver).clickLogin();
		String actual = new loginPage(driver).getErrorMsg();
		Assert.assertEquals(actual, "Epic sadface: Username and password do not match any user in this service");
	}

	@Test()
	public void FileUpload() {
		new loginPage(driver).uploadFile();
	}
	
@Test(groups = {"logintests"})	
public void invalidlogin3() {
		
	}
	
@Test
public void validlogin() {
	
}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
