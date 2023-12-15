package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;


import java.io.IOException;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import base.TestBase;

import pages.LoginPage;
import utility.CaptureScreenshot;

public class LoginPageTest extends TestBase
{
	   LoginPage login;
	   
	   @BeforeMethod (alwaysRun = true)
	   public void setUp() throws InterruptedException
	   {
		   initialization();
		   login=new LoginPage();
	   }
	   @Test(groups = "Sanity")
	   
	   public void VerifyTitleOfApplication()
	   {
		   String expTitle="Swag Labs";
		   String actTitle=login.VerifyTitleOfApplication();
		   AssertJUnit.assertEquals(expTitle, actTitle);
		   }
	   
	   @Test   (groups = {"Sanity","Retesting"})
	   public void VerifyURLofApplication()
	   {
		   String expURL="https://www.saucedemo.com/";
		   String actURL=login.VerifyURLofApplication();
		   AssertJUnit.assertEquals(expURL, actURL);
	   }
	   
	   @Test(groups = "Regression")
	   public void LoginToApplication()
	   {
		   String expURL="https://www.saucedemo.com/inventory.html";
		   String actURL=login.LoginToApplication();
		   AssertJUnit.assertEquals(expURL, actURL);
		   
	   }
	   @AfterMethod(alwaysRun = true)
	   public void CloseBrowser(ITestResult it) throws IOException
	   {
		   if(it.FAILURE == it.getStatus())
		   {
			   CaptureScreenshot.screenshot(it.getName());
		   }
		   report.flush();
		   driver.close();
	   }
	   
}

