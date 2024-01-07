package section6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class uniqueTagNameLocatorsCopy {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  
	  String name="Kamal";
	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  //<input type="text" placeholder="Username" id="inputUsername" value="">
	  //<div class="form-container sign-in-container" xpath="1"><form class="form"><h1>Sign in</h1><p class="error">* Incorrect username or password </p><input type="text" placeholder="Username" id="inputUsername" value=""><input type="password" placeholder="Password" name="inputPassword" value=""><div class="checkbox-container"><span><input type="checkbox" id="chkboxOne" name="chkboxOne" value="rmbrUsername"><label for="chkboxOne"> Remember my username</label></span><span><input type="checkbox" id="chkboxTwo" name="chkboxTwo" value="agreeTerms"><label for="chkboxTwo"> I agree to the <a href="#"> terms </a> and <a href="#">privacy policy</a>.</label></span></div><div class="forgot-pwd-container"><a href="#">Forgot your password?</a></div><button class="submit signInBtn" type="submit">Sign In</button></form></div>
	  WebElement uname= driver.findElement(By.xpath("//form[@class='form']/input[1]"));
	  uname.sendKeys(name);
	  
	  //<input type="password" placeholder="Password" name="inputPassword" value="">
	  WebElement password= driver.findElement(By.xpath("//div[@class='form-container sign-in-container']/form/input[2]"));
	  password.sendKeys("rahulshettyacademy");
	  
	  //<button class="submit signInBtn" type="submit">Sign In</button>
	  WebElement login= driver.findElement(By.xpath("//button[@class='submit signInBtn'][@type='submit']"));
	  login.click();
	  
	  Thread.sleep(2000);
	  
	  //Locating element by tag name
	  // If in a web-page there is a single tag
	  
	 System.out.println("Detecting paragraph");
	 String paragraph= driver.findElement(By.tagName("p")).getText();
	 System.out.println(paragraph);
	 
	 // either or is correct
	// String Greetings=driver.findElement(By.cssSelector("h2")).getText(); 
	 String Greetings=driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
	 System.out.println(Greetings);
	 
	 Assert.assertEquals(paragraph, "You are successfully logged in.");
	 Assert.assertEquals(Greetings, "Hello "+name+",");
	// System.out.println("Test ended");
	 
	 WebElement LogOut= driver.findElement(By.xpath("//button[text()='Log Out']"));
	 WebElement LogOut2= driver.findElement(By.xpath("//*[text()='Log Out']"));
	 //Both are correct
	 
	 System.out.println(driver.getTitle());
	 LogOut.click();
	 System.out.println(driver.getTitle());
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
