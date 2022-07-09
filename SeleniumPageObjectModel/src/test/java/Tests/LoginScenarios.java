package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.loginPage;
import Utilities.DataLoader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScenarios {

	public WebDriver driver;
	@Parameters({"browserName"})
	@BeforeMethod
	public void OpenBrowser(String browserName) {
		switch(browserName){
		case "chrome":
			WebDriverManager.chromedriver().cachePath("src/test/resources/drivers").setup(); 
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().cachePath("src/test/resources/drivers").setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalStateException("Invalid browser name: ");
		}
		driver.manage().window().maximize();
		driver.get(new DataLoader().getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test()
	public void invalidlogin() {
		new loginPage(driver).enterusername(new DataLoader().getUsername());
		new loginPage(driver).enterpassword(new DataLoader().getPassword());
		new loginPage(driver).clickLogin();
		String actual = new loginPage(driver).getErrorMsg();
		System.out.println("test2"); 
		Assert.assertEquals(actual, "Epic sadface: Username and password do not match any user in this service");
	}


	
@Test()	
public void invalidlogin3() {
	Assert.assertTrue(true);	
	}
	
@Test
public void validlogin() {
	
}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
