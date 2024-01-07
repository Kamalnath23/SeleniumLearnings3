package KamalIndustries.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KamalIndustries.resources.extentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentReports extent= extentReporterNG.getRepoertObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); //Thread Safe
	
	@Override
	public void onTestStart(ITestResult result) { // TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //Unique Thread ID (ErrorValidation)-> Test
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	// TODO Auto-generated method stub
		test.log(Status.PASS,"Test Passed");
		System.out.println("I successfully executed listeners pass code");
	}

	@Override
	public void onTestFailure (ITestResult result) { 
		// TODO Auto-generated method stub
		//Take Screen
		//response if API Failure
		//test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());
		
		test.log(Status.FAIL,"Test Failed");
		System.out.println("I successfully executed listeners FAIL code OF METHOD "+result.getName());
		
		
		//defining driver and its life
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		//Step#1 Take a Screenshot
		//Step#2 Attach the screenshot to the report
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) { 
		// TODO Auto-generated method stub
		//extent.flush();
		test.log(Status.SKIP,"Test Skipped");
		System.out.println("I successfully executed listeners SKIP code OF METHOD "+result.getName());
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
