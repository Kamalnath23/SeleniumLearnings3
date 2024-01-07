package Section14;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AutomationPaginationScenariosToSearchTheDataUsingDoWhile {
	WebDriver driver;

	@Test
	public void f() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		WebElement veg = driver.findElement(By.xpath("//span[text()='Veg/fruit name']"));
		// veg.click();

		List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> price;
		do {

			price = names.stream().filter(s -> s.getText().contains("Wheat"))
					.map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));
			price.stream().forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				WebElement next = driver.findElement(By.xpath("//a[@aria-label='Next']"));
				next.click();

			}
		} while (price.size() < 1);
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();

		return priceValue;
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
