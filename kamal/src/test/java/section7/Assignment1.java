package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment1 {
	WebDriver driver;
  @Test
  public void assignment() {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  
	  //<input id="checkBoxOption1" value="option1" name="checkBoxOption1" type="checkbox">
	  WebElement cb1= driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
	  cb1.click();
	  System.out.println(cb1.isSelected());
	  Assert.assertTrue(cb1.isSelected());
	  
	  cb1.click();
	  System.out.println(cb1.isSelected());
	  Assert.assertFalse(cb1.isSelected());
	  
	  List<WebElement> cb= driver.findElements(By.xpath("//input[@type='checkbox'][contains(@value,'option')]"));
	  System.out.println(cb.size());
	  
	  List<WebElement> cb_total= driver.findElements(By.xpath("//input[@type='checkbox']"));
	  System.out.println(cb_total.size());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	driver.quit();
  }

}
