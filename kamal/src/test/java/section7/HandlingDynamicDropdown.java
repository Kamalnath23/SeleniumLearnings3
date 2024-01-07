package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class HandlingDynamicDropdown {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	//FAILED
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  
	  //<option value="MAA">Chennai (MAA)</option>
	  
	  
	  driver.get("https://www.spicejet.com/");
	  
	//  //a[@value='MAA']  - Xpath for chennai

	//  //a[@value='BLR']
	  
	  // below 3 my own code
	  //<div class="css-76zvg2 r-jwli3a r-xb2eav r-majxgm r-q4m81j" dir="auto" data-testid="search-source-code" style="font-family: inherit;">DEL</div>
	 // WebElement from = driver.findElement(By.className("css-76zvg2 r-jwli3a r-xb2eav r-majxgm r-q4m81j"));
	 // from.click();
	 driver.switchTo().alert().dismiss();

	  //line copied from rahul academy
	  
	  //<div class="css-76zvg2 r-jwli3a r-xb2eav r-majxgm r-q4m81j" dir="auto" data-testid="search-source-code" style="font-family: inherit;">DEL</div>
	  // WebElement from= driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
	  WebElement from= driver.findElement(By.xpath("/div[text()='Depart']"));
	  from.click();
	  
	  WebElement from_place = driver.findElement(By.xpath("//a[@value='BLR']"));
	  from_place.click();
	  
	  Thread.sleep(2000);
	  
	  //
	  WebElement to_place =driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
	  to_place.click();
	  
	  
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
