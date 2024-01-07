package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class HandlingStaticDropdownWithSelectWebDriverAPI {
	WebDriver driver;
  @Test
  public void staticDropdownWithSelect() {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	  //select dropdown
	  /** <select name="ctl00$mainContent$DropDownListCurrency" id="ctl00_mainContent_DropDownListCurrency" class="valid">
		<option value="">Select</option>
		<option value="INR">INR</option>
		<option value="AED">AED</option>
		<option value="USD">USD</option>
		</select> **/
	  
	  WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	  Select dropdown= new Select(staticdropdown); //declaring object in special calss called Select
	  
	  dropdown.selectByIndex(3); //selecting third option in the dropdown
	  String selectedDropdown= dropdown.getFirstSelectedOption().getText(); //getting string value of selected dropdown value
	  System.out.println(selectedDropdown);
	  
	  dropdown.selectByVisibleText("AED");
	  System.out.println(dropdown.getFirstSelectedOption().getText());
	  
	  dropdown.selectByValue("INR"); //SELECT BASED ON ATTRIBUTE
	  System.out.println(dropdown.getFirstSelectedOption().getText());
	  					
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
