package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy (name="firstname")
	WebElement txtfname;
	
	@FindBy (name="lastname")
	WebElement txtlname;
	
	@FindBy (id="input-email") WebElement txtEmail;
	
	@FindBy (id="input-telephone") WebElement txttel;
	
	@FindBy (xpath="//input[@name='password']") WebElement txtpass;
	
	@FindBy (xpath="//input[@name='confirm']") WebElement txtConfirm;
	
	@FindBy (xpath="//input[@type='checkbox']") WebElement chkbox;
	
	@FindBy (xpath="//input[@value='Continue']")  WebElement clkcontinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstname(String fname) {

		txtfname.sendKeys(fname);
	}

	public void setlattname(String lname) {

		txtlname.sendKeys(lname);
	}
	
	
	public void setEmail(String email) {

		txtEmail.sendKeys(email);
	}
	
	public void setTel(String ph) {
		txttel.sendKeys(ph);
	}
	
	public void setpass(String pass) {
		txtpass.sendKeys(pass);
	}
	
	public void setConfirm(String word) {
		txtConfirm.sendKeys(word);
	}
	
	public void setclickchk() {
		chkbox.click();
	}
	
	public void clickContinue() {
		clkcontinue.click();
	}
	
	
	public String getConfirmationMsg() {
		try {
			
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}

}
