package tests;
//apstraktna klasa koja sadrži sve zajedničke funkcionalnosti za sve test klase
//od dodatnih atributa ima:
//baseUrl 
//imejl i lozinku demo korisnika customer@dummyid.com/12345678a
//BeforeMethod metoda koja konfiguriše Selenium drajver
//AfterMethod metoda koja u slučaju pada testa kreira screenshot stranice i te slike čuva u 
//okviru screenshots direktorijuma i zatvara sesiju drajvera
//sve ostale test klase nasleđuju ovu klasu

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.Helper;
import pages.LocatioPopUpPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

abstract class BaseTest {

	protected WebDriver driver;
	protected LocatioPopUpPage locationPP;
	protected WebDriverWait wdWait;
	protected LoginPage loginPage;
	protected ProfilePage profilePage;
	protected AuthPage authorPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummary;
	protected NotificationSistemPage notifiSP;
	protected Helper helper;
	
	protected String baseUrl = "https://demo.yo-meals.com/";
	protected String loginPagee = "";
	protected String profilPage = "";
	
	protected String username ="customer@dummyid.com";
	protected String password = "12345678a";
	
	ITestResult result;
	 
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver_lib\\chromedriver.exe");
		driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wdWait = new WebDriverWait(driver, 10);
		 
		this.driver = new ChromeDriver();
		this.locationPP = new LocatioPopUpPage(driver, wdWait);
		this.loginPage = new LoginPage(driver, wdWait);
		this.profilePage = new ProfilePage(driver, wdWait, helper);
		this.authorPage = new AuthPage(driver, wdWait);
		this.mealPage = new MealPage(driver, wdWait);
		this.cartSummary = new CartSummaryPage(driver, wdWait);
		this.helper = new Helper();
		this.notifiSP = new NotificationSistemPage(driver, wdWait);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {
		
		if(result.FAILURE == result.getStatus()) {
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			
		}
	}
	
}
