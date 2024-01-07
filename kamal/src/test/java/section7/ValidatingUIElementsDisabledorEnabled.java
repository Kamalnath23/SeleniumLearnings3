package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ValidatingUIElementsDisabledorEnabled {
	WebDriver driver;
	
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  driver.navigate().refresh();
	  
	  //<input id="ctl00_mainContent_rbtnl_Trip_0" type="radio" name="ctl00$mainContent$rbtnl_Trip" value="OneWay">
	  WebElement oneway= driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
	  
	  //<input id="ctl00_mainContent_rbtnl_Trip_1" type="radio" name="ctl00$mainContent$rbtnl_Trip" value="RoundTrip">
	  WebElement returntrip= driver.findElement(By.xpath("(//*[@value='RoundTrip'])[1]"));
	  
	  //<input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick">
	  WebElement dd= driver.findElement(By.name("ctl00$mainContent$view_date2"));
	  
	  //WebElement from_date= driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
	  
	  System.out.println("Check: "+dd.isEnabled());
	  
	  WebElement div=driver.findElement(By.id("Div1"));
	  System.out.println(div.getAttribute("style"));
	  
	  returntrip.click();
	  System.out.println(div.getAttribute("style"));
	  
	 if(div.getAttribute("style").contains("1")) {
		  System.out.println("Return date is enabled");
		  System.out.println("One way is not enabled");
	 }else {
		 System.out.println("One way is enabled");
		 System.out.println("Return date not enabled");
		
	 }
	 
	 System.out.println("Clicking one-way");
	 oneway.click();
	 System.out.println("one way clicked.");
	 
	 if(div.getAttribute("style").contains("1")) {
		  System.out.println("Return date is enabled");
		  System.out.println("One way is not enabled");
	 }else {
		 System.out.println("One way is enabled");
		 System.out.println("Return date not enabled");
		 
	 }
	 
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  		System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
