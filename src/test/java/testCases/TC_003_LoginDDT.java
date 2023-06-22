package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email,String password,String exp) {
		
		logger.info("***TC_003_LoginDDT***");
		
		try {
			
			HomePage hp=new HomePage(driver);
			hp.clickMyaccount();
			logger.info("click on My account");
			
			hp.clickLogin();
			
			logger.info("click on Login");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.loginclick();
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage= macc.isMyAccountPageExists();
			
			if(exp.equals("valid")) {
				
				if(targetpage==true) {
					macc.clickLogout();
					
					Assert.assertTrue(true);
				}else {
					
					Assert.fail();
				}
				
			}
			
			
			if (exp.equals("Invalid")) {

				if (targetpage == true) {
					macc.clickLogout();

					Assert.assertTrue(false);
				} else {

					Assert.assertTrue(true);
				}

			}
			
			logger.info("***TC_003_LoginDDT*** Finished..");

			
		}catch(Exception e) {
			Assert.fail();
			
		}
		
			}

}
