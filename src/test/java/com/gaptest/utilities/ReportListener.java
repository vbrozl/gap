package com.gaptest.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportListener extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) 
	{
		//String repName = "RepName.html";  //Set the report name
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/ExtentReport.html");  //Report path
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");   //Get the extent configuration file
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);   //Attach the HTML report
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Vanessa Broz");
		 
		htmlReporter.config().setDocumentTitle("GAP Automation Test");  
		htmlReporter.config().setReportName("GAP Automation Test");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);  //Set the charts location in the report
		htmlReporter.config().setTheme(Theme.STANDARD);  //Set the report theme
	}
	
	public void onTestSuccess(ITestResult testRes) 
	{
		logger=extent.createTest(testRes.getName());  //Create a new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(testRes.getName(), ExtentColor.GREEN));  //Set the test as passed in the report
		
	}
	
	public void onTestFailure(ITestResult testRes) 
	{
		logger=extent.createTest(testRes.getName());  //Create a new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(testRes.getName()+ " Failed", ExtentColor.RED));  //Set the test as failed in the report
		logger.fail(testRes.getThrowable());  //Log the error in the report
		
	}
	
	public void onTestSkipped(ITestResult testRes)
	{
		logger=extent.createTest(testRes.getName());   //Create a new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(testRes.getName(), ExtentColor.ORANGE));  //Set the test as skipped in the report
		
	}
	
	public void onFinish(ITestContext testContext) 
	{
		extent.flush();  //Flush the information to the report
	}
	
}
