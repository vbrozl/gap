package com.gaptest.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	//Set site url, username and password for all test classes to use.
	public String url="https://vacations-management.herokuapp.com/users/sign_in";
	public String useremail="gap-automation-test@mailinator.com";
	public String userpassword="12345678";
	public static WebDriver driver;
	
	
	@BeforeClass
	public void setup()
	{
		//Create a driver, all the test cases use this.
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
