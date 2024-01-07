package section5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Test5 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  //
	  WebElement link= driver.findElement(By.linkText("Forgot your password?"));
	  link.click();
	  Thread.sleep(2000);
	  WebElement resetLogin= driver.findElement(By.cssSelector("button.reset-pwd-btn"));
	  resetLogin.click();
	  //<p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
	  
	  
	  // <input type="text" placeholder="Username" id="inputUsername" value="">
	  WebElement uname= driver.findElement(By.cssSelector("#inputUsername"));
	  uname.sendKeys("Kamal");
	  
	  // <input type="password" placeholder="Password" name="inputPassword" value="">
	  // using css special attributes since last 4 alphabets of the value may change dynamically
	  WebElement password=driver.findElement(By.cssSelector("input[type*='pass']"));
	  
	
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.close();
  }

}
