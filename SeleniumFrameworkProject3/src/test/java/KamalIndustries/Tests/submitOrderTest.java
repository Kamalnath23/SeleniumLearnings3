package KamalIndustries.Tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import KamalIndustries.PageObjects.cartPage;
import KamalIndustries.PageObjects.checkOutPage;
import KamalIndustries.PageObjects.confirmationPage;
import KamalIndustries.PageObjects.landingPage;
import KamalIndustries.PageObjects.orderPage;
import KamalIndustries.PageObjects.productCatalogue;
import KamalIndustries.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class submitOrderTest extends BaseTest {
	String productName = "zara coat 3";
	@Test
	public void submitOrder() throws IOException {
		
		// landingPage LandingPage= launchApplication();   --> this method is used before 'BeforeMethod'

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
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		productCatalogue PC = LandingPage.loginApplication("kamalnath121998@gmail.com", "Password1*");
		orderPage OrderPage= PC.goToOrderPage();
		OrderPage.VerifyOrderDisplay(productName);
		
		Assert.assertTrue(OrderPage.VerifyOrderDisplay(productName));
	}

}
