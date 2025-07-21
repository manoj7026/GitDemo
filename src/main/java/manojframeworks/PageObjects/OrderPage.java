package manojframeworks.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojframeworks.AbstractComponents.AbsractCompenentsReUseable;

public class OrderPage extends AbsractCompenentsReUseable{
	
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//tr td:nth-child(3) 
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordersList;
	
	public Boolean verifyOrdersList(String productName)
	{
		Boolean match = ordersList.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}
