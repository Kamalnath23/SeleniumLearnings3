package KamalIndustries.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalIndustries.AbstractComponents.AbstractComponent;

public class checkOutPage extends AbstractComponent {
	WebDriver driver;
	
	public checkOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement SelectCountry;
	
	@FindBy(xpath="(//span[@class='ng-star-inserted'])[2]")
	WebElement india;
	
	@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	By results= By.cssSelector("section[class='ta-results list-group ng-star-inserted']");
	
	public void selectCountry() {
		Actions action= new Actions(driver);
		action.sendKeys(SelectCountry, "India").build().perform();
		
		waitForElementToAppear(results);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class='ta-results list-group ng-star-inserted']")));
		
		india.click();
	}
	
	public  confirmationPage submitOrder(){
		submit.click();
		confirmationPage confirmPage= new confirmationPage(driver);
		return confirmPage;
	}
	
}
