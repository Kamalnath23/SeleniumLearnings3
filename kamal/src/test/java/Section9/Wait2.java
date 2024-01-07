package Section9;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Wait2 {
	WebDriver driver;
	String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
	int j = 0;
	String code = "rahulshettyacademy";

	@Test
	public void f() {
		// IMPLICIT WAIT - Below line code
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems();

		WebElement addToCart = driver.findElement(By.cssSelector("img[alt='Cart']"));
		addToCart.click();

		WebElement proceedToCheckOut = driver
				.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"));
		proceedToCheckOut.click();

		// explicit wait-1
		WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(7));
		w2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.promoCode")));

		WebElement promoCode = driver.findElement(By.cssSelector("input.promoCode"));
		promoCode.sendKeys(code);

		WebElement Apply = driver.findElement(By.cssSelector(".promoBtn"));
		Apply.click();

		// explicit wait-2
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(7));
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.promoInfo")));

		WebElement codeVerification = driver.findElement(By.cssSelector("span.promoInfo"));
		System.out.println(codeVerification.getText());
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

	public void addItems() {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			System.out.println();
			String product_name[] = products.get(i).getText().split("-");
			String vegName = product_name[0].trim();
			// format to trim it to specific vegetable name
			// covert array into array list for easy search - to save memeory. we're
			// coverting it during run time
			// check whether name you extracted is presented in array or not-
			List itemsNeededList = Arrays.asList(itemsNeeded);
			System.out.println(itemsNeededList + " vs " + vegName);

			if (itemsNeededList.contains(vegName)) {
				j++;
				// click on Add to cart
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				/*
				 * if(j==itemsNeededList.size()) { break; }
				 */
				// Note: the commented if loop will work
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
