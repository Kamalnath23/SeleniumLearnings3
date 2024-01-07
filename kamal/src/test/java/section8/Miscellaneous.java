package section8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.browser.model.WindowID;

public class Miscellaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		// WindowID.killByName("excel.exe");

		// driver.manage().deleteCookieNamed("sessionKey");

		// click on any link
		// login page- verify login url

		/*
		 * driver.get("http://google.com");
		 * 
		 * File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src,new File("C:\\Users\\rahul\\screenshot.png"));
		 */

	}

}
