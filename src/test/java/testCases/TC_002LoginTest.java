package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.baseclass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002LoginTest extends baseclass
{

	@Test(groups= {"sanity","master"})
	public void verify_login()
	{
		logger.info("**** Starting TC_002_LoginTest ****");
		logger.debug("capturing application debug logs ......");
		
		try {
				
		//home page
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account link on the home page");
		hp.clickLogin();
		logger.info("clicked on login link under my account..");
		
		
		//login page
		LoginPage lp =  new LoginPage(driver);
		logger.info("entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		
		
		//My Account page
		MyAccountPage macc =new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		if(targetPage==true)
		{
			logger.info("login test pass");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("login test goes fail");
			Assert.fail();
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** finished TC_002_LoginTest ****");
	}
}
