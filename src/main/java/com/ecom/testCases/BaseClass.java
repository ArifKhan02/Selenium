package com.ecom.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecom.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();

	public String url = readconfig.getApplicationUrl();
	public String username =readconfig.getUsername();
	public String password =readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("Browser")
	@BeforeClass
	public void setUp(String br) {
		logger=Logger.getLogger("EcommerceProject");
		PropertyConfigurator.configure("log4j.properties");
		
		 if(br.equals("chrome")) 
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\eclipse-workspace\\EcommerceProject\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
		 }
		 else if(br.equals("firefox")) 
		 {
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\ASUS\\eclipse-workspace\\EcommerceProject\\Drivers\\FirefoxDriver.exe");
			 driver=new FirefoxDriver();
		 }
		 else if(br.equals("Edge")) 
		 {
			 System.setProperty("webdriver.edge.driver","C:\\Users\\ASUS\\eclipse-workspace\\EcommerceProject\\Drivers\\EdgeDriver.exe");
			 driver=new FirefoxDriver();
		 }
		 driver.get(url);

		
		
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
