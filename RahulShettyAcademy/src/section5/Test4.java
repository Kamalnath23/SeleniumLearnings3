package section5;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Test4 {
	WebDriver driver;
  @Test
  public void xpath2() throws InterruptedException {
	  
	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //<a href="#">Forgot your password?</a>
	  WebElement link= driver.findElement(By.linkText("Forgot your password?"));
	  link.click();
	  
	  // <input type="text" placeholder="Name">
	  WebElement name=driver.findElement(By.xpath("//input[@placeholder='Name']"));
	  name.sendKeys("Soulmate");
	  
	  // <input type="text" placeholder="Email">
	  WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
	  email.sendKeys("soulmate@gmail.com");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  // <input type="text" placeholder="Email">
	  // using index for different 
	  WebElement email2=driver.findElement(By.xpath("//input[@type='text'][2]"));
	  email2.clear();
	  
	  //In X-Path hidden attribute is not considered but in CSS hidden attribute is considered.
	  
	  WebElement email3 = driver.findElement(By.cssSelector("input[type='text']:nth-child(3)"));
	  email3.sendKeys("soulmate@yahoo.com");
	  
	  
	  //parent child relationship
	  //Generating xpaths with parents to child tag transverse techniques
	  
	  // //*[@id="container"]/div[1]/form/h2 - copy xpath
	  // /html/body/div/div/div/div/div/div/div[1]/form/h2 - copy full xpath
	  WebElement h2=driver.findElement(By.xpath("//form/h2"));
	 System.out.println(h2.getText());
	  
	  
	  WebElement phone_number=driver.findElement(By.xpath("//form/input[3]"));
	  phone_number.sendKeys("9876543210");
	  
	  
	  
	  //<button class="reset-pwd-btn">Reset Login</button>
	  WebElement resetLogin= driver.findElement(By.cssSelector("button.reset-pwd-btn"));
	  resetLogin.click();
	  
	  
	  /**
	  WebElement msg= driver.findElement(By.xpath("//form/p"));
	  WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(120));
	  wait2.until(ExpectedConditions.elementToBeClickable(msg));
	  System.out.println("Message after reseting pass: "+msg);
	  **/
	  
	  //<button class="go-to-login-btn">Go to Login</button>
	  WebElement goToLogin=driver.findElement(By.cssSelector("button.go-to-login-btn"));
	  goToLogin.click();
	  
	  // *******************  Test3 ********************
	  Thread.sleep(2000); // ** Not recomended in frame work
	  
	  WebElement username=driver.findElement(By.xpath("//input[@id='inputUsername']"));
	  username.sendKeys("Soulmate");
	  
	  WebElement pass=driver.findElement(By.xpath("//input[@name='inputPassword']"));
	  pass.sendKeys("rahulshettyacademy");
	  
	  WebElement submitButton= driver.findElement(By.className("signInBtn"));
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
	  wait.until(ExpectedConditions.elementToBeClickable(submitButton));

	  submitButton.click();
	  
	  /** 
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/button")));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/button")));
	  
	  
	  WebElement submitButton= driver.findElement(By.xpath("//form/button"));
	  // //*[@id="container"]/div[2]/form/button
	  submitButton.click();
		FAILED: xpath2
org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <button class="submit signInBtn" type="submit">...</button> is not clickable at point (743, 468). Other element would receive the click: <form class="form">...</form>
  (Session info: chrome=104.0.5112.81)
		
	  
	  **/
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
