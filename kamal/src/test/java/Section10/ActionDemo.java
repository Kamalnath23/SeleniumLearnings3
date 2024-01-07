package Section10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ActionDemo {
	WebDriver driver;

	@Test
	public void f() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		WebElement SignInAccountList = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		WebElement searchTextBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		
		a.moveToElement(searchTextBox).click().keyDown(Keys.SHIFT).sendKeys("sony camera").doubleClick().build().perform();
		
		//a.moveToElement(SignInAccountList);
		a.moveToElement(SignInAccountList).contextClick().build().perform(); //move to specific web element
		
		
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
