package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.baseclass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_003_LoginDDT extends baseclass

{
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class)
	
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("***** Starting TC_003_LoginDDT *****");
		
		try
		{
		
		//home page
				HomePage hp =new HomePage(driver);
				hp.clickMyAccount();
				hp.clickLogin();
				
				
				//login page
				LoginPage lp =  new LoginPage(driver);
				lp.setEmail(p.getProperty("email"));
				lp.setPassword(p.getProperty("password"));
				lp.clickLogin();
							
				
				
				//My Account page
				MyAccountPage macc =new MyAccountPage(driver);
				boolean targetPage=macc.isMyAccountPageExists();
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}	
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{
					
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** finishing TC_003_LoginDDT *****");
	}
	
	
}
