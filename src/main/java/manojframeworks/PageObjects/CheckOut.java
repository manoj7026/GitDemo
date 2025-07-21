package manojframeworks.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojframeworks.AbstractComponents.AbsractCompenentsReUseable;

public class CheckOut extends AbsractCompenentsReUseable{
	
	WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
		@FindBy(css="li[class='totalRow'] button[type='button']")
		WebElement checkOutBtn;
		
		//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		@FindBy(xpath="//input[@placeholder='Select Country']")
		WebElement SelectCountry;
		
		//List<WebElement> options = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		@FindBy(css=".ta-item.list-group-item.ng-star-inserted")
		List<WebElement> options;
		
		//driver.findElement(By.cssSelector(".actions a")).click();
		@FindBy(css=".actions a")
		WebElement PlaceHolder;
		
		By checkoutbtnToAppear = By.cssSelector(".totalRow button");
		public void clickOnCheckOutBtn() throws InterruptedException
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
					waitForElementsToAppear(checkoutbtnToAppear);
					ThreadSleepForIndClick();
					scrollToCheckOutBtn();
					checkOutBtn.click();
					scrollToCheckOutBtn();
		}
		
		public void selectIndiaInSelectCountryField(String CntryName)
		{
			SelectCountry.sendKeys(CntryName);
		}
		
		public void oneThreadSleep() throws InterruptedException
		{
			ThreadSleepForIndClick();
		}
		
		public List<WebElement> selectCountryOptions()
		{
			return options;
		}
		
		public void SelectIndiaAndClick()
		{
			for(WebElement option : options)
			{
				if(option.getText().equalsIgnoreCase("India"))
				{
					option.click();
					break;
				}
			}
		}
		
		public Confirmation ClickOnPlaceHolder()
		{
			PlaceHolder.click();
			Confirmation confirmation = new Confirmation(driver);
			return confirmation;
			
		}
		

}
