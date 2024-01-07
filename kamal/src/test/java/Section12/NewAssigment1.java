package Section12;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewAssigment1 {
	WebDriver driver;

	@Test
	public void test() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement table = driver.findElement(By.cssSelector("table.table-display"));

		List<WebElement> rows = driver.findElements(By.xpath("//fieldset/table/tbody/tr"));
		int no_of_rows = rows.size();
		System.out.println("No.of. rows " + no_of_rows);

		for (int i = 0; i < no_of_rows; i++) {
			if (i == 2) {
				// String[] s= rows.get(i).getText().split(i);
				System.out.println(rows.get(i).getText());

			}
		}

		List<WebElement> cols = driver.findElements(By.xpath("//fieldset/table/tbody/tr/th"));
		int no_of_cols = cols.size();
		System.out.println("No.of.cols " + no_of_cols);

		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());
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
