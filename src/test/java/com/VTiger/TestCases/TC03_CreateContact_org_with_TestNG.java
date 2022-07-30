package com.VTiger.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.VTiger.ObjectRepo.ConatctInfoPage;
import com.VTiger.ObjectRepo.ContactOrg_popup;
import com.VTiger.ObjectRepo.CreateNewContactPage;
import com.VTiger.ObjectRepo.HomePage;
import com.VTiger.generic.BaseClass;
import com.VTiger.generic.TestData;
import com.VTiger.generic.WebDriverUtil;

public class TC03_CreateContact_org_with_TestNG extends BaseClass
{
//	@Parameters("Contactsname")
	@Test
	public void createcontact_org() throws IOException, InterruptedException 
	{
		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		ConatctInfoPage conatctInfoPage = new  ConatctInfoPage(driver);
		conatctInfoPage.getCreatecontactsimg().click();
		TestData testData= new TestData();

		String contactname=testData.getLastName();

		System.out.println(contactname);

		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getLastNameEdt().sendKeys(contactname);

		createNewContactPage.getOrganizationLookUpImage().click();

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Accounts");

		Thread.sleep(4000);

		ContactOrg_popup contactOrg_popup = new ContactOrg_popup(driver);

		contactOrg_popup.searchandSelectforOrg("MS Technologies");

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Contacts");

		createNewContactPage.getSaveBtn().click();

		Thread.sleep(8000);

		String contactid=createNewContactPage.getcontactid().getText();

		System.out.println(contactid);
		driver.navigate().refresh();

		homePage.getContactslink().click();

		conatctInfoPage.checkcontactcreated(contactid);

		Thread.sleep(4000);

		String actualcontactlastname=conatctInfoPage.getactualcontact().getText();

		System.out.println(actualcontactlastname);

	/*	if (actualcontactlastname.equals(contactname)) 
		{
			System.out.println("Tc Passes");
		}
		else {
			System.out.println("TC Fail");
		}  */
		
		Assert.assertEquals(actualcontactlastname, contactname);
		
		
//		Thread.sleep(2000);
//		driver.close();
	}
}
