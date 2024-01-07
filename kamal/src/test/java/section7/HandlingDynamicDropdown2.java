package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class HandlingDynamicDropdown2 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	//FAILED
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  
	  driver.navigate().refresh();
	  //#ctl00_mainContent_ddl_originStation1
	  //WebElement from=driver.findElement(By.cssSelector(null))
	  //  WebElement from= driver.findElement(By.xpath("//div/select[@name='ctl00$mainContent$ddl_originStation1']"));
	  
	  
	  WebElement dc= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1'][1]"));
	  //WebElement dc= driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1"));
	  driver.manage().timeouts().implicitlyWait(17,TimeUnit.SECONDS);
	  System.out.println(dc.isDisplayed());
	  
	  dc.click();
	  
	  Thread.sleep(2000);
	  
	  System.out.println("test in progress");
	  WebElement dc_select = driver.findElement(By.xpath("//a[@value='MAA']"));
	  dc_select.click();
	  
	  
	  WebElement dec_select= driver.findElement(By.xpath("(//a[@value='BLR'])[2]"));
	  dec_select.click();
	  
	  
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
