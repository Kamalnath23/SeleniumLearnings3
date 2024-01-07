package KamalIndustries.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import KamalIndustries.PageObjects.cartPage;
import KamalIndustries.PageObjects.checkOutPage;
import KamalIndustries.PageObjects.confirmationPage;
import KamalIndustries.PageObjects.landingPage;
import KamalIndustries.PageObjects.productCatalogue;
import KamalIndustries.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImpl extends BaseTest {
	
	public landingPage Landingpage;
	public productCatalogue PC;
	//public cartPage cp;
	public confirmationPage confirmPage;
	//public checkOutPage CheckOut;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		LandingPage = launchApplication();
		//code
	}
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		//code
		LandingPage = launchApplication();
		
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String userName, String password) {
		PC = LandingPage.loginApplication(userName,password );
		
	}
	
	@When ("^I add the product (.+) from Cart$")
	public void I_add_product_to_Cart(String productName)throws InterruptedException {
		List<WebElement> products = PC.getProductList();

		PC.addProductToCart(productName);
	}
	
	@And ("^Checkout (.+) and submit the Order$")
	public void Checkout_productName_and_submit_the_order(String productName){
		cartPage cp = PC.goToCartPage();

		Boolean match = cp.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		checkOutPage CheckOut = cp.goToCheckOut();
		CheckOut.selectCountry();

		confirmPage = CheckOut.submitOrder();
	}
	
	@Then ("{string} message is displayed on Confirmation Page")
	public void message_displayed_ConfirmationPage(String string) {
		
		String confirmedMsg = confirmPage.getConfirmationMessgae();
		Boolean check = confirmedMsg.equalsIgnoreCase(string);
		System.out.println(check);
		Assert.assertTrue(check);
		driver.close();
	}
	
	 @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
	   
	    	Assert.assertEquals(strArg1, LandingPage.getErrorMessage());
	    	driver.close();
	 }
	
}
