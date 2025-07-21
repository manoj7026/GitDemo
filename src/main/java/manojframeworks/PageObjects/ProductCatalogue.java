package manojframeworks.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import manojframeworks.AbstractComponents.AbsractCompenentsReUseable;

public class ProductCatalogue extends AbsractCompenentsReUseable{
	
	

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".offset-md-0"));
	@FindBy(css=".offset-md-0")
	List<WebElement> products;
	
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	@FindBy(css=".ng-animating")
	WebElement animating;
	
	//driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]")
	WebElement cartBtn;
	
	
	
	
	
	By waitBy = By.cssSelector(".offset-md-0");
	By addToCartClick = By.cssSelector(".card-body button:last-of-type");
	By toaster = By.cssSelector("#toast-container");
	//WebElement animation = driver.findElement(By.cssSelector(".ng-animating"));
	


	
	public List<WebElement> getProductsList()
	{
		waitForElementsToAppear(waitBy);
		return products;
	}
	
	
	public WebElement getProductName(String productName) {
		
		
		WebElement pro = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return pro;
	}
	
	public CheckOut addToCart(String productName) throws InterruptedException 
	{
		
		WebElement pro = getProductName(productName);
		pro.findElement(addToCartClick).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitForElementsToAppear(toaster);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		waitForElementsTodisAppear(animating);
		cartBtn.click();
		Thread.sleep(2000);
		CheckOut checkOut = new CheckOut(driver);
		return checkOut;
		
		
		
	}
	
	
	
	
	

}
