package com.ecom.seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.WithTimeout.DurationBuilder;
import junit.framework.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Practice_1 {
	//define wedriver
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		//set browserdriver path
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ASUS\\\\eclipse-workspace\\\\EcommerceProject\\\\Drivers\\\\chromedriver.exe");
		//Initialize the chrome driver
		driver=new ChromeDriver();
		
		//load the url
		driver.get("https://demowebshop.tricentis.com/login");
		
		//navigate to url
		//it will not wait for the page load
		//driver.navigate().to("https://demowebshop.tricentis.com/login");
		
		//driver.navigate().forward();
		//driver.navigate().back();
		
		//scroll the page to down using pixel
		JavascriptExecutor js_exe=(JavascriptExecutor)driver;
		//js_exe.executeScript("window.scrollBy(0,600)");
		
		//locate the gift cards using locator relative xpath
		//
		//scroll the page to particular webelement
		//js_exe.executeScript("arguments[0].scrollIntoView()", element);
		
		//locate the element using css selector
		WebElement element=driver.findElement(By.cssSelector("input[type=\"text\"][class=\"search-box-text ui-autocomplete-input\"]"));
		
		//implicit wait
		
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		//send the element without using send key
		js_exe.executeScript("arguments[0].value='Laptop'",element);
		
		//clear the text box
		element.clear();
		
		//get the name of attribute name same I can use for fetching the text from the disable webelement
		String class_attr=element.getAttribute("class");
		System.out.println("Search box class Attributes name: "+class_attr);
		
		
		//locate the Search button using xpath axes
		//WebElement Search_butn=driver.findElement(By.xpath("//form/child::input[2]"));
		
		//How to use the Enter Key in selenium
		//Search_butn.sendKeys(Keys.ENTER);
		
		//how to pause the selenium Execution for two seconds 
		//1.driver.wait(5000); 2.Thread.sleep(3000);
		driver.wait(5000);
		
		//fetch the current page url
		//String current_page_url=driver.getCurrentUrl();
		//System.out.println(current_page_url);
		
		//how to maximize the browser
		driver.manage().window().maximize();
		
		//how to delete the all the cookies
		driver.manage().deleteAllCookies();
		
		//diff ways to refresh the page
		//driver.navigate().refresh();
		 Actions action=new Actions(driver);
		//action.sendKeys(Keys.F5).build().perform();
		
		//how handle the hidden element in selenium 
		//selenium cannot handle the hidden button by using java script executor we can use same 
		//will result in Exceptions like ElementNotVisible or ElementNotInteractable Exceptions
		//driver.get("https://www.letskodeit.com/practice");
		//js_exe.executeScript("document.getElementByID('displayed-text').value='enter the value'");
		
		//how resize the page
		Dimension ds=new Dimension(500,400);
		driver.manage().window().setSize(ds);
		
		
		//defing Explicit wait
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(""))));
		
		//how to perform drag and drop
		//action.dragAndDrop(element, element).build().perform();
		//Using click and hold and Move to the elements
		//action.clickAndHold(element).moveToElement(element);		
		
		//right click
		action.contextClick().build().perform();
		//double click
		action.doubleClick().build().perform();
		
		
		//Assert verification point
		/**Assert.assertTrue(true);
		Assert.assertFalse(true);
		Assert.assertEquals(expected,actual);
		Assert.assertNotEquals(expected,actual);**/
		
		
		
	}

}
