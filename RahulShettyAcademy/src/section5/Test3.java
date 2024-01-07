package section5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Test3 {
	WebDriver driver;
	
  @Test
  public void xpath() {
	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //<input type="text" placeholder="Username" id="inputUsername" value="">
	  //WebElement username= driver.findElement(By.id("inputUsername"));
	  WebElement username=driver.findElement(By.xpath("//input[@id='inputUsername']"));
	  username.sendKeys("Kamal");
	  
	  //<input type="password" placeholder="Password" name="inputPassword" value="">
	  //WebElement pass= driver.findElement(By.name("inputPassword"));
	  WebElement pass=driver.findElement(By.xpath("//input[@name='inputPassword']"));
	  pass.sendKeys("rahulshettyacademy");
	  
	  //<button class="submit signInBtn" type="submit">Sign In</button>
	  //WebElement submitButton= driver.findElement(By.className("signInBtn"));
	  WebElement submitButton= driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button"));
	  // //*[@id="container"]/div[2]/form/button
	  submitButton.click();
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
