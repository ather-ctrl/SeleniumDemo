package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void click(WebElement e) {
		waitForElement(e);
		e.click();
	}

	public void enterText(WebElement e, String text) {
		waitForElement(e);
		e.sendKeys(text);
	}

	public void waitForElement(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	public String getText(WebElement e) {
		waitForElement(e);
		return e.getText();
	}
	public void clear(WebElement e) {
		waitForElement(e);
		e.clear();
	}
	public void clickByJavaScript(WebElement e) {
		waitForElement(e);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", e);
	}	

	public void doubleClick(WebElement e) {
		Actions actions = new Actions(driver);
		waitForElement(e);
		actions.doubleClick().perform();	
	}
	public void rightClick(WebElement e) {
		Actions actions = new Actions(driver);
		waitForElement(e);
		actions.contextClick().perform();	
	}
	public void switchToNextTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}
	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}
	public void ScrollToElement(WebElement e) {
		waitForElement(e);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",e);
	}
	public void OpenNewTab() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open()");
	}
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}
	public void selectByValue(WebElement e, String value) {
		waitForElement(e);
		Select selectElement = new Select(e);
		selectElement.selectByValue(value);
	}
	public void selectByText(WebElement e, String text) {
		waitForElement(e);
		Select selectElement = new Select(e);
		selectElement.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement e, int number) {
		waitForElement(e);
		Select selectElement = new Select(e);
		selectElement.selectByIndex(number);
	}
	public void moveToElement(WebElement e) {
		Actions actions = new Actions(driver);
		waitForElement(e);
		actions.moveToElement(e).perform();	
	}
	public void fileUpload(String filepath, WebElement e) {
		String path = System.getProperty("user.dir")+"\\testData\\"+ "FilePaths";
		waitForElement(e);
		e.sendKeys(path);
	}
	public void dragnDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();		
	}

	public void submitKeys(WebElement e, Keys k)
	{
		waitForElement(e);	
		e.sendKeys(k);
	}
}
