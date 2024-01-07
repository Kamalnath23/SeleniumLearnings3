package section16;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTestDemo {
  @Test
  public void f() {
	  System.out.println("Hi");
  }
  
  @Test(groups= {"Smoke"})
  public void f2() {
	  System.out.println("Hello");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
