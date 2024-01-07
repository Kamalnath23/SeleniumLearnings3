package section16;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Annotations {
	WebDriver driver;
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This block executes before each Test");
	
	}

	@BeforeTest
	public void Cookies() {
		System.out.println("This block executes Before all  Testcases");
		// delete cookies
	}

	@AfterTest
	public void Cookiesclose() {
		System.out.println("This block executes after all  Testcases");
		// close the browesers
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This block executes after each Test");
		
	}
	
	@Parameters({"URL"})
	@Test(groups= {"Smoke"})
	public void OpeningBrowser(String urladdress) {
		// This opens the Browser
		System.out.println("Executing Test 2");
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(urladdress);
		driver.get(urladdress);
		driver.quit();
	}

	@Test(groups= {"Smoke"},dependsOnMethods= {"OpeningBrowser"})
	public void FlightBooking() {
		System.out.println("Executing Test 1");
	}

	@Test(groups= {"Smoke"},dependsOnMethods= {"OpeningBrowser","FlightBooking"})
	// @Test (dependsOnMethods= {"FlightBooking"})
	public void FlightCancel() {
		System.out.println("Executing Test Priority 2");
	}
	
	@Test(enabled=false)
	public void calc() {
		System.out.println("Calc process");
	}
	
	@Test(timeOut=4000)
	public void activities() {
		System.out.println("Activities logged");
	}
	
	@Test
	public void fail() {
		String f;
		int f1=8;
		Assert.assertFalse(true);
	}

}
