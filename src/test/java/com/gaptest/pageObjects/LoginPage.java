package com.gaptest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//*********Constructor*********
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*********Web Elements by using Page Factory*********
	@FindBy(id="user_email")
	@CacheLookup
	WebElement txtUserEmail;
	
	@FindBy(id="user_password")
	@CacheLookup
	WebElement txtUserPassword;
	
	@FindBy(name="commit")
	@CacheLookup
	WebElement btnSingIn;
	
	
	//*********Page Methods*********
	
	//Enter user email
	public void setUserEmail(String useremail) {
		txtUserEmail.sendKeys(useremail);
	}
	
	//Enter user password
	public void setUserPassword(String userpassword) {
		txtUserPassword.sendKeys(userpassword);
	}
	
	//Click sing in button
	public void clickSingInBtn() {
		btnSingIn.click();
	}
}
