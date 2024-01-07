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

public class FilterWebTable {
	WebDriver driver;
	
  @Test
  public void test() {
	  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	  
	  WebElement Search= driver.findElement(By.xpath("//input[@id='search-field']"));
	  Search.sendKeys("Rice");
	  
	  List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
	  // 5 results
	  //veggies.stream().forEach(a->System.out.println(a));
	  // veggies.stream().forEach(v->System.out.println(v));
	  
	  List SearchItem= veggies.stream().filter(s->s.getText().equalsIgnoreCase("rice"))
	  .collect(Collectors.toList());
	  
	  Assert.assertEquals(veggies.size(), SearchItem.size());
	  
	  boolean value=veggies.equals(SearchItem);
	  Assert.assertTrue(value);
	  
	  
	  
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
