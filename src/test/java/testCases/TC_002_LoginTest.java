package testCases;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity","Master"})
	public void LoginTest() {
		
		try {
			
			logger.info("****TC_002_LoginTest Started *****");
			
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			logger.info("click on My account");
			
			hp.clickLogin();
			
			logger.info("click on Login");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.loginclick();
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage= macc.isMyAccountPageExists();
			
			Assert.assertEquals(targetpage,true,"Invalid Login data");
		}catch(Exception e) {
			Assert.fail();
		}
		
		
		
	logger.info("***Finished TC_002_LoginTest****");
		
	}
	


}
