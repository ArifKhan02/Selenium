package com.ecom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	static WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	//@CacheLookup
	WebElement login;
	
	
	public void setUsername(String user) 
	{
		username.sendKeys(user);
	}
	
	public void setPassword(String pass) 
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin() 
	{
		login.click();
	}
}
