package Section12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class NewAssignment2_2 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  WebElement dropdownbox= driver.findElement(By.cssSelector("input#autocomplete"));
	  String s="ind";
	  Actions action= new Actions(driver);
	  //action.moveToElement(dropdownbox).click().sendKeys(s).build().perform();
	  // .click(driver.findElement(By.xpath("text()='United Kingdom (UK)'")))
	  action.moveToElement(dropdownbox).click().sendKeys(s).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
	  
	  /*
	  dropdownbox.sendKeys("ind");
	  dropdownbox.sendKeys(Keys.DOWN);
	  dropdownbox.sendKeys(Keys.DOWN); */
	  
	  System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
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
