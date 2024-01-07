package Section10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Assignment2 {
	WebDriver driver;
  @Test
  public void assignment() {
	  driver.get("https://the-internet.herokuapp.com/nested_frames");
	  
	  System.out.println("Determing no.of.frameset and frame");
	  List<WebElement> Frame= driver.findElements(By.tagName("frameset"));
	  System.out.println(Frame.size());
	  
	  List<WebElement> nestedFrame= driver.findElements(By.tagName("frame"));
	  System.out.println(nestedFrame.size());
	  
	  //driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@frameborder='1'][@name='frameset-middle']")));
	  //driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
	  System.out.println("Switching to Frame1");
	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
	  System.out.println(Frame.size()); //
	  System.out.println(nestedFrame.size());
	  
	  System.out.println("Switching to middle frame in Frame1");
	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
	  System.out.println(Frame.size()); //
	  System.out.println(nestedFrame.size());
	  
	  System.out.println();
	  WebElement text=driver.findElement(By.cssSelector("div#content"));
	  System.out.println(text.getText());
	  
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
