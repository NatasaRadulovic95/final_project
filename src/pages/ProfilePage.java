package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.corba.se.spi.orbutil.fsm.Action;

public class ProfilePage extends BasicPage {

	private Helper helper;
	public ProfilePage(WebDriver driver, WebDriverWait wdWait,Helper helper) {
		super(driver, wdWait);
		this.helper = new Helper();;
		// TODO Auto-generated constructor stub
	}

	public WebElement getFirstNameInput() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastNameInput() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getAddressInput() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneInput() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}

	public Select getDropDownCountry() {
		Select drpCountry = new Select(driver.findElement(By.name("user_country_id")));
		return drpCountry;
	}

	public void setDropDownCountry(String nameCountry) {
		this.getDropDownCountry().selectByVisibleText(nameCountry);
	}

	public Select getDropDownState() {
		Select drpState = new Select(driver.findElement(By.name("user_state_id")));
		return drpState;
	}

	public void setDropDownState(String state) {
		this.getDropDownState().selectByVisibleText(state);

	}

	public Select getDropDownCity() {
		Select drpCity = new Select(driver.findElement(By.name("user_city")));
		return drpCity;
	}

	public void setDropDownCity(String city) {
		this.getDropDownCity().selectByVisibleText(city);
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("btn_submit"));
	}

	public WebElement getCurentpasswor() {
		return driver.findElement(By.name("current_password"));
	}

	public WebElement getNewPassword() {
		return driver.findElement(By.name("new_password"));
	}

	public WebElement confirmPassword() {
		return driver.findElement(By.name("conf_new_password"));
	}

	public WebElement getSave2Button() {
		return driver.findElement(By.xpath("(//*[@name='btn_submit'])[2]"));
	}

	public WebElement getProfileButton() {
		return driver.findElement(By.xpath("//*[@id='fixed__panel']/ul/li[2]"));
	}

	public void getHoverAvatar() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@class='avatar']"))).perform();
	}

	public WebElement getButtonForUpload() {
		
		return driver.findElement(By.xpath("//a[@title='Uplaod']"));

	}
	
	public WebElement getRemoveButton() {
		return driver.findElement(By.xpath("//*[@class='remove']"));
	}

	public void uploadPhoto(String url) throws InterruptedException, AWTException {
		
		this.getProfileButton().click();
		
		this.getHoverAvatar();
		this.getButtonForUpload().click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		this.getButtonForUpload().sendKeys(url);

	}
	
	public void removePhoto() {
		this.getHoverAvatar();
		this.getRemoveButton();
	}
	
	public void setInformations(String name, String lastName,
			String address, String phone, String zipCode,String country, String state, String city) throws InterruptedException {
		this.getFirstNameInput().clear();
		this.getFirstNameInput().sendKeys(name);
		this.getLastNameInput().clear();
		this.getLastNameInput().sendKeys(lastName);
		this.getAddressInput().clear();
		this.getAddressInput().sendKeys(address);
		this.getPhoneInput().clear();
		this.getPhoneInput().sendKeys(phone);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		this.setDropDownCountry(country);
		Thread.sleep(500);
		this.setDropDownState(state);
		Thread.sleep(500);
		this.setDropDownCity(city);
		this.getSaveButton().click();
		
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
}
