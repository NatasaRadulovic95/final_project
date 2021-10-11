package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatioPopUpPage {
	
	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	public LocatioPopUpPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getLocationButton() {
		return driver.findElement(By.xpath("//*[@class='location-selector']"));
	}
	
	public WebElement getCloseElement() {
		return driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
	}
	
	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
		
	}
	
	public WebElement getLocationItem(String locationName) {
		 return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getlocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id"));
		
	}
	
	public void openPopUpDialog() {
		this.getLocationButton().click();
	}


	public void setLocationName(String locationName) {
		String dataValue = this.getLocationItem(locationName).getAttribute("value");
		js.executeScript("arguments[0].value=arguments[1]", this.getlocationInput(), dataValue);
		
		js.executeScript("arguments[0].click();", this.getSubmitButton());
		this.getCloseElement().click();
	}
	
	
}
