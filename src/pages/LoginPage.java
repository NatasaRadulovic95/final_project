package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	

	
	
	public LoginPage(WebDriver driver, WebDriverWait wdWait) {
		super(driver, wdWait);
		// TODO Auto-generated constructor stub
	}

	public WebElement getInputUserNameFiled() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getInputPasswordFiled() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void logIn(String email, String password) {
		this.getInputUserNameFiled().clear();
		this.getInputUserNameFiled().sendKeys(email);
		this.getInputPasswordFiled().clear();
		this.getInputPasswordFiled().sendKeys(password);
		this.getLoginButton().click();
	}
	
}
