package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.*;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() {
		
		
		logger.debug("application logs.......");
		logger.info("***Starting TC_001_Account Registration");
		try {
			
			
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			logger.info("Clicked on My account link");
			hp.clickRegister();
			logger.info("Clicked on Registration link");
			
		RegistrationPage rp=new RegistrationPage(driver);
		
		logger.info("entering customer data");
		
		rp.setFirstname(randomeString().toUpperCase());
		rp.setlattname(randomeString().toUpperCase());
		rp.setEmail(randomeString()+"@gmail.com");   //randomly generated email
		
		rp.setTel(randomNumber());
		
		String pass=randomAlphaNumeric();
		
		rp.setpass(pass);
		
		rp.setConfirm(pass);
		
		rp.setclickchk();
		
		rp.clickContinue();
		
		logger.info("clicked continue");
		
		String confmsg=rp.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
			
			
		}catch(Exception e) {
			
			logger.info("test failed");
			Assert.fail();
			
		}
		
		logger.info("*****Finished TC_001_AccountRegistarionTest***..");
	}
	
	

}
