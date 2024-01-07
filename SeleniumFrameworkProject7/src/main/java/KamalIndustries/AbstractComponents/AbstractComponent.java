package KamalIndustries.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import KamalIndustries.PageObjects.cartPage;
import KamalIndustries.PageObjects.orderPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement Cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement WE) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(WE));
	}
	
	public cartPage goToCartPage() {
		Cart.click();
		// defining object using class (cartPage Java class)
		cartPage cp=new cartPage(driver);
		return cp;
	}
	
	public void waitForElementToDisAppear(WebElement ElementDisappear) {
		// use thread.sleep  - if you want to load the screen at faster.because this spinner animation taking 4 sec so that all codes loaded in back-end at slower rate
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ElementDisappear));
	}
	
	public orderPage goToOrderPage() {
		orderHeader.click();
		orderPage OrderPage= new orderPage(driver);
		return OrderPage;
	}
}
