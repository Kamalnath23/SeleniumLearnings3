package section16;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo {
	@DataProvider
	public Object[][] getData() {
		//1st combiantion - username password - good credit history 
		//2nd username password -no cedit history
		// 3rd fraude lent credit history

		Object[][] data= new Object[3][2];
		
		//1st set
		data[0][0]="firstsetupUserName";
		data[0][1]="password";
		
		//2nd set
		data[1][0]="secondsetupUserName";
		data[1][1]="secondpassword";
		
		//3rd set
		data[2][0]="thirdsetupUserName";
		data[2][1]="thirdpassword";
		return data;
	
	  }
  @Test(dataProvider="getData")
  public void MobileLogInCarLoan(String name, String pass) {
	  System.out.println("Logged in as: "+name);
	  System.out.println("Keep pass confidential: "+pass);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Test commence");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("test end");
  }
  

}
