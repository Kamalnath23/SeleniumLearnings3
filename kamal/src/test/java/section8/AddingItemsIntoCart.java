package section8;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AddingItemsIntoCart {
	WebDriver driver;

	@Test
	public void f() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// //button[text()='ADD TO CART'] - this xpath showing all 30 elements present
		// in the shopping site

		// h4.product-name -- css selector showing all 30 product lists as well
		
		// So, Sending array of carts for products to check out
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size();i++) {
			String product_name= products.get(i).getText();
			
			if(product_name.contains("Cucumber")) {
				// click on Add to cart
				 driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
				
			}
		}
		
		for(int i=0; i<products.size();i++) {
			String product_name= products.get(i).getText();
			
			if(product_name.contains("Brocolli")) {
				// click on Add to cart
				 driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
				
			}
		}
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
