package section13;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.lang.StackWalker.Option;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class Miscellaneous {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://expired.badssl.com/");
	  System.out.println(driver.getTitle());
  
  }
  
  @Test
  public void f2() {
	  driver.get("https://expired.badssl.com/");
	  System.out.println(driver.getCurrentUrl());
	  
	  Proxy proxy=new Proxy();
	  proxy.setHttpProxy("ipaddress:4444");
	  //option.se
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions option= new ChromeOptions();
	  option.setAcceptInsecureCerts(true);
	  System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		//option.setCapability("proxy", proxy);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
