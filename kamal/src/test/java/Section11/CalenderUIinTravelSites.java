package Section11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CalenderUIinTravelSites {
	WebDriver driver;
  @Test
  public void ui_test() {
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));
	  driver.get("https://www.path2usa.com/travel-companion/");
	  
	  //click on specific date
	  WebElement cal = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", cal);
	  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='form-field-travel_comp_date']")));
	  
	// cal.click();
	 Actions a = new Actions(driver);
	 // a.moveToElement(cal).click().build().perform();
	 //a.moveByOffset(293, 1319).click().build().perform();
	 a.moveToElement(cal).contextClick().build().perform();
	  
	  while(!driver.findElement(By.cssSelector("[class='flatpickr-month'] [class='flatpickr-next-month']")).getText().contains("December"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
	  
	  List<WebElement> allDates= driver.findElements(By.className("flatpickr-day "));
	  
	  int count= allDates.size();
	  System.out.println(count);
	  for(int i=0;i<count;i++) {
		  String Date= allDates.get(i).getText();
		  if(Date.equalsIgnoreCase("31")) {
			  allDates.get(i).click();
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
  }

}
