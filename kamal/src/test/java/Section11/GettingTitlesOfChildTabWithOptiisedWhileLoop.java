package Section11;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GettingTitlesOfChildTabWithOptiisedWhileLoop {
	WebDriver driver;

	@Test
	public void test_of_scope() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		WebElement section1_of_footer = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> a_tags_at_firstelement_of_footer = section1_of_footer.findElements(By.tagName("a"));
		int no_of_tags_in_div1 = a_tags_at_firstelement_of_footer.size();
		System.out.println("A tags in div 1: "+no_of_tags_in_div1);
		
		for(int i=1; i<no_of_tags_in_div1;i++) {
			String clickOnLinkTabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
			System.out.println("For loop output: "+a_tags_at_firstelement_of_footer.get(i).getText());
			a_tags_at_firstelement_of_footer.get(i).sendKeys(clickOnLinkTabs);
			
			//Thread.sleep(5000L);
		}	
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it=windows.iterator();
			int z=0;
			while(it.hasNext()) {
				
				// it.next();
				driver.switchTo().window(it.next());
				driver.getTitle();
				System.out.println(z+" "+driver.getTitle());
				z++;
				
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
