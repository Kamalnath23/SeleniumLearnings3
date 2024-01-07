package section6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserActivities {
	WebDriver driver;
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  //driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  driver.get("https://www.google.com/"); //here selenium ll wait by default till 100% component loaded
	  driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");  //but here not like above case. Immediate execution starts
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // Hence, we're introducing Implicit wait. Thread.wait or Explicit wait function can also be added
	  driver.navigate().back();
	  driver.navigate().forward();
	  
	  
	  
	  
	  
	  
			  
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
