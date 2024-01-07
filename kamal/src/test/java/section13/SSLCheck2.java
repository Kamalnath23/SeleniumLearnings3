package section13;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

public class SSLCheck2 {
	WebDriver driver;
  @Test
  public void f() {
	  ChromeOptions option= new ChromeOptions();
	  option.setAcceptInsecureCerts(true);
	  System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed(null);
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions option= new ChromeOptions();
	  option.setAcceptInsecureCerts(true);
	  System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
