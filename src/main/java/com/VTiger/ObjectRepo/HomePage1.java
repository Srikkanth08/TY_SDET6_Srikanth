package com.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.generic.WebDriverUtil;

public class HomePage1 
{
	WebDriver driver;
	
	public HomePage1(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[.='Organizations'])[1]")
	private WebElement orglink;
	
	@FindBy(xpath = "//img[src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutbutton;
	
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactlink;

	public WebElement getOrglink() 
	{
		return orglink;
	}

	public WebElement getSignoutimg() 
	{
		return signoutimg;
	}

	public WebElement getSignoutbutton() 
	{
		return signoutbutton;
	}
	
	public WebElement getContactlink() 
	{
		return contactlink;
	}

	
	
	public void signout() throws Throwable
	{
		WebDriverUtil wdu = new WebDriverUtil(driver);
		
		wdu.moveToelement(signoutimg);
		Thread.sleep(3000);
		signoutbutton.click();
	}
	
}
