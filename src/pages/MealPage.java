package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{

	
	
	public MealPage(WebDriver driver, WebDriverWait wdWait) {
		super(driver, wdWait);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMealButton() {
		return driver.findElement(By.xpath("//*[@class='navs--main']/ul/li"));
	}
	
	public WebElement getFirstMeal() {
		return driver.findElement(By.xpath("//*[@class='featured-img']/a/img"));
		
	}
	
	public WebElement getQuantity() {
		return driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getAddToCard() {
		
		return driver.findElement(By.xpath("//*[contains(@class,'btn btn--primary btn--large j')]"));
	}
	
	public WebElement getAddToFavoritesButton() {
		return driver.findElement(By.id("item_119"));
	}
	
	public void addToCard(String numberOfMeal) {
		this.getQuantity().sendKeys(Keys.CONTROL+"a"+Keys.ENTER);
		this.getQuantity().sendKeys(numberOfMeal);
		this.getAddToCard().click();
		
	}
	
	public void addToFavorites() {
		this.getAddToFavoritesButton().click();
	}
}
