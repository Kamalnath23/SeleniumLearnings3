package Section11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class SNTest {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {

		driver.get("https://support-sbox11.accenture.com/login.do");

		WebElement uname = driver.findElement(By.xpath("//input[@id='user_name']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='user_password']"));

		uname.sendKeys("ads.kbalakrishnan");
		pass.sendKeys("Doctor_Thanisha2001*");

		WebElement login = driver.findElement(By.xpath("//button[@id='sysverb_login']"));
		login.click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebElement filternav = driver.findElement(By.xpath("//input[@id='filter']"));
		filternav.sendKeys("ptat");

		WebElement ptat = driver.findElement(By.xpath("//div[text()='PTAT Portal Request']"));
		ptat.click();

		Set<String> windows = driver.getWindowHandles(); // parent id, child id
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		System.out.println("Parent ID: " + parentId);
		System.out.println("cHILD id: " + childId);
		
		driver.switchTo().window(childId);
		Thread.sleep(3000);
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(58));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-default'][@aria-label='Show Calendar for Departure date']")));
		WebElement dept_date = driver.findElement(By.xpath("//button[@class='btn btn-default'][@aria-label='Show Calendar for Departure date']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();", dept_date);
		  Thread.sleep(45000L);
		  w.until(ExpectedConditions.elementToBeClickable(dept_date));
		dept_date.click();
		
		List<WebElement> days= driver.findElements(By.cssSelector(".day"));
		int count= days.size();
		System.out.println(count);
		
		  for(int i=0;i<count;i++) {
			  String Date= days.get(i).getText();
			  if(Date.equalsIgnoreCase("31")) {
				  days.get(i).click();
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
		driver.quit();
	}

}
