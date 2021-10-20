package tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BaseTest {

//	@Test
	public void addMealToCardTest() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPP.getCloseElement().click();
		mealPage.addToCard("5");
		softAssert.assertTrue(notifiSP.getMessageForLocation().getText()
				.contains("The Following Errors Occurred: Please Select Location"));
		wdWait.until(ExpectedConditions.invisibilityOf(notifiSP.getMessageForLocation()));
		locationPP.setLocationName("City Center - Albany");
		Thread.sleep(1000);
		mealPage.addToCard("7");
		Thread.sleep(300);
		softAssert.assertTrue(notifiSP.getMessageForSucefullyAddToCard().getText().contains("Meal Added To Cart"));
		
	}
	
//	@Test
	public void addMealToFavourite() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPP.getCloseElement().click();
		mealPage.addToFavorites();
		softAssert.assertTrue(notifiSP.getMessagePleaseLogin().getText().contains("Please login first!"));
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		loginPage.logIn(username, password);
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addToFavorites();
		softAssert.assertTrue(notifiSP.getMessagee().getText().contains("Product has been added to your favorites."));
	}

	
	@Test
	public void clearCartTest() throws InterruptedException, IOException {
		SoftAssert softAssert = new SoftAssert();
		driver.get("http://demo.yo-meals.com/meals");
		locationPP.getCloseElement().click();
		locationPP.setLocationName("City Center - Albany");
		File file = new File("C:\\Users\\Info\\Desktop\\data\\Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetMeals= wb.getSheet("Meals");
//		locationPP.getCloseElement().click();
		
		for (int i = 1; i <=5; i++) {
			String meal = (sheetMeals.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(500);
			driver.get(meal);
			mealPage.addToCard("5");
			softAssert.assertTrue(notifiSP.getMessageForSucefullyAddToCard().getText().contains("Meal Added To Cart"));
		}	
		
		Thread.sleep(500);
		cartSummary.cleearAll();
		softAssert.assertTrue(notifiSP.getMessagee().getText().contains("All meals removed from Cart successfully"));
		
		
	}
}
