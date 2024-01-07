package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class HandleCalenderUIinTravelWebSites {
	WebDriver driver;
  @Test
  public void test() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  
	  driver.navigate().refresh();
	  // <input name="ctl00$mainContent$view_date1" type="text" readonly="readonly"
	  // id="ctl00_mainContent_view_date1" class="custom_date_pic required picker-first home-date-pick valid">
	  WebElement departure_date= driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date1']"));
	  departure_date.click();
	  
	  Thread.sleep(2000);
	  
	  // <a class="ui-state-default ui-state-highlight" href="#">18</a>
	  WebElement from_date= driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
	  from_date.click();
	  
	  //unique class name for current date
	  
	  // for future date there ll be some special attributes and has same class names
	  
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
