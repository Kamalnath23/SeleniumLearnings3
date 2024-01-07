package section6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class siblimgWithXpathTransverse {
	WebDriver driver;
  @Test
  public void test() {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  
	  //   driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); - shopping website
	  //	driver.get("https://rahulshettyacademy.com/angularpractice/");
	  
	  // one sibling to other
	  WebElement login= driver.findElement(By.xpath("//header/div/button[2]"));
	  System.out.println(login.getText());
	  
	  WebElement loginFollowingElement = driver.findElement(By.xpath("//header/div/button[2]/following-sibling::button[1]"));
	  System.out.println(loginFollowingElement.getText());
	  
	  //child element to parent element xpath
	  
	  WebElement practice = driver.findElement(By.xpath("//header/div/button[2]/parent::div/button[1]"));
	  System.out.println(practice.getText());
	  
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
