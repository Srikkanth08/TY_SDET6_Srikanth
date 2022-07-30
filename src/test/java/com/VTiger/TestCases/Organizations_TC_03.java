package com.VTiger.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.VTiger.generic.Browser;
import com.VTiger.generic.TestData;
import com.VTiger.generic.WebDriverUtil;

public class Organizations_TC_03 extends Browser
{
		public static void main(String[] args) throws Throwable 
		{
			Browser br = new Browser();
			br.openBrowser();
			
			WebDriverUtil wb = new WebDriverUtil(driver);
			wb.maxwindow();
			wb.pageloadtimeout();
			
			driver.findElement(By.xpath("//a[.='Contacts']")).click();

			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

			TestData testData= new TestData();

			String contactname=testData.getLastName();

			driver.findElement(By.name("lastname")).sendKeys(contactname);

			String createcontactpagetitle=driver.getTitle();

			System.out.println("Parent title="+createcontactpagetitle);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

			Thread.sleep(2000);
			wb.switchWindow("Accounts");
//			String child_title = driver.getTitle();
//			System.out.println("Child Title="+child_title);

			Thread.sleep(4000);

			driver.findElement(By.id("search_txt")).sendKeys("MS Technologies");

			driver.findElement(By.name("search")).click();

			driver.findElement(By.id("1")).click();

			Thread.sleep(2000);
			wb.switchWindow("Contacts");

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


			Thread.sleep(6000);

			String contactid=driver.findElement(By.xpath("//td[@id='mouseArea_First Name']/../td[4]")).getText();


			driver.findElement(By.xpath("//a[.='Contacts']")).click();

			driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(contactid);

			driver.findElement(By.name("submit")).click();

			Thread.sleep(2000);

			String actualcontactlastname=driver.findElement(By.xpath("(//a[@title='Contacts'])[2]")).getText();


			if (actualcontactlastname.equals(contactname)) 
			{
				System.out.println("Test Case is Successful, PASS");
			}
			else {
				System.out.println("Test Case is NOT Successful, FAIL");
			}

			WebElement signoutimg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

			wb.moveToelement(signoutimg);

			driver.findElement(By.xpath("//a[.='Sign Out']")).click();

			Thread.sleep(6000);

			driver.quit();

			
		}
}
