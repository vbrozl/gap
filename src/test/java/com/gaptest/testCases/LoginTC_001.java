package com.gaptest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gaptest.pageObjects.HomePage;
import com.gaptest.pageObjects.LoginPage;

/**
 * This test logs in an user and checks that some elements in the home page are present.
 * @author Vanessa Broź
 */
public class LoginTC_001 extends BaseClass {
	
	@Test
	public void loginUserTest()
	{
		//Instantiate the loginPage
		LoginPage lpage = new LoginPage(driver);
		
		//Enter the credentials and click the sing up button
		lpage.setUserEmail(useremail); 
		lpage.setUserPassword(userpassword);
		lpage.clickSingInBtn(); 

		//Instantiate the HomePage
		HomePage hpage = new HomePage(driver);
		
		//*************ASSERTIONS***********************
		Assert.assertTrue(hpage.siteLogoIsVisible());
		Assert.assertEquals(hpage.getLoginText(), "Welcome gap, Logout"); 
		Assert.assertEquals(hpage.getLoginSuccessMsg(), "Signed in successfully.");
	}
}
