package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicPage {

	protected WebDriver driver;
	protected WebDriverWait wdWait;

	public BasicPage(WebDriver driver, WebDriverWait wdWait) {
		this.driver = driver;
		this.wdWait = wdWait;
	}
}
