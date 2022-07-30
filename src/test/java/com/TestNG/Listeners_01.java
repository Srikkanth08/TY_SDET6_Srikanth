package com.TestNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listeners_01 implements ITestListener {
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestStart");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess");
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("onTestFailure");

		TakesScreenshot screenshot = (TakesScreenshot) Sample.sdriver;

		String dest = "../TYSS_SRIKANTH/screenshots/" + result.getMethod().getMethodName() + ".png";

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File destpath = new File(dest);

		try {
			Files.copy(src, destpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onStart(ITestContext context) 
	{
		System.out.println("onStart");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("onFinish");
	}

}
