package com.VTiger.generic;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.VTiger.ObjectRepo.HomePage;
import com.VTiger.ObjectRepo.LoginPage;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public PropertyFiles propertyFiles = new PropertyFiles();
	
	@BeforeSuite
	public void connecttoDB() {
		System.out.println("====DB Connection====");
	}

	@AfterSuite
	public void disConnectDB() {
		System.out.println("=====Disconnected DB=====");
	}

//	@Parameters("BROWSER")
	@BeforeClass
//	public void launchBrowser(String BROWSER) throws Throwable {
	public void launchBrowser() throws Throwable {
		String BROWSER = propertyFiles.readDataFromPropertyfiles("browser");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid input");
		}

		driver.get(propertyFiles.readDataFromPropertyfiles("url"));
		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);
		webDriverUtil.maxwindow();
		webDriverUtil.pageloadtimeout();

	}

	@BeforeMethod
	public void login() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logintoApp();

	}

	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.logoutfromApp();
	}

 /*	@AfterClass
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(10000);
		driver.close();

	}    */
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(10000);
		driver.close();

	}

	public static void takeScreenshot(String methodname) {
		TakesScreenshot screenshot = (TakesScreenshot)sdriver;

		String dest = "../TYSS_SRIKANTH/screenshots/"+methodname+".png";

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File destpath = new File(dest);

		try {
			Files.copy(src, destpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
