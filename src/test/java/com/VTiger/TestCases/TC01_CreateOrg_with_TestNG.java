package com.VTiger.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.VTiger.ObjectRepo.CreateNewOrgPage;
import com.VTiger.ObjectRepo.HomePage;
import com.VTiger.ObjectRepo.OrgInfoPage;
import com.VTiger.generic.BaseClass;
import com.VTiger.generic.TestData;

public class TC01_CreateOrg_with_TestNG extends BaseClass
{
	@Test
	public void createorg () throws Throwable
	{
		HomePage homePage = new HomePage(driver);

		homePage.getOrglink().click(); 

		OrgInfoPage orgInfoPage= new OrgInfoPage(driver);
		orgInfoPage.getCreateorgbtn().click();

		TestData testData= new TestData();
		String orgname = testData.oraganization();
		
//		JavaUtil javaUtil = new JavaUtil();
//		String orgname=testData.getOrganizationName()+javaUtil.createRandomnumber();

		CreateNewOrgPage createNewOrgPage = new CreateNewOrgPage(driver);

		createNewOrgPage.getOrgname().sendKeys(orgname);
		createNewOrgPage.getSaveorgbtn().click();

		Thread.sleep(4000);
		driver.navigate().refresh();

		homePage.getOrglink().click();

		orgInfoPage.searchforOrg(orgname, "accountname");

		Thread.sleep(3000);

		String actualorgname=orgInfoPage.getfirstOrg().getText();

	/*	if (orgname.equals(actualorgname)) 
		{
			System.out.println("Tc Passes");
		}
		else {
			System.out.println("TC Fail");
		}      */
		
		Assert.assertEquals(actualorgname, orgname);
		
//		Thread.sleep(2000);
//		driver.close();
	}

}
