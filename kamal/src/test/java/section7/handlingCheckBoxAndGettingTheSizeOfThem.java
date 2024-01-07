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

public class handlingCheckBoxAndGettingTheSizeOfThem {
	WebDriver driver;
  @Test
  public void checkbox_test() {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  
	  // <input id="ctl00_mainContent_chk_friendsandfamily" type="checkbox" name="ctl00$mainContent$chk_friendsandfamily">
	  WebElement cb1 = driver.findElement(By.cssSelector("input[id$='friendsandfamily']"));
	  System.out.println("Before test: "+cb1.isSelected()); //check whether check box is enabled or not
	  cb1.click();
	  cb1.isSelected();
	  System.out.println("After test: "+cb1.isSelected()); //check whether check box is enabled or not
	  
	  //note: selenium finds element from top left. so if u use find element it ll show first element. use find elements to show up all
	  
	  //To count the no.of.checkboxes  //6check boxes in the testing page
	  List<WebElement> total_cbs= driver.findElements(By.cssSelector("input[type='checkbox']"));
	  System.out.println(total_cbs.size());
	  
	  for(WebElement cb: total_cbs) {
		  System.out.println("Checkbox names: "+cb.getText());
	  }
	  // the above for-loop didn't worked as check box didn't have any name in The console :)
	  
	  
	  
	  
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
