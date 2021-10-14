package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {



	
	public NotificationSistemPage(WebDriver driver, WebDriverWait wdWait) {
		super(driver, wdWait);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
		
	}
	
	public WebElement getMessageForSaveInf() {
		return driver.findElement(By.xpath("//*[contains(@class, 'system_message alert alert--position')]"));
		
	}
	
	public WebElement getLogOutMessage() {
		wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class'div_msg']"))));
		return driver.findElement(By.xpath("//*[@class'div_msg']"));
	}
	
	public WebElement getMessageForLocation() {
		return driver.findElement(By.xpath("//*[contains(@class, 'system_message alert alert--')]"));
		
	}
	
	public WebElement getMessageForSucefullyAddToCard() {
		return driver.findElement(By.xpath("//*[@class='system_message alert alert--positioned-top-full alert--success']"));
	}
	public String getMesageText() {
		return driver.findElement(By.xpath("//*[@class='div_msg']")).getText();
	}
	
	public WebElement getMessagePleaseLogin() {
		return driver.findElement(By.xpath("//*[@class='content']"));
		
	}
	
	public WebElement getMessageAssToFavourites() {
		return driver.findElement(By.xpath("//*[@class='content']"));
	}
	
}
