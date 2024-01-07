package section7;

import org.testng.annotations.Test;

import bsh.util.Util;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Assignment2 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  driver.get("https://rahulshettyacademy.com/angularpractice/");
	  
	  //<input class="form-control ng-untouched ng-pristine ng-invalid" minlength="2" name="name" required="" type="text">
	  WebElement name = driver.findElement(By.xpath("//input[@name='name'] [@class='form-control ng-untouched ng-pristine ng-invalid']"));
	  name.sendKeys("Thanisha");
	  
	  //<input class="form-control ng-untouched ng-pristine ng-invalid" name="email" required="" type="text">
	  WebElement email= driver.findElement(By.xpath("//input[@name='email'] [@class='form-control ng-untouched ng-pristine ng-invalid']"));
	  email.sendKeys("thanishadayalan102@gmail.com");
	  
	  WebElement pass =driver.findElement(By.xpath("//input[@class='form-control'][@type='password']"));
	  pass.sendKeys("Doctor");
	  
	  //<input class="form-check-input" id="exampleCheck1" type="checkbox">
	  WebElement check=driver.findElement(By.id("exampleCheck1"));
	  check.click();
	  
	  
	  //<select class="form-control" id="exampleFormControlSelect1">
     // <option>Male</option>
      //<option>Female</option>
    //</select>
	  WebElement dd = driver.findElement(By.cssSelector("select[class='form-control']"));
	  Select dropdown= new Select(dd);
	  String selectedDropdown= dropdown.getFirstSelectedOption().getText();
	  System.out.println(selectedDropdown);
	  //dropdown.selectByValue("Female");
	  //dropdown.selectByIndex(2);
	  //String selectedDropdown2= dropdown.getFirstSelectedOption().getText();
	  //System.out.println(selectedDropdown2);
	  
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	  
	  js.executeScript("arguments[0].scrollIntoView();", dd);
	  
	  //<input class="form-check-input" id="inlineRadio2" name="inlineRadioOptions" type="radio" value="option2">
	  //WebElement radio=driver.findElement(By.className("input[class='form-check-input'][value='option1']"));
	  WebElement radio=driver.findElement(By.xpath("//input[@class='form-check-input'][@value='option1']"));
	  
	  radio.click();
	  
	  WebElement DOB_Cal;
	  DOB_Cal=driver.findElement(By.xpath("//div/input[@class='form-control'][@name='bday']"));
	  DOB_Cal.sendKeys("09042001");
	  
	  WebElement submit= driver.findElement(By.xpath("//input[@value='Submit']"));
	  submit.click();
	  
	  js.executeScript("arguments[0].scrollIntoView();", name);
	  
	  
	  WebElement verify=driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]"));
	  String expected= verify.getText();
	  System.out.println(verify.getText());
	  Assert.assertEquals("Success! The Form has been submitted successfully!.", expected);
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
