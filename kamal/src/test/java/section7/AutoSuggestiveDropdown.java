package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AutoSuggestiveDropdown {
	WebDriver driver;
  @Test
  public void autosuggestiveDropdown() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  
	  //<input type="text" id="autosuggest" class="inputs ui-autocomplete-input" placeholder="Type to Select" autocomplete="off">
	  WebElement country_dd= driver.findElement(By.id("autosuggest"));
	  country_dd.sendKeys("Ind");
	  Thread.sleep(2000);
	  
	  // css path li[class='ui-menu-item'] a[id='ui-id-123']
	  
	  
	  List<WebElement> opts = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

	  for(WebElement opt: opts) {
		  if(opt.getText().equalsIgnoreCase("India")) {
			  opt.click();
			  break;
		  }
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
	  //driver.quit();
  }

}
