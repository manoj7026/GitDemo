package manojframeworks.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class standAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		System.setProperty("webdriver.edge.driver", "C:/Intel/edgedriver_win64 (1)/msedgedriver.exe");		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("manu76876@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Manoj@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".offset-md-0")));
		List<WebElement> products = driver.findElements(By.cssSelector(".offset-md-0"));
		WebElement pro = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
//		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(match);
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,200)");
    	
		driver.findElement(By.cssSelector(".totalRow button")).click();
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
    	js1.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
//		Actions actions = new Actions(driver);
//		actions.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		driver.findElement(By.cssSelector(".actions a")).click();
		String confirmationMessage = driver.findElement(By.cssSelector("[class='hero-primary']")).getText();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(driver.findElement(By.cssSelector("div[aria-label$='Order Placed Successfully']")).getText());
		
		
		

	}

}
