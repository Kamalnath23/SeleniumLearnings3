package Section11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;

public class Assignment_1_Dynamic {
	WebDriver driver;
  @Test
  public void test_assignment_1() {
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  
	  WebElement cb1= driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
	  cb1.click(); 
	  WebElement cb1_name_we=driver.findElement(By.xpath("//label[@for='bmw']"));
	  String cb1_name = cb1_name_we.getText();
	  System.out.println(cb1_name);
	  System.out.println(cb1_name.isEmpty());
	  
	  WebElement dd= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	  if(cb1_name.isEmpty()==false) {
		  dd.click();
		  
		  List<WebElement> dd_options = driver.findElements(By.xpath("//option"));
		  int no_of_dd= dd_options.size();
		  System.out.println(no_of_dd);
		  
		  for(int i=0;i<dd_options.size();i++) {
			  String nam=dd_options.get(i).getText();
			  System.out.println(nam);
			  if(nam.equalsIgnoreCase(cb1_name)) {
				  dd_options.get(i).click();
			  }
		  }
	  
	  }
	  
	  WebElement e_y_n= driver.findElement(By.xpath("//input[@id='name']"));
	  e_y_n.sendKeys(cb1_name);
	  
	  WebElement Alert_btn= driver.findElement(By.xpath("//input[@id='alertbtn']"));
	  Alert_btn.click();
	  
	  if(ExpectedConditions.alertIsPresent()!=null) {
		  Alert alert= driver.switchTo().alert();
		  String text=alert.getText();
		  String[] output= text.split(",");
		  String output_name=output[0].split(" ")[1];
		  System.out.println();
		  System.out.println("Ans is "+output_name);
		  alert.accept();
	  }
	  
	  
	  
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
