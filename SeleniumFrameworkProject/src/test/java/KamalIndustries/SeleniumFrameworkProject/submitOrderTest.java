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
import KamalIndustries.PageObjects.checkOutPage;
import KamalIndustries.PageObjects.confirmationPage;
import KamalIndustries.PageObjects.landingPage;
import KamalIndustries.PageObjects.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitOrderTest {

	public static void main(String[] args) {
		String productName = "zara coat 3";

		// WebDriverManager.chromedriver().
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// defining object using class (landingPage java class)
		landingPage LandingPage = new landingPage(driver);
		LandingPage.goTo();
		productCatalogue PC = LandingPage.loginApplication("kamalnath121998@gmail.com", "Password1*");

		List<WebElement> products = PC.getProductList();

		PC.addProductToCart(productName);

		cartPage cp = PC.goToCartPage();

		Boolean match = cp.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		checkOutPage CheckOut = cp.goToCheckOut();
		CheckOut.selectCountry();

		confirmationPage confirmPage = CheckOut.submitOrder();
		String confirmedMsg = confirmPage.getConfirmationMessgae();

		Boolean check = confirmedMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		System.out.println(check);
		Assert.assertTrue(check);

	}

}
