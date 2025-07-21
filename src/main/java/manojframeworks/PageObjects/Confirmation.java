package manojframeworks.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import manojframeworks.AbstractComponents.AbsractCompenentsReUseable;


public class Confirmation extends AbsractCompenentsReUseable {

	WebDriver driver;
	public Confirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//String confirmationMessage = driver.findElement(By.cssSelector("[class='hero-primary']")).getText();
	@FindBy(css="[class='hero-primary']")
	WebElement confirmationMessage;
	
	//System.out.println(driver.findElement(By.cssSelector("div[aria-label$='Order Placed Successfully']")).getText());
	@FindBy(css="div[aria-label$='Order Placed Successfully']")
	WebElement OrderSuccessText;
	
	public String getOrderConfirmationMsg()
	{
		return confirmationMessage.getText();
	}
	
	public void orderSuccessFullText()
	{
		System.out.println(OrderSuccessText.getText());
	}
	
	
	
	

}
