package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Dropdown {
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	//FAILED
	  driver.get("http://spicejet.com"); //URL in the browser

	//  //a[@value='MAA']  - Xpath for chennai

	//  //a[@value='BLR']

	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

	driver.findElement(By.xpath("//a[@value='BLR']")).click();

	Thread.sleep(2000);

	//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
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
