package section15;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class InvokingMultipleTabsOrWindows {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://rahulshettyacademy.com/angularpractice/");
	  
	  //open new tab - invoking
	  driver.switchTo().newWindow(WindowType.TAB);
	  //switch to the new tab - working
	  Set<String> handles =driver.getWindowHandles();
	  Iterator<String> it= handles.iterator();
	  
	 	String parentWindowId= it.next();
		String childWindowId = it.next();
		System.out.println("Parent ID: "+parentWindowId);
		System.out.println("cHILD id: "+childWindowId);
		
	driver.switchTo().window(childWindowId);
	driver.get("https://rahulshettyacademy.com/");
	
	WebElement c_name =driver.findElement(By.xpath("//h2/a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']"));
	System.out.println(c_name.getText());
	String cname = c_name.getText();
	
	List<WebElement> Courses_aggregate_links = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
	String firstCourse= Courses_aggregate_links.get(1).getText();
	System.out.println(firstCourse);
	
	driver.switchTo().window(parentWindowId);
	
	WebElement name= driver.findElement(By.cssSelector("input[name=name]"));
	name.sendKeys(firstCourse);
	name.clear();
	name.sendKeys(cname);
	  
  }
  
  @Test
  public void f2() {
 driver.get("https://rahulshettyacademy.com/angularpractice/");
	  
	  //open new tab - invoking
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  //switch to the new tab - working
	  Set<String> handles =driver.getWindowHandles();
	  Iterator<String> it= handles.iterator();
	  
	 	String parentWindowId= it.next();
		String childWindowId = it.next();
		System.out.println("Parent ID: "+parentWindowId);
		System.out.println("cHILD id: "+childWindowId);
		
	driver.switchTo().window(childWindowId);
	driver.get("https://rahulshettyacademy.com/");
	
	WebElement c_name =driver.findElement(By.xpath("//h2/a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']"));
	System.out.println(c_name.getText());
	String cname = c_name.getText();
	
	List<WebElement> Courses_aggregate_links = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
	String firstCourse= Courses_aggregate_links.get(1).getText();
	System.out.println(firstCourse);
	
	driver.switchTo().window(parentWindowId);
	
	WebElement name= driver.findElement(By.cssSelector("input[name=name]"));
	name.sendKeys(firstCourse);
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
	  driver.quit();
  }

}