package KamalIndustries.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporterNG {
	
	public static ExtentReports getRepoertObject() {
	//ExtentReports, ExtentSparkReporter
		
		String extentSparkReporterFilePath = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(extentSparkReporterFilePath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kamalnath");
	
		return extent;
	}
}
