package manojframeworks.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import manojframeworks.PageObjects.CheckOut;
import manojframeworks.PageObjects.Confirmation;
import manojframeworks.PageObjects.LandingPage;
import manojframeworks.PageObjects.ProductCatalogue;
import manojframeworks.testComponents.BaseTest;

public class errorMessageValidationTest extends BaseTest{

	
		@Test(groups="Smoke")
		public void submitOrder() throws IOException, InterruptedException
		{
		String productName = "ZARA COAT 3";		
		landingPage.logInPage("manu76876@gmail.com", "Ma3");		
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		}
		
		@Test
		public void confirmationMessageValidation() throws IOException, InterruptedException
		{
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.logInPage("mt@gmail.com", "Manoj@123");		
		List<WebElement> products = productCatalogue.getProductsList();
		CheckOut checkOut = productCatalogue.addToCart(productName);		
		checkOut.clickOnCheckOutBtn();		
		checkOut.selectIndiaInSelectCountryField("ind");
		checkOut.oneThreadSleep();
		List<WebElement> options = checkOut.selectCountryOptions();
		checkOut.SelectIndiaAndClick();
		Confirmation confirmation = checkOut.ClickOnPlaceHolder();		 		
		Assert.assertEquals("THANKYOU FOR/ THE ORDER.", confirmation.getOrderConfirmationMsg());
		
		}

}
