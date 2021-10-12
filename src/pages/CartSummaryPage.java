package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	
	
	
	public CartSummaryPage(WebDriver driver, WebDriverWait wdWait) {
		super(driver, wdWait);
		// TODO Auto-generated constructor stub
	}

	public WebElement getClearAllButton() {
		return driver.findElement(By.xpath("//*[@class='btn btn--third  btn--small no-radius']"));
	}
	
	public void cleearAll() {
		this.getClearAllButton().click();
	}
}
