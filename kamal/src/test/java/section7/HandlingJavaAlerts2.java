package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;

public class HandlingJavaAlerts2 {
	WebDriver driver;

	@Test
	public void f() {
		// NO SUCH ALERT ERROR

		driver.get("https://www.spicejet.com/");
		if (ExpectedConditions.alertIsPresent() != null) {
			Alert confirm = driver.switchTo().alert();
			System.out.println("second time: " + confirm.getText());
			confirm.dismiss();
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
		driver.close();
	}

}
