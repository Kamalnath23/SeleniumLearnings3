package KamalIndustries.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import KamalIndustries.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css="li.totalRow button[class='btn btn-primary']")
	WebElement CheckOut;
	
	public cartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyProductDisplay(String productName) {
		Boolean match= cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText()
						.equalsIgnoreCase(productName));
		return match;
	}
	
	public void goToCheckOut() {
		CheckOut.click();
	}
	
}
