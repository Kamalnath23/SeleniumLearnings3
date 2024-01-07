package experiment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestClass01 extends BaseClass {
  @Test
  public void testMethod1() {
	  System.out.println("TestClass01: In testMethod1");
  }
  
  @Test(groups= {"Smoke"})
  public void testMethod2() {
	  System.out.println("TestClass01: In testMethod2");
  }
  
  @BeforeMethod(groups= {"Smoke"})
  public void beforeMethod() {
	  System.out.println("TestClass01: In Before METHOD");
  }

  @AfterMethod(groups= {"Smoke"})
  public void afterMethod() {
	  System.out.println("TestClass01: In After METHOD");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("TestClass01: In Before CLASS method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("TestClass01: In After CLASS method");
  }

}
