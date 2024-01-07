package KamalIndustries.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import KamalIndustries.PageObjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest {

	public static void main(String[] args) {
		String productName="zara coat 3";
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		// landingPage LandingPage= new landingPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		WebElement id= driver.findElement(By.id("userEmail"));
		WebElement pass= driver.findElement(By.cssSelector("input#userPassword"));
		
		id.sendKeys("kamalnath121998@gmail.com");
		pass.sendKeys("Password1*");
		
		WebElement LoginBtn =  driver.findElement(By.id("login"));
		LoginBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		 
		// List product= products.stream().filter(product -> 
		// product.findElement(By.cssSelector("b")).getText().equals("zara coat 3"))
		WebElement prod=  products.stream().filter(product -> 
		 product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		// prod.click(); -wont work
		// //button[@class='btn w-10 rounded'] 
		// div.card-body button:last-of-type
		
		//WebElement addToCart= prod.findElement(By.xpath("//button[@class='btn w-10 rounded']"));
		//addToCart.click();
		
		WebElement addToCart2 = prod.findElement(By.cssSelector("div.card-body button:last-of-type"));
		addToCart2.click();
		
		
		//wait.until(ExpectedConditions.visibilityOf(addToCart2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#toast-container")));
		//ng-animating
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		WebElement Cart= driver.findElement(By.cssSelector("button[routerlink*='cart']"));
		Cart.click();
		
		//Logic to verify items in cart and cjeckout
		
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match= cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		WebElement CheckOut= driver.findElement(By.cssSelector("li.totalRow button[class='btn btn-primary']"));
		CheckOut.click();
		
		Actions action= new Actions(driver);
		
		WebElement SelectCountry = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.sendKeys(SelectCountry, "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class='ta-results list-group ng-star-inserted']")));
		
		WebElement india= driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]"));
		india.click();
		
		WebElement submit= driver.findElement(By.cssSelector("a[class='btnn action__submit ng-star-inserted']"));
		submit.click();
		
		WebElement confirmMessage= driver.findElement(By.cssSelector(".hero-primary"));
		String msg= confirmMessage.getText();
		
		Boolean check = msg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		System.out.println(check);
		Assert.assertTrue(check);
		
		
		
	}

}
