package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatioPopUpPage extends BasicPage {
	

	public LocatioPopUpPage(WebDriver driver, WebDriverWait wdWait) {
		super(driver, wdWait);
		// TODO Auto-generated constructor stub
	}


	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	public WebElement getLocationButton() {
			return driver.findElement(By.xpath("//*[@class='location-selector']/a"));
	
	}
	
	public boolean isLocationButtonDisplayed() {
		try {
			driver.findElement(By.xpath("//*[@class='location-selector']"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public WebElement getCloseElement() {
		return driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
	}
	
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@class='location-search-field']/input"));
		
	}
	
	public WebElement getLocationItem(String locationName) {
		 return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}										
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getlocationInput() {
		return driver.findElement(By.xpath("//input[@id='location_id']"));
		
	}
	
	public void openPopUpDialog() {
		if(this.isLocationButtonDisplayed()) {
			this.getLocationButton().click();
		}
	
	}


	public void setLocationName(String locationName) throws InterruptedException {
		
		this.getLocationButton().click();
		Thread.sleep(500);
		this.getKeyword().click();
		Thread.sleep(500);
		js.executeScript("arguments[0].scrollIntoView(true);", this.getLocationItem(locationName));
		this.getLocationItem(locationName).click();
		this.getSubmitButton().click();
		
	}
	
	
}
