package com.gaptest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gaptest.pageObjects.CreateEmployeePage;
import com.gaptest.pageObjects.EmployeesPage;
import com.gaptest.pageObjects.LoginPage;

/**
 * This tests creates a new employee filling all the fields and checks that after that the new 
 * employee is displayed in the employee list.
 * @author Vanessa Broź
 */

public class CreateEmployeeTC_002 extends BaseClass{

	@Test
	public void createEmployeeTest() throws InterruptedException
	{	
		//Instantiate the loginPage
		LoginPage lpage = new LoginPage(driver);
		
		//Set the credentials and login to the site
		lpage.setUserEmail(useremail);     
		lpage.setUserPassword(userpassword);   
		lpage.clickSingInBtn();   
		
		//Instantiate the EmployeePage
		EmployeesPage epage = new EmployeesPage(driver);  
		
		//Click the "Create new employee" button
		epage.clickCreatEmployeeBtn();    
		
		//Instantiate the AddEmployeePage
		CreateEmployeePage cepage = new CreateEmployeePage(driver);
		
		//Fill the form to create a new user and click the submit button
		cepage.setEmployeeName("James");    
		cepage.setEmployeeLastName("Smith");    
		cepage.setEmployeeEmail("vbtest@test.com");    
		cepage.setEmployeeId("1234567890");   
		cepage.setEmployeeLeaderName("Vanessa Broz");    
		cepage.setEmployeeStartDate("2014", "January", "21");  
		cepage.clickSubmitFormBtn(); 
		
		//Go back to the employees list
		cepage.clickBackBtn(); 
		
		//*************ASSERTIONS***********************
		Assert.assertTrue(epage.employeeExists(cepage.employeeNumber));

	}
}
