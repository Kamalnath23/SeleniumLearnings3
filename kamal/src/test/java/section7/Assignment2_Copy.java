package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Assignment2_Copy {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://rahulshettyacademy.com/angularpractice/");

	  driver.findElement(By.name("name")).sendKeys("rahul");

	  driver.findElement(By.name("email")).sendKeys("hello@abc.com");

	  driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");

	  driver.findElement(By.id("exampleCheck1")).click();

	  WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

	  Select abc = new Select(dropdown);

	  abc.selectByVisibleText("Female");

	  driver.findElement(By.id("inlineRadio1")).click();

	  driver.findElement(By.name("bday")).sendKeys("02/02/1992");

	  driver.findElement(By.cssSelector(".btn-success")).click();

	  System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
