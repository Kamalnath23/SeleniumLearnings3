package KamalIndustries.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import KamalIndustries.PageObjects.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public landingPage LandingPage;
	
	public WebDriver initializeDrivers() throws IOException {
		// properties class

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\KamalIndustries\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName =System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		// prop.getProperty("browser");

		// WebDriverManager.chromedriver().
		if (browserName.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1400,900)); //fullscreen
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Firefox
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumAutomationMaven\\SELENIUM AUTOMATION FROM BASICS\\Firefox");

			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			// edge
			System.setProperty("webdriver.edge.driver", "D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\MSEdge\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver; 
	}
	
	//(map,amp)
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		
		//read JSON to String
		//FileUtils.readFileToString(new File("D:\\IT Skill Up Zone - Practicals\\Rahul Shetty Academy\\SeleniumFrameworkProject4\\src\\test\\java\\KamalIndustries\\Data\\purchaseOrder.json"))
		
		String jsonContent= FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8
				);  
		
		//String to Hashmap
		//Jackson databind
		ObjectMapper mapper= new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {			
		});
		
		return data;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File source= ts.getScreenshotAs(OutputType.FILE);
		
		File file= new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+".png");
		
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir")+"//reports//"+ testCaseName+".png";
}
	
	@BeforeMethod(alwaysRun=true)
	public landingPage launchApplication() throws IOException {
		driver=initializeDrivers();
		// defining object using class (landingPage java class)
				LandingPage = new landingPage(driver);
				LandingPage.goTo();
				return LandingPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
