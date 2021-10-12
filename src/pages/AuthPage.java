package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	

	
	public AuthPage(WebDriver driver, WebDriverWait wdWait) {
		super(driver, wdWait);
		
	}

	public WebElement getNameOfAuthor() {
		return driver.findElement(By.xpath("//*[@class='filled ']"));
		
	}
	
	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li[2]"));
	}
	
	public void logOutUser() {
		this.getNameOfAuthor().click();
		this.getLogoutButton().click();
	}
}
