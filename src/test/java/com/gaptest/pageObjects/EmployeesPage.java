package com.gaptest.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeesPage {

	WebDriver driver;
	
	//*********Constructor*********
	public EmployeesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*********Web Elements by using Page Factory*********
	@FindBy(xpath="//table")
	@CacheLookup
	WebElement empList;
	
	@FindBy(xpath="//a[@href='/employees/new']")
	@CacheLookup
	WebElement btnCreateEmployee;
	
	
	//*********Page Methods*********
	
	//Click the button to create a new employee
	public void clickCreatEmployeeBtn()
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(btnCreateEmployee));
		btnCreateEmployee.click();
	}
	
	//Returns true or false if employee number exists in the employee list
	public boolean employeeExists(String empNumber) 
	{
		boolean empExists = false;
		
		List<WebElement> empLstRows  =  empList.findElements(By.xpath("//tbody/tr"));
		//Check all the rows in the table to get the employee number
		for (int i=1; i<empLstRows.size();i++) { 
			
			//Check the href attribute in the row to get the employee number
			String cell = empLstRows.get(i).findElement(By.xpath(".//td[7]//a")).getAttribute("href");
		    if (cell.contains(empNumber)) {
		    	System.out.println("New employee exists in table");
		    	empExists = true;
		    	break;
		    }
	    }
		return empExists;
	}
}
