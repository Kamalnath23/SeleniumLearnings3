package KamalIndustries.SeleniumFrameworkProject;

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

import KamalIndustries.PageObjects.cartPage;
import KamalIndustries.PageObjects.landingPage;
import KamalIndustries.PageObjects.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitOrderTest {

	public static void main(String[] args) {
		String productName="zara coat 3";
		
		//WebDriverManager.chromedriver().
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		// defining object using class (landingPage java class)
		landingPage LandingPage= new landingPage(driver);
		LandingPage.goTo();
		LandingPage.loginApplication("kamalnath121998@gmail.com", "Password1*");
		
		
		// defining object using class (productCatalog Java class)
		productCatalogue PC= new productCatalogue(driver);
		List<WebElement> products=PC.getProductList();
		
		PC.addProductToCart(productName);
		
		PC.goToCartPage();
		
		// defining object using class (cartPage Java class)
		cartPage cp=new cartPage(driver);
		Boolean match= cp.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		cp.goToCheckOut();
		
		Actions action= new Actions(driver);
		
		WebElement SelectCountry = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.sendKeys(SelectCountry, "India").build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class='ta-results list-group ng-star-inserted']")));
		
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
