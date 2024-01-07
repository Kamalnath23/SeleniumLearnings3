package Section10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AssignmentTest1 {
	WebDriver driver;

	@Test
	public void testSol() {
		driver.get("https://the-internet.herokuapp.com/windows");
		
		WebElement new_Window_btn =driver.findElement(By.cssSelector("a[target='_blank'][href='/windows/new']"));
		new_Window_btn.click();
		
		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		WebElement newWindow= driver.findElement(By.cssSelector("h3"));
		System.out.println(newWindow.getText());
		
		driver.switchTo().window(parentId);
		WebElement window1=driver.findElement(By.cssSelector("h3"));
		System.out.println(window1.getText());
		
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
