package experiment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	// 3
	@BeforeTest
	public void beforeTest() {
		System.out.println("In Before TEST method");
	}

	// 4
	@AfterTest
	public void afterTest() {
		System.out.println("In After TEST method");
	}

	// 1
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("In Before SUITE method");
	}

	// 2

	@AfterSuite
	public void afterSuite() {
		System.out.println("In After SUITE method");
	}

}
