package com.gaptest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	//*********Constructor*********
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*********Web Elements by using Page Factory*********
	@FindBy(css="#logo")
	@CacheLookup
	WebElement siteLogo;
	
	@FindBy(css="div ul span")
	@CacheLookup
	WebElement lgnText;
	
	@FindBy(css=".flash_notice")
	WebElement lgnSuccessMsg;
	
	//*********Page Methods*********
	
	//Return true or false if logo is visible
	public boolean siteLogoIsVisible()
	{
		boolean logoExists;
		if (siteLogo.isDisplayed())
		{
			logoExists = true; 
		}else {
			logoExists = false;
		}
		return logoExists;
	}
	
	//Get the login text
	public String getLoginText()
	{
		String loginText = lgnText.getText();
		return loginText;
	}
	
	//Get login success message
	public String getLoginSuccessMsg()
	{
		String loginSuccessMsg = lgnSuccessMsg.getText();
		return loginSuccessMsg;
	}
}
