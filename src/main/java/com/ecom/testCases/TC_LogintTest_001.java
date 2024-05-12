package com.ecom.testCases;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.ecom.Utilities.ReadWrite;
import com.ecom.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LogintTest_001 extends BaseClass {
	
	public static WebDriver driver;
	String url="https://demowebshop.tricentis.com/login";
	
	@Test(dataProvider="testData1")
	public void loginTest(String user, String pass) {
		BaseClass base=new BaseClass();
		
		driver.get(url);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(user);
		base.logger.info("username entered");
		loginpage.setPassword(pass);
		//logger.info("password entered");
		loginpage.clickLogin();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Demo Web Shop"))
		{
			Assert.assertTrue(true);
			//logger.info("login test passed");
		}
		else 
		{
			
			Assert.assertTrue(false);
			//logger.info("login test Failed");
		}
	}

}
