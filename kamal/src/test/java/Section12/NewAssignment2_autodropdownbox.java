package Section12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class NewAssignment2_autodropdownbox {
	WebDriver driver;
	
  @Test
  public void test_autodropdownbox() {
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  String s="uni";
	  WebElement dropdownbox= driver.findElement(By.cssSelector("input#autocomplete"));
	  dropdownbox.sendKeys(s);
	  // div#ui-id-32
	  
	  w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#ui-id-111")));
	  Actions action= new Actions(driver);
	  action.moveToElement(driver.findElement(By.cssSelector("div#ui-id-111"))).click().build().perform();
	  
	  
	  
	  
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
  }

}
