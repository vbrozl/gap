package com.gaptest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEmployeePage {

	WebDriver driver;
	public String employeeNumber;
	
	//*********Constructor*********
	public CreateEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*********Web Elements by using Page Factory*********
	@FindBy(id="employee_first_name")
	@CacheLookup
	WebElement txtEmpFirstName;
	
	@FindBy(id="employee_last_name")
	@CacheLookup
	WebElement txtEmpLastName;
	
	@FindBy(id="employee_email")
	@CacheLookup
	WebElement txtEmpEmail;
	
	@FindBy(id="employee_identification")
	@CacheLookup
	WebElement txtEmpId;
	
	@FindBy(id="employee_leader_name")
	@CacheLookup
	WebElement txtEmpLeadeName;
	
	@FindBy(id="employee_start_working_on_1i")
	@CacheLookup
	WebElement drpStartYear;
	
	@FindBy(id="employee_start_working_on_2i")
	@CacheLookup
	WebElement drpStartMonth;
	
	@FindBy(id="employee_start_working_on_3i")
	@CacheLookup
	WebElement drpStartDay;
	
	@FindBy(css="[name=commit]")
	@CacheLookup
	WebElement btnCreateEmployee;
	
	@FindBy(xpath="//a[contains(text(), 'Back')]")
	@CacheLookup
	WebElement btnBack;
	
	
	//*********Page Methods*********
	
	//Enter employee name
	public void setEmployeeName(String empName)
	{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(txtEmpFirstName));
		txtEmpFirstName.sendKeys(empName);
	}
	
	//Enter employee last name
	public void setEmployeeLastName(String empLastName)
	{
		txtEmpLastName.sendKeys(empLastName);
	}
	
	//Enter employee email
	public void setEmployeeEmail(String empEmail)
	{
		txtEmpEmail.sendKeys(empEmail);
	}
	
	//Enter employee id
	public void setEmployeeId(String empId)
	{
		txtEmpId.sendKeys(empId);
	}
	
	//Enter employee leader name
	public void setEmployeeLeaderName(String empLeaderName)
	{
		txtEmpLeadeName.sendKeys(empLeaderName);
	}
	
	//Enter employee start date (year, month, day)
	public void setEmployeeStartDate(String empStartYear, String empStartMonth, String empStartDay)
	{
		Select dropdownYear = new Select(drpStartYear);  
		dropdownYear.selectByVisibleText(empStartYear);
		
		Select dropdownMonth = new Select(drpStartMonth);  
		dropdownMonth.selectByVisibleText(empStartMonth);
		
		Select dropdownDay = new Select(drpStartDay);  
		dropdownDay.selectByVisibleText(empStartDay);
	}
	
	//Click button to submit form to create new employee
	public void clickSubmitFormBtn()
	{
		btnCreateEmployee.click();
		getEmployeeNumber();
	}
	
	//Get the unique identifier of the recently created employee
	public void getEmployeeNumber()
	{
		String currentURL =  driver.getCurrentUrl();
		String empNumer = currentURL.substring(currentURL.lastIndexOf("/")+1);
		System.out.println("New employee number: "+empNumer);
		employeeNumber = empNumer;
	}
	
	//Click back button
	public void clickBackBtn() {
		btnBack.click();
	}
	
}
