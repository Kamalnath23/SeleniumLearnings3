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

public class CustomSeleniumMethodStreamMapper {
	WebDriver driver;

	@Test
	public void customSeleniumMethodUsingStreamMapper() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		WebElement veg = driver.findElement(By.xpath("//span[text()='Veg/fruit name']"));
		veg.click();

		List<WebElement> names = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> original_list = names.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sorted = original_list.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(original_list.equals(sorted));
		Assert.assertEquals(original_list, sorted);
		// scan the name column with getText(); -->Beans - print price of the beans

		// names.stream().map(s->getPriceVeggie()).collect(Collectors.toList());
		List<String> price = names.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());

		// xpath to transverse to sibling WebElement
		price.forEach(a -> System.out.println(a));
		price.stream().forEach(a-> System.out.println(a));

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();

		return priceValue;
		// return String;
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
