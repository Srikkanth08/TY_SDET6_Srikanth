package com.VTiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.VTiger.generic.WebDriverUtil;

public class OrganizationsPage 
{
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Organizations']") 
	private WebElement orglink;
	
	@FindBys({@FindBy(xpath="//img[@title='Create Organization...']"), @FindBy(xpath = "//img[@alt='Create Organization...']")})
	private WebElement orgimg;
	
	@FindAll({@FindBy(name = "search_text"), @FindBy(xpath = "//input[@class='txtBox']")})
	private WebElement searchbox;
	
	@FindBy(name="search_field")
    private WebElement orgdd;
	
	@FindBy(name="submit")
    private WebElement searchbtn;
	
	@FindBy(name="accountname")
    private WebElement orgnametb;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement savebtn;

	public WebElement getOrglink() 
	{
		return orglink;
	}

	public WebElement getOrgimg() 
	{
		return orgimg;
	}

	public WebElement getSearchbox() 
	{
		return searchbox;
	}

	public WebElement getOrgdd() 
	{
		return orgdd;
	}

	public WebElement getSearchbtn() 
	{
		return searchbtn;
	}

	public WebElement getOrgnametb() 
	{
		return orgnametb;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	WebDriverUtil wdu = new WebDriverUtil(driver);
	public void searchOrg(String orgname, String value) throws Throwable
	{
		orglink.click();
	    searchbox.sendKeys(orgname);
	    wdu.selectValuefromdd(orgdd,value);
	    Thread.sleep(2000);
	    searchbox.click();
	  
	}
	
	 public void createOrg(String orgname)
	 {
		 orglink.click();
		 orgimg.click();
		 orgnametb.sendKeys(orgname);
		 savebtn.click();
	 
	 }
	 	
}

