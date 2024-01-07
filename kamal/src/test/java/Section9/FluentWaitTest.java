package Section9;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitTest {
	WebDriver driver;

	@Test
	public void fluentWaitTest() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		WebElement Start = driver.findElement(By.xpath("//button"));
		Start.click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(30L)) .pollingEvery(Duration.ofSeconds(5L))
		 * .ignoring(NoSuchElementException.class);
		 */

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}else {
					return null;  
				}
				
				
			}

		});
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	}
	//

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
