package KamalIndustries.Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import KamalIndustries.PageObjects.cartPage;
import KamalIndustries.PageObjects.productCatalogue;
import KamalIndustries.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
  @Test(groups= {"ErrorHandling"}, retryAnalyzer = KamalIndustries.TestComponents.Retry.class)
  public void loginErrorValidation() {
	  String productName = "zara coat 3";
	LandingPage.loginApplication("kamalnath12199@gmail.com", "Pssword1*");
	LandingPage.getErrorMessage();
	Assert.assertEquals("Incorrect email or password.", LandingPage.getErrorMessage() );

  }
  
  @Test( retryAnalyzer = KamalIndustries.TestComponents.Retry.class)
  public void productErrorValidation() {
		String productName = "zara coat 3";

		// landingPage LandingPage= launchApplication();   --> this method is used before 'BeforeMethod'

		productCatalogue PC = LandingPage.loginApplication("kamalnath121998@gmail.com", "Password1*");

		List<WebElement> products = PC.getProductList();

		PC.addProductToCart(productName);

		cartPage cp = PC.goToCartPage();

		Boolean match = cp.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

  }
  
}
