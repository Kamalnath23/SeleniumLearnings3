package section8;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class BuildProgrammingLogicToProcessItemsInArrayForCart {
	WebDriver driver;
  @Test
  public void f() {
	  
	  String itemsNeeded[]= {"Cucumber","Brocolli","Beetroot"};
	  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	  //check whether 
	  List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size();i++) {
			String product_name[]= products.get(i).getText().split("-");
			String vegName= product_name[0].trim();
			//format to trim it to specific vegetable name
			//covert array into array list for easy search - to save memeory. we're coverting it during run time
			//check whether name you extracted is presented in array or not-
			 List itemsNeededList = Arrays.asList(itemsNeeded);
			 System.out.println(itemsNeededList+" vs "+vegName);
			if(itemsNeededList.contains(vegName)) {
				// click on Add to cart
				 driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
				
			}
		}
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(option);
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
