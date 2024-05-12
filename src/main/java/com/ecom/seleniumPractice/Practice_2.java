package com.ecom.seleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.ecom.pageObjects.BooksPage;
import com.ecom.pageObjects.LoginPage;

import junit.framework.Assert;

public class Practice_2 {
	
	
	WebDriver driver;
	public static String Excel_path="C:/Users/ASUS/Desktop/Employee.xlsx";
	public static FileInputStream fileinputstream;
	public static XSSFWorkbook workbook;
	public static  XSSFSheet sheet;
	public static  String username;
	public static  String password;
	
	@BeforeMethod
	public void setUp() 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\eclipse-workspace\\EcommerceProject\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//driver.get("https://demowebshop.tricentis.com/login");
		driver.get("https://www.letskodeit.com/practice");
		System.out.println("in Method");

		
	}
	
	@Ignore
	@Test(dataProvider="newData",priority=0)
	public void login(String user ,String pass) 
	{
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(user);
		
		loginpage.setPassword(pass);
		
		loginpage.clickLogin();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Demo Web Shop"))
		{
			Assert.assertTrue(true);
			
		}
		else 
		{
			
			Assert.assertTrue(false);
			
		}
		
		
		
	}
	@Ignore
	@Test(priority=1)
	public void checkDropdownView() 
	{	
		
		LoginPage loginpage  = new LoginPage(driver);
		loginpage.setUsername("ak124@gmail.com");
		
		loginpage.setPassword("a@1234");
		
		loginpage.clickLogin();
		
				
		BooksPage bookpg=new BooksPage(driver);
		bookpg.clickBooks();
		
		Select select_views= new Select(bookpg.getViews());
		
		List<WebElement>listofOptions=select_views.getOptions();
		for(WebElement option:listofOptions) 
		{
			
			System.out.println(option.getText());
			
		}
		
		select_views.selectByVisibleText("Grid");
		System.out.println(select_views.getFirstSelectedOption().getText());
		
	}
	
	@Test(priority=2,enabled=false)
	public void ExcelWrite() throws IOException 
	{	
		
		
		LoginPage loginpage  = new LoginPage(driver);
		loginpage.setUsername("ak124@gmail.com");
		
		loginpage.setPassword("a@1234");
		
		loginpage.clickLogin();
		
		fileinputstream=new FileInputStream(Excel_path);
		workbook=new XSSFWorkbook(fileinputstream);
		sheet=workbook.getSheet("Sheet1");
		int row_count=sheet.getLastRowNum()-sheet.getFirstRowNum();
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getPhysicalNumberOfCells();
		
		String user=driver.findElement(By.xpath("//a[@class='account'][contains(text(),\"@gmail.com\")]")).getText();
		System.out.print("User Logged in: "+user);
		
		sheet.getRow(1).createCell(2).setCellValue(user);
		FileOutputStream fileoutputstram=new FileOutputStream(Excel_path);
		workbook.write(fileoutputstram);
		workbook.close();
		
		
		
	}
	
	@Test
	public void TableOperation() throws IOException 
	{
		
		WebElement table=driver.findElement(By.xpath("//table[@id='product']"));
		
		List<WebElement>trows=table.findElements(By.tagName("tr"));
		
		
		for(WebElement row:trows) 
		{
			List<WebElement>tcells=row.findElements(By.tagName("td"));
			
			for(int i=0;i<tcells.size();i++)
			{
				System.out.print(tcells.get(i).getText()+" ");
				
			}
			System.out.println();
			
			
		}
		
		
	System.out.println("____________________________________________________");
		
	List<WebElement> tcells=trows.get(2).findElements(By.tagName("td"));
	System.out.println("2nd row course name:  "+tcells.get(1).getText());
	System.out.println("3nd row Price of the course:  "+tcells.get(2).getText());
	
	System.out.println("____________________________________________________");
	
	fileinputstream=new FileInputStream(Excel_path);
	workbook=new XSSFWorkbook(fileinputstream);
	sheet=workbook.getSheet("Sheet1");
	
	sheet.getRow(1).createCell(3).setCellValue(tcells.get(1).getText());
	sheet.getRow(1).createCell(4).setCellValue(tcells.get(2).getText());
	
	FileOutputStream fileoutputstram=new FileOutputStream(Excel_path);
	workbook.write(fileoutputstram);
	workbook.close();
	
	File src_scrnshots=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src_scrnshots,new File("C://Users//ASUS//eclipse-workspace//EcommerceProject//Screenshots/Screendhot1.png"));
		
	}
	
	
	

	
	
	
	
	
	@DataProvider(name="newData")
	public  Object[][] testData() throws IOException
	{
		System.out.println("Ecell "+Excel_path);
		 fileinputstream=new FileInputStream(Excel_path);
		 workbook=new XSSFWorkbook(fileinputstream);
		 sheet=workbook.getSheet("Sheet1");
		int row_count=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("row_count "+row_count);
		
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] data=new Object[rows-1][cols];
		
		for(int i=1;i<=row_count;i++) 
		{
			Row row= sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue(); // Assuming all cells contain string data
            }
			
		}
		
		workbook.close();
		fileinputstream.close();
		
		
		return data;
		
		
		
	}
	
	@AfterMethod
	public void AfterMethod() 
	{
		System.out.println("in AfterMethod");
		//driver.close();
	}
	
	
	
}
