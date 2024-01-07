package Section11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class cals_make_my_trip_UI {
	WebDriver driver;
	
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(10));
	  driver.get("https://www.makemytrip.com/flights/?cmp=SEM|M|DF|B|Brand|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|Expanded|&s_kwcid=AL!1631!3!!e!!o!!makemytrip.com&ef_id=8a1973b60fe716e90ae710ba7930a058:G:s");
	  WebElement dept_date= driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]"));
	  dept_date.click();
	  
	  //current date //div[@class='DayPicker-Day DayPicker-Day--selected'] 
	  //ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='DayPicker-Day']")));
	  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='DayPicker-Day']")));
	  
	  List<WebElement> dates= driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
	  
	  int count= dates.size();
	  
	 System.out.println(count);
	 
	 for(int i=0;i<count;i++) {
		 String Date= dates.get(i).getText();
		  if(Date.contains("31")) {
			  dates.get(i).click();
			  System.out.println(dates.get(i).getText());
			  break;
		  }
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
