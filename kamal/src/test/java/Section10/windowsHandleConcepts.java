package Section10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class windowsHandleConcepts {
	WebDriver driver;
	String pass="learning";
	
	@Test
	public void test() {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newWindowPage= driver.findElement(By.xpath("//a[@target='_blank']"));
		newWindowPage.click();
		
		Set<String> windows= driver.getWindowHandles(); //parent id, child id
		Iterator<String> it= windows.iterator();
		String parentId= it.next();
		String childId = it.next();
		System.out.println("Parent ID: "+parentId);
		System.out.println("cHILD id: "+childId);
		driver.switchTo().window(childId);
		
		WebElement paragraph= driver.findElement(By.cssSelector("p[class='im-para red']"));
		System.out.println(paragraph.getText());
		String name= paragraph.getText().split("at")[1].trim().split(" ")[0];
		System.out.println(name);
		
		String []n= name.split("@");
		System.out.println(n[1]);
		String m=n[1];
		//String[]k= m.split(".");
		//System.out.println(k[0]);
		
		//String username=null;
		//System.out.println(username);
		driver.switchTo().window(parentId);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		WebElement user_radio_btn = driver.findElement(By.xpath("//*[text()=' User']"));
		WebElement dd= driver.findElement(By.xpath("//select[@class='form-control']"));
		WebElement signInBtn= driver.findElement(By.cssSelector("input#signInBtn"));
		
		Actions a = new Actions(driver);
		a.moveToElement(username).click().sendKeys(m).keyDown(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).build().perform();
		
		
		//Additional codes referd from assignment9 class in sectio-9 package
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

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {

	}

}
