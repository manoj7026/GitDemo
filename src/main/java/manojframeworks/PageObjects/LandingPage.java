package manojframeworks.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojframeworks.AbstractComponents.AbsractCompenentsReUseable;

public class LandingPage extends AbsractCompenentsReUseable{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	//driver.findElement(By.id("userEmail")).sendKeys("manu76876@gmail.com");
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword")).sendKeys("Manoj@123");
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement login;
	
	
	
	
	//ActionMethod
	public ProductCatalogue logInPage(String email,String pas)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(pas);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
		
	}
	
	public void goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
	public String getErrorMessage()
	{
		waitForWebElementsToAppear(errorMessage);
		return errorMessage.getText();
	}
	

}
