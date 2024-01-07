package section6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTestFirefox {
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  String name ="Kamal";
	  String password= getPassword(driver);
	  
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  
	  WebElement uname= driver.findElement(By.xpath("//form[@class='form']/input[1]"));
	  uname.sendKeys(name);
	  
	  WebElement pass= driver.findElement(By.xpath("//div[@class='form-container sign-in-container']/form/input[2]"));
	  pass.sendKeys(password);
	  
	  WebElement login= driver.findElement(By.xpath("//button[@class='submit signInBtn'][@type='submit']"));
	  login.click();
	  
	  //Thread.sleep(2000);
	  Thread.sleep(1000);
	  
	  WebElement LogOut2= driver.findElement(By.xpath("//*[text()='Log Out']"));
	  LogOut2.click();
  }
  
  public static String getPassword(WebDriver driver) throws InterruptedException {
	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  
	  driver.findElement(By.linkText("Forgot your password?")).click();
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

	  String PasswordText = driver.findElement(By.cssSelector("form p")).getText();
	  //Please use temporary password 'rahulshettyacademy' to Login.
	  String PasswordArray[]= PasswordText.split("'");
	  //oth index- Please use temporary password 
	  //1st index- rahulshettyacademy' to Login.
	  
	  //rahulshettyacademy' to Login.
	  String password_[]= PasswordArray[1].split("'");
	  String password = password_[0];
	  System.out.println("Method 1 password: "+password);
	  return password;
	  //or
	  //String passwd= PasswordArray[1].split("'")[0];
	 // System.out.println("Method 2 password: "+passwd);
	  
	  
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }
  
  

}
