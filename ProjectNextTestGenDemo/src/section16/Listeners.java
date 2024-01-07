package section16;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) { // TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	// TODO Auto-generated method stub
		System.out.println("I successfully executed listeners pass code");
	}

	@Override
	public void onTestFailure (ITestResult result) { 
		// TODO Auto-generated method stub
		//Take Screen
		//response if API Failure
		System.out.println("I successfully executed listeners FAIL code OF METHOD "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) { 
		// TODO Auto-generated method stub

	}
}
