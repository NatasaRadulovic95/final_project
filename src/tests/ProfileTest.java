package tests;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocatioPopUpPage;
import pages.LoginPage;
import pages.MealPage;
import pages.ProfilePage;

public class ProfileTest extends BaseTest {

	@Test
	public void editProfileTest() throws InterruptedException, AWTException {

		SoftAssert softAssert = new SoftAssert();
		String photo = "";

		driver.get("http://demo.yo-meals.com/guest-user/login-form");

		locationPP.getCloseElement().click();
		Thread.sleep(500);
		loginPage.logIn("customer@dummyid.com", "12345678a");
		softAssert.assertTrue(notifiSP.getMesageText().contains("Login Successfull"));
		driver.get("http://demo.yo-meals.com/member/profile");
		Thread.sleep(2000);
		profilePage.setInformations("Pera", "Petrovic", "FF", "55", "44", "India", "Bihar", "Barh");
		softAssert.assertTrue(notifiSP.getMessageForSaveInf().getText().contains("Setup Successful"));
		authorPage.logOutUser();
		softAssert.assertTrue(notifiSP.getMesageText().contains("Logout Successfull!"));
	}

	@Test
	public void changeProfileImageTest() throws InterruptedException, IOException, AWTException {
		SoftAssert softAssert = new SoftAssert();
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPP.getCloseElement().click();
		Thread.sleep(500);
		loginPage.logIn(username, password);
		softAssert.assertTrue(notifiSP.getMesageText().contains("Login Successfull"));
		driver.get("http://demo.yo-meals.com/member/profile");
		String imgPath = new File("C:\\Users\\Info\\Desktop\\profilna_slika.jpg").getCanonicalPath();
		Thread.sleep(1000);
		profilePage.uploadImage(imgPath);
		softAssert.assertTrue(notifiSP.getMessagee().getText().contains("Profile Image Uploaded Successfully"));
		wdWait.until(ExpectedConditions.invisibilityOf(notifiSP.getMessage()));
		profilePage.removePhoto();
		softAssert.assertTrue(notifiSP.getMessagee().getText().contains("Profile Image Deleted Successfully"));
		wdWait.until(ExpectedConditions.invisibilityOf(notifiSP.getMessage()));
		


	}

}
