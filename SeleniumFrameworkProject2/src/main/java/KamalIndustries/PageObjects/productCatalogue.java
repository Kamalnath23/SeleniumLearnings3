package KamalIndustries.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalIndustries.AbstractComponents.AbstractComponent;

public class productCatalogue extends AbstractComponent{
	WebDriver driver;
	public productCatalogue(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory - Concept :)
	//Instead of below commented, use PageFactor by implementing @findBy tags
	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinnerAnimation;
	
	//locator
	By ProductsBy=By.cssSelector(".mb-3");
	By addToCart = By.cssSelector("div.card-body button:last-of-type");
	By toastMessage= By.cssSelector("div#toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(ProductsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod=  products.stream().filter(product -> 
		 product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod= getProductByName(productName);
		 prod.findElement(addToCart).click();
		 waitForElementToAppear(toastMessage);
		 waitForElementToDisAppear(spinnerAnimation);
	}
	
	
	
	
	
}
