package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.baseclass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends baseclass  
{
	
	
	@Test(groups= {"regression"})
	public void verify_account_registration()
	
	{
		logger.info("****** starting TC_001_AccountRegistrationTest  *****");
		
		logger.debug("applications logs started... ");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("Clicked on My account link");
		
		hp.clickRegister(); 
		
		logger.info("Clicked on Registration link");
		
		logger.info("Entering customer");		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");   // randomly generate the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("clicked on continue..");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message ");
		
		
		if(confmsg.equals("Your Account Has Been Created!!!"))
		{
			logger.info("test passed....");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.error("test failed...");
			Assert.fail();
		}
			
	}
		
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();  
		}
		logger.debug("applications logs ended... ");
		logger.info("****** Finishing TC_001_AccountRegistrationTest  *****");
		
	}
	
	
	
	
}
















