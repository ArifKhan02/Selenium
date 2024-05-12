package com.ecom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	
	


static WebDriver driver;
	
	public BooksPage(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")
	@CacheLookup
	WebElement Books;
	
	@FindBy(id="products-viewmode")
	@CacheLookup
	WebElement views;
	
	
	public void clickBooks() 
	{
		Books.click();
	}
	
	public WebElement getViews() 
	{
		return views;
	}
}
