package section7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;

public class HandlingJavaAlerts {
	WebDriver driver;

	@Test
	public void handlingJavaAlerts() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// driver.get("https://www.spicejet.com/");

		String Name = "Kamal";
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys(Name);

		// <input id="alertbtn" class="btn-style" value="Alert" onclick="displayAlert()"
		// type="submit">
		WebElement Alert_btn = driver.findElement(By.cssSelector("input#alertbtn"));
		Alert_btn.click();

		if (ExpectedConditions.alertIsPresent() != null) {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println("Alert dialogue text is " + text);
			alert.accept();
		}

		// <input id="confirmbtn" class="btn-style" value="Confirm"
		// onclick="displayConfirm()" type="submit">
		WebElement confirm_btn = driver.findElement(By.xpath("//input[@id='confirmbtn']"));
		confirm_btn.click();

		if (ExpectedConditions.alertIsPresent() != null) {
			Alert confirm = driver.switchTo().alert();
			System.out.println(confirm.getText());
			confirm.accept();
		}

		confirm_btn.click(); // clicking the button second time clicking to cancel/dismiss

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
		// driver.close();
	}

}
