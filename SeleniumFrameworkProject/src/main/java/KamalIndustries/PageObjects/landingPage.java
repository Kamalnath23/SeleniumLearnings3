package KamalIndustries.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalIndustries.AbstractComponents.AbstractComponent;

public class landingPage extends AbstractComponent {
	WebDriver driver;
	public landingPage(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory - Concept :)
	//Instead of below commented, use PageFactor by implementing @findBy tags
	//WebElement id= driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement id;
	
	//WebElement pass= driver.findElement(By.cssSelector("input#userPassword"));
	@FindBy(css="input#userPassword")
	WebElement pass;
	
	//WebElement LoginBtn =  driver.findElement(By.id("login"));
	@FindBy(id="login")
	WebElement LoginBtn;
	
	//Implementing Actions method for page factory
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public productCatalogue loginApplication(String email, String Password) {
		id.sendKeys(email);
		pass.sendKeys(Password);
		LoginBtn.click();
		
		// defining object using class (productCatalog Java class)
		productCatalogue PC= new productCatalogue(driver);
		return PC;
	}
	
	
}
