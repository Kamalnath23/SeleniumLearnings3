package Section10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class FrameTest {
	WebDriver driver;

	@Test
	public void test() {
		driver.get("https://jqueryui.com/droppable/");
		List<WebElement> IFRAME= driver.findElements(By.tagName("iframe"));
		System.out.println((driver.findElements(By.tagName("iframe")).size()));
		System.out.println(IFRAME.size());
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		WebElement dragElement = driver.findElement(By.cssSelector("div#draggable"));
		dragElement.click();
		
		WebElement drop=driver.findElement(By.cssSelector("div#droppable"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(dragElement, drop).build().perform();
		
		//List<WebElement> IFRAME= driver.findElements(By.tagName("iframe"));
		System.out.println((driver.findElements(By.tagName("iframe")).size()));
		
		driver.switchTo().defaultContent();
		//List<WebElement> IFRAME= driver.findElements(By.tagName("iframe"));
		System.out.println((driver.findElements(By.tagName("iframe")).size()));
		
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
