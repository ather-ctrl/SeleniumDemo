package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.addressPage;
import Pages.cartPage;
import Pages.checkOutPage;
import Pages.completePage;
import Pages.loginPage;
import Pages.productDetailPage;
import Pages.productsPage;

public class SauceLabsTestCases {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe"); 
		driver = new ChromeDriver();   //Open the browser
		driver.get("https://www.saucedemo.com/"); 	
	}
	
	@Test(description = "this is end to end purchase!!", priority= 1, timeOut=3000, invocationCount=3 )
	public void avalidcredentials() {
		
		new loginPage(driver).enterusername("standard_user");
		new loginPage(driver).enterpassword("secret_sauce");
		new loginPage(driver).clickLogin();
		new productsPage(driver).ChooseOneProduct();
		new productDetailPage(driver).clickAddToCart();
		new productsPage(driver).clickShoppingCart();
		new cartPage(driver).clickCheckOut();
		new addressPage(driver).enterDetails("Maria", "S", "234232424");
		new checkOutPage(driver).clickFinish();
		String actual = new completePage(driver).validatelastMsg();
		Assert.assertNotEquals(actual, "THANK YOU FOR YOUR");				//pass or fail
	}
	
	@Test(enabled = true)
	public void b() {
		System.out.println("This is test case 2");
		
	}
	
	@Test(enabled = true)
	public void c() {
		System.out.println("This is test case 2");
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
