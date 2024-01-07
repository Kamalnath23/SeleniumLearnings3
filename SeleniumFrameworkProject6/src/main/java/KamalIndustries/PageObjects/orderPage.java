package KamalIndustries.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalIndustries.AbstractComponents.AbstractComponent;

public class orderPage extends AbstractComponent {
	WebDriver driver;
	
	public orderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> productNames;
	
	
	public boolean VerifyOrderDisplay(String productName) {
		Boolean match= productNames.stream()
				.anyMatch(Product -> Product.getText()
						.equalsIgnoreCase(productName));
		return match;
	}

	
}
