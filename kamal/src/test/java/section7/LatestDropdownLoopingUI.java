package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LatestDropdownLoopingUI {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  // <div id="divpaxinfo" class="paxinfo">1 Adult</div>
	  WebElement passengersdropdown = driver.findElement(By.id("divpaxinfo"));
	  passengersdropdown.click();
	  
	  Thread.sleep(2000);
	  
	  // Have to increase no.of.adults in the drop down box
	  // <span class="pax-add pax-enabled" id="hrefIncAdt">+</span>
	  WebElement adultadd=driver.findElement(By.id("hrefIncAdt"));
	  // adultadd.click(); // 2 adults
	  //if you want to add more adults(lets say 5) you can use 'adultadd.click();' 4 times but its a not a good practice
	  int i=1;
	  while(i<5) {
		  adultadd.click();
		  i++;
	  } //4 times this loop ll be executed
	  
	  // <span class="pax-add pax-enabled" id="hrefIncChd">+</span>
	  WebElement childadd= driver.findElement(By.id("hrefIncChd"));
	  for(int j=0;j<4;j++) {
		  childadd.click();
	  }
	  
	  // <input class="buttonN" id="btnclosepaxoption" value="Done" type="button">
	  WebElement done= driver.findElement(By.id("btnclosepaxoption"));
	  done.click();
	  
	  System.out.println(passengersdropdown.getText());
	  
	  
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
