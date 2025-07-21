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

public class addingTwoProductsToCart {

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
		WebElement firstProduct = driver.findElement(By.xpath("(button[data-product-id='1']"));
		firstProduct.click();
		WebElement secondProduct = driver.findElement(By.xpath("button[data-product-id='2']"));
		secondProduct.click();
		
		
	}

}
