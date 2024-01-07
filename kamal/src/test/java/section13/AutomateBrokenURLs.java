package section13;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AutomateBrokenURLs {
	WebDriver driver;
  @Test
  public void test() throws MalformedURLException, IOException {
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  WebElement soapui= driver.findElement(By.cssSelector("a[href*='soapui']"));
	  String url1= soapui.getAttribute("href");
	  
	  HttpURLConnection conn= (HttpURLConnection) new URL(url1).openConnection();
	  conn.setRequestMethod("HEAD");
	  conn.connect();
	  int respCode = conn.getResponseCode();
	  System.out.println(respCode);  
	  
  }
  
  @Test
  public void test2()throws MalformedURLException, IOException{
	  // driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  WebElement bl= driver.findElement(By.cssSelector("a[href*='brokenlink']"));
	  String url1= bl.getAttribute("href");
	  
	  HttpURLConnection conn= (HttpURLConnection) new URL(url1).openConnection();
	  conn.setRequestMethod("HEAD");
	  conn.connect();
	  int respCode = conn.getResponseCode();
	  System.out.println(respCode); 
  }
  
  //Iterate all links in the page to validate broken link mechanism
  @Test
  public void test3() throws MalformedURLException, IOException {
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  
	  List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	  SoftAssert a = new SoftAssert();
	  
	  for(WebElement link: allLinks) {
		  String url1= link.getAttribute("href");
		  
		  HttpURLConnection conn= (HttpURLConnection) new URL(url1).openConnection();
		  conn.setRequestMethod("HEAD");
		  conn.connect();
		  int respCode = conn.getResponseCode();
		  System.out.println(respCode);
		  String f=link.getText();
		  
		  a.assertTrue(respCode<400, "The link with text has broken URL is : "+f+". Its broken code is "+respCode);
		  
		  /** if(respCode>400) {
			  
			  System.out.println("The link with text has broken URL is : "+f+". Its broken code is "+respCode);
			  
			  // Assert.assertTrue(false);
		  }**/
	  } a.assertAll();
	  
	  
	  // li[class='gf-li'] a[href*='https']
  }
  @Test
  public void test4() throws MalformedURLException, IOException{
 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  
	  List<WebElement> allLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a[href*='https']"));
	  
	  for(WebElement link: allLinks) {
		  String url1= link.getAttribute("href");
		  
		  HttpURLConnection conn= (HttpURLConnection) new URL(url1).openConnection();
		  conn.setRequestMethod("HEAD");
		  conn.connect();
		  int respCode = conn.getResponseCode();
		  System.out.println(respCode);
	  }
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
	  driver.close();
  }

}
