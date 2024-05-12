package com.ecom.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadWrite  {

	static ReadConfig readconfig=new ReadConfig();
	public static String Excel_path=readconfig.getExcelPath();
	
	public static FileInputStream fileinputstream;
	public static XSSFWorkbook workbook;
	public static  XSSFSheet sheet;
	public String username;
	public String password;
	

	
	@DataProvider(name="testData1")
	public  Object[][] testData() throws IOException
	{
		System.out.println("Ecell "+Excel_path);
		 fileinputstream=new FileInputStream(Excel_path);
		 workbook=new XSSFWorkbook(fileinputstream);
		 sheet=workbook.getSheet("Sheet1");
		int row_count=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("row_count "+row_count);
		
		for(int row=2;row<=row_count;row++) 
		{
			 username=sheet.getRow(row).getCell(0).getStringCellValue();
			 password=sheet.getRow(row).getCell(2).getStringCellValue();
			
			
		}
		
		System.out.println(username);
		System.out.println(password);
		
		
		Object [][] data=new Object[2][3];
				data[0][0]=username;
				data[0][1]=password;
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
}
