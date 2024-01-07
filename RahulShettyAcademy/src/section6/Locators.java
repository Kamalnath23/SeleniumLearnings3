package section6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Locators {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	// TODO Auto-generated method stub

	

	  driver.get("https://rahulshettyacademy.com/locatorspractice/");

	  driver.findElement(By.id("inputUsername")).sendKeys("rahul"); //ID

	  driver.findElement(By.name("inputPassword")).sendKeys("hello123"); //NAME

	  driver.findElement(By.className("signInBtn")).click();  //CLASSNAME
	  Thread.sleep(1000);
	  System.out.println(driver.findElement(By.cssSelector("p.error")).getText());  //CSS SELECTOR

	  driver.findElement(By.linkText("Forgot your password?")).click(); //LINK TEXT

	  Thread.sleep(1000);//

	  driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John"); //XPATH

	  driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com"); //CSS

	  driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //XPATH USING INDEX

	  driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com"); // CSS USING INDEX

	  driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253"); //XPATH USING PARENT-CHILD AND INDEX

	  driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); //CSS USING REGULAR EXPRESSION (class means dot)

	  System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // CSS with PARENT-CHILD

	  driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); // XPATH with Class attribute(parent tag) and child tag...

	  Thread.sleep(1000);

	  driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul"); // CSS selector using ID

	  driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); //CSS using contains (regular expression)

	  driver.findElement(By.id("chkboxOne")).click(); //ID
	  
	  driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //Xpath
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
