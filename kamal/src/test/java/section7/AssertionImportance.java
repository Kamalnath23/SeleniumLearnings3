package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertionImportance {
	WebDriver driver;
  @Test
  public void assertionTest() {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

	  WebElement cb1 = driver.findElement(By.cssSelector("input[id$='friendsandfamily']"));
	  Assert.assertFalse(cb1.isSelected());
	  System.out.println("Before test: "+cb1.isSelected()); //check whether check box is enabled or not
	  cb1.click();
	  cb1.isSelected();
	  Assert.assertTrue(cb1.isSelected());
	  System.out.println("After test: "+cb1.isSelected()); //check whether check box is enabled or not
	  
	  
	  List<WebElement> total_cbs= driver.findElements(By.cssSelector("input[type='checkbox']"));
	  System.out.println(total_cbs.size());
	  Assert.assertEquals(total_cbs.size(), 6);
	 // Assert.assertEquals(total_cbs.size(), 5); - Failed assertion
	  
	  // rahulShettyAcademyCode
	  Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

	//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

	driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

	System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

	Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

}
