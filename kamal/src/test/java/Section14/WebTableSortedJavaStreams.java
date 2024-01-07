package Section14;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebTableSortedJavaStreams {
	WebDriver driver;
  @Test
  public void test1() {
	  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	  
	  //click on column
	  WebElement veg= driver.findElement(By.xpath("//span[text()='Veg/fruit name']"));
	  // //tr/th[1]
	  veg.click();
	  
	//Capture all the WE into list
	  List<WebElement> names=driver.findElements(By.xpath("//tr/td[1]"));
	  
	//capture text of all WE into new(original) list
	  List<String>original_list =names.stream().map(s->s.getText()).collect(Collectors.toList());
	  
	  
	  //sort in the list of step 3
	  List<String> sorted = original_list.stream().sorted().collect(Collectors.toList());
	  
	  
	  //compare original list vs sorted list
	  Assert.assertTrue(original_list.equals(sorted));
	  Assert.assertEquals(original_list, sorted);
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

}
