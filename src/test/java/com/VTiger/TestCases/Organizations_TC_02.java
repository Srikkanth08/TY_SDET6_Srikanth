package com.VTiger.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.VTiger.generic.Browser;
import com.VTiger.generic.TestData;
import com.VTiger.generic.WebDriverUtil;

public class Organizations_TC_02 extends Browser {
	public static void main(String[] args) throws Throwable {
		Browser br = new Browser();
		br.openBrowser();

		WebDriverUtil wb = new WebDriverUtil(driver);
		wb.maxwindow();
		wb.pageloadtimeout();

		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		TestData td = new TestData();
		String org = td.oraganization();

		driver.findElement(By.name("accountname")).sendKeys(org);

		WebElement ind_dd = driver.findElement(By.name("industry"));
		ind_dd.click();
		wb.selectValuefromdd("Education", ind_dd);

		WebElement type_dd = driver.findElement(By.name("accounttype"));
		type_dd.click();
		wb.selectValuefromdd(type_dd, "Customer");

		WebElement rating_dd = driver.findElement(By.name("rating"));
		rating_dd.click();
		wb.selectValuefromdd(rating_dd, "Active");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(org);
		Thread.sleep(2000);

		WebElement Staticdd = driver.findElement(By.name("search_field"));
		Staticdd.click();
		wb.selectValuefromdd(Staticdd, 1);

		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(2000);

//		WebElement orgname = driver.findElement(By.xpath("//input[@class='txtBox']"));
//		orgname.getText();
//		Thread.sleep(3000);

//		WebElement orgname = driver.findElement(By.xpath("//tbody[*]//tr[@class='lvtColData']//td[3]"));
//		orgname.click();
//		orgname.getText();

		String orgname = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		Thread.sleep(2000);
		System.out.println(org + "     " + orgname);

		if (org.equals(orgname)) {
			System.out.println("Test Case is Created Successfully, PASS");
		} else {
			System.out.println("Test Case is Not Created Successfully, FAIL");
		}

		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wb.moveToelement(signOut);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		Thread.sleep(3000);
		driver.quit();

	}
}
