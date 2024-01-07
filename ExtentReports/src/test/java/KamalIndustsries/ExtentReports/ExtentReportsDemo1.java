package KamalIndustsries.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo1 {
	public WebDriver driver;
	ExtentReports extent;
	
	@BeforeTest
	public void configurationOfExtentReport() {
		//ExtentReports, ExtentSparkReporter
		
		String extentSparkReporterFilePath = System.getProperty("user.dir")+"//reports//index.html";
		//String path= "D:\\IT Skill Up Zone - Practicals\\Rahul Shetty Academy\\ExtentReports";
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentSparkReporterFilePath);
		//ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kamalnath");
		
	}
	@Test
	public void initialDemo() {
		ExtentTest test= extent.createTest("initialDemo");
		
		System.setProperty("webdriver.chrome.driver",
				"D:\\IT Skill Up Zone - Practicals\\SELENIUM AUTOMATION FROM BASICS\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com");
		String title= driver.getTitle();
		System.out.println(title);
		test.addScreenCaptureFromBase64String(title);
		test.fail("resuly do not match");
		driver.quit();
		extent.flush();
		
		
	}
}
