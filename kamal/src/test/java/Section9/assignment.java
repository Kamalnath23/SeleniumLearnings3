package Section9;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class assignment {
	WebDriver driver;
	String u_name = "rahulshettyacademy";
	String pass = "learning";

	@Test
	public void test4() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//explicit wait
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		// webelement
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		WebElement user_radio_btn = driver.findElement(By.xpath("//*[text()=' User']"));
		WebElement dd= driver.findElement(By.xpath("//select[@class='form-control']"));
		WebElement signInBtn= driver.findElement(By.cssSelector("input#signInBtn"));
		
		// operations
		username.sendKeys(u_name);
		password.sendKeys(pass);
		user_radio_btn.click();
		Select dropdown= new Select(dd);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@class='form-control']")));
		//Thread.sleep(3000);
		dropdown.selectByIndex(2);
		String selectedDropdown= dropdown.getFirstSelectedOption().getText(); //getting string value of selected dropdown value
		 System.out.println(selectedDropdown);
		
		WebElement okay = driver.findElement(By.cssSelector("button#okayBtn"));
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button#okayBtn")));
		okay.click();
		
		signInBtn.click();
		
		//webelemnet and operations at shoppping page
		// //button[@class='btn btn-info']
		// h4.card-title  //h4[@class='card-title']
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h4.card-title")));
		List<WebElement> products=driver.findElements(By.cssSelector("h4.card-title"));
		for(int i=0;i<products.size();i++) {
			String product_name=products.get(i).getText();
			System.out.println("Going to select "+product_name);
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
		
		WebElement checkout= driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']"));
		checkout.click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		WebElement checkout2= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		checkout2.click();
		
		
		/*if (user_radio_btn.isSelected()==true) {
			WebElement okay = driver.findElement(By.cssSelector("button#okayBtn"));
			w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button#okayBtn")));
			okay.click();
		} */

		/*
		 * if (ExpectedConditions.alertIsPresent() != null) { Alert alert =
		 * driver.switchTo().alert(); String text = alert.getText();
		 * System.out.println("Alert dialogue text is " + text); alert.accept(); }
		 */

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// (username is rahulshettyacademy and Password is learning)

	}

	@AfterMethod
	public void afterMethod() {
		// driver.close();
	}

}
