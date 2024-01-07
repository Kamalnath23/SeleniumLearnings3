package section5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Test2 {
	WebDriver driver;
  @Test
  public void css() {
driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  
	  //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	  
	  //<input type="text" placeholder="Username" id="inputUsername" value="">
	  //WebElement username= driver.findElement(By.id("inputUsername"));
	  WebElement username=driver.findElement(By.cssSelector("input#inputUsername"));
	  username.sendKeys("Kamal");
	  
	  //<input type="password" placeholder="Password" name="inputPassword" value="">
	  WebElement pass= driver.findElement(By.name("inputPassword"));
	  //try css selector later
	  pass.sendKeys("rahulshettyacademy");
	  
	  //<button class="submit signInBtn" type="submit">Sign In</button>
	  //WebElement submitButton= driver.findElement(By.className("signInBtn"));
	  WebElement submitButton= driver.findElement(By.cssSelector("button.submit"));
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
	  //driver.quit();
  }

}
