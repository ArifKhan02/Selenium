package com.ecom.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() 
	{
		File src_file=new File("./Configuration/config.properties");
		try 
		{
			FileInputStream fis=new FileInputStream(src_file) ;
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}

		
	}
	public String getApplicationUrl() 
	{
		String url=pro.getProperty("url");
		return url;
		
	}
	
	public String getUsername() 
	{
		String username=pro.getProperty("username");
		return username;
		
	}
	public String getPassword() 
	{
		String password=pro.getProperty("password");
		return password;
		
	}
	public String getExcelPath() 
	{
		String Excel_path=pro.getProperty("Excel_path");
		return Excel_path;
		
	}
	
	
	

}
