package manojframeworks.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;

import manojframeworks.PageObjects.OrderPage;




public class AbsractCompenentsReUseable {
	
	WebDriver driver;
	
	
	public AbsractCompenentsReUseable(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		
		
		
	}


	public void waitForElementsToAppear(By findBy)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementsToAppear(WebElement findBy)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementsTodisAppear(WebElement element)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
	
	public void scrollToCheckOutBtn()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0, 200)");
	}
	
	public void scrollToCheckOutBtn1()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0, 900)");
	}
	
	public void ThreadSleepForIndClick() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	//button[@routerlink='/dashboard/myorders']
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderBtn;
	
	public OrderPage goToOrders()
	{
		orderBtn.click();
		OrderPage orderPage =  new OrderPage(driver);
		return orderPage;
	}
	
	
	
	
	
	
	
	

}
