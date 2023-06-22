package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import io.opentelemetry.sdk.resources.Resource;



public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;
	
	public ResourceBundle rb;
	@Parameters("browser")
	@BeforeClass(groups = {"Sanity","Master","Regression"})
	public void setup(String br) {
		
		
		rb=ResourceBundle.getBundle("config");//load config.properties file
		logger=LogManager.getLogger(this.getClass());  //logging
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("exclude Switches",new String[]{"enable-automation"});
		
		if(br.equals("chrome")) {
			
			driver = new ChromeDriver();
		}else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().deleteAllCookies();
		
		driver.get(rb.getString("appURL1"));
		
		//driver.get("http://localhost/opencart/upload/index.php?");
		
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups = {"Sanity","Master","Regression"})
	public void teardown() {
		
		driver.quit();
	}
	
	public String randomeString() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		
		return (generatedString);
	}
	
	public String randomNumber() {
		
		String  generatedString=RandomStringUtils.randomNumeric(10);
		
		return (generatedString);
		
	}
	
	public String randomAlphaNumeric() {
		
		String st=RandomStringUtils.randomAlphabetic(4);
		
		String  num=RandomStringUtils.randomNumeric(3);
		
	
		return (st+"@"+num);
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

}
	


	
}
