package driverSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driversInvoke {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		 
			
			
			//Invoking Browser

			//Chrome - ChromeDriver exten->Methods close get

			//Firefox- FirefoxDriver ->methods close get

			// WebDriver  close  get

			//WebDriver methods + class methods

			// Chrome

		//System.setProperty("webdriver.chrome.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		//driver = new ChromeDriver();



			//Firefox

			//System.setProperty("webdriver.gecko.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Firefox\\geckodriver.exe");

			//WebDriver driver1 = new FirefoxDriver();

			//Microsoft Edge

			System.setProperty("webdriver.edge.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\MSEdge\\msedgedriver.exe");

			WebDriver driver2 = new EdgeDriver();

			driver2.get("https://rahulshettyacademy.com");

			System.out.println(driver2.getTitle());

			System.out.println(driver2.getCurrentUrl());

			//driver1.close();

			//driver.quit();
			
	}

}
