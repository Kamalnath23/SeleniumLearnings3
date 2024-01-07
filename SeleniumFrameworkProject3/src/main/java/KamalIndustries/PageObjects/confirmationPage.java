package KamalIndustries.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalIndustries.AbstractComponents.AbstractComponent;

public class confirmationPage extends AbstractComponent {
	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	public String getConfirmationMessgae() {
		String msg= confirmMessage.getText();
		System.out.println(msg);
		return msg;
	}
	
}
