package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;

public class VerifyMultipleCredentials extends TestBase
{
	   LoginPage login;
	   
	@BeforeMethod(alwaysRun=true)
	   public void setUp() throws InterruptedException
	   {
		   initialization();
		   login=new LoginPage();
	   }
	@DataProvider(name="Credentials")
	public Object[][] getData()
	{
		return new Object [][]
			{
			{"standard_user","secret_sauce1"},//un correct,pass incorrect
			{"locked_out_user1","secret_sauce"},//un incorrect,pass correct
			{"problem_user1","secret_sauce1"},//un incorrect,pass incorrect
			{"performance_glitch_user","secret_sauce"},//un correct,pass correct
			//{"error_user","secret_sauce"},
			//{"visual_user","secret_sauce"}
			};
	}
	
	  @Test(dataProvider = "Credentials")
	  public void logintoAppWithMultiCreds(String un,String pass)
	  {
		  SoftAssert s=new SoftAssert();
		  String expURL="https://www.saucedemo.com/inventory.html";
		  String actURL=login.logintoAppWithMultiCreds(un, pass);
		  s.assertEquals(expURL, actURL);
		  s.assertAll();
	  }
	   @AfterMethod
	   public void CloseBrowser()
	   {
		   driver.close();
	   }
	   
}
