package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

	public class completePage extends BasePage{
		public WebDriver driver;
		public completePage(WebDriver driver) {
			super(driver);
			this.driver = driver;
		}
		
		@FindBy(xpath = "//h2[contains(text(),'THANK')]")
		private WebElement lastMsg;
		
		public String validatelastMsg() {
			return getText(lastMsg);
		}
}
