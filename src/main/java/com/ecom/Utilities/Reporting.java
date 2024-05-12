package com.ecom.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting extends TestListenerAdapter {
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest logger;
    
    
    public void onStart(ITestContext testcontext) {
        //String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "TestReport.html";
        extent = new ExtentReports();
        //Provide the Report Path
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//"+repName);
        extent.attachReporter(htmlReporter);
        System.out.println(System.getProperty("user.dir")+"\\test-output\\"+repName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
        
        
        
        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Env", "Automation Testing");
        extent.setSystemInfo("User", "Arif Khan");

        htmlReporter.config().setDocumentTitle("Ecommerce Application");
        htmlReporter.config().setReportName("Automatio Testing Report");
        htmlReporter.config().setTheme(Theme.DARK);
        
        
    }
    
   
    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName());//create a new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //send the pass information
    }
    
    
    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String Scrn_path = System.getProperty("user.dir") + "\\Screenshots\\" +tr.getName() + ".png";
        File f = new File(Scrn_path);

        if (f.exists()) {
            try {
                logger.fail("screenshots is below " + logger.addScreenCaptureFromPath(Scrn_path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }
    
    
    
    public void onTestFinished(ITestContext testcontext) {
        extent.flush();
    }
}
