package Section12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HandleTableGridsInWebPages {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int count = values.size();
		int sum=0;
		for (int i = 0; i < count; i++) {
			System.out.println(values.get(i).getText());
			int v = Integer.parseInt(values.get(i).getText());
			System.out.println(v);
			
			sum=sum+v;
		}
		
		System.out.println("Total sum is :"+sum);
		
		
		// Parsing String and compare with generated amount
		
		WebElement totalAmountCollected = driver.findElement(By.cssSelector("div.totalAmount"));
		String s= totalAmountCollected.getText().split(":")[1].trim();
		System.out.println(s);
		int original_sum= Integer.parseInt(s);
		
		Assert.assertEquals(sum, original_sum);

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
