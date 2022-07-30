package com.VTiger.TestCases;

import com.VTiger.ObjectRepo.HomePage;
import com.VTiger.ObjectRepo.HomePage1;
import com.VTiger.ObjectRepo.LoginPage;
import com.VTiger.ObjectRepo.OrganizationsPage;
import com.VTiger.generic.Browser;
import com.VTiger.generic.TestData;
import com.VTiger.generic.WebDriverUtil;

public class Org_TC_01_With_POM extends Browser {
	public static void main(String[] args) throws Throwable {
		Browser browser = new Browser();
		browser.openBrowser();

		WebDriverUtil wdu = new WebDriverUtil(driver);
		wdu.maxwindow();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.logintoApp();

		TestData td = new TestData();
		String org = td.oraganization();

	/*	OrganizationsPage or = new OrganizationsPage(driver);
		or.createOrg(orgname);
		Thread.sleep(4000);

		or.searchOrg(orgname);

		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(name);

		if (name.equals(orgname)) {
			System.out.println("Organization is Successfully Created-Verified-Pass");
		} else {
			System.out.println("Organization is not Created");
		}

		HomePage1 hp = new HomePage1(driver);
		hp.signout();
		Thread.sleep(4000);
		driver.close();
		
		*/
		

	}
}
