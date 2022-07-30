package com.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.generic.PropertyFiles;

public class LoginPage1      //Rule - 1
{
	WebDriver driver;
	
	public LoginPage1(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule - 2
	
	@FindBy(name="user_name")
	WebElement untextfield;
	
	@FindBys({@FindBy(name="user_password"), @FindBy(xpath="//input[@type='password']")})
	WebElement pwdtextfield;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath = "//input[@type='submit']")})
	WebElement loginbutton;

	public WebElement getUntextfield() 
	{
		return untextfield;
	}

	public WebElement getPwdtextfield() 
	{
		return pwdtextfield;
	}

	public WebElement getLoginbutton() 
	{
		return loginbutton;
	}
	
	
	 PropertyFiles prop = new PropertyFiles();
	 
	 public void loginToApp() throws Throwable
	 {
		 untextfield.sendKeys(prop.readDataFromPropertyfiles("username")); 
		 pwdtextfield.sendKeys(prop.readDataFromPropertyfiles("password"));
		 loginbutton.click();
	 }

	 
}
