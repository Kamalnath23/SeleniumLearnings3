package Section11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class PrintTheCountLinksInPage {
	WebDriver driver;

	@Test
	public void scopeTest() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		// driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.get("https://qaclickacademy.com/practice.php");
		// 1. Give me the count of links on the page

		List<WebElement> a_tags = driver.findElements(By.tagName("a"));
		int no_of_a_tags = a_tags.size();
		System.out.println("A tags in the website : " + no_of_a_tags);

		// 2. Count the link in footer section
		// LIMITING WEB DRIVER SCOPE
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		List<WebElement> a_tags_at_footer = footerDriver.findElements(By.tagName("a"));
		int no_of_tags_in_footer = a_tags_at_footer.size();
		System.out.println("A tags in footer : " + no_of_tags_in_footer);
		
		//3. Count the link in first division of footer section
		WebElement section1_of_footer = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> a_tags_at_firstelement_of_footer = section1_of_footer.findElements(By.tagName("a"));
		int no_of_tags_in_div1 = a_tags_at_firstelement_of_footer.size();
		System.out.println("A tags in div 1: "+no_of_tags_in_div1);
		
		//4. Click on each link in column and check if pages are opening
		/* for(int i=1;i<no_of_tags_in_div1;i++) {
			System.out.println(a_tags_at_firstelement_of_footer.get(i).getText());
			a_tags_at_firstelement_of_footer.get(i).click();
			driver.navigate().back();
			w.until(ExpectedConditions.presenceOfElementLocated(By.id("gf-BIG")));
			
		} */
		
		// Optimised steps in for loop
		for(int i=1; i<no_of_tags_in_div1;i++) {
			String clickOnLinkTabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			System.out.println(a_tags_at_firstelement_of_footer.get(i).getText());
			a_tags_at_firstelement_of_footer.get(i).sendKeys(clickOnLinkTabs);
			System.out.println();
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
