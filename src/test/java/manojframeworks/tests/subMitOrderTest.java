package manojframeworks.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import manojframeworks.PageObjects.CheckOut;
import manojframeworks.PageObjects.Confirmation;
import manojframeworks.PageObjects.LandingPage;
import manojframeworks.PageObjects.OrderPage;
//import manojframeworks.PageObjects.OrderPage;
import manojframeworks.PageObjects.ProductCatalogue;
import manojframeworks.testComponents.BaseTest;

public class subMitOrderTest extends BaseTest{
	
	String productName = "ZARA COAT 3";
	
		@Test(dataProvider="getData",groups={"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
		{
		
		
		ProductCatalogue productCatalogue = landingPage.logInPage(input.get("email"),input.get("pass"));		
		List<WebElement> products = productCatalogue.getProductsList();
		CheckOut checkOut = productCatalogue.addToCart(input.get("product"));		
		checkOut.clickOnCheckOutBtn();		
		checkOut.selectIndiaInSelectCountryField("ind");
		checkOut.oneThreadSleep();
		List<WebElement> options = checkOut.selectCountryOptions();
		checkOut.SelectIndiaAndClick();
		Confirmation confirmation = checkOut.ClickOnPlaceHolder();		 		
		Assert.assertEquals("THANKYOU FOR THE ORDER.", confirmation.getOrderConfirmationMsg());
		confirmation.orderSuccessFullText();		

	}
		
		@Test(dependsOnMethods={"submitOrder"})
		public void verifyOrdredProduct() throws IOException, InterruptedException
		{
		
		ProductCatalogue productCatalogue = landingPage.logInPage("manu76876@gmail.com", "Manoj@123");
		OrderPage orderPage = productCatalogue.goToOrders();
		System.out.println(orderPage.verifyOrdersList(productName));
		Assert.assertTrue(orderPage.verifyOrdersList(productName));
}
		
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
//			HashMap<String,String> map = new HashMap<String,String>();
//			map.put("email", "manu76876@gmail.com");
//			map.put("pass", "Manoj@123");
//			map.put("product", "ZARA COAT 3");
//			
//			HashMap<String,String> map1 = new HashMap<String,String>();
//			map1.put("email", "anshika@gmail.com");
//			map1.put("pass", "Iamking@000");
//			map1.put("product", "ADIDAS ORIGINAL");
			List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//manojframeworks//data//PurchaseOrder.json");
			
			return new Object[] [] {{data.get(0)},{data.get(1)}};
		}	
				

	
		
		

}
